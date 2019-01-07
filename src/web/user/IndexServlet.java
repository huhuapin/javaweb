package web.user;

import dao.MessageDao;
import dao.iml.DormitoryDaoIml;
import dao.iml.MessageDaoIml;
import dao.iml.NoticeDaoIml;
import dao.iml.UserDaoIml;
import domain.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "UserIndexServlet",urlPatterns = "/user/index")
public class IndexServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        HttpSession session = request.getSession();
        User user = (User)session.getAttribute("user");
        Dormitory dormitory = (Dormitory) session.getAttribute("dormitory");
        if (dormitory == null ) {
            DormitoryDaoIml dormitoryDaoIml = new DormitoryDaoIml();
            dormitory = dormitoryDaoIml.find(user.getDormitory_id());
            session.setAttribute("dormitory",dormitory);
        }
        List<User> roommates = (List<User>) session.getAttribute("roommates");
        if (roommates == null) {
            UserDaoIml userDaoIml = new UserDaoIml();
            roommates = userDaoIml.getRoommate(user);
            session.setAttribute("roommates",roommates);
        }
        Notice firstNotice = (Notice) session.getAttribute("firstNotice");
        if (firstNotice == null ){
            NoticeDaoIml noticeDaoIml = new NoticeDaoIml();
            firstNotice = noticeDaoIml.getFirst(dormitory.getId());
            session.setAttribute("firstNotice",firstNotice);
        }
        MessageDao messageDao = new MessageDaoIml();
        List<Message> messages = new ArrayList<>();
        messages = messageDao.findAll(user.getDormitory_id());
        //页面当前页
        int curPage = 0;
        //jsp传过来的当前页
        String strPage = request.getParameter("page");
        Page page = new Page();
        page.setPageSize(6);
        page.setCount(messages.size());
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
        List<Message> list_page = new ArrayList<>();
        for(int i = page.getPage() * page.getPageSize(); i <(page.getPage()+1)*page.getPageSize() && i < messages.size(); i++) {
            list_page.add(messages.get(i));
        }
        request.setAttribute("page", page);
        request.setAttribute("list_page", list_page);
        request.getRequestDispatcher("/user/index.jsp").forward(request,response);
    }
}
