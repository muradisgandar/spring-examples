package com.company.aop.service;

import org.springframework.stereotype.Service;

@Service
public class MessageService {

    public String sendMessage(String param) {
        System.out.println("Message is sent :" + param);
        return param;
    }
}
