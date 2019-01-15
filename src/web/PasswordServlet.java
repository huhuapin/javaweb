package web;

import dao.AdminDao;
import dao.UserDao;
import dao.iml.AdminDaoIml;
import dao.iml.UserDaoIml;
import domain.Admin;
import domain.User;
import net.sf.json.JSONObject;
import utils.MD5Utils;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "PasswordServlet",urlPatterns = "/password")
public class PasswordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        HttpSession session = request.getSession();
        String old_password = request.getParameter("old_password");
        String new_password_cofirmation = request.getParameter("new_password_confirmation");
        String new_password = request.getParameter("new_password");
        Map<String,String> map = new HashMap<String,String>();
        //参数不完整
        if (old_password == null || new_password_cofirmation == null || new_password == null) {
            map.put("code","-2");
            map.put("status","PARAM_ERR");
            map.put("message","参数不完整");
        }else if (!new_password.equals(new_password_cofirmation)) {
            //密码不一致
            map.put("code","-1");
            map.put("status","VALIDATE_ERR");
            map.put("message","两次密码输入不一致");
        }else if (session.getAttribute("identity") != null) {
            //已登录
            if ((int) session.getAttribute("identity") != 0) {
                //管理员
                Admin admin = (Admin) session.getAttribute("object");
                if (admin.getPassword().equals(MD5Utils.md5(MD5Utils.md5(old_password)))) {
                    //密码正确
                    AdminDao adminDao = new AdminDaoIml();
                    adminDao.modify(admin.getId(),new_password);
                    session.setAttribute("object", admin);
                    map.put("code","0");
                    map.put("status","OK");
                    map.put("message","修改成功");
                }else {
                    //密码错误
                    map.put("code","1");
                    map.put("status","PASSWORD_ERR");
                    map.put("message","密码错误");
                }
            }else {
                //用户
                User user = (User)session.getAttribute("object");
                if (user.getPassword().equals(MD5Utils.md5(MD5Utils.md5(old_password)))) {
                    //密码正确
                    UserDao userDao = new UserDaoIml();
                    userDao.modify(user.getId(), new_password);
                    session.setAttribute("object",user);
                    map.put("code","0");
                    map.put("status","OK");
                    map.put("message","修改成功");
                }else {
                    //密码错误
                    map.put("code","1");
                    map.put("status","PASSWORD_ERR");
                    map.put("message","密码错误");
                }
            }
        }
        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().println(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
