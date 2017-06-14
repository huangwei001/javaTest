package com.java.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by huangwei on 2017/6/14.
 */
public class fileInputStream {

    public static void main(String[] args) throws FileNotFoundException {
        //使用变量i来装调用read()方法是返回的函数
        int i = 0;
        //使用FileInputSttream流来读取有中文的内容时，读取出来的是乱码，因为使用InputStream流
        //里面的read()方法读取内容是是一个字节一个字节的读取的，而汉字是占用两个字节的,所以读取出来的
        //汉字无法正常显示
        //FileReader inputStream = null，使用FileReader流来读取内容时，中英文都可以正确显示，因为
        //reader流里面的read方法是一个字符一个字符的读取的，这样每次读取出来的都是一个完整的汉字
        //这样就可以正常的显示了
        java.io.FileInputStream inputStream = null;
        try {
            //读取文件
            inputStream = new java.io.FileInputStream("F:\\TestFile\\TestFile.docx");
        }catch (FileNotFoundException e){
            System.err.println("系统文件不存在");
            System.exit(-1);
        }
        //使用变量num来记录读取到的字符数
        long num = 0;
        try{
            while ((i = inputStream.read()) != -1){
                System.err.println((char)i);
                num++;
            }
            inputStream.close();
            System.err.println("总共读取了" + num + "个字节的文件");
        }catch (IOException e){
            System.err.println("文件读取失败");
        }



    }



}
