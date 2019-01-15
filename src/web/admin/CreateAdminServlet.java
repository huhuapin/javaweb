package web.admin;

import dao.AdminDao;
import dao.iml.AdminDaoIml;
import domain.Admin;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "CreateAdminServlet", urlPatterns = "/admin/admin_create")
public class CreateAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

    }
}
