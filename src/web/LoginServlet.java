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
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        HttpSession session = request.getSession();
        //查询数据库并设置session
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String identity = request.getParameter("identity");
        if(identity.equals("0")) {
            UserDao userDao = new UserDaoIml();
            User user = userDao.find(username,password);
            if(user == null) {
                //登录失败
                printWriter.println("<script>alert('用户名密码错误');location.href='/dormitory/login';</script>");
            }else {
                session.setAttribute("identity", 0);
                session.setAttribute("object", user);
                response.sendRedirect("/dormitory/user/index");
            }
        }else {
            AdminDao adminDao = new AdminDaoIml();
            Admin admin = adminDao.find(username,password);
            if (admin == null) {
                //登录失败
                printWriter.println("<script>alert('用户名密码错误');location.href='/dormitory/login';</script>");
            }else {
                if(identity.equals("1")) {
                    session.setAttribute("identity", 1);

                }else {
                    session.setAttribute("identity", 2);
                }
                session.setAttribute("object", admin);
                response.sendRedirect("/dormitory/admin/index");
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        SignServlet signServlet = new SignServlet();
        signServlet.doGet(request,response);
    }

}
