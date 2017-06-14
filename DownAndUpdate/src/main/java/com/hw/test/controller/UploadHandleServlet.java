package com.hw.test.controller;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadBase;
import org.apache.commons.fileupload.ProgressListener;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
import java.util.UUID;

/**
 * Created by huangwei on 2017/5/31.
 */
public class UploadHandleServlet extends HttpServlet{

    public void doget(HttpServletRequest request, HttpServletResponse response) throws Exception{
        String CHARSET = "UTF-8";
        //得到上传文件的保存目录,将上传的文件存放在WEB-INF目录下，不允许外界直接访问，保证上传文件的安全
        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        File file = new File(savePath);
        //判断上传文件的保存目录是不是存在
        if (!file.exists() && !file.isDirectory()) {
            System.err.print(savePath + "目录不存在，需要创建");
            //创建目录
            file.mkdir();
        }
        //消息提示
        String message = "";
        try {
            //使用Apache文件上传组件处理文件上传步骤
            //1.创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //2.创建一个人文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //解决上传文件名的中文乱码
            upload.setHeaderEncoding("UFF-8");
            //3.判断提交上来的数据是否是上传的表单的数据
            if (!ServletFileUpload.isMultipartContent(request)) {
                //按照传统方式获取数据
                return;
            }
            //使用ServletFileUpload解析器解析上传的数据，解析结果返回的是一个List<FileItem>
            //每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fileItem : list) {
                //如果fileItem中封装的是普通输入项的数据
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
//                    String value = fileItem.getString("UTF_8");
//                    System.err.print(name + "=" + value);
                //如果fileItem封装的是上传文件
                }else {
                    //得到上传的文件名称
                    String filename = fileItem.getName();
                    //filename = URLDecoder.decode(filename,CHARSET);
                    System.err.print(filename);
                    if (filename == null || filename.trim().equals("")){
                        continue;
                    }
                    //注意：不同的浏览器提交的文件名是不一样的，有些浏览器提交的上来的文件名
                    //是带有路径的，如：C:\A\B\1.txt,而有些只是单纯的文件名，如：1.txt
                    filename = filename.substring(filename.lastIndexOf("\\") + 1);
                    //获取fileItem中的上传文件的输入流
                    InputStream inputStream = fileItem.getInputStream();
                    //创建一个文件的输出流
                    FileOutputStream outputStream = new FileOutputStream(savePath + "\\" + filename);
                    //创建一个缓冲区
                    byte buffer[] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int length = 0;
                    //循环将输入流读入到缓冲区当中，(length = inputStream.read(buffer)) > 0 标识inputStream里面还有数据
                    while ((length = inputStream.read(buffer))>0){
                        //使用FileOutStream输出流将缓冲区的数据写入到指定的目录(savePath + "\\" + filename)当中
                        outputStream.write(buffer,0,length);
                    }
                    //关闭输入流
                    inputStream.close();
                    //关闭输出流
                    outputStream.close();
                    //删除处理文件上传时生成的临时文件
                    fileItem.delete();
                    message = "文件上传成功！";
                }
            }
        }catch (Exception e){
            message = "文件上传失败！";
            e.printStackTrace();
        }
    }


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
        //得到上传文件的保存目录，将上传的文件存放于WEB_INF下，不允许外界直接访问，保证上传文件的安全
        String savePath = this.getServletContext().getRealPath("/WEB-INF/upload");
        //上传时生成的临时文件保存目录
        String tempPath = this.getServletContext().getRealPath("/WEB-INF/temp");
        File tempFile = new File(tempPath);
        //创建临时目录
        if (!tempFile.exists()){
            tempFile.mkdir();
        }
        String message = "";
        try {
            //使用Apache文件上传组件处理文件上传步骤
            //1.创建一个DiskFileItemFactory工厂
            DiskFileItemFactory factory = new DiskFileItemFactory();
            //设置工厂的缓冲器大小，当上传的文件大小超过缓冲区的大小时，就会生成一个
            //临时文件存放到指定的临时目录当中
            //设置缓冲区的大小为100kb,如果不指定，那么缓冲区的大小默认为10kb
            factory.setSizeThreshold(1024*100);
            //设置上传时生成的临时文件的保存目录
            factory.setRepository(tempFile);
            //2.创建一个文件上传解析器
            ServletFileUpload upload = new ServletFileUpload(factory);
            //监控文件上传的进度
            upload.setProgressListener(new ProgressListener() {
                public void update(long pBytesRead, long pContentLength, int arg2) {
                    System.err.println("文件大小为:" + pContentLength + ",当前已处理:" + pBytesRead);
                }
            });
            //解决上传文件名的乱码问题
            upload.setHeaderEncoding("UTF-8");
            //3.判断提交上来的数据是否是上传表单的数据
            if (!ServletFileUpload.isMultipartContent(request)){
                //按照传统的方式获取数据
                return;
            }
            //设置上传单个文件的大小的最大值，目前是设置为1024*1024*1000字节
            upload.setFileSizeMax(1024*1024*1000);
            //设置上传文件总量的最大值，最大值=同时上传的多个文件的大小的最大值的和，
            //目前为10000M
            upload.setSizeMax(1024*1024*10000);
            //4.使用ServletFileUpload解析器解析上传数据，解析结果返回的是一个
            //List<FileItem>集合，每一个FileItem对应一个Form表单的输入项
            List<FileItem> list = upload.parseRequest(request);
            for (FileItem fileItem : list) {
                //如果fileItem中封装的事普通输入项的数据
                if (fileItem.isFormField()) {
                    String name = fileItem.getFieldName();
                    //解决普通输入项的数据的中文乱码问题
                    String value = fileItem.getString("UTF-8");
                    System.err.println(name + "=" + value);
                    //如果fileItem中封装的是上传文件
                }else {
                    //获取上传文件的文件名称
                    String fileName = fileItem.getName();
                    System.err.println(fileName);
                    if (fileName == null || fileName.trim().equals("")) {
                        continue;
                    }
                    //注意: 不用的浏览器提交的文件的文件名是不一样的
                    //有些浏览器的提交上来的文件名是带有路径的，
                    //如：C:\a\b\1.txt,而有些只是单纯的文件名，
                    //如：1.txt
                    //处理获取到的上传文件的文件名的路径部分，只保留文件名部分
                    fileName = fileName.substring(fileName.lastIndexOf("\\") + 1);
                    //得到上传文件的拓展名
                    String fileExtName = fileName.substring(fileName.lastIndexOf(".") + 1);
                    System.err.println("上传的文件的扩展名是:" + fileExtName);
                    //获取fileItem中的上传文件的输入流
                    InputStream inputStream = fileItem.getInputStream();
                    //得到文件保存的名称
                    String saveFileName = makeFileName(fileName);
                    //得到文件保存的目录
                    String realSavePath = makePath(fileName,savePath);
                    //创建一个文件输出流
                    FileOutputStream outputStream = new FileOutputStream(realSavePath + "\\" + saveFileName);
                    //创建一个缓冲区
                    byte buffer [] = new byte[1024];
                    //判断输入流中的数据是否已经读完的标识
                    int length = 0;
                    //循环将输入流读入到缓冲区(length = inputStream.read(buffer))>0表示inputStream里面还有数据
                    while ((length = inputStream.read(buffer)) > 0){
                        //使用FileOutStream输入流将缓冲区的数据写入到指定的目录(savePath＋＂＼＼＂　＋ filename)当中
                        outputStream.write(buffer,0,length);
                    }
                    //关闭输入流
                    inputStream.close();
                    //关闭输出流
                    outputStream.close();

                    message = "文件上传成功";
                }
            }

        }catch (FileUploadBase.SizeLimitExceededException e){
            e.printStackTrace();
            request.setAttribute("message","单个文件超出最大值！！！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
            return;
        }catch (FileUploadBase.FileSizeLimitExceededException e){
            e.printStackTrace();
            request.setAttribute("message","上传文件的总的大小超出限制的最大值！！！");
            request.getRequestDispatcher("/message.jsp").forward(request,response);
            return;
        }catch (Exception e){
            e.printStackTrace();
            message = "文件上传失败！";
        }
        request.setAttribute("message",message);
        request.getRequestDispatcher( "/message.jsp").forward(request,response);

    }

    public String makeFileName (String fileName) {
        //为防止文件被覆盖的现象发生，要为上传文件产生一个唯一的文件名
        return UUID.randomUUID().toString() + "_" + fileName;
    }

    public String makePath(String fileName, String savePath){
        //得到文件名的hashCode的值，得到的就是fileItem这个字符串对象在内存中的地址
        int hashCode = fileName.hashCode();
        int dir1 = hashCode&0xf;
        int dir2 = (hashCode&0xf0) >> 4;
        //构造新的保存目录
        String dir = savePath + "\\" + dir1 + "\\" + dir2;
        //File既可以代表文件也可以代表目录
        File file = new File(dir);
        //如果目录不存在
        if (!file.exists()) {
            //创建目录
            file.mkdirs();
        }
        return dir;
    }

    public void doPost(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse) throws ServletException,IOException{
        try {
            doget(httpServletRequest,httpServletResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
