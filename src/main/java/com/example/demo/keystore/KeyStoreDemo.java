package com.example.demo.keystore;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.KeyStore;
import java.security.KeyStore.LoadStoreParameter;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.SecureRandom;
import java.security.UnrecoverableEntryException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

public class KeyStoreDemo {

	public static void main(String[] args) {
		try {
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

			char[] pwdArray = "password".toCharArray();
			ks.load(null, pwdArray);

			// Saving a Symmetric Key with PRIVATE KEY and Certificate

			KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			KeyPair keyPair = keyPairGenerator.generateKeyPair();

			// Private Key

			PrivateKey privateKey = keyPair.getPrivate();

			// Setting Keys with Alias in Keystore
			CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
			InputStream certificateInputStream = new FileInputStream("cert.cert");

			Certificate certificate = certificateFactory.generateCertificate(certificateInputStream);
			Certificate certificateArray[] = new Certificate[1];
			certificateArray[0] = certificate;
			KeyStore.PrivateKeyEntry privateKeyEntry = new KeyStore.PrivateKeyEntry(privateKey, certificateArray);
			KeyStore.ProtectionParameter password = new KeyStore.PasswordProtection(pwdArray);
			ks.setEntry("db-encryption-secret", privateKeyEntry, password);
			
			
			
			try (FileOutputStream fos = new FileOutputStream("newKeyStoreFileName.jks")) {
				ks.store(fos, pwdArray);
			}
			
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
