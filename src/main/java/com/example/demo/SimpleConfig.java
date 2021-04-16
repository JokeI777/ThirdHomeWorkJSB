package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;


@ConfigurationProperties(prefix = "app")
@ConstructorBinding
public class SimpleConfig {
    public String first_config;
    public Second_config second_config;


    public SimpleConfig(String first_config, Second_config second_config){
        this.first_config = first_config;
        this.second_config = second_config;
    }
    public static class Second_config{
        public String subConfig;
        public String user;
        public String ttl;

        public Second_config(String subConfig, String user, String ttl){
            this.subConfig = subConfig;
            this.user = user;
            this.ttl = ttl;
        }
    }
}
