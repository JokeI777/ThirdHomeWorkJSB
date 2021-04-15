package com.example.demo;

import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Component;

@ConstructorBinding
public class EventPublisher {
    public ApplicationEventPublisher applicationEventPublisher;

    public void publishCustomEvent(ConfigEvent configEvent) {
        System.out.println("Publishing custom event. ");
        applicationEventPublisher.publishEvent(configEvent);
    }
}
