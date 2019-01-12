package web.user;

import dao.NoticeDao;
import dao.iml.NoticeDaoIml;
import domain.Notice;
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
        User user = (User) request.getSession().getAttribute("object");
        NoticeDao noticeDao = new NoticeDaoIml();
        List<Notice> list_page = new ArrayList<>();
        int page = 0;    //待显示页面
        int count = (int) noticeDao.sum(user.getDormitory_id()); //数据总条数
        int pageSum = 0; //页面总数
        int limit = 10;  //每页显示的数据条数
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
        list_page = noticeDao.findAll(user.getDormitory_id(), limit * (page - 1), limit);
        request.setAttribute("page", page);
        request.setAttribute("pageSum", pageSum);
        request.setAttribute("list_page", list_page);
        request.getRequestDispatcher("/user/notice.jsp").forward(request,response);
    }
}
