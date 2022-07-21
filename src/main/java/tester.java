import dao.Comment;
import dao.CommentDao;
import dao.Comments;
import dao.DaoFactory;

import java.util.ArrayList;
import java.util.List;

public class tester {


    public static void main(String[] args) {
        Comments commentDao = DaoFactory.getCommentDao();
//        List<Comment> c = commentDao.all();
        Comment c = new Comment("/r", "c");
        commentDao.insert(c);

        System.out.println(commentDao.all());


    }
}
