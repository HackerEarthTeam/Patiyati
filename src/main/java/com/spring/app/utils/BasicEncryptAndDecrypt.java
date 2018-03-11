package com.spring.app.utils;

import org.apache.tomcat.util.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;

@Controller
public class BasicEncryptAndDecrypt {
	
	static Logger LOG = LoggerFactory.getLogger(BasicEncryptAndDecrypt.class.getName());
	
	public static String encrypt(String value) {
		try {

			byte[] bytesEncoded = Base64.encodeBase64(value.getBytes());
			String password     = new String(bytesEncoded);
			//LOG.info("encoded value is " + password.toString());
			return password;
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return null;
	}

	public static String decrypt(String encrypted) {
		try {

			byte[] valueDecoded = Base64.decodeBase64(encrypted);
			String password     = new String(valueDecoded);
			//LOG.info("Decoded value is " + password.toString());
			return password;

		} catch (Exception ex) {
			ex.printStackTrace();
		}

		return null;
	}
}
