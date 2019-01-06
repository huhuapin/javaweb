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
        System.out.println("22-----------");
        DiskFileItemFactory factory = new DiskFileItemFactory();
        String savePath = this.getServletContext().getRealPath("/uploads/");
        System.out.println(savePath);
        File file = new File(savePath);
        if (!file.exists()) {
            System.out.println("文件夹不存在");
            file.mkdir();
        }
        System.out.println("29-----------");

        //设置文件缓存的路径
        factory.setRepository(file);
        //创建ServletFileUpload对象
        ServletFileUpload fileUpload = new ServletFileUpload(factory);
        fileUpload.setHeaderEncoding("utf-8");
        System.out.println("36-----------");

        try {
            System.out.println("39-----------");

            List<FileItem> fileItems = fileUpload.parseRequest(request);
            System.out.println("42-----------");
            for (FileItem fileItem : fileItems) {
                String filename = fileItem.getName();
                //处理上传文件
                System.out.println("46----------- " + filename);
                if (filename != null && !filename.equals("")) {
                    System.out.println(filename);
                    filename = UUID.randomUUID().toString() + "_" + filename;
                    File file1 = new File(savePath+filename);
                    file1.getParentFile().mkdirs();
                    file1.createNewFile();
                    InputStream in = fileItem.getInputStream();
                    FileOutputStream out = new FileOutputStream(file1);
                    byte[] buffer = new byte[1024];
                    int len;
                    while((len = in.read(buffer)) >0) {
                        out.write(buffer,0,len);
                    }
                    in.close();
                    out.close();
                    fileItem.delete();
                    System.out.println("文件上传成功");
                    System.out.println("上传路径："+savePath+filename);
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
