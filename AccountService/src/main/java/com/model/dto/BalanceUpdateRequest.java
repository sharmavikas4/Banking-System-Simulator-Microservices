package com.model.dto;

import com.util.enums.UpdateType;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Schema(description = "Request body for updating the balance of an existing account. This is used to either deposit money into the account or withdraw funds.")
public record BalanceUpdateRequest(
		
		@Schema(description = "The amount to be added to or deducted from the account balance. This value must be a positive, non-zero number.",example = "1000",requiredMode = RequiredMode.REQUIRED)
		@Positive(message = "Amount must be positive non-zero value")
		double amount,
		
		@Schema(description = "The type of balance update to perform. Allowed values are defined in the UpdateType enum, such as DEPOSIT or WITHDRAW.",example = "DEPOSIT",requiredMode = RequiredMode.REQUIRED)
		@NotNull(message = "Update type must not be null")
		UpdateType updateType
) {
}
