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


	private SimpleConfig simpleConfig;
	private SmsSender smsSender;
	private ApplicationEventPublisher eventPublisher;
	static final Logger logger = LoggerFactory.getLogger("apps");


	public DemoApplication(ApplicationEventPublisher eventPublisher, SmsSender smsSender, SimpleConfig simpleConfig) {
		this.simpleConfig = simpleConfig;
		this.smsSender =  smsSender;
		this.eventPublisher = eventPublisher;
	}

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@EventListener(ApplicationStartedEvent.class)
	public void publishStart(ApplicationStartedEvent event){
		eventPublisher.publishEvent(new ConfigEvent(simpleConfig));
	}

	@EventListener(ConfigEvent.class)
	public void listenConfigEvent(ConfigEvent event) {
		logger.info("first-config: " + event.simpleConfig.getFirstConfig());
		logger.info("second-config:");
		logger.info("  subconfig: "+ event.simpleConfig.getSecondConfig().getSubConfig());
		logger.info("  user: " + event.simpleConfig.getSecondConfig().getUser());
		logger.info("  ttl: " + event.simpleConfig.getSecondConfig().getTtl());
		smsSender.send("777", "Simple text");
	}
}
