package Medtrack;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/newrecord")
public class NewRecordServlet extends HttpServlet {
    private ShotRecordDao srDao = new ShotRecordDao();
    private MedicineDao mDao = new MedicineDao();
    private ShotLocationDao slDao = new ShotLocationDao();
    private UserDao userDao = new UserDao();

    private User getLoggedInUser(HttpServletRequest req) {
        int loggedInUserId = 0;
        for(Cookie i : req.getCookies()) {
            if(i.getName().equals("loggedInUser")) {
                loggedInUserId = Integer.parseInt(i.getValue());
            }
        }
        return userDao.getUserById(loggedInUserId);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String mName = req.getParameter("mName");
        String locName = req.getParameter("locName");
        String dateAndTime = req.getParameter("dateAndTime");
        String notes = req.getParameter("notes");
        int usId = getLoggedInUser(req).getUsId();
        int slId = slDao.getSlId(locName);
        int mId;
        if(mDao.getMedId(mName) == 0) {
            Medicine medicine = new Medicine(mName);
            mDao.insert(medicine);
            mId = mDao.getMedId(mName);
        } else {
            mId = mDao.getMedId(mName);
        }
        
        ShotRecord sRecord = new ShotRecord(usId, mId, slId, notes, dateAndTime);
        srDao.insert(sRecord);
        
        String redirect = "/viewrecords.html";
        res.sendRedirect(req.getContextPath() + redirect);
    }
}
