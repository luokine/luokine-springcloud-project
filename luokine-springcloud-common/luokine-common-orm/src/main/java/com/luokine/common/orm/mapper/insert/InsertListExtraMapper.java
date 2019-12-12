package com.luokine.common.orm.mapper.insert;

import com.luokine.common.orm.provider.insert.InsertListExtraProvider;
import org.apache.ibatis.annotations.InsertProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * @author: tianziquan
 */
@RegisterMapper
public interface InsertListExtraMapper<T> {

    /**
     * 批量插入，支持批量插入的数据库可以使用，例如MySQL,H2等
     * <p>
     * 不支持主键策略，插入前需要设置好主键的值
     * <p>
     *
     * @param recordList
     * @return
     */
    @InsertProvider(type = InsertListExtraProvider.class, method = "dynamicSQL")
    int insertListNoId(List<? extends T> recordList);
}
