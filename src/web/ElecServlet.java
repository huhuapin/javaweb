package web;

import org.apache.commons.httpclient.Cookie;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.URI;
import org.apache.commons.httpclient.cookie.CookiePolicy;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.methods.PostMethod;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ElecServlet",urlPatterns = "/test")
public class ElecServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");
        String loginUrl = "http://hqfw.sdut.edu.cn/login.aspx";
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(loginUrl);
        int code = 0;
        // 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
        httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        code = httpClient.executeMethod(getMethod);

        // 获得登陆后的 Cookie
        Cookie[] cookies = httpClient.getState().getCookies();
        StringBuffer tmpcookies = new StringBuffer();
        for (Cookie c : cookies) {
            tmpcookies.append(c.toString() + ";");
            System.out.println("cookies = "+c.toString());
        }

        //正则匹配
        String pattern = "<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"([^<>]+)\" />";
        Pattern r = Pattern.compile(pattern);
        Matcher m1 = r.matcher(getMethod.getResponseBodyAsString());
        if (m1.find()) {
            System.out.println(m1.group(0));
        }else {
            System.out.println("m1未找到");
        }

        String pattern2 = "<input type=\"hidden\" name=\"__EVENTVALIDATION\" id=\"__EVENTVALIDATION\" value=\"([^<>]+)\" />";
        r = Pattern.compile(pattern2);
        Matcher m2 = r.matcher(getMethod.getResponseBodyAsString());
        if (m2.find()) {
            System.out.println(m2.group(0));
        }else {
            System.out.println("m2未找到");
        }

        PostMethod postMethod = new PostMethod(loginUrl);
        // 设置登陆时要求的信息，用户名和密码
        NameValuePair[] data = { new NameValuePair("__VIEWSTATE", m1.group(1)), new NameValuePair("__EVENTVALIDATION", m2.group(1)),
        new NameValuePair("ctl00$MainContent$txtName","胡华聘"),new NameValuePair("ctl00$MainContent$txtID","16111101135"),new NameValuePair("ctl00$MainContent$btnTijiao","登录")};
        postMethod.setRequestBody(data);
        postMethod.setRequestHeader("cookie",tmpcookies.toString());
        postMethod.setRequestHeader("Referer", loginUrl);
        postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
        //模拟登陆请求
        httpClient.executeMethod(postMethod);
        response.getWriter().println(postMethod.getResponseBodyAsString());
    }
}
