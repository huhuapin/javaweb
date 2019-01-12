package web;

import net.sf.json.JSONObject;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@WebServlet(name = "ImageUploadServlet",urlPatterns = "/images/upload")
public class ImageUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("UTF-8");
        request.setCharacterEncoding("UTF-8");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        //设置文件临时上传路径

        String savePath = this.getServletContext().getRealPath("/uploads/");
        File file = new File(savePath);
        if (!file.exists()) {
            //文件夹不存在，新建文件夹
            file.mkdir();
        }

        //设置文件缓存的路径
        factory.setRepository(file);
        //创建ServletFileUpload对象
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        fileUpload.setHeaderEncoding("utf-8");

        try {

            //获取请求参数
            List<FileItem> fileItems = fileUpload.parseRequest(request);
            for (FileItem fileItem : fileItems) {
                String filename = fileItem.getName();
                //处理上传文件
                if (filename != null && !filename.equals("")) {
                    //文件不为空
                    System.out.println(filename);
                    //新建唯一名称
                    filename = UUID.randomUUID().toString() + "_" + filename;
                    File file1 = new File(savePath+filename);
                    file1.getParentFile().mkdirs();
                    file1.createNewFile();
                    //获取输入流
                    InputStream in = fileItem.getInputStream();
                    FileOutputStream out = new FileOutputStream(file1);
                    //设置缓冲大小 1024,一次读入1024个字节
                    byte[] buffer = new byte[1024];
                    int len;
                    //写入文件
                    while((len = in.read(buffer)) >0) {
                        out.write(buffer,0,len);
                    }
                    in.close();
                    out.close();
                    //删除临时文件
                    fileItem.delete();
                    //返回json  文件地址
                    Map<String,Object> map = new HashMap<>();
                    map.put("code","0");
                    map.put("status","OK");
                    map.put("message","上传成功");
                    Map<String,String> data = new HashMap<>();
                    data.put("src",request.getContextPath()+"/uploads/"+filename);
                    map.put("data", data);
                    response.getWriter().println(JSONObject.fromObject(map));
                }
            }
        } catch (FileUploadException e) {
            e.printStackTrace();
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
