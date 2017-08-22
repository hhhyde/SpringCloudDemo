package cn.kejt.apigateway;

import cn.kejt.apigateway.filter.AccessFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

/**
 * 路由网关优点
 * 1. 统一入口<br/>
 * 2. 与服务治理框架结合,实现自动化的服务维护和负载均衡的路由转发<br/>
 * 3. 可以将 接口权限验证 与 微服务业务部分 解耦<br/>
 * 4. 通过过滤器,在各生命周期中校验请求,将原本在对外服务层做的校验前移,保证了为服务的无状态性,同时降低了微服务的测试难度,让服务本身更集中关注业务逻辑的处理<br/>
 */
@EnableZuulProxy
@SpringCloudApplication
public class ApiGatewayApplication {

    /**
     * 启动过滤器
     * @return
     */
    @Bean
    public AccessFilter accessFilter() {
        return new AccessFilter();
    }

    public static void main(String[] args) {
        SpringApplication.run(ApiGatewayApplication.class, args);
    }
}
