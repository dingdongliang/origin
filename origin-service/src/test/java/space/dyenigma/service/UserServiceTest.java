package space.dyenigma.service;

import space.dyenigma.ServerApplicationTests;
import space.dyenigma.entity.User;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.List;

/**
 * Description: 注意测试类的地址和主类地址保持一致
 * author  dyenigma
 * date 2017/7/25 12:04
 */
public class UserServiceTest extends ServerApplicationTests {

    private Logger logger = LoggerFactory.getLogger(UserServiceTest.class);

    @Autowired
    private IUserService userService;

    /**
     * 查询主数据源
     */
    @Test
    public void updateTest() {
        User user = new User();
        user.setUsername("account");
        user.setAtomid(5);
        user.setAge(34);
        user.setBalance(BigDecimal.valueOf(1000000));
        userService.update(user);
    }

    /**
     * 查询SlaveA数据源
     */
    @Test
    public void findAllTest() {
        List<User> userList = userService.findAll();
        for (User user : userList) {
            logger.info(user.toString());
        }
    }

    /**
     * 查询slaveB数据源
     */
    @Test
    public void findByIdsTest() {
        List<User> userList = userService.findByIds("5");
        for (User user : userList) {
            logger.info(user.toString());
        }
    }
}
