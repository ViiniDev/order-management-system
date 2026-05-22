package com.viinidev.notificationservice.controller;

import com.viinidev.notificationservice.dto.ProcessedNotificationResponse;
import com.viinidev.notificationservice.service.ProcessedNotificationService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
public class NotificationController {
    private final ProcessedNotificationService processedNotificationService;

    public NotificationController(ProcessedNotificationService processedNotificationService) {
        this.processedNotificationService = processedNotificationService;
    }

    @GetMapping
    public List<ProcessedNotificationResponse> list() {
        return processedNotificationService.list();
    }
}
