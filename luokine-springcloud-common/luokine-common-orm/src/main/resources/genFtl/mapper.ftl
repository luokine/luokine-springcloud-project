package ${userMapperTargetPackage};

import ${tableClass.fullClassName};

import com.luokine.common.orm.mapper.base.BaseMapper;

/**
* 通用 Mapper 代码生成器
*
* @author
*/
public interface ${tableClass.shortClassName}${mapperSuffix} extends ${baseMapper!"tk.mybatis.mapper.common.Mapper"}<${tableClass.shortClassName} , ${tableClass.pkFields[0].shortTypeName}> {

}