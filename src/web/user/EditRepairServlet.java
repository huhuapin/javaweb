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
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "EditRepairServlet",urlPatterns = "/user/repair/edit")
public class EditRepairServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();

        //获取参数
        int id = Integer.parseInt(request.getParameter("id"));
        String reason = request.getParameter("reason");
        String address = request.getParameter("address");
        String image = request.getParameter("image");
        String detail = request.getParameter("detail");
        String tel = request.getParameter("tel");
        if (image == null || image.equals("")){
            printWriter.println("<script>alert('必须上传照片');location.href='"+request.getContextPath()+"/user/repair/detail?id="+id+"';</script>");
        }
        //获取session用户
        User user = (User)request.getSession().getAttribute("user");
        Date currentTime = new Date();
        //获取当前时间
        Timestamp timestamp = new Timestamp(currentTime.getTime());
        //获取repair类
        RepairDao repairDao = new RepairDaoIml();
        Repair repair = repairDao.find(id);
        //更新类
        repair.setReason(reason);
        repair.setAddress(address);
        repair.setImage(image);
        repair.setDetail(detail);
        repair.setTel(tel);
        int bool = repairDao.updateRepair(repair);
        //存入数据库
        printWriter.println("<script>alert('修改报修信息成功');location.href='"+request.getContextPath()+"/user/repair/detail?id="+id+"';</script>");
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        if (request.getParameter("id") == null || request.getParameter("id").equals("")) {
            response.getWriter().println("<script>alert('参数错误');location.href='"+request.getContextPath()+"/user/repair';</script>");
            return;
        }
        int id = Integer.parseInt(request.getParameter("id"));
        RepairDao repairDao = new RepairDaoIml();
        Repair repair = repairDao.find(id);
        User user = (User) request.getSession().getAttribute("object");
        if (repair == null || repair.getUser_id() != user.getId()) {
            response.getWriter().println("<script>alert('报修不存在或您没有该权限');location.href='"+request.getContextPath()+"/user/repair';</script>");
            return;
        }
        request.setAttribute("repair",repair);
        request.getRequestDispatcher("/user/repair_edit.jsp").forward(request,response);
    }
}
