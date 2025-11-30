package com.model.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.media.Schema.RequiredMode;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

@Schema(description = "Request body used to create a new bank account. Contains the account holder’s basic information required during account registration.")
public record AccountCreateRequest(
		@Schema(description = "Full name of the account holder. Only alphabetic characters and spaces are allowed.", example = "John Doe", requiredMode = RequiredMode.REQUIRED)
		@NotBlank(message = "Account Holder Name must not be null or only white spaces")
		@Pattern(regexp = "[A-Za-z ]+",message = "Account Holder Name must contain only alphabets and spaces")
		String holderName
) {
}
