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
import java.util.List;

@WebServlet(name = "FundsRecordServlet",urlPatterns = "/user/funds")
public class FundsRecordServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        User user = (User)request.getSession().getAttribute("object");
        FundsDao fundsDao = new FundsDaolml();
        List<Funds> allfunds = fundsDao.findByRoomId(user.getDormitory_id(),user.getRoom(),0,10);
        request.setAttribute("allfunds",allfunds);
        request.getRequestDispatcher("/user/funds_list.jsp").forward(request,response);
    }
}
