package web.admin;

import dao.UserDao;
import dao.iml.UserDaoIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelUserServlet", urlPatterns = "/admin/userlist")
public class DelUserServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String temp = request.getParameter("id");
        if(temp != null) {
            //删除用户
            int id = Integer.parseInt(temp);
            UserDao userDao = new UserDaoIml();
            userDao.delete(id);
            response.sendRedirect(""+request.getContextPath()+"/admin/user_list");
        }
    }
}
