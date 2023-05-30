package com.controler;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;

public class 文件操作 {
        public static void main(String[] args) {

            replace("old","new","D:\\a.txt");

        }
        public static void replace(String oldString,String newString,String path){
            try {
                File file = new File(path);
                BufferedReader br = new BufferedReader(new FileReader(file));
                ArrayList<String> strings = new ArrayList<String>();
                String s;//读取的每一行数据
                while ((s=br.readLine()) != null){
                    if (s.contains(oldString)) {
                        s = s.replace(oldString, newString);
                    }
                    strings.add(s);//将数据存入集合
                }
                BufferedWriter bw = new BufferedWriter(new FileWriter(file));
                for (String string : strings) {
                    bw.write(string);//一行一行写入数据
                    bw.newLine();//换行
                }
                bw.close();
            }catch (Exception e){

            }
        }
}

