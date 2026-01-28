package by.tms;

import by.tms.entities.Account;
import by.tms.store.InMemoryAccountRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Objects;
import java.util.Optional;

@WebServlet("/register")
public class RegisterServlet extends HttpServlet {
    private final InMemoryAccountRepository accountRepository = new InMemoryAccountRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Object account = req.getSession().getAttribute("account");

        if (account != null) {
            res.sendRedirect("/");
            return;
        }

        getServletContext().getRequestDispatcher("/pages/auth/register.jsp").forward(req, res);
    }

    @Override
    protected  void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String email = req.getParameter("email");
        String name = req.getParameter("fullname");
        String password = req.getParameter("password");


        if (accountRepository.findByEmail(email).isPresent()) {
            req.setAttribute("warning", "Email already used");
            req.setAttribute("message", null);
            req.getRequestDispatcher("/pages/auth/register.jsp").forward(req, res);
            return;
        }

        req.setAttribute("warning", null);

        Account account = new Account(name, email, password);
        accountRepository.addAccount(account);

        req.setAttribute("message", "Account is created");
        req.getRequestDispatcher("/pages/auth/register.jsp").forward(req, res);
    }
}
