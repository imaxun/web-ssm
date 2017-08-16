package com.aly.ssm.test;


import com.alibaba.fastjson.JSONObject;
import com.aly.ssm.model.Config;
import com.aly.ssm.uitl.JacksonUtil;
import net.sf.json.JSONArray;

import java.io.*;
import java.util.List;

/**
 * Created by lizhen on 2017/7/12.
 */
public class Test {
    public static void main(String[] args) {
        try {
            String str = readTxtFile("d://11.txt");
            String json_str = JSONObject.parseObject(str).getJSONObject("model").getJSONObject("result").getString("data");
//            List<Object> c = JacksonUtil.json2List(json_str);
//            List<Config> list = new ArrayList<Config>();
//            for (Object o : c) {
//                Config borrow = JacksonUtil.json2Obj(JacksonUtil.bean2Json(o), Config.class);
//                list.add(borrow);
//            }

            List<Config> list = JacksonUtil.json2List(json_str, Config.class);
            for (Config config : list) {
                System.out.println(config.getCode());
            }
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

    public static String readTxtFile(String filePath) {
        String str = null;
        try {
            String encoding = "GBK";
            File file = new File(filePath);
            if (file.isFile() && file.exists()) { //判断文件是否存在
                InputStreamReader read = new InputStreamReader(
                        new FileInputStream(file), encoding);//考虑到编码格式
                BufferedReader bufferedReader = new BufferedReader(read);
                String lineTxt = null;
                while ((lineTxt = bufferedReader.readLine()) != null) {
                    str = lineTxt;
                }
                read.close();
            } else {
                System.out.println("找不到指定的文件");
            }
        } catch (Exception e) {
            System.out.println("读取文件内容出错");
            e.printStackTrace();
        }
        return str;
    }
}
