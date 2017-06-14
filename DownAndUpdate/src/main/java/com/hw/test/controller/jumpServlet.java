package com.hw.test.controller;

import com.hw.test.Constant.Constants;
import com.hw.test.Constant.publicMethod;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.http.HTTPException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangwei on 2017/6/7.
 */
public class jumpServlet extends HttpServlet{


    public publicMethod publicMethod;


    public void doPost(HttpServletRequest request,HttpServletResponse response){
        try {
            doGet(request,response);
        }catch (Exception e){

        }
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        String jspName = request.getParameter("jspName");
        Map<String,String> params = new HashMap<String, String>();
        if (jspName.equals(Constants.PAGE)) {
            publicMethod publicMethod = new publicMethod();
            try{
                params = publicMethod.getFiles(request,response,this.getServletContext());
                request.setAttribute("fileNameMap",params);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/"+jspName + ".jsp");
        requestDispatcher.forward(request,response);
    }

    public publicMethod getPublicMethod() {
        return publicMethod;
    }

    public void setPublicMethod(publicMethod publicMethod) {
        this.publicMethod = publicMethod;
    }
}
