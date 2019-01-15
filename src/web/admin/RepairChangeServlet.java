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
import java.io.IOException;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "RepairChangeServlet",urlPatterns = "/admin/repair_change")
public class RepairChangeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
            response.getWriter().println("<script>alert('参数错误');location.href='"+request.getContextPath()+"/admin/repair_list';</script>");
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));
        RepairDao repairDao = new RepairDaoIml();
        Repair repair = repairDao.find(id);
        Admin admin = (Admin) request.getSession().getAttribute("object");
        if (repair == null) {
            response.getWriter().println("<script>alert('报修不存在或您没有该权限');location.href='"+request.getContextPath()+"/admin/repair_list';</script>");
            return;
        }
        if (!admin.isRoot()) {
            if (admin.getDormitory_id() != repair.getDormitory_id()) {
                response.getWriter().println("<script>alert('报修不存在或您没有该权限');location.href='"+request.getContextPath()+"/admin/repair_list';</script>");
                return;
            }
        }
        String message = request.getParameter("message");
        Timestamp timestamp = new Timestamp(new Date().getTime());
        repair.setMessage(message);
        repair.setUpdated_at(timestamp);
        repairDao.updateRepair(repair);
        response.getWriter().println("<script>alert('回复成功！');location.href='"+request.getContextPath()+"/admin/showrepair?id="+ id +"';</script>");
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
            response.getWriter().println("<script>alert('报修不存在或您没有该权限');location.href='"+request.getContextPath()+"/admin/repair_list';</script>");
            return;
        }
        if (!admin.isRoot()) {
            if (admin.getDormitory_id() != repair.getDormitory_id()) {
                response.getWriter().println("<script>alert('报修不存在或您没有该权限');location.href='"+request.getContextPath()+"/admin/repair_list';</script>");
                return;
            }
        }
        //如果是待处理或是处理中状态，更新状态
        if (repair.getStatus()<2) {
            repair.setStatus(repair.getStatus() + 1);
            repairDao.updateRepair(repair);
        }
        String refer = request.getHeader("referer");
        System.out.println(refer);
        response.getWriter().println("<script>alert('修改成功！');location.href='"+refer+"'</script>");

    }
}
