package web.admin;

import dao.NoticeDao;
import dao.iml.NoticeDaoIml;
import domain.Admin;
import domain.Notice;
import domain.Page;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.*;

@WebServlet(name = "NoticeServlet", urlPatterns = "/admin/notice_list")
public class NoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession session = request.getSession();
        Admin admin = (Admin) session.getAttribute("user");
        List<Notice> list = new ArrayList<>();
        NoticeDao noticeDao = new NoticeDaoIml();
        list = noticeDao.findAll(admin.getDormitory_id());
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
        List<Notice> list_page = new ArrayList<>();
        for(int i = page.getPage() * page.getPageSize(); i <(page.getPage()+1)*page.getPageSize() && i < list.size(); i++)
            list_page.add(list.get(i));
        request.setAttribute("page", page);
        request.setAttribute("list_page", list_page);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/notice_list.jsp");
        dispatcher.forward(request, response);
    }
}
