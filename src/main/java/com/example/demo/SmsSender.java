package com.example.demo;

public interface SmsSender {
    void send(String phoneNumber, String text);
}
