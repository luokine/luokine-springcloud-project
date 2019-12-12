package com.luokine.common.orm.provider.update;

import org.apache.ibatis.mapping.MappedStatement;
import tk.mybatis.mapper.entity.EntityColumn;
import tk.mybatis.mapper.mapperhelper.*;

import java.util.Set;


/**
 * @author: tianziquan
 */
public class UpdateBatchByPrimaryKeySelectiveProvider extends MapperTemplate {

    public UpdateBatchByPrimaryKeySelectiveProvider(Class<?> mapperClass, MapperHelper mapperHelper) {
        super(mapperClass, mapperHelper);
    }


    /**
     * 拼update sql, 使用case when方式，id为主键
     *
     * @param ms
     * @return
     */
    public String updateBatchByPrimaryKeySelective(MappedStatement ms) {
        final Class<?> entityClass = getEntityClass(ms);
        Set<EntityColumn> entityColumns = EntityHelper.getPKColumns(entityClass);


        String primaryKey = entityColumns.iterator().next().getColumn();
        String primaryProperty = entityColumns.iterator().next().getProperty();

        //开始拼sql
        StringBuilder sql = new StringBuilder();
        sql.append(SqlHelper.updateTable(entityClass, tableName(entityClass)));
        sql.append("<trim prefix=\"set\" suffixOverrides=\",\">");

        //获取全部列
        Set<EntityColumn> columnList = EntityHelper.getColumns(entityClass);
        for (EntityColumn column : columnList) {
            if (!column.isId() && column.isUpdatable()) {
                sql.append("  <trim prefix=\""+column.getColumn()+" =case\" suffix=\"end,\">");
                sql.append("    <foreach collection=\"list\" item=\"i\" index=\"index\">");
                sql.append("      <if test=\"i."+column.getEntityField().getName()+"!=null\">");
                sql.append("         when ");
                sql.append(primaryKey);
                sql.append("=#{i.");
                sql.append(primaryProperty);
                sql.append("} then #{i."+column.getEntityField().getName()+"}");
                sql.append("      </if>");
                sql.append("    </foreach>");
                sql.append("  </trim>");
            }
        }

        sql.append("</trim>");
        sql.append("WHERE ");
        sql.append(primaryKey);
        sql.append("  IN ");
        sql.append("<trim prefix=\"(\" suffix=\")\">");
        sql.append("<foreach collection=\"list\" separator=\", \" item=\"i\" index=\"index\" >");
        sql.append("#{i.");
        sql.append(primaryProperty);
        sql.append("}");
        sql.append("</foreach>");
        sql.append("</trim>");

        return sql.toString();
    }
}
