package com.java.test;



import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by huangwei on 2017/6/14.
 */
public class fileOutputStream {

    public static void main(String[] args) throws IOException {

        int i = 0;
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;

        try {
            inputStream = new FileInputStream("F:\\TestFile\\项目售后管理系统V0.1.doc");
            outputStream = new FileOutputStream("F:\\TestFile\\TestFile.docx");
        }catch (FileNotFoundException e){
            System.err.println("文件不存在！！！");
        }

        while((i = inputStream.read()) !=-1){

            outputStream.write(i);
        }

        outputStream.close();
        inputStream.close();

    }
}
