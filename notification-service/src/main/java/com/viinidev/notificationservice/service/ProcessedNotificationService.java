package com.viinidev.notificationservice.service;

import com.viinidev.notificationservice.domain.ProcessedNotification;
import com.viinidev.notificationservice.dto.OrderCreatedEvent;
import com.viinidev.notificationservice.dto.ProcessedNotificationResponse;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
public class ProcessedNotificationService {
    private final List<ProcessedNotification> notifications = new ArrayList<>();

    public void process(OrderCreatedEvent event) {
        String message = "Order %d created for product %s, quantity %d."
                .formatted(event.orderId(), event.productName(), event.quantity());
        notifications.add(new ProcessedNotification(event.orderId(), event.customerEmail(), message, LocalDateTime.now()));
    }

    public List<ProcessedNotificationResponse> list() {
        return notifications.stream().map(ProcessedNotificationResponse::from).toList();
    }
}
