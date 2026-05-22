package com.viinidev.notificationservice.dto;

import com.viinidev.notificationservice.domain.ProcessedNotification;

import java.time.LocalDateTime;

public record ProcessedNotificationResponse(Long orderId, String recipient, String message, LocalDateTime processedAt) {
    public static ProcessedNotificationResponse from(ProcessedNotification notification) {
        return new ProcessedNotificationResponse(
                notification.orderId(),
                notification.recipient(),
                notification.message(),
                notification.processedAt()
        );
    }
}
