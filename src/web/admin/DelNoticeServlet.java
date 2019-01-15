package web.admin;

import dao.NoticeDao;
import dao.iml.NoticeDaoIml;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "DelNoticeServlet", urlPatterns = "/admin/delnotice")
public class DelNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String temp = request.getParameter("id");
        if(temp != null) {
            //删除公告
            int id = Integer.parseInt(temp);
            NoticeDao noticeDao = new NoticeDaoIml();
            noticeDao.delete(id);
            response.sendRedirect(""+request.getContextPath()+"/admin/notice_list");
        }
    }
}
