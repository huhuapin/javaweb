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

@WebServlet(name = "RepairDetailServlet",urlPatterns = "user/repair/detail")
public class RepairDetailServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getAttribute("id") == null || request.getParameter("id").equals("")) {
            response.getWriter().println("<script>alert('参数错误');location.href='/dormitory/user/repair';</script>");
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));
        RepairDao repairDao = new RepairDaoIml();
        Repair repair = repairDao.find(id);
        User user = (User) request.getSession().getAttribute("object");
        if (repair == null || repair.getUser_id() != user.getId()) {
            response.getWriter().println("<script>alert('报修不存在或您没有该权限');location.href='/dormitory/user/repair';</script>");
            return;
        }
        request.setAttribute("repair",repair);
        request.getRequestDispatcher("/user/repair_detail.jsp");
    }
}
