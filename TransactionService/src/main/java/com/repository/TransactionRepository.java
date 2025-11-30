package com.repository;

import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.model.Transaction;

public interface TransactionRepository extends MongoRepository<Transaction, String> {
	
	List<Transaction> findDistinctByAccountNumberOrSourceAccountOrDestinationAccountOrderByTimestampDesc(
		    String acc1, String acc2, String acc3
		);
}
