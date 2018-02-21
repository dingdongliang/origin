package ${basePackage}.control;

import ${basePackage}.core.Result;
import ${basePackage}.core.ResultGenerator;
import ${basePackage}.entity.${modelNameUpperCamel};
import ${basePackage}.service.I${modelNameUpperCamel}Service;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * origin/${basePackage}.control
 *
 * @Description:
 * @Author: ${author}
 * @Date: ${date}
 */
@RestController
@RequestMapping("${baseRequestMapping}")
public class ${modelNameUpperCamel}Controller{

private final Logger logger = LoggerFactory.getLogger(${modelNameUpperCamel}Controller.class);

@Resource
private I${modelNameUpperCamel}Service ${modelNameLowerCamel}Service;

@PostMapping
public Result add(${modelNameUpperCamel} ${modelNameLowerCamel}) {
${modelNameLowerCamel}Service.save(${modelNameLowerCamel});
return ResultGenerator.genSuccessResult();
}

@DeleteMapping("/{id}")
public Result delete(@PathVariable Integer id) {
${modelNameLowerCamel}Service.deleteById(id);
return ResultGenerator.genSuccessResult();
}

@PutMapping
public Result update(${modelNameUpperCamel} ${modelNameLowerCamel}) {
${modelNameLowerCamel}Service.update(${modelNameLowerCamel});
return ResultGenerator.genSuccessResult();
}

@GetMapping("/{id}")
public Result detail(@PathVariable Integer id) {
${modelNameUpperCamel} ${modelNameLowerCamel} = ${modelNameLowerCamel}Service.findById(id);
return ResultGenerator.genSuccessResult(${modelNameLowerCamel});
}

@GetMapping("/list")
public Result list(@RequestParam(defaultValue = "0") Integer page, @RequestParam(defaultValue = "0") Integer size) {
PageHelper.startPage(page, size);
List<${modelNameUpperCamel}> list = ${modelNameLowerCamel}Service.findAll();
PageInfo pageInfo = new PageInfo(list);
return ResultGenerator.genSuccessResult(pageInfo);
}
}
