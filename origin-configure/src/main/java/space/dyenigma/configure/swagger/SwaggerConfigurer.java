package space.dyenigma.configure.swagger;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * origin/space.dyenigma.configure.swagger
 *
 * @Description: swagger自动生成springboot API
 * @Author: dingdongliang
 * @Date: 2017/7/27 16:32
 * P.S.注意设置目标文件夹，本项目是space.dyenigma.controller
 */
@Configuration
@EnableSwagger2
public class SwaggerConfigurer {

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                .apis(RequestHandlerSelectors.basePackage("space.dyenigma.control"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        Contact contact = new Contact("dyenigma", "https://github.com/dingdongliang/origin", "dyenigma@163.com");
        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("dyenigma's Spring Boot 脚手架：https://github.com/dingdongliang/origin")
                .contact(contact)
                .version("1.0")
                .build();
    }
}
