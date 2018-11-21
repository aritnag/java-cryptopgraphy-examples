package com.example.demo.signature;

import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;

public class SignatureWithKeyPairDemo {

	public static void main(String[] args) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, SignatureException, KeyStoreException {
		test();
	}
	
	public static void test() throws NoSuchAlgorithmException, InvalidKeyException, UnsupportedEncodingException, SignatureException, KeyStoreException {
		SecureRandom secureRandom = new SecureRandom();
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("DSA");
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
 	
		
		//Private Key
		PrivateKey privateKey = keyPair.getPrivate();
		System.out.println("privateKey = " + privateKey);
		//Public Key
		PublicKey publicKey = keyPair.getPublic();
		System.out.println("publicKey = " + publicKey);

		Signature signature = Signature.getInstance("SHA256WithDSA");

		signature.initSign(keyPair.getPrivate(), secureRandom);

		byte[] data = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
		signature.update(data);

		byte[] digitalSignature = signature.sign();

		byte[] modifiedDate = "abcdefghijklmnopqrstuvxyz".getBytes("UTF-8");
		
		Signature signature2 = Signature.getInstance("SHA256WithDSA");
		signature2.initVerify(keyPair.getPublic());

		signature2.update(modifiedDate);

		boolean verified = signature2.verify(digitalSignature);

		System.out.println("verified = " + verified);
	}
}
