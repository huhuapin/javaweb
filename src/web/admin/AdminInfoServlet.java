package web.admin;

import dao.AdminDao;
import dao.iml.AdminDaoIml;
import domain.Admin;
import domain.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "AdminInfoServlet", urlPatterns = "/admin/admin_list")
public class AdminInfoServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        AdminDao adminDao = new AdminDaoIml();
        List<Admin> list = new ArrayList<>();
        list = adminDao.getAll();
        //页面当前页
        int curPage = 0;
        //jsp传过来的当前页
        String strPage = request.getParameter("page");
        Page page = new Page();
        page.setPageSize(10);
        page.setCount(list.size());
        int temp = page.getCount() / page.getPageSize();
        page.setPageNum(page.getCount() == temp * page.getPageSize() ? temp: temp + 1);
        if(strPage != null) {
            int pag = Integer.parseInt(strPage);
            if(pag >= 0) {
                curPage = pag;
                if(pag >= page.getPageNum()) curPage = pag - 1;
            }
        }
        page.setPage(curPage);
        List<Admin> list_page = new ArrayList<>();
        for(int i = page.getPage() * page.getPageSize(); i <(page.getPage()+1)*page.getPageSize() && i < list.size(); i++)
            list_page.add(list.get(i));
        request.setAttribute("page", page);
        request.setAttribute("list_page", list_page);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/admin_list.jsp");
        dispatcher.forward(request, response);
    }
}
