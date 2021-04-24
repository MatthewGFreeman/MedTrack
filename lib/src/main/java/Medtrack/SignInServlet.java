package Medtrack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/index")
public class SignInServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("signup.html");
        view.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        User loggedInUser = userDao.userLogin(req.getParameter("userName"), req.getParameter("password"));

        if(loggedInUser != null) {
            Cookie cookie = new Cookie("loggedInUser", loggedInUser.getUsId() + "");
            res.addCookie(cookie);
            res.sendRedirect(req.getContextPath() + "/viewrecords.html");
        } else {
            doGet(req, res);
        }
    }
}