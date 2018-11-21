package com.example.demo.generic;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Mac;
import javax.crypto.spec.SecretKeySpec;

public class MacDemo {

	public static void main(String[] args) throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException {
		Mac mac = Mac.getInstance("HmacSHA256");
		byte[] keyBytes   = new byte[]{0,1,2,3,4,5,6,7,8 ,9,10,11,12,13,14,15};
		String algorithm  = "RawBytes";
		SecretKeySpec key = new SecretKeySpec(keyBytes, algorithm);

		mac.init(key);
		
		byte[] data  = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
		byte[] data2 = "0123456789".getBytes("UTF-8");

		mac.update(data);
		mac.update(data2);

		byte[] macBytes = mac.doFinal();

	}

}
