package com.rqy.util;

import java.util.List;

/**
 * @author 申涛涛
 * @date 2019/8/9 20:09
 */
public class PageBean<T> {

    private long total;
    private List<T> rows;
    public PageBean(long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
    public PageBean() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
