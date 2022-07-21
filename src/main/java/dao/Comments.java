package dao;

import java.util.List;

public interface Comments {
    List<Comment> all();
    List<Comment> insert (Comment comment);
}
