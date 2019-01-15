package web;

import net.sf.json.JSON;
import net.sf.json.JSONObject;
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
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@WebServlet(name = "ElecServlet",urlPatterns = "/elec")
public class ElecServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        response.setContentType("text/html;charset=UTF-8");

        //获取参数
        String school = request.getParameter("school");
        String dormitory = request.getParameter("dormitory");
        String room = request.getParameter("room");

        String cookieUrl = "http://hqfw.sdut.edu.cn/"; //获取cookie的地址
        String loginUrl = "http://hqfw.sdut.edu.cn/login.aspx";//登录地址
        String elecUrl = "http://hqfw.sdut.edu.cn/stu_elc.aspx";//查询地址
        PrintWriter printWriter = response.getWriter();

        //创建一个HttpClient
        HttpClient httpClient = new HttpClient();
        GetMethod getMethod = new GetMethod(cookieUrl);
        int code = 0;
        // 设置 HttpClient 接收 Cookie,用与浏览器一样的策略
        httpClient.getParams().setCookiePolicy(CookiePolicy.BROWSER_COMPATIBILITY);
        httpClient.executeMethod(getMethod);

        // 获得登陆后的 Cookie
        Cookie[] cookies = httpClient.getState().getCookies();
        StringBuffer tmpcookies = new StringBuffer();
        for (Cookie c : cookies) {
            tmpcookies.append(c.toString() + ";");
            System.out.println("cookies = "+c.toString());
        }

        //获取登录所需参数

        getMethod.setURI(new URI(loginUrl,true));         //重新设置getMethod的地址为登录地址
        getMethod.setRequestHeader("cookie",tmpcookies.toString());
        httpClient.executeMethod(getMethod);
        //正则匹配
        Matcher m1 = Pattern.compile("<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"([^<>]+)\" />").matcher(getMethod.getResponseBodyAsString());
        Matcher m2 = Pattern.compile("<input type=\"hidden\" name=\"__EVENTVALIDATION\" id=\"__EVENTVALIDATION\" value=\"([^<>]+)\" />").matcher(getMethod.getResponseBodyAsString());
        m1.find();
        m2.find();

        //模拟提交
        PostMethod postMethod = new PostMethod(loginUrl);
        // 设置登陆时要求的信息，用户名和密码
        NameValuePair[] data = { new NameValuePair("__VIEWSTATE", m1.group(1)), new NameValuePair("__EVENTVALIDATION", m2.group(1)),
                new NameValuePair("ctl00$MainContent$txtName","胡华聘"),new NameValuePair("ctl00$MainContent$txtID","16111101135"),new NameValuePair("ctl00$MainContent$btnTijiao","登录")};
        //设置提交信息
        postMethod.setRequestBody(data);
        //设置请求头
        postMethod.setRequestHeader("cookie",tmpcookies.toString());
        postMethod.setRequestHeader("Referer", loginUrl);
        postMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        postMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
        httpClient.executeMethod(postMethod);

        //请求查询电费页面，获取提交所需参数
        getMethod.setURI(new URI(elecUrl,true));
        getMethod.setRequestHeader("cookie",tmpcookies.toString());
        System.out.println(tmpcookies.toString());
        getMethod.setRequestHeader("Referer", loginUrl);
        getMethod.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        getMethod.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
        httpClient.executeMethod(getMethod);
//        printWriter.println(getMethod.getResponseBodyAsString());
        Matcher matcher1 = Pattern.compile("<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"([^<>]+)\" />").matcher(getMethod.getResponseBodyAsString());
        Matcher matcher2 = Pattern.compile("<input type=\"hidden\" name=\"__VIEWSTATEGENERATOR\" id=\"__VIEWSTATEGENERATOR\" value=\"([^<>]+)\" />").matcher(getMethod.getResponseBodyAsString());
        Matcher matcher3 = Pattern.compile("<input type=\"hidden\" name=\"__EVENTVALIDATION\" id=\"__EVENTVALIDATION\" value=\"([^<>]+)\" />").matcher(getMethod.getResponseBodyAsString());
        matcher1.find();
        System.out.println(matcher1.group(1));
        matcher2.find();
        System.out.println(matcher2.group(1));
        matcher3.find();
        System.out.println(matcher3.group(1));
        String building;
        String campus;
        if (school.equals("1")) {
            building ="ctl00$MainContent$buildingwest";
            campus = "1";
        }else {
            building ="ctl00$MainContent$buildingeast";
            campus = "0";
            postMethod.setURI(new URI(elecUrl,true));
            postMethod.setRequestHeader("cookie","ASP.NET_SessionId=jmg54b0hmfu0i0tgnrl01x2f");
            NameValuePair[] data1 = {new NameValuePair("__EVENTTARGET","ctl00$MainContent$campus"),new NameValuePair("__EVENTARGUMENT",""),new NameValuePair("__LASTFOCUS",""),
                    new NameValuePair("__VIEWSTATE",matcher1.group(1)),new NameValuePair("__VIEWSTATEGENERATOR",matcher2.group(1)),new NameValuePair("__EVENTVALIDATION",matcher3.group(1)),
                    new NameValuePair("ctl00$MainContent$buildingwest","01#南"),new NameValuePair("ctl00$MainContent$roomnumber","101"),new NameValuePair("ctl00$MainContent$TextBox1","请先登录，再选择楼栋和输入房间号查询!")};
            postMethod.setRequestBody(data1);
            httpClient.executeMethod(postMethod);
            response.getWriter().println(postMethod.getResponseBodyAsString());
            matcher1 = Pattern.compile("<input type=\"hidden\" name=\"__VIEWSTATE\" id=\"__VIEWSTATE\" value=\"([^<>]+)\" />").matcher(postMethod.getResponseBodyAsString());
            matcher2 = Pattern.compile("<input type=\"hidden\" name=\"__VIEWSTATEGENERATOR\" id=\"__VIEWSTATEGENERATOR\" value=\"([^<>]+)\" />").matcher(postMethod.getResponseBodyAsString());
            matcher3 = Pattern.compile("<input type=\"hidden\" name=\"__EVENTVALIDATION\" id=\"__EVENTVALIDATION\" value=\"([^<>]+)\" />").matcher(postMethod.getResponseBodyAsString());
            matcher1.find();
            System.out.println(matcher1.group(0));
            matcher2.find();
            System.out.println(matcher2.group(0));
            matcher3.find();
            System.out.println(matcher3.group(0));
        }
        PostMethod postMethod1 = new PostMethod(elecUrl);
        postMethod1.setRequestHeader("cookie",tmpcookies.toString());
        postMethod1.setRequestHeader("Referer", elecUrl);
        postMethod1.setRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=utf-8");
        postMethod1.setRequestHeader("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/31.0.1650.63 Safari/537.36");
        NameValuePair[] data2 = {new NameValuePair("__EVENTTARGET",""),new NameValuePair("__EVENTARGUMENT",""),new NameValuePair("__LASTFOCUS",""),
                new NameValuePair("__VIEWSTATE",matcher1.group(1)),new NameValuePair("__VIEWSTATEGENERATOR",matcher2.group(1)),new NameValuePair("__EVENTVALIDATION",matcher3.group(1)),
                new NameValuePair("ctl00$MainContent$campus",campus),
                new NameValuePair(building,dormitory),new NameValuePair("ctl00$MainContent$roomnumber",room),new NameValuePair("ctl00$MainContent$Button1","查询"),new NameValuePair("ctl00$MainContent$TextBox1","请先登录，再选择楼栋和输入房间号查询!")};

        postMethod1.setRequestBody(data2);
        httpClient.executeMethod(postMethod1);
        Matcher matcher = Pattern.compile("您所查询的房间为：([^<>]+)。\\r\\n 在([^<>]+)时，所余电量为：([^<>]+)度。\\r\\n 根据您的用电规律，所余电量可用 ([^<>]+)天。\\r\\n 当前用电状态为：([^<>]+)。").matcher(postMethod1.getResponseBodyAsString());
        if (matcher.find()) {
            System.out.println("spider success");
        }
        Map<String,Object> map = new HashMap<>();
        map.put("code","0");
        map.put("status","OK");
        map.put("message","查询成功");
        Map<String,Object> data0 = new HashMap<>();
        data0.put("room",matcher.group(1));
        data0.put("time",matcher.group(2));
        data0.put("elec",matcher.group(3));
        data0.put("remain",matcher.group(4));
        data0.put("status",matcher.group(5));
        map.put("data",data0);
        JSONObject jsonObject = JSONObject.fromObject(map);
        printWriter.println(jsonObject);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
    public static String Pair_2_String(NameValuePair[] nvp) throws Exception {

        StringBuffer sfb = new StringBuffer();

        for (int i = 0; i < nvp.length; i++) {
            sfb.append(nvp[i].getName() + "=");
            sfb.append(nvp[i].getValue() + "<br>");
        }
        return sfb.toString();

    }
}
