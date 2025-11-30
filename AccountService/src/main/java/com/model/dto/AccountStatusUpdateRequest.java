package com.model.dto;


import com.util.enums.Status;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;

@Schema(description = "Request body used to update the current status of an existing bank account. This is typically used to activate or deactivate an account.")
public record AccountStatusUpdateRequest(
		@Schema(description = "The new status that the account should be updated to. Allowed values are defined in the Status enum (e.g., ACTIVE, INACTIVE).",example = "INACTIVE", requiredMode = RequiredMode.REQUIRED)
		@NotNull(message = "Status must not be null")
		Status status
) {
}
