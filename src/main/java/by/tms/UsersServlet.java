package by.tms;

import com.google.gson.Gson;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(value = "/users", loadOnStartup = 0)
public class UsersServlet extends HttpServlet {
    private List<User> users = new ArrayList<>();

    @Override
    public void init() {
        System.out.println("Init users servlet right away");

        int countUsers = 10;
        for (int i = 0; i < countUsers; i++) {
            users.add(new User("Name " + i + 1,(int)(Math.random() * 101)));
        }
        System.out.println("All users: " + users);
    }

    @Override
    public void destroy() {
        System.out.println("Destroy users");
    }

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String sortBy = request.getParameter("sortBy");

        response.setContentType("application/json");
        response.setCharacterEncoding("UTF-8");

        PrintWriter out = response.getWriter();
        Gson gson = new Gson();

        if (sortBy != null) {
            users.sort(User.getComparator(sortBy));
        }

        String json = gson.toJson(users);
        out.print(json);
    }
}
