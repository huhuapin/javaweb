package web;

import dao.iml.AdminDaoIml;
import dao.iml.UserDaoIml;
import domain.Admin;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@WebServlet(name = "SignServlet",urlPatterns = "/sign")
public class SignServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        PrintWriter printWriter = response.getWriter();
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        String password_cofirmation = request.getParameter("password_confirmation");
        String name = request.getParameter("name");
        String dormitory_id = request.getParameter("dormitory");
        printWriter.println(request.getParameter("admin"));
        if (!password.equals(password_cofirmation)) {
            printWriter.println("<script>alert('用户名密码错误');hostory.go(-1);</script>");
            return;
        }
        if (request.getParameter("admin").equals("1")) {
            Admin admin = new Admin();
            admin.setName(name);
            admin.setDormitory_id(Integer.parseInt(dormitory_id));
            admin.setPassword(password);
            admin.setStatus(0);
            AdminDaoIml adminDaoIml = new AdminDaoIml();
            adminDaoIml.add(admin);
            printWriter.println("<script>alert('注册成功，请等待管理员审核！');hostory.go(-1);</script>");
            response.sendRedirect("/dormitory/login");
        }else {
            String _class = request.getParameter("class");
            String nickname = request.getParameter("name");
            String room = request.getParameter("room");
            User user  = new User();
            user.setUsername(username);
            user.setPassword(password);
            user.setName(name);
            user.setNickname(nickname);
            user.set_class(_class);
            user.setDormitory_id(Integer.parseInt(dormitory_id));
            user.setRoom(Integer.parseInt(room));
            UserDaoIml userDaoIml  = new UserDaoIml();
            userDaoIml.add(user);
            printWriter.println("<script>alert('注册成功，请登录！');hostory.go(-1);</script>");
            response.sendRedirect("/dormitory/login");
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doPost(request, response);
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
    }

}
