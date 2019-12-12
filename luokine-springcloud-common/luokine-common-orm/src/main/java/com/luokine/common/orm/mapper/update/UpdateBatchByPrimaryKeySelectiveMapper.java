package com.luokine.common.orm.mapper.update;

import com.luokine.common.orm.provider.update.UpdateBatchByPrimaryKeySelectiveProvider;
import org.apache.ibatis.annotations.UpdateProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * @author: tianziquan
 */
@RegisterMapper
public interface UpdateBatchByPrimaryKeySelectiveMapper<T>{

    /**
     * 根据Example条件批量更新实体`record`包含的不是null的属性值
     *
     * @return
     */
    @UpdateProvider(type = UpdateBatchByPrimaryKeySelectiveProvider.class, method = "dynamicSQL")
    boolean updateBatchByPrimaryKeySelective(List<? extends T> recordList);
}
