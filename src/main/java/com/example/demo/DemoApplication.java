package com.example.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.event.EventListener;

@SpringBootApplication
@EnableConfigurationProperties(SimpleConfig.class)
public class DemoApplication {


	public SimpleConfig simpleConfig;
	public SmsSender smsSender;
	public EventPublisher eventPublisher;
	Logger logger = LoggerFactory.getLogger("apps");


	public DemoApplication(ApplicationEventPublisher eventPublisher, SmsSender smsSender) {
		var publisher = new EventPublisher();
		publisher.applicationEventPublisher = eventPublisher;
		this.eventPublisher = publisher;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@EventListener(ApplicationStartedEvent.class)
	public void publishStart(ApplicationStartedEvent event){
		simpleConfig = event.getApplicationContext().getBean(SimpleConfig.class);
		smsSender = event.getApplicationContext().getBean(SmsSender.class);
		eventPublisher.publishCustomEvent(new ConfigEvent(simpleConfig));
	}

	@EventListener(ConfigEvent.class)
	public void listenConfigEvent(ConfigEvent event) {
		logger.info("first-config: " + event.simpleConfig.first_config);
		logger.info("second-config: "+ event.simpleConfig.secondConfig);
		logger.info("subconfig: "+ event.simpleConfig.subconfig);
		logger.info("user: " + event.simpleConfig.user);
		logger.info("ttl: " + event.simpleConfig.ttl);
		smsSender.send("777", "Simple text");
	}
}
