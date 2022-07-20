package servlets;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        if (session.getAttribute("user") != null){
            res.sendRedirect("/profile");
        } else{
            req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, res);
        }
    }




    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        boolean canLogIn = username.equals("DadBod@34") && password.equals("password");




        if (canLogIn){
            session.setAttribute("user", username);
            res.sendRedirect("/profile");
        } else {
            res.sendRedirect("/login");
        }

    }
}
