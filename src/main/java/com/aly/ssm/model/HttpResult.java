package com.aly.ssm.model;

/**
 * @Author lizhen
 * @Date 2017/8/21 15:25
 */
public class HttpResult {
    /**
     * 状态码
     */
    private Integer status;
    /**
     * 返回数据
     */
    private String data;

    public HttpResult(int statusCode, String s) {
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
