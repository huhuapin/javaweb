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

@WebServlet(name = "ShowInfoServlet", urlPatterns = "/admin/showinfo")
public class ShowInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("name", request.getParameter("name"));
        request.setAttribute("_class", request.getParameter("_class"));
        DormitoryDao dormitoryDao = new DormitoryDaoIml();
        int id = Integer.parseInt(request.getParameter("dormitory_id"));
        request.setAttribute("description", dormitoryDao.find(id).getDescription());
        List<Dormitory> list = new ArrayList<>();
        list = dormitoryDao.getAll();
        request.setAttribute("dormitoryList", list);
        request.setAttribute("room", request.getParameter("room"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/user_edit.jsp");
        dispatcher.forward(request, response);
    }
}
