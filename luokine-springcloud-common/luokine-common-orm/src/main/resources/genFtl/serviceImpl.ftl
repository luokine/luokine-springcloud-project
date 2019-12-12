package ${userServiceImplTargetPackage};

import ${tableClass.fullClassName};

import com.luokine.common.orm.mapper.base.impl.CommonServiceImpl;
import org.springframework.stereotype.Service;
import ${userMapperTargetPackage}.${tableClass.shortClassName}${mapperSuffix};
import ${userServiceTargetPackage}.${tableClass.shortClassName}${serviceSuffix};

/**
* 通用 serviceImpl 代码生成器
*
* @author
*/
@Service
public class ${tableClass.shortClassName}${serviceImplSuffix} extends ${CommonServiceImpl!"com.luokine.common.orm.mapper.base.CommonService"}<${tableClass.shortClassName}${mapperSuffix} , ${tableClass.shortClassName} , ${tableClass.pkFields[0].shortTypeName}> implements ${tableClass.shortClassName}${serviceSuffix}{

}



