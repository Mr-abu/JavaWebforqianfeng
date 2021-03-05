package com.book.www.entity;

import java.util.List;

public class Page { //分页
    private List records;
    private int pageSize = 3;
    private int pageNum;

    private int totalPageSize;
    private int pageIndex;
    private int totalRecordsNum;

    private int prePageNum;
    private int nextPageNum;

    private String url;

    @Override
    public String toString() {
        return "Page{" +
                "records=" + records +
                ", pageSize=" + pageSize +
                ", pageNum=" + pageNum +
                ", totalPageSize=" + totalPageSize +
                ", pageIndex=" + pageIndex +
                ", totalRecordsNum=" + totalRecordsNum +
                ", prePageNum=" + prePageNum +
                ", nextPageNum=" + nextPageNum +
                ", url='" + url + '\'' +
                '}';
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNum() {
        return pageNum;
    }

    public void setPageNum(int pageNum) {
        this.pageNum = pageNum;
    }

    public int getTotalPageSize() {
        return totalPageSize;
    }

    public void setTotalPageSize(int totalPageSize) {
        this.totalPageSize = totalPageSize;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotalRecordsNum() {
        return totalRecordsNum;
    }

    public void setTotalRecordsNum(int totalRecordsNum) {
        this.totalRecordsNum = totalRecordsNum;
    }

    public int getPrePageNum() {
        return prePageNum;
    }

    public void setPrePageNum(int prePageNum) {
        this.prePageNum = prePageNum;
    }

    public int getNextPageNum() {
        return nextPageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Page(int pageNum, int totalRecordsNum) {
        this.pageNum = pageNum;
        this.totalRecordsNum = totalRecordsNum;
        //计算总页数
        totalPageSize = totalRecordsNum%pageSize==0?totalRecordsNum/pageSize:totalRecordsNum/pageSize+1;
        //开始记录的索引
        pageIndex = (pageNum-1)*pageSize;
        prePageNum = pageNum-1<1?1:pageNum-1;
        nextPageNum = pageNum+1>totalPageSize?totalPageSize:pageNum+1;
    }

    public Page(List records, int pageSize, int pageNum, int totalPageSize, int pageIndex, int totalRecordsNum, int prePageNum, int nextPageNum, String url) {
        this.records = records;
        this.pageSize = pageSize;
        this.pageNum = pageNum;
        this.totalPageSize = totalPageSize;
        this.pageIndex = pageIndex;
        this.totalRecordsNum = totalRecordsNum;
        this.prePageNum = prePageNum;
        this.nextPageNum = nextPageNum;
        this.url = url;
    }
}
