package servlets;

import dao.Comment;
import dao.CommentDao;
import dao.Comments;
import dao.DaoFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
String comment = null;
String url = "";


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        req.setAttribute("user", user);

        Comments commentsDao = DaoFactory.getCommentDao();
        List<Comment> comments = commentsDao.all();
        if (comments != null){
            req.setAttribute("comments", comments);
        }


        req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        List<Comment> comments = null;
        HttpSession session = req.getSession();

        int random = (int) (Math.random() * 3) + 1;


        if (random == 1) {
            url = "/images/random-user1.webp";
        }
        if (random == 2) {
            url = "/images/random-user2.webp";
        }
        if (random == 3) {
            url = "/images/random-user3.webp";
        }


        comment = req.getParameter("comment");

        if (comment.equals("") || url.equals("")) {
            comment = null;
            url = null;
        }

        if (comment != null && url != null) {
            Comments commentsDao = DaoFactory.getCommentDao();
            commentsDao.insert(new Comment(url, comment));
            comments = commentsDao.all();
            Collections.reverse(comments);
            session.setAttribute("comments", comments);

        }

        if (comments != null){
            req.setAttribute("comments", comments);
        }

        req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, res);


    }
}
