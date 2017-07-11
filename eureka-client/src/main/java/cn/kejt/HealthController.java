package cn.kejt;

import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

@Component
public class HealthController implements HealthIndicator {

    @Override
    public Health health() {
        int errorCode = check();
        if (0 == errorCode) {
            System.out.println(123);
            return Health.down().withDetail("Error Code", errorCode).build();
        } else {
            return Health.up().build();
        }

    }

    private int check() {
        // TODO: 2017/7/11 0011 这里可以做自定义的一些   健康检查 
        return 0;
    }
}
