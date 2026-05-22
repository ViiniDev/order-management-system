package com.viinidev.notificationservice.service;

import com.viinidev.notificationservice.dto.OrderCreatedEvent;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class OrderEventConsumer {
    private final ProcessedNotificationService processedNotificationService;

    public OrderEventConsumer(ProcessedNotificationService processedNotificationService) {
        this.processedNotificationService = processedNotificationService;
    }

    @RabbitListener(queues = "${app.rabbitmq.queue}")
    public void consume(OrderCreatedEvent event) {
        processedNotificationService.process(event);
    }
}
