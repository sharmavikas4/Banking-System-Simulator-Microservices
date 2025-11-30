package com.model.dto;

import jakarta.validation.constraints.NotBlank;

public record NotificationRequest(
    @NotBlank(message = "Message must not be blank")
    String message
) {}
