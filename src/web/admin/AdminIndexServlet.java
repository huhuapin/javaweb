package web.admin;

import dao.AdminDao;
import dao.NoticeDao;
import dao.UserDao;
import dao.iml.AdminDaoIml;
import dao.iml.NoticeDaoIml;
import dao.iml.UserDaoIml;
import domain.Admin;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;


@WebServlet(name = "AdminIndexServlet", urlPatterns = "/admin/index")
public class AdminIndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("user");
        //获取管理员管理的宿舍
        AdminDao adminDao = new AdminDaoIml();
        request.setAttribute("description", adminDao.show(admin.getDormitory_id()));
        //获取管理员宿舍的所有公告
        NoticeDao noticeDao = new NoticeDaoIml();
        request.setAttribute("noticeSum", noticeDao.sum(admin.getDormitory_id()));
        //获取宿舍楼的用用户数量
        UserDao userDao = new UserDaoIml();
        request.setAttribute("userSum", userDao.sum(admin.getDormitory_id()));
        //获取全部管理员数量
        request.setAttribute("adminSum", adminDao.sum());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
