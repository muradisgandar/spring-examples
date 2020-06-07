package com.company.listener;

import com.company.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    @RabbitListener(queues = "company-queue")
    public void handleMessage(Notification notification){
        System.out.println("Message is recieved");
        System.out.println(notification.toString());
    }
}
