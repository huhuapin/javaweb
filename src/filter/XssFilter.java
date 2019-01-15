package filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

@WebFilter(filterName = "XssFilter")
public class XssFilter implements Filter {

    public void destroy() {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws ServletException, IOException {
        HttpServletRequest req = (HttpServletRequest) request;
        HttpServletResponse res = (HttpServletResponse) response;
        req.setCharacterEncoding("UTF-8");
        res.setCharacterEncoding("UTF-8");
        res.setContentType("text/html;charset=UTF-8");

        //获得所有请求参数名
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
//        chain.doFilter(req, res);
//        return;
        //有xss过滤关键字
        if (xssValidate(sql)) {
            PrintWriter printWriter = response.getWriter();
            printWriter.println("<script>alert('您的输入含有非法字符！');location.href='/dormitory/login';</script>");
        } else {
            chain.doFilter(req, res);
        }
    }

    protected static boolean xssValidate(String str) {
        str = str.toLowerCase();
        String badStr = "script|javascript|.js|vbscript:|view-source:";
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) != -1) return true;
        }
        return false;
    }

    public void init(FilterConfig config) throws ServletException {

    }

}
