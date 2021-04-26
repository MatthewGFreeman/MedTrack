package Medtrack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;
// import java.util.List;
// import java.util.Map;
// import java.util.stream.Collectors;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/api/viewrecords/*")
public class ViewRecordsApiServlet extends HttpServlet {
    
    private ShotRecordDao srDao = new ShotRecordDao();
    private UserDao userDao = new UserDao();
    private ObjectMapper mapper = new ObjectMapper();

    private void sendJson(HttpServletResponse res, Object obj) throws IOException {
        res.setContentType("application/json");
        String resp = mapper.writeValueAsString(obj);
        PrintWriter out = res.getWriter();
        out.print(resp);
        out.flush();
    }
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        String pathData = req.getPathInfo();
        int usId = Integer.parseInt(pathData.split("/")[1]);
        String userName = userDao.getUserById(usId).getUserName();
        Collection<ShotRecord> shotRecords = srDao.getOneUsersRecords(userName);

        sendJson(res, shotRecords);
        return;

    }

    // @Override
    // protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
    //     String notes = req.getParameter("notes");
    //     String dateAndTime = req.getParameter("dateAndTime");
    //     srDao.deleteOneRecord(notes, dateAndTime);
    //     doGet(req, res);
    //     // res.sendRedirect("viewrecords.html");
    // }
}
