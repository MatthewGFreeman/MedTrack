package Medtrack;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/api/deleteShotRecord/*")
public class DeleteShotRecord extends HttpServlet{

    private ShotRecordDao srDao = new ShotRecordDao();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        RequestDispatcher view = req.getRequestDispatcher("viewrecords.html");
        view.forward(req, res);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String notes = req.getParameter("notes");
        String dateAndTime = req.getParameter("dateAndTime");
        srDao.deleteOneRecord(notes, dateAndTime);

        res.sendRedirect("viewrecords.html");
    }
    
}
