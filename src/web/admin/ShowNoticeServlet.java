package web.admin;

import dao.NoticeDao;
import dao.iml.NoticeDaoIml;
import domain.Notice;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;

@WebServlet(name = "ShowNoticeServlet", urlPatterns = "/admin/shownotice")
public class ShowNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        NoticeDao noticeDao = new NoticeDaoIml();
        Notice notice = noticeDao.find(id);
        request.setAttribute("id", notice.getId());
        request.setAttribute("title", notice.getTitle());
        request.setAttribute("content", notice.getContent());
        RequestDispatcher dispatcher = request.getRequestDispatcher("/admin/notice_edit.jsp");
        dispatcher.forward(request, response);
    }
}
