package space.dyenigma;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 * origin/space.dyenigma
 *
 * @Description : 入口
 * @Author : dingdongliang
 * @Date : 2018/2/15 8:54
 */
@Slf4j
@SpringBootApplication
@ComponentScan(basePackages = {"space.dyenigma"})
@EnableJpaRepositories("space.dyenigma.dao")
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

