package web.user;

import dao.UserDao;
import dao.iml.UserDaoIml;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "EditUserServlet",urlPatterns = "/user/edit")
public class EditUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        User user = (User)request.getSession().getAttribute("user");
        String nickname = request.getParameter("nickname");
        String image = request.getParameter("image");
        PrintWriter printWriter = response.getWriter();
        if (nickname == null) {
            printWriter.println("<script>alert('昵称不能为空');location.href='/dormitory/user/user';</script>");
        }
        user.setNickname(nickname);
        if (image!=null) {
            user.setImage(image);
        }
        UserDao userDao = new UserDaoIml();
        userDao.update(user);
        request.getSession().setAttribute("user",user);
        printWriter.println("<script>location.href='/dormitory/user/index';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        request.getRequestDispatcher("/user/user.jsp").forward(request,response);
    }
}
