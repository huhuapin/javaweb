package web.user;

import dao.NoticeDao;
import dao.iml.NoticeDaoIml;
import domain.Notice;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
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
        request.setAttribute("notices",notices);
        request.getRequestDispatcher("/user/notice.jsp").forward(request,response);
    }
}
