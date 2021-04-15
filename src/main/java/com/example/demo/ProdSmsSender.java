package com.example.demo;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Profile("!dev")
@Component
public class ProdSmsSender implements SmsSender{

    @Override
    public void send(String phoneNumber, String text){
        Logger logger = Logger.getLogger("prodSend");
        logger.info("Prod message");
    }
}
