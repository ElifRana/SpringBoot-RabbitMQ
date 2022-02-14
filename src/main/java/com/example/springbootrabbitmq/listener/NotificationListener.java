package com.example.springbootrabbitmq.listener;

import com.example.springbootrabbitmq.model.Notification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

@Service
public class NotificationListener {

    //kuyruktan gelen mesajları dinliyor
    //bir mesaj geldiğinde rabbit listener tetiklensin
    @RabbitListener(queues = "elif-rana-queue")
    public void handleMessage(Notification notification){
        System.out.println("Mesaj alındı");
        System.out.println(notification.toString());
    }
}
