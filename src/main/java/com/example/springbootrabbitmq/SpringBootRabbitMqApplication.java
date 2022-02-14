package com.example.springbootrabbitmq;

import com.example.springbootrabbitmq.model.Notification;
import com.example.springbootrabbitmq.producer.NotificationProducer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Date;
import java.util.UUID;

@SpringBootApplication
public class SpringBootRabbitMqApplication {

    @Autowired
    NotificationProducer notificationProducer;

    public static void main(String[] args) {
        SpringApplication.run(SpringBootRabbitMqApplication.class, args);
    }

}
