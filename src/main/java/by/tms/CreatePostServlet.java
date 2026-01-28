package by.tms;

import by.tms.entities.Post;
import by.tms.store.InMemoryPostRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet("/posts/create")
public class CreatePostServlet extends HttpServlet {
    private final InMemoryPostRepository postRepository = new InMemoryPostRepository();

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        String title = req.getParameter("title");
        String description = req.getParameter("description");
        String img = req.getParameter("img");

        Post post = new Post(title, description, img);
        postRepository.addPost(post);
        res.sendRedirect("/posts");
    }

}
