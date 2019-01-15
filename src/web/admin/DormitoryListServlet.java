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

@WebServlet(name = "DormitoryListServlet", urlPatterns = "/admin/dormitory_list")
public class DormitoryListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取宿舍列表
        DormitoryDao dormitoryDao = new DormitoryDaoIml();
        List<Dormitory> list = new ArrayList<>();
        list = dormitoryDao.getAll();
        request.setAttribute("dormitoryList", list);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/admin_create.jsp");
        dispatcher.forward(request, response);
    }
}
