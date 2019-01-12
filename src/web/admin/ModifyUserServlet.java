package web.admin;

import dao.UserDao;
import dao.iml.UserDaoIml;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ModifyUserServlet", urlPatterns = "/admin/modifyinfo")
public class ModifyUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        UserDao userDao = new UserDaoIml();
        String temp = request.getParameter("id");
        if(temp != null){
            //修改用户信息
            User user = userDao.find(Integer.parseInt(temp));
            if((int) request.getSession().getAttribute("identity") == 2) {
                user.setName(request.getParameter("name"));
            }
            user.set_class(request.getParameter("_class"));
            user.setDormitory_id(Integer.parseInt(request.getParameter("dormitory")));
            user.setRoom(Integer.parseInt(request.getParameter("room")));
            userDao.update(user);
        }
        response.sendRedirect("/dormitory/admin/user_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
