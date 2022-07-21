package dao;

import com.mysql.cj.jdbc.Driver;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class CommentDao implements Comments {
    private Connection connection = null;


    //TODO: THIS METHOD IS ONLY FOR MAKING A CONNECTION TO THE DATABASE!
    public CommentDao() {
        try {
            //todo: need to get config data
            Config config = new Config();

            //todo: register driver (MUST HAVE MYSQL DEPENDENCIES!!)
            DriverManager.registerDriver(new Driver());

            connection = DriverManager.getConnection(
                    config.url(),
                    config.username(),
                    config.password()
            );
        } catch (SQLException e) {

            throw new RuntimeException("This is from making a connection", e);
        }
    }

    //TODO: THIS METHOD WILL SELECT ALL FROM THE DATABASE
    @Override
    public List<Comment> all() {

        try {
            //todo: make a statement object
            Statement statement = connection.createStatement();

            //todo: execute statement using a result set
            ResultSet rs = statement.executeQuery("SELECT * FROM comments_table;");
            List<Comment> comments = new ArrayList<>();
            //todo: display the data
            while (rs.next()) {
                comments.add(new Comment(
                        rs.getString("url"),
                        rs.getString("comment")
                ));

            }
            return comments;

        } catch (SQLException e) {
            throw new RuntimeException("This is from the select all method", e);
        }
    }

    @Override
    public long insert(Comment comment) {
    //todo: create string query for sql query
    String query = String.format("INSERT INTO comments_table(url, comment) VALUES ('%s', '%s')", comment.getUrl(), comment.getComment());

        try {
            //todo: create a statement object (MUST BE IN A TRY CATCH)
            Statement statement = connection.createStatement();

            //todo: use the execute update method
            statement.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);

            //todo: get a result set for the generated keys (TO DISPLAY THAT OBJECT WAS SUCCESSFULLY INSERTED)
            ResultSet rs = statement.getGeneratedKeys();
            if (rs.next()){
                //todo: this will notify us when we make a new comment
                System.out.println("Inserted a new record! New id: " + rs.getLong(1));
            }
            //todo: return the result set
            return rs.getLong(1);
        } catch (SQLException e){
            throw new RuntimeException("This is from the insert method", e);
        }




    }
}
