package com.qf.www.servlets;

import com.qf.www.utils.UploadUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;

@WebServlet(name = "FileListServlet", value = "filelist")
public class FileListServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //1.获取下载的目录路径
        String realPath = request.getServletContext().getRealPath("/WEB-INF/upload");
        //2.Map集合 键--UUID 值--原名称
        HashMap<String , String > fileNames = new HashMap<String, String>();
        //3.调用工具类的方法，把所有的文件的名字，文件的UUID后的名字都封装在集合里
        UploadUtils.getFileList(realPath, fileNames);
    }
}
