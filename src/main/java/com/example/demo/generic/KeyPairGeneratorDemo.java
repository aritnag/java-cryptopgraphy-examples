package com.example.demo.generic;

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;

public class KeyPairGeneratorDemo {

	public static void main(String[] args) {
		KeyPairGenerator keyPairGenerator;
		try {
			
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPairGenerator.initialize(2048);
			KeyPair keyPair = keyPairGenerator.generateKeyPair();

		} catch (Exception e) {
			e.printStackTrace();
		}
		

	}

}
