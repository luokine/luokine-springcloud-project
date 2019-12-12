package com.luokine.common.orm.service.impl;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.luokine.common.orm.mapper.BaseMapper;
import com.luokine.common.orm.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: tianziquan
 * @create: 2019-10-21 19:31
 */
public class BaseServiceImpl<K extends BaseMapper<T>, T> extends ServiceImpl<K, T> implements BaseService<T> {

    @Autowired
    protected K baseMapper;

    public BaseServiceImpl() {
    }

    public IPage<T> pageByQuery(IPage<T> query) {
        return this.baseMapper.pageByQuery(query);
    }
}
