#origin
**起源**

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
