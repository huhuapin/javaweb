package web.admin;

import dao.NoticeDao;
import dao.RepairDao;
import dao.iml.NoticeDaoIml;
import dao.iml.RepairDaoIml;
import domain.Admin;
import domain.Notice;
import domain.Repair;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "RepairListServlet",urlPatterns = "/admin/repair_list")
public class RepairListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("object");
        RepairDao repairDao = new RepairDaoIml();
        List<Repair> list_page = new ArrayList<>();
        int page = 0;    //待显示页面
        int count = 0;   //数据总条数
        int pageSum = 0; //页面总数
        int limit = 10;  //每页显示的数据条数
        if((int) session.getAttribute("identity") == 1) {
            count = (int) repairDao.sum(admin.getDormitory_id());
        }else {
            count = (int) repairDao.sum();
        }
        //由记录总数除以每页记录数得出总页数
        pageSum = (int) Math.ceil(count / (limit * 1.0));
        //获取跳页时传进来的当前页面参数
        String strPage = request.getParameter("page");
        ///判断当前页面参数的合法性并处理非法页号（为空或小于0显示第一页，大于总页数显示最后一页）
        if (strPage == null) {
            page = 1;
        } else {
            try {
                page = Integer.parseInt(strPage);
            } catch (Exception e) {
                page = 1;
            }
            if(page < 1) page = 1;
            if(page > pageSum) page = pageSum;
        }
        //由(page-1)*limit算出当前页面第一条记录，由limit查询limit条记录，得出当前页面的记录
        if((int) session.getAttribute("identity") == 1) {
            list_page = repairDao.findAll(admin.getDormitory_id(), limit * (page - 1), limit);
        }else {
            list_page = repairDao.findAll(limit * (page - 1), limit);
        }
        request.setAttribute("page", page);
        request.setAttribute("pageSum", pageSum);
        request.setAttribute("list_page", list_page);
        request.getRequestDispatcher("/admin/repair_list.jsp").forward(request,response);
    }
}
