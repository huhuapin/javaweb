package web.admin;

import dao.AdminDao;
import dao.iml.AdminDaoIml;
import domain.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "AdminInfoServlet", urlPatterns = "/admin/admin_list")
public class AdminInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDao adminDao = new AdminDaoIml();
        List<Admin> list = new ArrayList<>();
        request.setAttribute("adminList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/admin_list.jsp");
        dispatcher.forward(request, response);
    }
}
