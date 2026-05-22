package com.viinidev.notificationservice.domain;

import java.time.LocalDateTime;

public record ProcessedNotification(Long orderId, String recipient, String message, LocalDateTime processedAt) {
}
