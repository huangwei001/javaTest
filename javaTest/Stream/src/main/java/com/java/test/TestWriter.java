package com.java.test;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * Created by huangwei on 2017/6/14.
 */
public class TestWriter {

    public static void main(String[] args){
        int i = 0;

        FileReader reader = null;
        FileWriter writer = null;
        try{
            reader = new FileReader("F:\\TestFile\\项目售后管理系统V0.1.doc");
            writer = new FileWriter("F:\\TestFile\\TestFile.docx");
        }catch (FileNotFoundException e){
            System.err.println("文件不存在！！！");
        } catch (IOException e) {
            e.printStackTrace();
        }

        try{
            while ((i = reader.read()) != -1){
                writer.write(reader.getEncoding());
            }
        }catch (IOException e){
            System.err.println("文件读取失败！！！");
        }



    }

}
