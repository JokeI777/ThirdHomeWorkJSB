package com.example.demo;

import org.springframework.context.ApplicationEvent;

public class ConfigEvent {

    SimpleConfig simpleConfig;

    public ConfigEvent(SimpleConfig simpleConfig){
        this.simpleConfig = simpleConfig;
    }
}
