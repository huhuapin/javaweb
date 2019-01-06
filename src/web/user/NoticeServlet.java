package web.user;

import dao.NoticeDao;
import dao.iml.NoticeDaoIml;
import domain.Notice;
import domain.Page;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserNoticeServlet",urlPatterns = "/user/notice")
public class NoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        User user = (User) request.getSession().getAttribute("user");
        NoticeDao noticeDao = new NoticeDaoIml();
        List<Notice> notices = noticeDao.findAll(user.getDormitory_id());
        //页面当前页
        int curPage = 0;
        //jsp传过来的当前页
        String strPage = request.getParameter("page");
        Page page = new Page();
        page.setPageSize(10);
        page.setCount(notices.size());
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
        for(int i = page.getPage() * page.getPageSize(); i <(page.getPage()+1)*page.getPageSize() && i < notices.size(); i++)
            list_page.add(notices.get(i));
        request.setAttribute("page", page);
        request.setAttribute("list_page", list_page);
        request.getRequestDispatcher("/user/notice.jsp").forward(request,response);
    }
}
