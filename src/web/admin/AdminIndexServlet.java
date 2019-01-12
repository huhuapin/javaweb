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
        AdminDao adminDao = new AdminDaoIml();
        NoticeDao noticeDao = new NoticeDaoIml();
        UserDao userDao = new UserDaoIml();
        if((int) session.getAttribute("identity") == 1) {
            Admin admin = (Admin) session.getAttribute("object");
            request.setAttribute("description", admin.getDescription());
            //获取管理员宿舍的所有公告
            request.setAttribute("noticeSum", noticeDao.sum(admin.getDormitory_id()));
            //获取宿舍楼的用用户数量
            request.setAttribute("userSum", userDao.sum(admin.getDormitory_id()));
            //获取全部管理员数量
            request.setAttribute("adminSum", adminDao.sum());
        }else {
            //获取所有公告
            request.setAttribute("noticeSum", noticeDao.sum());
            //获取全部用户数量
            request.setAttribute("userSum", userDao.sum());
            //获取全部管理员数量
            request.setAttribute("adminSum", adminDao.sum());
        }
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/index.jsp");
        dispatcher.forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }
}
