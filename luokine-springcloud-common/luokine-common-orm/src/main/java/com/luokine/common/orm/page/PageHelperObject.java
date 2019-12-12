package com.luokine.common.orm.page;

import lombok.Data;

@Data
public class PageHelperObject {

    /**
     * 页码
     */
    private int pageNum;

    /**
     * 每页显示数量
     */
    private int pageSize;

    public PageHelperObject(int pageNum , int pageSize){
        if(pageSize <= 0){
            this.pageNum = 1;
        }else {
            this.pageNum = pageNum;
        }
        this.pageSize = pageSize;
    }
}
