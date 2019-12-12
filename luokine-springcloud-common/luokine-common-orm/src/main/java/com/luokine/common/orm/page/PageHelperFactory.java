package com.luokine.common.orm.page;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author: tianziquan
 */
public abstract class PageHelperFactory{

    /**
     * 系统默认的每页多少条
     */
    public static int defaultPageSize = 10;

    public PageHelperObject buildPage() {
        // 获得page对象
        PageWarp pageWarp = convertPage();

        //页码
        int pageNum = (Integer) ObjectUtil.defaultIfNull(pageWarp.getPageNum() , 1);
        //每页有多少条
        int pageSize = (Integer) ObjectUtil.defaultIfNull(pageWarp.getPageSize(), defaultPageSize);
        return new PageHelperObject(pageNum , pageSize);
    }

    /**
     * 子类实现，用来获得实际前台传递过来的数据
     * @return
     */
    public abstract PageWarp convertPage();
}
