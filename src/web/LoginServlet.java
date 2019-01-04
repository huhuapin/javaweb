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

@WebServlet(name = "IndexServlet",urlPatterns = "/dormitory/login")
public class LoginServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
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
                    PrintWriter printWriter = response.getWriter();
                    printWriter.println("<script>alter('用户名密码错误');hostory.go(-1);</script>");
                }else {
                    session.setAttribute("admin",1);
                    session.setAttribute("user",admin);
                }
            }else {
                session.setAttribute("admin",0);
                session.setAttribute("user",user);
            }
        }else {
            int admin = (int) (session.getAttribute("admin"));
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
    }

}
