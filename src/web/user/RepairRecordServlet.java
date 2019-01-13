package web.user;

import dao.RepairDao;
import dao.iml.RepairDaoIml;
import domain.Repair;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RepairRecordServlet",urlPatterns = "/user/repair")
public class RepairRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("object");
        RepairDao repairDao = new RepairDaoIml();
        List<Repair> repairs = repairDao.findByUserId(user.getId(),0,10);
        request.setAttribute("repairs",repairs);
        request.getRequestDispatcher("/user/repair_list.jsp").forward(request,response);
    }
}
