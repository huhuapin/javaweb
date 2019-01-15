package web.admin;

import dao.RepairDao;
import dao.iml.RepairDaoIml;
import domain.Admin;
import domain.Repair;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ShowRepairServlet",urlPatterns = "/admin/showrepair")
public class ShowRepairServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
            response.getWriter().println("<script>alert('参数错误');location.href='"+request.getContextPath()+"/admin/repair_list';</script>");
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));
        RepairDao repairDao = new RepairDaoIml();
        Repair repair = repairDao.find(id);
        Admin admin = (Admin) request.getSession().getAttribute("object");
        if (repair == null) {
            response.getWriter().println("<script>alert('报修不存在或您没有该权限');location.href='"+request.getContextPath()+"/user/repair_list';</script>");
            return;
        }
        if (!admin.isRoot()) {
            if (admin.getDormitory_id() != repair.getDormitory_id()) {
                response.getWriter().println("<script>alert('报修不存在或您没有该权限');location.href='"+request.getContextPath()+"/user/repair_list';</script>");
                return;
            }
        }
        request.setAttribute("repair",repair);
        request.getRequestDispatcher("/admin/repair_detail.jsp").forward(request,response);
    }
}
