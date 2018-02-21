# origin

**起源**

### 一些项目介绍 
- IDEA使用Gradle构建多项目工程的步骤说明
    - IDEA不能直接新建多项目使用Gradle
    - 新建项目根目录
        - mkdir origin
        - 或者windows下右键新建文件夹
	- 新建的origin目录下执行：gradle init
	- 创建多个模块，有几个模块写几行
		- Linux

			    mkdir -p origin-interface/src/main/{java,resources} origin-interface/src/test/{java,resource}
				mkdir -p origin-service/src/main/{java,resources} origin-service/src/test/{java,resource}
				mkdir -p origin-web/src/main/{java,resources} origin-web/src/test/{java,resource}
				mkdir -p origin-configure/src/main/{java,resources} origin-configure/src/test/{java,resource}

        - Windows

              mkdir origin-interface\src\main\java,origin-interface\src\main\resource,origin-interface\src\test\java,origin-interface\src\test\resource
              mkdir origin-service\src\main\java,origin-service\src\main\resource,origin-service\src\test\java,origin-service\src\test\resource
              mkdir origin-web\src\main\java,origin-web\src\main\resource,origin-web\src\test\java,origin-web\src\test\resource
              mkdir origin-configure\src\main\java,origin-configure\src\main\resource,origin-configure\src\test\java,origin-configure\src\test\resource

	- 修改settings.gradle文件
		-  引入子模块：include 'shiro-interface','shiro-service','shiro-web','shiro-configure'
	- 修改根目录build.gradle文件，公共配置
	- IDEA导入工程
		- File -> Project from existing sources
		- 选择目录
	- 子工程新建build.gradle文件，设置各种配置

- 设置mysql库
    - database文件夹下的：mysql.sql文件
- 设置redis
    - https://github.com/MicrosoftArchive/redis/releases
    - 解压到本地目录，cmd进入该目录，运行命令：redis-server.exe redis.windows.conf
    - 出现： The server is now ready to accept connections on port 6379 成功启动
- 日志配置:logback
- 模板文件：origin-web模块下的resources.Templates
- TODO:项目的依赖改成注册中心调用，SpringCloud相关改造

### 代码自动生成
- 对test包内的代码生成器CodeGenerator进行配置，根据表名来生成代码

    	修改CodeGenerator.java中的如下常量：
    	JDBC_URL
    	JDBC_USERNAME
    	JDBC_PASSWORD
    	JDBC_DIVER_CLASS_NAME

    	PROJECT_PATH
    	AUTHOR

    	修改ProjectConstant.java中的所有常量

- 输入表名，运行CodeGenerator.main()方法，生成基础代码
     
    	main函数中的genCode()参数为要生成的表，格式为"表名1,表名2,...."
     	执行main函数即可，如果想要打印实体类的详细信息，在实体类中添加：
     	@Override
     	public String toString() {
        	return ToStringBuilder.reflectionToString(this);
     	}
     	其依赖的包为："org.apache.commons:commons-lang3:3.4"

### SpringBoot某些说明
- @RestController注解，代替原Spring项目中的@Controller注解+@ResponseBody注解


### 其他组件整合
- Mybatis整合相关类

    	src/main/java/space/dyenigma/configure/mybatis/MybatisConfigurer.java

- Druid整合相关类

    	space.dyenigma.configure.druid.DruidStatFilter.java
    	space.dyenigma.configure.druid.DruidStatViewServlet.java
    	space.dyenigma.configure.druid.DruidConfigurer.java

- Druid使用相关问题

    	Q:（*）druid property for user to setup”错误？
    	A:该错误出现是因为没有发现使用druid作为数据源的配置项，调用一下数据库后刷新一下就好
	
    	Q:数据库密码怎么加密？
    	A:运行java -cp druid-1.0.16.jar com.alibaba.druid.filter.config.ConfigTools you_password
    	获取key和密文，设置connectionProperties属性为config.decrypt=true;config.decrypt.key=${publickey}
    	最后在Druid过滤器中添加@WebInitParam(name = "config.decrypt", value = "true")，
    	spring.datasource.filters添加config，其他细节自己看源码

    	Q:Druid怎么监控链接泄漏？
    	A:在内置监控页面weburi-detail.html中，查看‘连接池获取连接次数’和‘连接池关闭连接次数’，如果不相等，就是泄漏了

    	Q:数据库连接泄漏发现以后，怎么处理？
    	A:打开removeAbandoned功能，removeAbandoned=true，设置过期时间（秒）removeAbandonedTimeout=1800"，同时输出错误日志logAbandoned=true
- Freemarker整合说明

    	引用依赖：org.springframework.boot:spring-boot-starter-freemarker
    	模板路径：src/main/resources/templates/**.ftl
	
- swagger2整合说明(版本号自己选择)

    	引用依赖：
    		"io.springfox:springfox-swagger2:2.7.0",
     		"io.springfox:springfox-swagger-ui:2.7.0",
    	添加配置类：com.dyenigma.config.SwaggerConfigurer.java
    	API描述见示例类：com.dyenigma.controller.UserController.java

- shiro整合    

    	Apache Shiro 的三大核心组件：
    		Subject 当前用户操作
        	SecurityManager 用于管理所有的Subject
        	Realms 用于进行权限信息的验证，也是我们需要自己实现的
	

    	我们需要实现Realms的Authentication 和 Authorization
        	Authentication用来验证用户身份
        	Authorization授权访问控制，对用户进行的操作授权，如访问链接、资源文件等

    	实现步骤：
        	引入shiro依赖：
        	添加ShiroConfigurer.java配置类
        	实现Filter处理拦截资源文件的问题
        	继承AuthorizingRealm实现自定义Realm

### 一些细节，后续修改
- 过滤器排除规则（已实现）
- 页面跳转规则需要修改（重定向已实现，提交方式已更新）
- 权限操作页面需要调整
	- 修改include功能
		-  删除<%@ taglib prefix="tags" tagdir="/WEB-INF/tags" %>
		-  删除<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
		-  修改<tags:include/>为<#include '../include.ftl'>
	- 因控制器返回值格式改变，所以rsp.status需要改成rsp.code==200
	- 图片路径修改
	- 控制器路径修改
- 注意service实现类中的通用mapper陷阱，最好明确指定特定mapper
- 后台模板更新，已经修改为AdminLTE模板，TODO 相关展示待完善
- 权限存储方式：role_pmsn表，放弃一一对应格式，合并为一个长字符串