package web.user;

import dao.FundsDao;
import dao.iml.FundsDaolml;
import domain.Funds;
import domain.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Timestamp;
import java.util.Date;

@WebServlet(name = "FundsServlet", urlPatterns = "/user/funds/create")
public class FundsServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //获取参数
        String title = request.getParameter("title");
        String type1 = request.getParameter("type");
        int type = (Integer) Integer.parseInt(type1);
        String money1 = request.getParameter("money");
        double money = Double.parseDouble(money1);
        if(type == 0){
            money = money*(-1);
        }
        String description = request.getParameter("description");

        //获取session用户
        User user = (User)request.getSession().getAttribute("object");

        //获取当前时间
        Date currentTime = new Date();
        //Timestamp timestamp = new Timestamp(currentTime.getTime());

        //创建Funds类
        Funds funds = new Funds();
        funds.setDescription(title);
        funds.setUser_id(user.getId());
        funds.setName(user.getName());
        funds.setMoney(money);
        funds.setCreated_at(new Timestamp(currentTime.getTime()));
        funds.setDormirory_id(user.getDormitory_id());
        funds.setRoom(user.getRoom());
        FundsDao fundsdao1 = new FundsDaolml();
        double balance = fundsdao1.sumBalance(user.getDormitory_id(),user.getRoom());
        if(balance+money < 0){
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<script>alert('舍费不足');location.href='"+request.getContextPath()+"/user/funds';</script>");
            return;
        }
        funds.setBalance(balance+money);
        //存入数据库
        FundsDao fundsdao = new FundsDaolml();
        fundsdao.addFunds(funds);
        PrintWriter printWriter = response.getWriter();
        printWriter.println("<script>alert('记录成功');location.href='"+request.getContextPath()+"/user/funds';</script>");
        return;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        request.getRequestDispatcher("/user/funds.jsp").forward(request,response);
    }
}
