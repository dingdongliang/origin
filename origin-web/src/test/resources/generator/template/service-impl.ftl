package ${basePackage}.service.impl;

import ${basePackage}.dao.${modelNameUpperCamel}Mapper;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import ${basePackage}.service.impl.BaseService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * origin/${basePackage}.service.impl
 *
 * @Description:
 * @Author: ${author}
 * @Date: ${date}
 */
@Service
@Transactional
public class ${modelNameUpperCamel}Service extends BaseService<${modelNameUpperCamel}> implements
I${modelNameUpperCamel}Service {

private final Logger logger = LoggerFactory.getLogger(${modelNameUpperCamel}Service.class);

@Resource
private ${modelNameUpperCamel}Mapper ${modelNameLowerCamel}Mapper;

}
