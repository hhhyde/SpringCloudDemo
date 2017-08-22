package cn.kejt.helloserviceapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Spring Cloud Feign 的继承特性.由于 Feign 和 eureka_client 都重复定义了相同的接口(如)
 */
@SpringBootApplication
public class HelloServiceApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(HelloServiceApiApplication.class, args);
	}
}
