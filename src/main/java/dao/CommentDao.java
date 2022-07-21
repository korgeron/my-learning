package dao;

import java.util.ArrayList;
import java.util.List;

public class CommentDao implements Comments{
    List<Comment> comments = new ArrayList<>();

    @Override
    public List<Comment> all() {
        return comments;
    }

    @Override
    public List<Comment> insert(Comment comment) {
        this.comments.add(comment);
        return this.comments;
    }
}
