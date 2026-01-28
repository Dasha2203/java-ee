package by.tms.store;

import by.tms.entities.Post;

import java.util.ArrayList;
import java.util.List;

public class InMemoryPostRepository {
    private static final List<Post> posts = new ArrayList<>();

    public List<Post> findAll() {
        return posts;
    }

    public void addPost(Post post) {
        posts.add(post);
    }
}
