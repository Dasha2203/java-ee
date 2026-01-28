package by.tms;

import by.tms.entities.Account;
import by.tms.store.InMemoryAccountRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.Optional;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {
    private final InMemoryAccountRepository accountRepository = new InMemoryAccountRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        Object account = req.getSession().getAttribute("account");

        if (account != null) {
            res.sendRedirect("/");
            return;
        }

        getServletContext().getRequestDispatcher("/pages/auth/login.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String email = req.getParameter("email");
        String password = req.getParameter("password");

        Optional<Account> account = accountRepository.findByEmail(email);

        if (account.isEmpty()) {
            req.setAttribute("message", "Data is invalid");
            req.getRequestDispatcher("/pages/auth/login.jsp").forward(req, res);

            return;
        }

        boolean isEqualPasswords = account.get().getPassword().equals(password);

        if (!isEqualPasswords) {
            req.setAttribute("message", "Data is invalid");
            req.getRequestDispatcher("/pages/auth/login.jsp").forward(req, res);

            return;
        }

        req.getSession().setAttribute("account", account);
        res.sendRedirect("/");

    }
}
