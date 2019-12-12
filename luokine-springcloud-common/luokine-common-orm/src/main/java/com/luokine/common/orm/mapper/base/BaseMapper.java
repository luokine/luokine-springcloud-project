package com.luokine.common.orm.mapper.base;

import com.luokine.common.orm.mapper.batch.BatchMapper;
import tk.mybatis.mapper.additional.aggregation.AggregationMapper;
import tk.mybatis.mapper.additional.idlist.IdListMapper;
import tk.mybatis.mapper.additional.update.differ.UpdateByDifferMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;
import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @author: tianziquan
 * @create: 2019-12-12 14:09
 */
@RegisterMapper
public interface BaseMapper<T , PK> extends Mapper<T>, MySqlMapper<T>, AggregationMapper<T>,
        UpdateByDifferMapper<T>, IdListMapper<T , PK>, BatchMapper<T> {
}
