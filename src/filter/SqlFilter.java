package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebFilter(filterName = "SqlFilter")
public class SqlFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");
        //获得所有请求参数名
        @SuppressWarnings("rawtypes")
        Enumeration params = req.getParameterNames();

        String sql = "";
        while (params.hasMoreElements()) {
            //得到参数名
            String name = params.nextElement().toString();
            //得到参数对应值
            String[] value = req.getParameterValues(name);
            for (int i = 0; i < value.length; i++) {
                sql = sql + value[i];
            }
        }
        PrintWriter printWriter = response.getWriter();
        //有sql关键字
        if (sqlValidate(sql)) {
            printWriter.println("<script>alert('用户名密码错误');location.href='/dormitory/login';</script>");
        } else {
            chain.doFilter(req, res);
        }
    }

    protected static boolean sqlValidate(String str) {
        str = str.toLowerCase();
        //过滤掉的sql关键字
        String badStr = "database|insert|create|drop|alert|table|from|grant|revoke|use|column_name|union|where" +
                "|select|update|order|by|count|*|sys|delete|or|;|-|--|+|,|like|//|/|%|#";
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) != -1) return true;
        }
        return false;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
