package cn.kejt.trace2;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.servlet.http.HttpServletRequest;

@RestController
@EnableDiscoveryClient
@SpringBootApplication
public class Trace2Application {

    private final Logger logger = Logger.getLogger(getClass());

    @RequestMapping(value = "/trace-2", method = RequestMethod.GET)
    public String trace(HttpServletRequest request) {
        logger.info("===<call trace-2, TraceID="+request.getHeader("X-B3-TraceId")+",SpanID="+request.getHeader("X-B3-SpanId")+">===");
        return "trace";
    }

    public static void main(String[] args) {
        SpringApplication.run(Trace2Application.class, args);
    }
}
