package web.admin;

import dao.AdminDao;
import dao.iml.AdminDaoIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "DelAdminServlet", urlPatterns = "/admin/deladmin")
public class DelAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String temp = request.getParameter("id");
        if(temp != null) {
            //删除用户
            int id = Integer.parseInt(temp);
            AdminDao adminDao = new AdminDaoIml();
            adminDao.delete(id);
            response.sendRedirect("/dormitory/admin/admin_list");
        }
    }
}
