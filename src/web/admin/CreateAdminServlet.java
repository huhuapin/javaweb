package web.admin;

import dao.AdminDao;
import dao.DormitoryDao;
import dao.iml.AdminDaoIml;
import dao.iml.DormitoryDaoIml;
import domain.Admin;
import domain.Dormitory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "CreateAdminServlet", urlPatterns = "/admin/admin_create")
public class CreateAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        if(request.getParameter("usernamee")  ==null || request.getParameter("password") == null || request.getParameter("name") == null) {
            printWriter.println("<script>alert('添加失败！内容必须全部填写！');location.href='"+request.getContextPath()+"/admin/admin_create';</script>");

        }
        Admin admin = new Admin();
        admin.setUsername(request.getParameter("username"));
        admin.setPassword(request.getParameter("password"));
        admin.setName(request.getParameter("name"));
        admin.setDormitory_id(Integer.parseInt(request.getParameter("dormitory")));
        admin.setTel(request.getParameter("tel"));
        AdminDao adminDao = new AdminDaoIml();
        adminDao.add(admin);
        response.sendRedirect(""+request.getContextPath()+"/admin/admin_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DormitoryDao dormitoryDao = new DormitoryDaoIml();
        List<Dormitory> list = new ArrayList<>();
        list = dormitoryDao.getAll();
        request.setAttribute("dormitoryList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/admin_create.jsp");
        dispatcher.forward(request, response);
    }
}
