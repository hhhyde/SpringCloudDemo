package cn.kejt.security;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@SpringBootApplication
public class SecurityApplication extends WebMvcConfigurerAdapter {

    public static void main(String[] args) {
        SpringApplication.run(SecurityApplication.class, args);
    }
}
