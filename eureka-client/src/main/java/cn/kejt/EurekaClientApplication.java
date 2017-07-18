package cn.kejt;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


/**
 * 在 Application 启动类中支持 Swagger, 增加@EnableSwagger2注解, 让 SpringBoot 项目支持 Swagger
 */
@EnableSwagger2
@SpringBootApplication
public class EurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaClientApplication.class, args);
    }
}
