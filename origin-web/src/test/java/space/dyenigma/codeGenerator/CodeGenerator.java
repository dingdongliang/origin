package space.dyenigma.codeGenerator;

import freemarker.template.TemplateExceptionHandler;
import org.mybatis.generator.api.MyBatisGenerator;
import org.mybatis.generator.config.Configuration;
import org.mybatis.generator.config.Context;
import org.mybatis.generator.config.GeneratedKey;
import org.mybatis.generator.config.JDBCConnectionConfiguration;
import org.mybatis.generator.config.JavaClientGeneratorConfiguration;
import org.mybatis.generator.config.JavaModelGeneratorConfiguration;
import org.mybatis.generator.config.ModelType;
import org.mybatis.generator.config.PluginConfiguration;
import org.mybatis.generator.config.PropertyRegistry;
import org.mybatis.generator.config.SqlMapGeneratorConfiguration;
import org.mybatis.generator.config.TableConfiguration;
import org.mybatis.generator.internal.DefaultShellCallback;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static space.dyenigma.core.ProjectConstant.BASE_PACKAGE;
import static space.dyenigma.core.ProjectConstant.CONTROLLER_PACKAGE;
import static space.dyenigma.core.ProjectConstant.MAPPER_INTERFACE_REFERENCE;
import static space.dyenigma.core.ProjectConstant.MAPPER_PACKAGE;
import static space.dyenigma.core.ProjectConstant.MODEL_PACKAGE;
import static space.dyenigma.core.ProjectConstant.SERVICE_IMPL_PACKAGE;
import static space.dyenigma.core.ProjectConstant.SERVICE_PACKAGE;


/**
 * origin/space.dyenigma.control
 *
 * @Description: 代码生成器，一定注意修改PROJECT_PATH
 * @Author: dingdongliang
 * @Date: 2017/7/5
 */
public class CodeGenerator {

    private static Logger logger = LoggerFactory.getLogger(CodeGenerator.class);

    //JDBC配置，请修改为你项目的实际配置
    private static final String JDBC_URL = "jdbc:mysql://localhost:3306/origin";
    private static final String JDBC_USERNAME = "root";
    private static final String JDBC_PASSWORD = "origin2018!";
    private static final String JDBC_DIVER_CLASS_NAME = "com.mysql.jdbc.Driver";

    //项目在硬盘上的基础路径，这里根据不同的项目需要修改
    private static final String PROJECT_PATH = "E:/codeSpace/origin";
    //模板位置
    private static final String TEMPLATE_FILE_PATH = PROJECT_PATH + "/src/test/resources/generator/template";

    private static final String JAVA_PATH = "/src/main/java"; //java文件路径
    private static final String RESOURCES_PATH = "/src/main/resources";//资源文件路径

    private static final String PACKAGE_PATH_SERVICE = packageConvertPath(SERVICE_PACKAGE);//生成的Service存放路径
    private static final String PACKAGE_PATH_SERVICE_IMPL = packageConvertPath(SERVICE_IMPL_PACKAGE);//生成的Service实现存放路径
    private static final String PACKAGE_PATH_CONTROLLER = packageConvertPath(CONTROLLER_PACKAGE);//生成的Controller存放路径

    private static final String AUTHOR = "dingdongliang";//@author
    private static final String DATE = new SimpleDateFormat("yyyy/MM/dd").format(new Date());//@date

    public static void main(String[] args) {
        genCode("gen_answer", "gen_front_menu", "gen_qa_log",
                "gen_question", "sys_company", "sys_division", "sys_permission",
                "sys_post", "sys_post_role", "sys_prj_role", "sys_prj_user",
                "sys_project", "sys_role", "sys_role_pmsn", "sys_user_pmsn",
                "sys_user_post", "sys_user_role", "sys_user");
    }

    public static void genCode(String... tableNames) {
        for (String tableName : tableNames) {
            //根据需求生成，不需要的注掉，模板有问题的话可以自己修改。
            genModelAndMapper(tableName);
            genService(tableName);
            genController(tableName);
        }
    }

    public static void genModelAndMapper(String tableName) {
        Context context = new Context(ModelType.FLAT);
        context.setId("TheSunShines");
        context.setTargetRuntime("MyBatis3Simple");
        context.addProperty(PropertyRegistry.CONTEXT_BEGINNING_DELIMITER, "`");
        context.addProperty(PropertyRegistry.CONTEXT_ENDING_DELIMITER, "`");

        JDBCConnectionConfiguration jdbcConnectionConfiguration = new JDBCConnectionConfiguration();
        jdbcConnectionConfiguration.setConnectionURL(JDBC_URL);
        jdbcConnectionConfiguration.setUserId(JDBC_USERNAME);
        jdbcConnectionConfiguration.setPassword(JDBC_PASSWORD);
        jdbcConnectionConfiguration.setDriverClass(JDBC_DIVER_CLASS_NAME);
        context.setJdbcConnectionConfiguration(jdbcConnectionConfiguration);

        PluginConfiguration pluginConfiguration = new PluginConfiguration();
        pluginConfiguration.setConfigurationType("tk.mybatis.mapper.generator.MapperPlugin");
        pluginConfiguration.addProperty("mappers", MAPPER_INTERFACE_REFERENCE);
        context.addPluginConfiguration(pluginConfiguration);

        JavaModelGeneratorConfiguration javaModelGeneratorConfiguration = new JavaModelGeneratorConfiguration();
        javaModelGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaModelGeneratorConfiguration.setTargetPackage(MODEL_PACKAGE);
        context.setJavaModelGeneratorConfiguration(javaModelGeneratorConfiguration);

        SqlMapGeneratorConfiguration sqlMapGeneratorConfiguration = new SqlMapGeneratorConfiguration();
        sqlMapGeneratorConfiguration.setTargetProject(PROJECT_PATH + RESOURCES_PATH);
        sqlMapGeneratorConfiguration.setTargetPackage("mapper");
        context.setSqlMapGeneratorConfiguration(sqlMapGeneratorConfiguration);

        JavaClientGeneratorConfiguration javaClientGeneratorConfiguration = new JavaClientGeneratorConfiguration();
        javaClientGeneratorConfiguration.setTargetProject(PROJECT_PATH + JAVA_PATH);
        javaClientGeneratorConfiguration.setTargetPackage(MAPPER_PACKAGE);
        javaClientGeneratorConfiguration.setConfigurationType("XMLMAPPER");
        context.setJavaClientGeneratorConfiguration(javaClientGeneratorConfiguration);

        TableConfiguration tableConfiguration = new TableConfiguration(context);
        tableConfiguration.setTableName(tableName);
        tableConfiguration.setGeneratedKey(new GeneratedKey("id", "Mysql", true, null));
        context.addTableConfiguration(tableConfiguration);

        List<String> warnings;
        MyBatisGenerator generator;
        try {
            Configuration config = new Configuration();
            config.addContext(context);
            config.validate();

            boolean overwrite = true;
            DefaultShellCallback callback = new DefaultShellCallback(overwrite);
            warnings = new ArrayList<>();
            generator = new MyBatisGenerator(config, callback, warnings);
            generator.generate(null);
        } catch (Exception e) {
            throw new RuntimeException("生成Model和Mapper失败", e);
        }

        if (generator.getGeneratedJavaFiles().isEmpty() || generator.getGeneratedXmlFiles().isEmpty()) {
            throw new RuntimeException("生成Model和Mapper失败：" + warnings);
        }

        String modelName = tableNameConvertUpperCamel(tableName);
        logger.debug(modelName + ".java 生成成功");
        logger.debug(modelName + "Mapper.java 生成成功");
        logger.debug(modelName + "Mapper.xml 生成成功");
    }

    public static void genService(String tableName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            String modelNameUpperCamel = tableNameConvertUpperCamel(tableName);
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", BASE_PACKAGE);

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE + "I" + modelNameUpperCamel +
                    "Service.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            cfg.getTemplate("service.ftl").process(data,
                    new FileWriter(file));
            logger.debug("I" + modelNameUpperCamel + "Service.java 生成成功");

            File file1 = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_SERVICE_IMPL + modelNameUpperCamel +
                    "Service.java");
            if (!file1.getParentFile().exists()) {
                file1.getParentFile().mkdirs();
            }
            cfg.getTemplate("service-impl.ftl").process(data,
                    new FileWriter(file1));
            logger.debug(modelNameUpperCamel + "Service.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Service失败", e);
        }
    }

    public static void genController(String tableName) {
        try {
            freemarker.template.Configuration cfg = getConfiguration();

            Map<String, Object> data = new HashMap<>();
            data.put("date", DATE);
            data.put("author", AUTHOR);
            data.put("baseRequestMapping", tableNameConvertMappingPath(tableName));
            String modelNameUpperCamel = tableNameConvertUpperCamel(tableName);
            data.put("modelNameUpperCamel", modelNameUpperCamel);
            data.put("modelNameLowerCamel", tableNameConvertLowerCamel(tableName));
            data.put("basePackage", BASE_PACKAGE);

            File file = new File(PROJECT_PATH + JAVA_PATH + PACKAGE_PATH_CONTROLLER + modelNameUpperCamel +
                    "Controller.java");
            if (!file.getParentFile().exists()) {
                file.getParentFile().mkdirs();
            }
            //cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));
            cfg.getTemplate("controller-restful.ftl").process(data, new FileWriter(file));

            logger.debug(modelNameUpperCamel + "Controller.java 生成成功");
        } catch (Exception e) {
            throw new RuntimeException("生成Controller失败", e);
        }

    }

    private static freemarker.template.Configuration getConfiguration() throws IOException {
        freemarker.template.Configuration cfg = new freemarker.template.Configuration(freemarker.template
                .Configuration.VERSION_2_3_23);
        cfg.setDirectoryForTemplateLoading(new File(TEMPLATE_FILE_PATH));
        cfg.setDefaultEncoding("UTF-8");
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.IGNORE_HANDLER);
        return cfg;
    }

    private static String tableNameConvertLowerCamel(String tableName) {
        StringBuilder result = new StringBuilder();
        if (tableName != null && tableName.length() > 0) {
            tableName = tableName.toLowerCase();//兼容使用大写的表名
            boolean flag = false;
            for (int i = 0; i < tableName.length(); i++) {
                char ch = tableName.charAt(i);
                if ("_".charAt(0) == ch) {
                    flag = true;
                } else {
                    if (flag) {
                        result.append(Character.toUpperCase(ch));
                        flag = false;
                    } else {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }

    private static String tableNameConvertUpperCamel(String tableName) {
        String camel = tableNameConvertLowerCamel(tableName);
        return camel.substring(0, 1).toUpperCase() + camel.substring(1);
    }

    private static String tableNameConvertMappingPath(String tableName) {
        tableName = tableName.toLowerCase();//兼容使用大写的表名
        return "/" + (tableName.contains("_") ? tableName.replaceAll("_", "/") : tableName);
    }

    private static String packageConvertPath(String packageName) {
        return String.format("/%s/", packageName.contains(".") ? packageName.replaceAll("\\.", "/") : packageName);
    }
}
