package Medtrack;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.databind.ObjectMapper;

@WebServlet("/api/medname/")
public class MedicineNameApiServlet extends HttpServlet {
    private MedicineDao medDao = new MedicineDao();
    private ObjectMapper mapper = new ObjectMapper();

    private void sendJson(HttpServletResponse res, Object obj) throws IOException {
        res.setContentType("application/json");
        String resp = mapper.writeValueAsString(obj);
        PrintWriter out = res.getWriter();
        out.print(resp);
        out.flush();
    }

    @Override
    public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
        Collection<Medicine> medicines = medDao.getall();

        sendJson(res, medicines);
        return;
    }
}
