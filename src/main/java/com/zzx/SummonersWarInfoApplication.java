package com.zzx;

import com.zzx.config.kafka.KafkaSender;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

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
		SpringApplication application = new SpringApplication(SummonersWarInfoApplication.class);
		application.run( args);
	}

	//然后每隔1分钟执行一次
	//@Scheduled(fixedRate = 1000 * 30)
	public void testKafka() throws Exception {
		kafkaSender.sendTest();
	}

}
