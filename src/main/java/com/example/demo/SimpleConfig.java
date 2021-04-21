package com.example.demo;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.ConstructorBinding;

@ConstructorBinding
@ConfigurationProperties(prefix = "app")
public class SimpleConfig {
    private final String firstConfig;
    private final SecondConfig secondConfig;

    public SecondConfig getSecondConfig() {
        return secondConfig;
    }

    public String getFirstConfig() {
        return firstConfig;
    }

    public SimpleConfig(String firstConfig, SecondConfig secondConfig){
        this.firstConfig = firstConfig;
        this.secondConfig = secondConfig;
    }
    public static class SecondConfig{
        private final String subConfig;
        private final String user;
        private final String ttl;

        public SecondConfig(String subConfig, String user, String ttl){
            this.subConfig = subConfig;
            this.user = user;
            this.ttl = ttl;
        }

        public String getSubConfig() {
            return subConfig;
        }

        public String getUser() {
            return user;
        }

        public String getTtl() {
            return ttl;
        }
    }
}
