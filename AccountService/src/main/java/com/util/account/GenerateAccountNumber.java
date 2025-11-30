package com.util.account;


public class GenerateAccountNumber {
	
	public static String generate(String name){
		StringBuilder nameCleaned = new StringBuilder(name.replaceAll("[^A-Za-z]", "").toUpperCase());
		String initials;
		if(nameCleaned.length()>=3) {
			initials = nameCleaned.substring(0,3);
		}else {
			initials = String.format("%-3s", nameCleaned).replace(' ', 'X');
		}
		String randomNumber = Integer.toString((int)(Math.random()*10000));
		return initials+randomNumber;
	}
}