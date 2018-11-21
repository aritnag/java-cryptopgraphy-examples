package com.example.demo.generic;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MessageDigestDemo {
	
	public static void main(String [] args) throws UnsupportedEncodingException, NoSuchAlgorithmException {
		byte[] data1 = "0123456789".getBytes("UTF-8");
		byte[] data2 = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");

		MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
		messageDigest.update(data1);
		messageDigest.update(data2);

		byte[] digest = messageDigest.digest();
	
		System.out.println(digest);
		System.out.println(messageDigest.getProvider());
	}

}
