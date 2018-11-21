package com.example.demo.generic;

import java.security.Key;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class CipherDemo {
	private static final String ALGO = "AES";
    private static final byte[] keyValue = new byte[] { 'T', 'h', 'e', 'B', 'e', 's', 't','S', 'e', 'c', 'r','e', 't', 'K', 'e', 'y' };
    // KEY VALUE LENGTH needs to be 16 
    private static final String ALGORITHM       = "AES";
    private static final String myEncryptionKey = "ThisIsFoundation"; // Must be key length: 12 bytes
    private static final String UNICODE_FORMAT  = "UTF8";
    
    public static void main(String[] args) throws Exception {
    	String value = "Rest";
        String valueEnc = encrypt(value);
        String valueDec = decrypt(valueEnc);
        System.out.println("Plain Text : " + value);
        System.out.println("Encrypted : " + valueEnc);
        System.out.println("Decrypted : " + valueDec);
        System.out.println(decrypt(valueEnc).equals(value));
        System.out.println(encrypt(value).equals(valueEnc));
	}
    
    public static String encrypt(String valueToEnc) throws Exception {
    	Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.ENCRYPT_MODE, key);  
        byte[] encValue = c.doFinal(valueToEnc.getBytes(UNICODE_FORMAT));
        String encryptedValue = new BASE64Encoder().encode(encValue);
        return encryptedValue;
    }

    public static String decrypt(String encryptedValue) throws Exception {
    	Key key = generateKey();
        Cipher c = Cipher.getInstance(ALGORITHM);
        c.init(Cipher.DECRYPT_MODE, key);
        byte[] decordedValue = new BASE64Decoder().decodeBuffer(encryptedValue);
        byte[] decValue = c.doFinal(decordedValue);
        String decryptedValue = new String(decValue);
        return decryptedValue;
    }


    private static Key generateKey() throws Exception {
        byte[] keyAsBytes;
        keyAsBytes = myEncryptionKey.getBytes(UNICODE_FORMAT);
        Key key = new SecretKeySpec(keyAsBytes, ALGORITHM);
        return key;
   }
}
