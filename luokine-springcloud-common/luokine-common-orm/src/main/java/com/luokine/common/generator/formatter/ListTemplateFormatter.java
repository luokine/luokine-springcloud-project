package com.luokine.common.generator.formatter;

import com.luokine.common.generator.model.TableClass;

import java.util.Properties;
import java.util.Set;

/**
 * @author: tianziquan
 * @create: 2019-12-12 15:38
 */
public interface ListTemplateFormatter {

    /**
     * 获取根据模板生成的数据
     *
     * @param tableClassSet
     * @param properties
     * @param targetPackage
     * @param templateContent
     * @return
     */
    String getFormattedContent(Set<TableClass> tableClassSet, Properties properties, String targetPackage, String templateContent);
}
