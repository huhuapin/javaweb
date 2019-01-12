package web.admin;

import dao.NoticeDao;
import dao.iml.NoticeDaoIml;
import domain.Admin;
import domain.Notice;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "CreateNoticeServlet",urlPatterns = "/admin/notice_create")
public class CreateNoticeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String title = request.getParameter("title");
        String content = request.getParameter("content");
        PrintWriter printWriter = response.getWriter();
        if (title ==null || content == null) {
            //信息不完整
            printWriter.println("<script>alert('添加失败！内容必须全部填写！');location.href='/dormitory/admin/notice_create';</script>");
        }
        Admin admin = (Admin)request.getSession().getAttribute("object");
        Notice notice  = new Notice();
        notice.setTitle(title);
        notice.setContent(content);
        notice.setCreated_at(new Timestamp(new Date().getTime()));
        notice.setAdmin_id(admin.getId());
        notice.setDormitory_id(admin.getDormitory_id());
        NoticeDao noticeDao = new NoticeDaoIml();
        noticeDao.add(notice);
        response.sendRedirect("/dormitory/admin/notice_list");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("/admin/notice_create.jsp").forward(request,response);
    }
}
