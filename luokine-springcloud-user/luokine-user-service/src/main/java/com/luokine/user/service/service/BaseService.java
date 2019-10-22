package com.luokine.user.service.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @author: tiantziquan
 * @create: 2019-10-21 19:30
 */
public interface BaseService<T> extends IService<T> {
    IPage<T> pageByQuery(IPage<T> query);
}
