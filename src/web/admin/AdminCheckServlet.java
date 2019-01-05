package web.admin;

import dao.AdminDao;
import dao.iml.AdminDaoIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "AdminCheckServlet", urlPatterns = "/admin/admincheck")
public class AdminCheckServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = (int) request.getAttribute("id");
        AdminDao adminDao = new AdminDaoIml();
        adminDao.status(id);
        response.sendRedirect("/dormitory/admin/admin_list");
    }
}
