package space.dyenigma.configure.captcha;

import com.google.code.kaptcha.impl.DefaultKaptcha;
import com.google.code.kaptcha.util.Config;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

/**
 * origin/space.dyenigma.configure.captcha
 *
 * @Description: 验证码配置
 * @Author: dingdongliang
 * @Date: 2017/7/21 18:16
 */
@Configuration
public class CaptchaConfigurer {
    @Bean(name = "captchaProducer")
    public DefaultKaptcha getKaptchaBean() {
        DefaultKaptcha defaultKaptcha = new DefaultKaptcha();
        //可以使用kaptcha.image.width和kaptcha.image.height控制图片的长和高
        Properties properties = new Properties();
        //在session中获取code以取得验证码的值
        properties.setProperty("kaptcha.session.key", "code");
        // 验证码长度
        properties.setProperty("kaptcha.textproducer.char.length", "6");
        // 验证码文本字符大小
        properties.setProperty("kaptcha.textproducer.font.size", "45");
        // 图片边框，合法值：yes , no
        properties.setProperty("kaptcha.border", "no");
        //边框颜色，合法值： r,g,b (and optional alpha) 或者 white,black,blue.
        properties.setProperty("kaptcha.border.color", "105,179,90");
        // 边框厚度，合法值：>0
        properties.setProperty("kaptcha.border.thickness", "1");
        // 图片实现类
        properties.setProperty("kaptcha.producer.impl", "com.google.code.kaptcha.impl.DefaultKaptcha");
        // 图片样式，水纹WaterRipple,鱼眼FishEyeGimpy,阴影ShadowGimpy，可以自己继承com.google.code.kaptcha.GimpyEngine自定义样式
        properties.setProperty("kaptcha.obscurificator.impl", "com.google.code.kaptcha.impl.FishEyeGimpy");
        // 字体颜色，合法值： r,g,b 或者 white,black,blue.
        properties.setProperty("kaptcha.textproducer.font.color", "black");
        // 字体
        properties.setProperty("kaptcha.textproducer.font.names", "Arial, Courier");
        // 文字间隔
        properties.setProperty("kaptcha.textproducer.char.space", "3");
        // 文字渲染器
        properties.setProperty("kaptcha.word.impl", "com.google.code.kaptcha.text.impl.DefaultWordRenderer");
        // 文本集合,验证码值从此集合中获取
        properties.setProperty("kaptcha.textproducer.char.string", "abcde2345678hfknmurstwx");
        // 文本实现类
        properties.setProperty("kaptcha.textproducer.impl", "com.google.code.kaptcha.text.impl.DefaultTextCreator");
        // 干扰实现类，可以自己继承com.google.code.kaptcha.NoiseProducer，自定义干扰线
        properties.setProperty("kaptcha.noise.impl", "com.google.code.kaptcha.impl.NoNoise");
        // 干扰颜色，合法值： r,g,b 或者 white,black,blue.
        properties.setProperty("kaptcha.noise.color", "black");
        // 背景实现类
        properties.setProperty("kaptcha.background.impl", "com.google.code.kaptcha.impl.DefaultBackground");
        Config config = new Config(properties);
        defaultKaptcha.setConfig(config);
        return defaultKaptcha;
    }
}
