package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;
import org.springframework.stereotype.Component;


@ConfigurationProperties(prefix = "app")
@ConstructorBinding
public class SimpleConfig {
    public String first_config;
    public String secondConfig;
    public String subconfig;
    public String user;
    public String ttl;

    public SimpleConfig(String first_config, String secondConfig, String subconfig, String user, String ttl){
        this.first_config = first_config;
        this.secondConfig = secondConfig;
        this.subconfig = subconfig;
        this.user = user;
        this.ttl = ttl;
    }
}
