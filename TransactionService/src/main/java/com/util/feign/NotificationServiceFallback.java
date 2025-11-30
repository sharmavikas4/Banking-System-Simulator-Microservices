package com.util.feign;

import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;
import com.exceptions.ExternalServiceException;
import com.model.dto.notification.NotificationRequest;

@Component
public class NotificationServiceFallback implements FallbackFactory<NotificationServiceClient> {

    @Override
    public NotificationServiceClient create(Throwable cause) {
        return new NotificationServiceClient() {
            @Override
            public String sendNotification(NotificationRequest notificationRequest) {
                System.err.println("Notification Service unavailable. Cause: " + cause.getMessage());
                throw new ExternalServiceException("Notification Service unavailable");
            }
        };
    }
}
