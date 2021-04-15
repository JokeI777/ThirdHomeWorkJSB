package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Profile("dev")
@Component
public class DevSmsSender implements SmsSender {

    @Override
    public void send(String phoneNumber, String text){
        Logger logger = Logger.getLogger("devSend");
        logger.info("Dev message");
    }
}
