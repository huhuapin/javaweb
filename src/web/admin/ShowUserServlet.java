package web.admin;

import dao.DormitoryDao;
import dao.iml.DormitoryDaoIml;
import domain.Dormitory;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "ShowUserServlet", urlPatterns = "/admin/showinfo")
public class ShowUserServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取传来的用户信息
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("_class", request.getParameter("_class"));
        //获取宿舍列表
        DormitoryDao dormitoryDao = new DormitoryDaoIml();
        List<Dormitory> list = new ArrayList<>();
        list = dormitoryDao.getAll();
        request.setAttribute("dormitoryList", list);
        request.setAttribute("room", request.getParameter("room"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/user_edit.jsp");
        dispatcher.forward(request, response);
    }
}
