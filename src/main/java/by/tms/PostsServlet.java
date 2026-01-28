package by.tms;

import by.tms.entities.Post;
import by.tms.store.InMemoryPostRepository;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.util.List;

@WebServlet("/posts")
public class PostsServlet extends HttpServlet {
    InMemoryPostRepository postRepository = new InMemoryPostRepository();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws IOException, ServletException {
        List<Post> posts = postRepository.findAll();
        req.setAttribute("posts", posts);

        req.getRequestDispatcher("/pages/posts.jsp").forward(req, res);
    }
}
