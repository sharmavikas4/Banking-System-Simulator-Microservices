package com.exceptions;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<Map<String,Object>> handleAccountNotFound(AccountNotFoundException e){
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("error", "Account Not Found");
		errorResponse.put("message", e.getMessage());
		errorResponse.put("status", HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
	
	@ExceptionHandler(InactiveAccountException.class)
	public ResponseEntity<Map<String, Object>> handleInactiveAccountException(InactiveAccountException e){
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("error", "Inactive Account");
		errorResponse.put("message", e.getMessage());
		errorResponse.put("status", HttpStatus.LOCKED.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.LOCKED);
	}
	
	@ExceptionHandler(InsufficientBalanceException.class)
	public ResponseEntity<Map<String, Object>> handleInsufficientBalanceException(InsufficientBalanceException e){
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("error", "Insufficient Balance");
		errorResponse.put("message", e.getMessage());
		errorResponse.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	
	@ExceptionHandler(SameAccountStatusException.class)
	public ResponseEntity<Map<String, Object>> handleSameAccountStatusException(SameAccountStatusException e){
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("error", "Same Account");
		errorResponse.put("message", e.getMessage());
		errorResponse.put("status", HttpStatus.UNPROCESSABLE_ENTITY.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.UNPROCESSABLE_ENTITY);
	}
	@ExceptionHandler(NoTransactionFoundException.class)
    public ResponseEntity<Map<String,Object>> handleNoTransactionFoundException(NoTransactionFoundException e){
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("error", "Transaction Not Found");
		errorResponse.put("message", e.getMessage());
		errorResponse.put("status", HttpStatus.NOT_FOUND.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.NOT_FOUND);
    }
	
    @ExceptionHandler(BadRequestException.class)
    public ResponseEntity<Map<String,Object>> handleBadRequest(BadRequestException e){
    	Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("error", "Bad Request");
		errorResponse.put("message", e.getMessage());
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(ExternalServiceException.class)
    public ResponseEntity<Map<String,Object>> handleExternalService(ExternalServiceException e){
    	Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("error", "Service Unavailable");
		errorResponse.put("message", e.getMessage());
		errorResponse.put("status", HttpStatus.SERVICE_UNAVAILABLE.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.SERVICE_UNAVAILABLE);
    }
	
	@ExceptionHandler(DatabaseException.class)
	public ResponseEntity<Map<String, Object>> handleDatabaseException(DatabaseException e){
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("error", "Database Error");
		errorResponse.put("message", e.getMessage());
		errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<Map<String, Object>> handleConstraintViolationException(ConstraintViolationException e){
		Map<String, String> error = new HashMap<>();
		e.getConstraintViolations().forEach(
				err -> error.put(err.getPropertyPath().toString(), err.getMessage())
		);
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("error", "Constraint Violation");
		errorResponse.put("message",error);
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		Map<String, String> error = new HashMap<>();
		e.getBindingResult().getFieldErrors().forEach(
				err -> error.put(err.getField(), err.getDefaultMessage())
		);
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("error", "Validation Error");
		errorResponse.put("message",error);
		errorResponse.put("status", HttpStatus.BAD_REQUEST.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public ResponseEntity<Map<String, Object>> handleException(Exception e){
		Map<String, Object> errorResponse = new HashMap<>();
		errorResponse.put("timestamp", LocalDateTime.now());
		errorResponse.put("error", "Internal Server Error");
		errorResponse.put("message", e.getMessage());
		errorResponse.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value());
		return new ResponseEntity<>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
	}
}
