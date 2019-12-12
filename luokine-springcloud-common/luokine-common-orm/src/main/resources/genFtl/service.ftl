package ${userServiceTargetPackage};

import ${tableClass.fullClassName};

import com.luokine.common.orm.mapper.base.CommonService;

/**
* 通用 service 代码生成器
*
* @author
*/
public interface ${tableClass.shortClassName}${serviceSuffix} extends ${commonService!"com.luokine.common.orm.mapper.base.CommonService"}<${tableClass.shortClassName} , ${tableClass.pkFields[0].shortTypeName}> {

}



