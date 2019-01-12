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
import java.io.PrintWriter;

@WebServlet(name = "DeleteMessageServlet",urlPatterns = "/user/message/delete")
public class DeleteMessageServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        User user = (User) request.getSession().getAttribute("object");
        PrintWriter printWriter = response.getWriter();
        if (request.getParameter("id") != null) {
            //参数不为空
            int id = Integer.parseInt( request.getParameter("id"));
            MessageDao messageDao = new MessageDaoIml();
            //查找该留言
            Message message = messageDao.find(id);
            if (message!=null && message.getUser_id() == user.getId()) {
                //如果留言者和登录用户是一个人，可以删除
                messageDao.delete(id);
                printWriter.println("<script>location.href='/dormitory/user/index';</script>");
            }else {
                //否则，不允许删除
                printWriter.println("<script>alert('删除失败！您没有该权限或留言已删除');location.href='/dormitory/user/index';</script>");
            }
        }else{
            //没有参数 id
            printWriter.println("<script>alert('删除失败！，参数错误');location.href='/dormitory/user/index';</script>");
        }
    }
}
