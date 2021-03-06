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

@WebServlet(name = "ModifyAdminServlet", urlPatterns = "/admin/modifyadmin")
public class ModifyAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        AdminDao adminDao = new AdminDaoIml();
        String temp = request.getParameter("id");
        if(temp != null){
            //修改用户信息
            Admin admin = adminDao.find(Integer.parseInt(temp));
            admin.setName(request.getParameter("name"));
            admin.setDormitory_id(Integer.parseInt(request.getParameter("dormitory")));
            admin.setTel(request.getParameter("tel"));
            adminDao.update(admin);
        }
        response.sendRedirect(""+request.getContextPath()+"/admin/admin_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
