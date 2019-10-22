package com.luokine.user.service.dao;

import com.baomidou.mybatisplus.core.metadata.IPage;

public interface BaseMapper<T>  extends com.baomidou.mybatisplus.core.mapper.BaseMapper<T> {
    IPage<T> pageByQuery(IPage<T> query);
}

