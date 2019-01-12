package web.admin;

import dao.NoticeDao;
import dao.iml.NoticeDaoIml;
import domain.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.sql.Timestamp;

@WebServlet(name = "ModifyNoticeServlet", urlPatterns = "/admin/modifynotice")
public class ModifyNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        NoticeDao noticeDao = new NoticeDaoIml();
        String temp = request.getParameter("id");
        if(temp != null){
            //修改公告
            Notice notice = noticeDao.find(Integer.parseInt(temp));
            notice.setTitle(request.getParameter("title"));
            notice.setContent(request.getParameter("content"));
            notice.setCreated_at(new Timestamp(System.currentTimeMillis()));
            noticeDao.modify(notice);
        }
        response.sendRedirect("/dormitory/admin/notice_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }
}
