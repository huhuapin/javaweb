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
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "ShowAdminServlet", urlPatterns = "/admin/showadmin")
public class ShowAdminServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //获取传来的用户信息
        request.setAttribute("id", request.getParameter("id"));
        request.setAttribute("username", request.getParameter("username"));
        request.setAttribute("name", request.getParameter("name"));
        //获取宿舍列表
        DormitoryDao dormitoryDao = new DormitoryDaoIml();
        int id = Integer.parseInt(request.getParameter("dormitory_id"));
        request.setAttribute("description", dormitoryDao.find(id).getDescription());
        List<Dormitory> list = new ArrayList<>();
        list = dormitoryDao.getAll();
        request.setAttribute("dormitoryList", list);
        request.setAttribute("tel", request.getParameter("tel"));
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/admin_edit.jsp");
        dispatcher.forward(request, response);
    }
}
