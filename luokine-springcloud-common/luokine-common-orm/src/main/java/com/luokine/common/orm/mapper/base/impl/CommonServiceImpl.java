package com.luokine.common.orm.mapper.base.impl;


import com.github.pagehelper.ISelect;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.luokine.common.orm.mapper.base.BaseMapper;
import com.luokine.common.orm.mapper.base.CommonService;
import com.luokine.common.orm.mapper.util.GsonUtil;
import com.luokine.common.orm.mapper.util.SqlHelperUtil;
import com.luokine.common.orm.page.PageHelperObject;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.session.RowBounds;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.additional.aggregation.AggregateCondition;
import tk.mybatis.mapper.entity.Example;
import com.luokine.common.exception.ValidationException;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;

@Slf4j
public class CommonServiceImpl<M extends BaseMapper<T, PK>, T, PK> implements CommonService<T, PK> {

    @Autowired
    protected M baseMapper;

    /**
     * <p>
     * 判断数据库操作是否成功
     * </p>
     *
     * @param result 数据库操作返回影响条数
     * @return boolean
     */
    protected boolean retBool(Integer result) {
        return SqlHelperUtil.retBool(result);
    }

    /**
     * <p>
     * 插入一条记录（选择字段，策略插入）
     * </p>
     *
     * @param entity 实体对象
     */
    @Override
    public boolean save(T entity) {
        return retBool(baseMapper.insert(entity));
    }

    /**
     * <p>
     * 插入一条记录（只插入有值的属性）
     * </p>
     *
     * @param entity 实体对象
     */
    @Override
    public boolean saveSelective(T entity) {
        return retBool(baseMapper.insertSelective(entity));
    }

    /**
     * <p>
     * 插入（批量）, 主键使用mysql自增
     * </p>
     *
     * @param entityList 实体对象集合
     */
    @Override
    public boolean saveBatch(Collection<T> entityList) {
        baseMapper.insertList((List<T>) entityList);
        return true;
    }

    /**
     * <p>
     * 插入（批量），主键使用自己设置的
     * </p>
     *
     * @param entityList 实体对象集合
     */
    @Override
    public boolean saveBatchNoId(List<T> entityList) {
        baseMapper.insertListNoId(entityList);
        return true;
    }

    /**
     * <p>
     * 根据 ID 删除
     * </p>
     *
     * @param id 主键ID
     */
    @Override
    public boolean removeById(Serializable id) {
        return retBool(baseMapper.deleteByPrimaryKey(id));
    }

    /**
     * <p>
     * 根据 entity 条件，删除记录
     * </p>
     *
     * @param entity
     */
    @Override
    public boolean remove(T entity) {
        return retBool(baseMapper.deleteByPrimaryKey((T) entity));
    }

    /**
     * <p>
     * 根据 ID 选择修改
     * </p>
     *
     * @param entity 实体对象
     */
    @Override
    public boolean updateById(T entity) {
        return retBool(baseMapper.updateByPrimaryKeySelective((T) entity));
    }

    /**
     * <p>
     * 根据 whereEntity 条件，更新记录
     * </p>
     *
     * @param entity  实体对象
     * @param example 实体对象封装操作类 {@link Example}
     */
    @Override
    public boolean update(T entity, Example example) {
        return retBool(baseMapper.updateByExample((T) entity, example));
    }

    /**
     * 根据Example条件更新实体`record`包含的不是null的属性值
     *
     * @param record
     * @param example
     * @return
     */
    @Override
    public int updateByExampleSelective(T record, Object example) {
        return baseMapper.updateByExampleSelective(record , example);
    }

    /**
     * <p>
     * 根据ID 批量更新
     * </p>
     *
     * @param entityList 实体对象集合
     */
    @Override
    public boolean updateBatchById(List<T> entityList) {
        return baseMapper.updateBatchByPrimaryKeySelective(entityList);
    }

    /**
     * <p>
     * 根据ID 批量更新
     * </p>
     *
     * @param entityList 实体对象集合
     * @param batchSize  更新批次数量
     */
    @Override
    public boolean updateBatchById(List<T> entityList, int batchSize) {
        int count = entityList.size() % batchSize == 0 ?
                entityList.size() / batchSize : entityList.size() / batchSize + 1;
        for(int i = 0 ; i <= count ; i ++){
            int start = batchSize * i;
            int end = batchSize * (i + 1);
            List newList = entityList.subList(start, end);
            this.updateBatchById(newList);
        }
        return true;
    }

    /**
     * <p>
     * TableId 注解存在更新记录，否插入一条记录
     * </p>
     * <p>
     * TODO: 未实现
     *
     * @param entity 实体对象
     */
    @Override
    public boolean saveOrUpdate(T entity) {
        int result = baseMapper.updateByPrimaryKey(entity);
        if(result == 0){
            result = baseMapper.insert(entity);
        }
        return retBool(result);
    }

    /**
     * <p>
     * 根据 ID 查询
     * </p>
     *
     * @param id 主键ID
     */
    @Override
    public T getById(Serializable id) {
        return baseMapper.selectByPrimaryKey(id);
    }

    /**
     * <p>
     * 根据 Example，查询一条记录
     * </p>
     *
     * @param example 实体对象封装操作类 {@link Example}
     */
    @Override
    public T getOne(Example example) {
        return baseMapper.selectOneByExample(example);
    }

    /**
     * <p>
     * 根据 Example，查询一条记录
     * </p>
     *
     * @param example 实体对象封装操作类 {@link Example}
     * @param throwEx 抛出的异常
     */
    @Override
    public T getOne(Example example, ValidationException throwEx) {
        List<T> list = baseMapper.selectByExample(example);
        if (list == null) {
            return null;
        } else if (list.size() > 1) {
            throw throwEx;
        } else {
            return list.get(0);
        }
    }

    /**
     * <p>
     * 根据 Example，查询一条记录
     * </p>
     *
     * @param example 实体对象封装操作类 {@link Example}
     */
    @Override
    public Map<String, Object> getMap(Example example) {
        T t = baseMapper.selectOneByExample(example);
        return GsonUtil.GsonToMaps(GsonUtil.ObjectToString(t));
    }


    /**
     * 根据example和aggregateCondition进行聚合查询
     * 分组不支持having条件过滤， 如需要建议使用xml文件
     *
     * @param example
     * @param aggregateCondition 可以设置聚合查询的属性和分组属性
     * @return 返回聚合查询属性和分组属性的值
     */
    @Override
    public List<T> selectAggregationByExample(Example example, AggregateCondition aggregateCondition) {
        return baseMapper.selectAggregationByExample(example, aggregateCondition);
    }

    /**
     * <p>
     * 根据Example 获得条数
     * </P>
     *
     * @param example 实体对象封装操作类 {@link Example}
     * @return
     */
    @Override
    public int countExmple(Example example) {
        return baseMapper.selectCountByExample(example);
    }

    /**
     * <p>
     * 查询列表
     * </p>
     *
     * @param example 实体对象封装操作类 {@link Example}
     */
    @Override
    public List<T> list(Example example) {
        return baseMapper.selectByExample(example);
    }

    /**
     * <p>
     * 有条件翻页查询
     * </p>
     *
     * @param example
     * @param rowBounds
     * @return
     */
    @Override
    public List<T> selectByExampleAndRowBounds(Example example, RowBounds rowBounds) {
        return baseMapper.selectByExampleAndRowBounds(example, rowBounds);
    }

    /**
     * <p>
     * 无条件翻页查询
     * </p>
     *
     * @param pageHelperObject 页码对象
     * @return
     */
    @Override
    public PageInfo<T> selectAllAndPageHelper(PageHelperObject pageHelperObject) {
        final PageInfo<T> pageInfo = PageHelper.startPage(pageHelperObject.getPageNum(), pageHelperObject.getPageSize())
                .doSelectPageInfo(() -> this.baseMapper.selectAll());
        return pageInfo;
    }


    /**
     * <p>
     * 有条件翻页查询
     * </p>
     *
     * @param example
     * @param pageHelperObject
     * @return
     */
    @Override
    public PageInfo<T> selectByExampleAndPageHelper(Example example, PageHelperObject pageHelperObject) {
        final PageInfo<T> pageInfo = PageHelper.startPage(pageHelperObject.getPageNum(), pageHelperObject.getPageSize())
                .doSelectPageInfo(() -> this.baseMapper.selectByExample(example));
        return pageInfo;
    }

    /**
     * <p>
     * 查询全部记录
     * </p>
     */
    @Override
    public List<Object> listObjs() {
        return listObjs(Function.identity());
    }

    /**
     * <p>
     * 查询全部记录
     * </p>
     *
     * @param mapper 转换函数
     */
    @Override
    public <V> List<V> listObjs(Function<? super Object, V> mapper) {
        return null;
    }

    /**
     * <p>
     * 根据 Example 条件，查询全部记录
     * </p>
     *
     * @param example 实体对象封装操作类 {@link Example}
     */
    @Override
    public List<Object> listObjs(Example example) {
        return listObjs(example, Function.identity());
    }

    /**
     * <p>
     * 批量修改插入
     * </p>
     * <p>
     * TODO: 未实现
     *
     * @param entityList 实体对象集合
     * @param batchSize  每次的数量
     */
    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        return false;
    }

    /**
     * <p>
     * 查询列表
     * </p>
     *
     * @param example 实体对象封装操作类 {@link Example}
     */
    @Override
    public List<Map<String, Object>> listMaps(Example example) {
        return baseMapper.selectByExample(example).stream().map(t -> GsonUtil.GsonToMaps(GsonUtil.ObjectToString(t))).collect(Collectors.toList());
    }

    /**
     * <p>
     * 有分页得查询列表，返回map对象
     * </p>
     *
     * @param example          实体对象封装操作类 {@link Example}
     * @param pageHelperObject 页码对象 {@link PageHelperObject}
     */
    @Override
    public List<Map<String, Object>> listMapsAndPageHelper(Example example, PageHelperObject pageHelperObject) {
        return PageHelper.startPage(pageHelperObject.getPageNum(), pageHelperObject.getPageSize())
                .doSelectPageInfo(() -> this.baseMapper.selectByExample(example))
                .getList().stream().map(t -> GsonUtil.GsonToMaps(GsonUtil.ObjectToString(t))).collect(Collectors.toList());
    }

    /**
     * <p>
     * 根据 Example 条件，查询全部记录
     * </p>
     *
     * @param example 实体对象封装操作类 {@link Example}
     * @param mapper  转换函数
     */
    @Override
    public List listObjs(Example example, Function mapper) {
        return (List<T>) baseMapper.selectByExample(example).stream().filter(t ->
                Objects.nonNull(t)
        ).map(mapper).collect(Collectors.toList());
    }

    /**
     * <p>
     * 查询（根据ID 批量查询）
     * </p>
     *
     * @param idList 主键ID列表
     */
    @Override
    public Collection<T> listByIds(Collection<PK> idList) {
        return baseMapper.selectByIdList((List) idList);
    }

    /**
     * <p>
     * 查询（根据 columnMap 条件）
     * </p>
     *
     * @param columnMap 表字段 map 对象
     * @param Clazz     实体的类型
     */
    @Override
    public Collection<T> listByMap(Map<String, Object> columnMap, Class<T> Clazz) {
        T t = GsonUtil.GsonToBean(GsonUtil.MapToGson(columnMap, Clazz), Clazz);
        return baseMapper.select(t);
    }

    /**
     * <p>
     * 删除（根据ID 批量删除）
     * </p>
     *
     * @param idList 主键ID列表
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public int removeByIds(Collection<PK> idList) {
        return baseMapper.deleteByIdList((List) idList);
    }

    /**
     * <p>
     * 根据 columnMap 条件，删除记录
     * </p>
     *
     * @param columnMap 表字段 map 对象
     * @param clazz     实体的类型
     */
    @Override
    public boolean removeByMap(Map<String, Object> columnMap, Class<T> clazz) {
        T t = GsonUtil.GsonToBean(GsonUtil.MapToGson(columnMap, clazz), clazz);
        return retBool(baseMapper.delete(t));
    }

    /**
     * <p>
     * 无条件翻页查询
     * </p>
     *
     * @param pageHelperObject 页码对象
     * @param iSelect 查询语句
     * @return
     */
    @Override
    public PageInfo<T> selectCustomSelectAndPageHelper(PageHelperObject pageHelperObject, ISelect iSelect) {
        final PageInfo<T> pageInfo = PageHelper.startPage(pageHelperObject.getPageNum(), pageHelperObject.getPageSize())
                .doSelectPageInfo(iSelect);
        return pageInfo;
    }
}

