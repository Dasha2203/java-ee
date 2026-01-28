package by.tms;

import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/hello")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws SecurityException, IOException {
//        response.setContentType("text/html");
        PrintWriter writer = response.getWriter();

        try {
            writer.println("<h2>Hello from first servlet</h2>");
        } catch (Exception e) {
            writer.close();
        }
    }
}
