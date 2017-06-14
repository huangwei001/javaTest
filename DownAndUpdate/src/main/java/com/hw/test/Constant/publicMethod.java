package com.hw.test.Constant;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by huangwei on 2017/6/7.
 */
public class publicMethod {

    public publicMethod(){

    }

    public Map<String, String> getFiles(HttpServletRequest request, HttpServletResponse response, ServletContext servletContext) throws ServletException, IOException{
        String uploadFilePath = servletContext.getRealPath("/WEB-INF/upload");
        Map<String, String> fileNameMap = new HashMap<String, String>();
        listFile(new File(uploadFilePath),fileNameMap);
        return fileNameMap;
    }

    public void listFile(File file, Map<String, String> condition){

        if (!file.isFile()){
            File files[] = file.listFiles();
            for (File file1 : files) {
                listFile(file1,condition);
            }
        }else{
            String realName = file.getName().substring(file.getName().indexOf("_") + 1);
            condition.put(file.getName(),realName);
        }
    }

}
