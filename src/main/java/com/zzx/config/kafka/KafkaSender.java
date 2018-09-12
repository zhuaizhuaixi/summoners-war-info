package com.zzx.config.kafka;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.KafkaHeaders;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Component;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * @author zzx
 */
@Component
public class KafkaSender {

    @Autowired
    private KafkaTemplate kafkaTemplate;

    /**
     * 发送消息到kafka,主题为test
     */
    public void sendTest(){
        ListenableFuture<SendResult<Integer, String>> future = kafkaTemplate.send("test", "hello,kafka  " + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")));
        future.addCallback(new ListenableFutureCallback<SendResult<Integer, String>>(){
            @Override
            public void onSuccess(SendResult<Integer, String> result) {
                System.out.println(result);
            }

            @Override
            public void onFailure(Throwable ex) {
                System.out.println(ex);
            }
        });
    }
}
