package com.util.transaction;

import java.time.LocalDate;

public class GenerateTransactionId {
	
	public static String generate() {
		StringBuilder id = new StringBuilder("TXN-");
		id.append(LocalDate.now().toString().replaceAll("[^0-9]", ""));
		id.append("-");
		int random = (int) (Math.random() * 1000);
	    String randomStr = String.format("%03d", random);
	    id.append(randomStr);
		return id.toString();
	}
}
