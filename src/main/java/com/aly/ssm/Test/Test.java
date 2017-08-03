package com.aly.ssm.Test;


import com.alibaba.fastjson.JSONObject;
import com.aly.ssm.model.BorrowInfoExt;
import com.aly.ssm.model.User;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * Created by lizhen on 2017/7/12.
 */
public class Test {
    public static void main(String[] args) {
        try {
           User user= (User) Class.forName("com.aly.ssm.model.User").newInstance();
            System.out.println(user);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static String readFileByLines(String fileName) {
        String str = null;
        File file = new File(fileName);
        BufferedReader reader = null;
        try {
            System.out.println("以行为单位读取文件内容，一次读一整行：");
            reader = new BufferedReader(new FileReader(file));
            String tempString = null;
            // 一次读入一行，直到读入null为文件结束
            while ((tempString = reader.readLine()) != null) {
                // 显示行号
                str = tempString;
            }
            reader.close();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //最后关闭资源
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e1) {
                }
            }
        }
        return str;
    }
}
