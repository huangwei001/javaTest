package com.hw.test.controller;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangwei on 2017/6/7.
 */
public class ListFileServlet extends HttpServlet{

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        String uploadFilePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        Map<String, String> fileNameMap = new HashMap<String, String>();
        listFile(new File(uploadFilePath),fileNameMap);
        request.setAttribute("fileNameMap",fileNameMap);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/download.jsp");
        try {
            requestDispatcher.forward(request, response);
            return;
        }catch (Exception e){

        }
    }

    public void listFile(File file, Map<String, String> condition){

        if (!file.isFile()) {
            File files[] = file.listFiles();
            for (File file1 : files) {
                listFile(file1,condition);
            }
        }else{
            String realName = file.getName().substring(file.getName().indexOf("_") + 1);
            condition.put(file.getName(),realName);
        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        doGet(request,response);
    }
}
