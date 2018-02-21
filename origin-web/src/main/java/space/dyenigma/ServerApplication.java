package space.dyenigma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import space.dyenigma.configure.druid.DynamicDataSourceRegister;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Import;

/**
 * origin/space.dyenigma
 *
 * @Description : WEB 入口
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:54
 */
@SpringBootApplication
@Import(DynamicDataSourceRegister.class)
@MapperScan("space.dyenigma.dao")
@ServletComponentScan
public class ServerApplication implements CommandLineRunner {

    private final Logger logger = LoggerFactory.getLogger(ServerApplication.class);

    @Override
    public void run(String... args) {
        logger.info("初始化系统...");

    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(ServerApplication.class, args);
    }
}

