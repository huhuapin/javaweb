package web.admin;

import dao.UserDao;
import dao.iml.UserDaoIml;
import domain.Admin;
import domain.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "StudentInfoServlet", urlPatterns = "/admin/user_list")
public class StudentInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("user");
        UserDao userDao = new UserDaoIml();
        List<User> list = new ArrayList<>();
        list = userDao.findAll(admin.getDormitory_id());
        request.setAttribute("userList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/user_list.jsp");
        dispatcher.forward(request, response);
    }
}
