package web.user;

import dao.RepairDao;
import dao.iml.RepairDaoIml;
import domain.Repair;
import domain.User;
import net.sf.json.JSONObject;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "RepairRateServlet",urlPatterns = "/user/repair/rate")
public class RepairRateServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Map<String,Object> map = new HashMap<>();
        if (request.getParameter("id") == null || request.getParameter("id").equals("") || request.getParameter("value") == null) {
            map.put("code","-2");
            map.put("status","PARAM_ERR");
            map.put("message","参数不完整");
        }else {
            int id = Integer.parseInt(request.getParameter("id"));
            RepairDao repairDao = new RepairDaoIml();
            Repair repair = repairDao.find(id);
            User user = (User) request.getSession().getAttribute("object");
            if (repair == null || repair.getUser_id() != user.getId()) {
                map.put("code","-1");
                map.put("status","PERMISSION_ERR");
                map.put("message","您没有该权限");
            }else {
                int value = Integer.parseInt(request.getParameter("value"));
                repair.setRate(value);
                repairDao.updateRepair(repair);
                map.put("code","0");
                map.put("status","OK");
                map.put("message","评分成功！");
            }
        }
        JSONObject jsonObject = JSONObject.fromObject(map);
        response.getWriter().println(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
