package cn.kejt.streamhello.receive;

import cn.kejt.streamhello.StreamHelloApplication;
import cn.kejt.streamhello.send.SinkSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.stream.annotation.EnableBinding;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;

@EnableBinding(value = {Sink.class, SinkSender.class})
public class SinkReceiver {
    private static Logger logger = LoggerFactory.getLogger(StreamHelloApplication.class);

    @StreamListener(Sink.INPUT)
    public void receive(Object payload) {
        logger.info("Received : " + payload);
    }
}
