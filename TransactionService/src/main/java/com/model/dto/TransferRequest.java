package com.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;


@Schema(description = "Transfer Transaction Request Body")
public record TransferRequest(
		
		@Positive(message = "Transaction amount must be positive non-zero value")
		double amount,
		
		@NotBlank(message = "Source Account Number must not be null or only white spaces")
		@Pattern(regexp = "^[A-Z]{3}\\d{4}$",message = "Source Account number must be three uppercase alphabets followed by four digits")
		String sourceAccount,
		
		@NotBlank(message = "Destination Account Number must not be null or only white spaces")
		@Pattern(regexp = "^[A-Z]{3}\\d{4}$",message = "Destination Account number must be three uppercase alphabets followed by four digits")
		String destinationAccount
) {

}
