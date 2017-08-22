package cn.kejt.feignconsumer.web;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 定义HelloService接口,通过@FeignClient注解制定服务名来绑定服务,
 * 然后再使用<code>SpringMVC</code>的注解来绑定具体该服务提供的REST接口
 * @apiNote  服务名不区分大小写
 */
@FeignClient(value = "hello-service")
public interface HelloService {

    @RequestMapping("/hello")
    String hello();
}
