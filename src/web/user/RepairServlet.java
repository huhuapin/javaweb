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

@WebServlet(name = "RepairServlet",urlPatterns = "/user/repair/create")
public class RepairServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        //获取参数
        String reason = request.getParameter("reason");
        String address = request.getParameter("address");
        String image = request.getParameter("image");
        String detail = request.getParameter("detail");
        String tel = request.getParameter("tel");
        if (image == null || image.equals("")){
            printWriter.println("<script>alert('必须上传照片');location.href='"+request.getContextPath()+"/user/repair/create';</script>");
        }
        System.out.println(image);
        //获取session用户
        User user = (User)request.getSession().getAttribute("object");
        Date currentTime = new Date();
        //获取当前时间
        Timestamp timestamp = new Timestamp(currentTime.getTime());
        //创建repair类
        Repair repair = new Repair();
        repair.setReason(reason);
        repair.setAddress(address);
        repair.setImage(image);
        repair.setTel(tel);
        repair.setDetail(detail);
        repair.setUser_id(user.getId());
        repair.setDormitory_id(user.getDormitory_id());
        repair.setCreated_at(new Timestamp(currentTime.getTime()));
        //存入数据库
        RepairDao repairDao = new RepairDaoIml();
        repairDao.addRepair(repair);
        printWriter.println("<script>alert('报修成功');location.href='"+request.getContextPath()+"/user/index';</script>");
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.getRequestDispatcher("/user/repair.jsp").forward(request,response);
    }
}
