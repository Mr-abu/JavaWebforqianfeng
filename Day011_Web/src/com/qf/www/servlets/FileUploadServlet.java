package com.qf.www.servlets;

import com.qf.www.utils.UploadUtils;
import javafx.util.BuilderFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@WebServlet(name = "FileUploadServlet", value = "/fileupload")
@MultipartConfig(maxFileSize = 1024*1024*100, maxRequestSize = 1024*1024*200)
public class FileUploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");

        //文件上传的实现步骤
        //1.获取文件上传的路径
        String realPath = request.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(realPath);
        if (!file.exists()) {  //如果upload不存在
            file.mkdir();
        }

        //2.通过请求获得多分部的集合
        Collection<Part> parts = request.getParts();
//        System.out.println(parts.size());
        for (Part part : parts) {
            //3.在part可以获得当前上传的是文件还是普通的表单

//            String name = part.getName();
//            System.out.println(name);
            String fileName = part.getSubmittedFileName();

            if (fileName != null ) {
                List<String> fileNames = new ArrayList<String>();
                fileNames.add(".jpg");
                fileNames.add(".png");
                fileNames.add(".bmp");
                fileNames.add(".gif");

                String backZhui = fileName.substring(fileName.lastIndexOf("."));
                if (!fileNames.contains(backZhui)) {
                    response.getWriter().println(fileName + "不符合格式要求，上传失败");
                    continue;
                }
                //通过工具类获得文件唯一的名称
                String newFileName = UploadUtils.newFileName(fileName);
                //通过工具类获得打散的二级，三级目录
                String newFilePath = UploadUtils.newFilePath(realPath, fileName);
                //文件上传 --》路径 + 文件名称  File.separator 自动解析当前JDK运行平台的分隔符
//                part.write(realPath + "\\" + fileName);
                part.write(newFilePath + File.separator + newFileName);
                part.delete();  //如果写了缓冲区  --》清除临时缓冲区
//                System.out.println(fileName);

            } else {
                //打印或者后续改成上传数据库 调用Service
                String name = part.getName();
                String parameter = request.getParameter(name);
//                System.out.println(parameter);
            }

        }
    }
}
