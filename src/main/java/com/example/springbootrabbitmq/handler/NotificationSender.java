package com.example.springbootrabbitmq.handler;

import com.example.springbootrabbitmq.model.Notification;
import com.example.springbootrabbitmq.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;
import java.util.UUID;

@Component
public class NotificationSender {

    @Autowired
    private NotificationProducer producer;

    public void getThread() {

        Thread thread = new Thread(() -> {

            while (true) {

                Notification notification = new Notification();
                notification.setNotificationId(UUID.randomUUID().toString());
                notification.setCreatedAt(new Date());
                notification.setMessage("RabbitMq");
                notification.setSeen(Boolean.FALSE);
                producer.sendToQueue(notification);

                try {
                    Thread.sleep(5000);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        });

        thread.setName("Notification Sender");
        thread.start();

    }

    @PostConstruct
    public void init() {
        getThread();
    }
}
