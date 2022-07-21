package dao;

import java.util.List;

public interface Comments {
    List<Comment> all();
    long insert (Comment comment);
}
