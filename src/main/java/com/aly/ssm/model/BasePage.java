package com.aly.ssm.model;

import java.io.Serializable;

/**
 * @Author lizhen
 * @Date 2017/7/28 10:54
 */
public class BasePage implements Serializable {
    private static final long serialVersionUID = -8858885101686311738L;
    private int pageNum;
    private int pageSize;
    private long total;
    private int pages;

    public BasePage() {
    }

    public int getPageNum() {
        if (this.pageNum <= 0) {
            this.pageNum = 1;
        }
        return this.pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getPageSize() {
        if (this.pageSize <= 0) {
            this.pageSize = 10;
        }

        return this.pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public long getTotal() {
        return this.total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public int getPages() {
        return this.pages;
    }

    public void setPages(int pages) {
        this.pages = pages;
    }

    public String toString() {
        return "BasePage [pageNum=" + this.pageNum + ", pageSize=" + this.pageSize + ", total=" + this.total + ", pages=" + this.pages + "]";
    }
}
