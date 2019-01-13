package web.admin;

import dao.RepairDao;
import dao.iml.RepairDaoIml;
import domain.Admin;
import domain.Repair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "RepairListServlet",urlPatterns = "/admin/repair_list")
public class RepairListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("object");
        int identify = (int) session.getAttribute("identity");
        RepairDao repairDao = new RepairDaoIml();
        List<Repair> repairs;
        if (identify == 1){
            //管理员
            repairs = repairDao.findAll(admin.getDormitory_id(),0,10);
        }else {
            //超级管理员
            repairs = repairDao.findAll(0,10);
        }
        request.setAttribute("repairs",repairs);
        request.getRequestDispatcher("/admin/repair_list.jsp").forward(request,response);
    }
}
