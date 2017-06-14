package com.hw.test.controller;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;

/**
 * Created by huangwei on 2017/6/7.
 */
public class downloadServlet extends HttpServlet{


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request, response);
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{

        String fileName = request.getParameter("fileName");
        fileName = new String(fileName.getBytes("iso8859-1"),"UTF-8");

        String fileSaveRootPath = this.getServletContext().getRealPath("/WEB-INF/upload");

        String path = findFileSavePathByFileName(fileName,fileSaveRootPath);

        File file = new File(fileSaveRootPath + "\\" + fileName);

        if (!file.exists()) {
            request.setAttribute("message","您要下载的资源不存在！！！");
            request.getRequestDispatcher("/message.jsp").forward(request, response);
            return;
        }
        String realName = fileName.substring(fileName.indexOf("_") + 1);

        response.setHeader("content-disposition","attachment;fileName=" + URLEncoder.encode(realName,"UTF-8"));
        FileInputStream inputStream = new FileInputStream(fileSaveRootPath + "\\" + fileName);

        OutputStream outputStream = response.getOutputStream();
        byte buffer[] = new byte[1024];
        int length = 0;
        while ((length= inputStream.read(buffer))>0){
            outputStream.write(buffer,0,length);
        }
        inputStream.close();
        outputStream.close();
    }

    public String findFileSavePathByFileName(String fileName, String saveRootPath) {

        int hashcode = fileName.hashCode();
        int dir1 = hashcode&0xf;
        int dir2 = (hashcode&0xf0) >> 4;
        String dir = saveRootPath + "\\" + dir1 + "\\" + dir2;
        File file = new File(dir);
        if (!file.exists()) {
            file.mkdirs();
        }
        return dir;
    }
}
