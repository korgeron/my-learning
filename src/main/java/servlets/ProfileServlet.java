package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


@WebServlet(name = "ProfileServlet", urlPatterns = "/profile")
public class ProfileServlet extends HttpServlet {
    List<String> comments = new ArrayList<>();


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String user = (String) session.getAttribute("user");
        req.setAttribute("user", user);
        req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req,res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {

        int random = (int)(Math.random()*3) +1;
        String url = null;

        if (random == 1){
            url = "/images/random-user1.webp";
        }
        if (random == 2){
            url = "/images/random-user2.webp";
        }
        if (random == 3){
            url = "/images/random-user3.webp";
        }

        req.setAttribute("random", url);

        String comment = req.getParameter("comment");
        if (comment != null) {
            comments.add(comment);
            req.setAttribute("comments", comments);
            System.out.println(comments.size());
        }
        req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req,res);


    }
}
