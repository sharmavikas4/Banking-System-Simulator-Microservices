package com.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;

@Schema(description = "Request Body for Deposit and Withdraw request")
public record TransactionRequest(
		@NotBlank(message = "Account Number must not be null or only white spaces")
		@Pattern(regexp = "^[A-Z]{3}\\d{4}$",message = "Account number must be three uppercase alphabets followed by four digits")
		String accountNumber,
		
		@Positive(message = "Transaction amount must be positive non-zero value")
		double amount
) {

}
