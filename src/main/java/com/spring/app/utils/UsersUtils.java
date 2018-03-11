package com.spring.app.utils;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class UsersUtils{
	
	private static final int len = 7;
	
	static Logger LOG = LoggerFactory.getLogger(UsersUtils.class.getName());

	public static int getRandomNumber() {
		Random rand = new Random();
		int number = rand.nextInt(1000000);
		LOG.info("Random Integers: " + number);
		return number;
	}
	
	public static char[] getOTP()  {
		
        String numbers = "0123456789";
        Random rndm_method = new Random();
        char[] otp = new char[len];
 
        for (int i = 0; i < len; i++) {
             otp[i] =  numbers.charAt(rndm_method.nextInt(numbers.length()));
        }
        return otp;
    }
	
	public static String getOneTimePassword() {

		String Capital_chars 	= "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		String Small_chars 		= "abcdefghijklmnopqrstuvwxyz";
		String numbers 			= "0123456789";
		String symbols 			= "!@#$?";
		String values 			= Capital_chars + Small_chars + numbers + symbols;

		Random rndm_method = new Random();
		char[] password = new char[len];

		for (int i = 0; i < len; i++) {
			password[i] = values.charAt(rndm_method.nextInt(values.length()));
		}
		return new String(password);
	}

}