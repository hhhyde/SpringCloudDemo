package cn.kejt;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class ConsumerController {

    @Autowired
    HelloService helloService;
    @Autowired
    RestTemplate restTemplate;

    @RequestMapping(value = "/ribbon-consumer", method = RequestMethod.GET)
    public String helloConsumer() {
        return helloService.helloService();
    }

    @RequestMapping(value = "/obd", method = RequestMethod.GET)
    public String obd(@RequestParam(value = "key") String key) {
        MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
        return restTemplate.getForEntity("http://OBDSERVICE/obd?key="+key, String.class).getBody();
    }
}
