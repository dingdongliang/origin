package space.dyenigma.configure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * origin/space.dyenigma.configure
 *
 * @Description:
 * @Author: dingdongliang
 * @Date: 2017/7/26 16:42
 */
@Configuration
@EnableScheduling
public class TaskConfigurer {
    private final Logger logger = LoggerFactory.getLogger(TaskConfigurer.class);

    @Scheduled(cron = "0 0/20 * * * ?") // 每20分执行一次
    public void scheduler() {
        logger.info(">>>>>>>>>>>>> 定时任务scheduled测试 ... ");
    }
}
