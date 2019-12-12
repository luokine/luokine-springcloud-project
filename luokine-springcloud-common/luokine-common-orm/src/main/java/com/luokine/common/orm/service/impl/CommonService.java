package com.luokine.common.orm.service.impl;
import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageInfo;
import com.luokine.common.orm.page.PageHelperObject;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.session.RowBounds;
import tk.mybatis.mapper.additional.aggregation.AggregateCondition;
import tk.mybatis.mapper.entity.Example;

import javax.xml.bind.ValidationException;
import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public interface CommonService<T , PK> {

    /**
     * <p>
     * 插入一条记录（选择字段，策略插入）
     * </p>
     *
     * @param entity 实体对象
     */
    boolean save(T entity);

    /**
     * <p>
     * 插入一条记录（只插入有值的属性）
     * </p>
     *
     * @param entity 实体对象
     */
    boolean saveSelective(T entity);

    /**
     * <p>
     * 插入（批量）
     * </p>
     *
     * @param entityList 实体对象集合
     */
    boolean saveBatch(Collection<T> entityList);

    /**
     * <p>
     * 插入（批量），主键使用自己设置的
     * </p>
     *
     * @param entityList 实体对象集合
     */
    boolean saveBatchNoId(List<T> entityList);

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     */
    boolean removeById(Serializable id);

    /**
     * <p>
     * 根据 columnMap 条件，删除记录
     * </p>
     *
     * @param columnMap 表字段 map 对象
     * @param clazz     实体的类型
     */
    boolean removeByMap(Map<String, Object> columnMap, Class<T> clazz);

    /**
     * <p>
     * 根据 entity 条件，删除记录
     * </p>
     *
     */
    boolean remove(T entity);

    /**
     * <p>
     * 删除（根据ID 批量删除）
     * </p>
     *
     * @param idList 主键ID列表
     */
    int removeByIds(Collection<PK> idList);

    /**
     * <p>
     * 根据 ID 选择修改
     * </p>
     *
     * @param entity 实体对象
     */
    boolean updateById(T entity);

    /**
     * <p>
     * 根据 whereEntity 条件，更新记录
     * </p>
     *
     * @param entity        实体对象
     * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
     */
    boolean update(T entity, Example example);

    /**
     * 根据Example条件更新实体`record`包含的不是null的属性值
     *
     * @param record
     * @param example
     * @return
     */
    int updateByExampleSelective(@Param("record") T record, @Param("example") Object example);

    /**
     * <p>
     * 根据ID 批量更新
     * </p>
     *
     * @param entityList 实体对象集合
     */
    default boolean updateBatchById(List<T> entityList) {
        return updateBatchById(entityList, 1000);
    }

    /**
     * <p>
     * 根据ID 批量更新
     * </p>
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     */
    boolean updateBatchById(List<T> entityList, int batchSize);

    /**
     * <p>
     * TableId 注解存在更新记录，否插入一条记录
     * </p>
     *
     * @param entity 实体对象
     */
    boolean saveOrUpdate(T entity);

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     */
    T getById(Serializable id);

    /**
     * <p>
     * 查询（根据ID 批量查询）
     * </p>
     *
     * @param idList 主键ID列表
     */
    Collection<T> listByIds(Collection<PK> idList);

    /**
     * <p>
     * 查询（根据 columnMap 条件）
     * </p>
     *
     * @param columnMap 表字段 map 对象
     * @param Clazz     实体的类型
     */
    Collection<T> listByMap(Map<String, Object> columnMap, Class<T> Clazz);

    /**
     * <p>
     * 根据 Example，查询一条记录
     * </p>
     *
     * @param example 实体对象封装操作类 {@link Example}
     */
    T getOne(Example example);

    /**
     * <p>
     * 根据 Example，查询一条记录
     * </p>
     *
     * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
     * @param throwEx  抛出的异常
     */
    T getOne(Example example, ValidationException throwEx);

    /**
     * <p>
     * 根据 Example，查询一条记录
     * </p>
     *
     * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
     */
    Map<String, Object> getMap(Example example);

    /**
     * 根据example和aggregateCondition进行聚合查询
     * 分组不支持having条件过滤， 如需要建议使用xml文件
     *
     * @param example
     * @param aggregateCondition 可以设置聚合查询的属性和分组属性
     * @return 返回聚合查询属性和分组属性的值
     */
    List<T> selectAggregationByExample(Example example, AggregateCondition aggregateCondition);

    /**
     * <P>
     *     根据Example 获得条数
     * </P>
     * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
     * @return
     */
    int countExmple(Example example);

    /**
     * <p>
     * 查询列表
     * </p>
     *
     * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
     */
    List<T> list(Example example);


    /**
     *
     * <p>
     * 有条件翻页查询
     * </p>
     *
     * @param example
     * @param rowBounds
     * @return
     */
    List<T> selectByExampleAndRowBounds(Example example, RowBounds rowBounds);

    /**
     * <p>
     * 查询全部记录
     * </p>
     */
    default List<Object> listObjs() {
        return listObjs(Function.identity());
    }

    /**
     * <p>
     * 查询全部记录
     * </p>
     *
     * @param mapper 转换函数
     */
    default <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return listObjs(null , mapper);
    }

    /**
     * <p>
     * 根据 Example 条件，查询全部记录
     * </p>
     *
     * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
     */
    default List<Object> listObjs(Example example) {
        return listObjs(example, Function.identity());
    }

    /**
     * <p>
     * 根据 Example 条件，查询全部记录
     * </p>
     *
     * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
     * @param mapper       转换函数
     */
    <V> List<V> listObjs(Example example, Function<? super Object, V> mapper);

    /**
     * <p>
     * 批量修改插入
     * </p>
     *
     * @param entityList 实体对象集合
     * @param batchSize  每次的数量
     */
    boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize);

    /**
     * <p>
     * 查询列表
     * </p>
     *
     * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
     */
    List<Map<String, Object>> listMaps(Example example);
    /**
     * <p>
     * 查询列表
     * </p>
     *
     * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
     * @param pageHelperObject 页码对象 {@link PageHelperObject }
     */
    List<Map<String, Object>> listMapsAndPageHelper(Example example, PageHelperObject pageHelperObject);

    /**
     * <p>
     * 有分页得查询列表，返回map对象
     * </p>
     *
     * @param example 实体对象封装操作类 {@link tk.mybatis.mapper.entity.Example}
     * @param pageHelperObject 页码对象
     * @return
     */
    PageInfo<T> selectByExampleAndPageHelper(Example example, PageHelperObject pageHelperObject);

    /**
     * <p>
     * 无条件翻页查询
     * </p>
     *
     * @param pageHelperObject 页码对象
     * @return
     */
    PageInfo<T> selectAllAndPageHelper(PageHelperObject pageHelperObject);

    /**
     * <p>
     * 无条件翻页查询
     * </p>
     *
     * @param pageHelperObject 页码对象
     * @param iSelect 查询语句
     * @return
     */
    PageInfo<T> selectCustomSelectAndPageHelper(PageHelperObject pageHelperObject , ISelect iSelect);
}
