package com.company.producer;

import com.company.model.Notification;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Service
public class NotificationProducer {

    @Value("${sb.rabbit.routing.name}")
    private String routingName;

    @Value("${sb.rabbit.exchange.name}")
    private String exchangeName;

    @PostConstruct
    public void init(){
        Notification notification = new Notification();
        notification.setNotificationId(UUID.randomUUID().toString());
        notification.setCreatedAt(new Date());
        notification.setMessage("Message");
        notification.setIsSeen(false);

        sendToQueue(notification);
    }

    private final RabbitTemplate rabbitTemplate;

    public NotificationProducer(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendToQueue(Notification notification){
        System.out.println("Notification sent ID : " + notification.getNotificationId());
        rabbitTemplate.convertAndSend(exchangeName,routingName,notification);
    }
}
