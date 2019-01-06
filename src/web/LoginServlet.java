package web;

import dao.AdminDao;
import dao.UserDao;
import dao.iml.AdminDaoIml;
import dao.iml.UserDaoIml;
import domain.Admin;
import domain.User;
import javax.servlet.annotation.WebServlet;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "IndexServlet",urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        HttpSession session = request.getSession();
        if (session.getAttribute("admin") == null) {
            //查询数据库并设置session
            String username = request.getParameter("username");
            String password = request.getParameter("password");
            UserDao userDao = new UserDaoIml();
            User user = userDao.find(username,password);
            if (user == null) {
                AdminDao adminDao = new AdminDaoIml();
                Admin admin = adminDao.find(username,password);
                if (admin == null) {
                    //登录失败
                    printWriter.println("<script>alert('用户名密码错误');location.href='/dormitory/login';</script>");
                }else {
                    //查找到管理员
                    if (admin.getStatus() == 1) {
                        //通过审核
                        session.setAttribute("admin", 1);
                        session.setAttribute("user", admin);
                        response.sendRedirect("/dormitory/admin/index");
                    }else{
                        printWriter.println("<script>alert('请等待其他管理员的审核');location.href='/dormitory/login';</script>");
                    }
                }
            }else {
                session.setAttribute("admin",0);
                session.setAttribute("user",user);
                response.sendRedirect("/dormitory/user/index");
            }
        }else {
            int admin = (int) (session.getAttribute("admin"));
            if (admin == 1) {
                response.sendRedirect("/dormitory/admin/index");
            }else {
                response.sendRedirect("/dormitory/user/index");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SignServlet signServlet = new SignServlet();
        signServlet.doGet(request,response);
    }

}
