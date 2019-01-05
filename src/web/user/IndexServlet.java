package web.user;

import dao.MessageDao;
import dao.iml.DormitoryDaoIml;
import dao.iml.MessageDaoIml;
import dao.iml.NoticeDaoIml;
import dao.iml.UserDaoIml;
import domain.Dormitory;
import domain.Message;
import domain.Notice;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
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
            firstNotice = noticeDaoIml.getFirst();
            session.setAttribute("firstNotice",firstNotice);
        }
        MessageDao messageDao = new MessageDaoIml();
        List<Message> messages = messageDao.findAll(user.getDormitory_id());
        request.setAttribute("messages",messages);
        request.getRequestDispatcher("/user/index.jsp").forward(request,response);
    }
}
