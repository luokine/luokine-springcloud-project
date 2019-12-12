package com.luokine.common.orm.mapper.batch;

import com.luokine.common.orm.mapper.insert.InsertListExtraMapper;
import com.luokine.common.orm.mapper.update.UpdateBatchByPrimaryKeySelectiveMapper;
import tk.mybatis.mapper.annotation.RegisterMapper;

/**
 * @author: tianziquan
 */
@RegisterMapper
public interface BatchMapper<T> extends
        UpdateBatchByPrimaryKeySelectiveMapper<T>, InsertListExtraMapper<T> {
}
