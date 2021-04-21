package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;


import java.util.logging.Logger;

@Profile("dev")
@Component
public class DevSmsSender implements SmsSender {
    static final Logger logger = Logger.getLogger("devSend");
    @Override
    public void send(String phoneNumber, String text){

        logger.info("Dev message");
    }
}
