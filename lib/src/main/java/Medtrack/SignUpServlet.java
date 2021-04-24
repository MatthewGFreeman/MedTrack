package Medtrack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {
    private UserDao userDao = new UserDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("signup.html");
        view.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String fName = req.getParameter("fName");
        String lName = req.getParameter("lName");
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String redirect = "/viewrecords.html";

        User newUser = new User(fName, lName, userName, password);
        userDao.insert(newUser);

        res.sendRedirect(req.getContextPath() + redirect);
    }
}
