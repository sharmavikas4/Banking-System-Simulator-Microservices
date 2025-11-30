package com.model;

import java.time.LocalDateTime;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import com.util.enums.TransactionStatus;
import com.util.enums.TransactionType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Document(collection = "transactions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Transaction {
	
	@Id
	@NotBlank(message = "ID must not be null or only white spaces")
	@Pattern(regexp = "[a-z0-9]+",message = "ID must contain only lower case alphabers and digits")
	private String id;
	
	@NotBlank(message = "Transaction ID must not be null or only white spaces")
	@Pattern(regexp = "^TXN-\\d{8}-\\d{3}$",message = "Transaction ID must contain only upper case alphabets, digits and hyphen")
	private String transactionId;
	
	@NotNull(message = "Type of Transaction must not be null")
	private TransactionType type;
	
	@Positive(message = "Transaction amount must be positive non-zero value")
	private double amount;
	
	@NotNull(message = "Timestamp must not be null")
	private LocalDateTime timestamp;
	
	@NotNull(message = "Status of Transaction must not be null")
	private TransactionStatus status;
	
	private String accountNumber;
	
	private String sourceAccount;
	
	private String destinationAccount;
}
