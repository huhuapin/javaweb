package web.user;

import dao.MessageDao;
import dao.iml.MessageDaoIml;
import domain.Message;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "CreateMessageServlet",urlPatterns = "/user/message/create")
public class CreateMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=utf-8");
        User user = (User) request.getSession().getAttribute("object");
        String content = request.getParameter("content");
        Date currentTime = new Date();
        //获取当前时间
        Timestamp timestamp = new Timestamp(currentTime.getTime());
        Message message = new Message();
        message.setContent(content);
        message.setCreated_at(timestamp);
        message.setDormitory_id(user.getDormitory_id());
        //初始化点赞数为0
        message.setPraise(0);
        message.setUser_id(user.getId());
        MessageDao messageDao = new MessageDaoIml();
        messageDao.add(message);
        response.getWriter().println("<script>location.href = '"+request.getContextPath()+"/user/index';</script>");
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
