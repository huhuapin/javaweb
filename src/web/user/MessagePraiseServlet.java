package web.user;

import com.mysql.cj.xdevapi.JsonArray;
import dao.MessageDao;
import dao.iml.MessageDaoIml;
import domain.Message;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "MessagePraiseServlet",urlPatterns = "/user/praise")
public class MessagePraiseServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        Map<String,String> map = new HashMap<String, String>();
        if (request.getAttribute("id") == null) {
            map.put("code","-1");
            map.put("message","参数无效");
            map.put("status","PARAM_ERR");
        }else {
            int id = (int)request.getAttribute("id");
            MessageDao messageDao = new MessageDaoIml();
            Message message = messageDao.find(id);
            if (message == null) {
                map.put("code","1");
                map.put("message","未找到该留言");
                map.put("status","ID_ERR");
            }else {
                messageDao.praise(id);
                map.put("code","0");
                map.put("message","点赞成功");
                map.put("status","OK");
            }
        }

        response.getWriter().println();
    }
}
