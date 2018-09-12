package com.zzx;

import com.zzx.config.kafka.KafkaSender;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

/**
 * @author zzx
 */
@SpringBootApplication
@EnableScheduling
public class SummonersWarInfoApplication {

	@Autowired
	private KafkaSender kafkaSender;

	public static Logger logger = LoggerFactory.getLogger(SummonersWarInfoApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(SummonersWarInfoApplication.class, args);
	}

	//然后每隔1分钟执行一次
	//@Scheduled(fixedRate = 1000 * 30)
	public void testKafka() throws Exception {
		kafkaSender.sendTest();
	}

}
