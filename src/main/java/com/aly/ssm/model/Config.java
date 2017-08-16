package com.aly.ssm.model;

/**
 * @Author lizhen
 * @Date 2017/8/15 15:37
 */
public class Config {
    private  String code;
    private String name;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Config(String code, String name) {
        this.code = code;
        this.name = name;
    }
    public  Config(){}
}
