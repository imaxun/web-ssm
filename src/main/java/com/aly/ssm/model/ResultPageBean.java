package com.aly.ssm.model;

import java.io.Serializable;

/**
 * Created by dell、 on 2017/6/5.
 */
public class ResultPageBean<T> implements Serializable {
    /**
     * 1. 当前的页面2. 每页显示的记录条 3.总的记录条  4. 总的页数
     */
    private int pageNum;//当前的页面
    private int pageSize;//每页显示的记录条
    private long total;//总的记录条
    private int pages;// 总的页数
    // 用来保存分页查询的数据
    private T model;

    public ResultPageBean() {

    }


    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public T getModel() {
        return model;
    }

    public void setModel(T model) {
        this.model = model;
    }
}