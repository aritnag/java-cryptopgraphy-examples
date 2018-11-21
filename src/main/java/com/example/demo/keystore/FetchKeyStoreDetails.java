package com.example.demo.keystore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.UnrecoverableEntryException;
import java.security.cert.CertificateException;

public class FetchKeyStoreDetails {

	public static void main(String[] args) {
		try {
			KeyStore ks = KeyStore.getInstance(KeyStore.getDefaultType());

			char[] pwdArray = "password".toCharArray();

			try (FileInputStream fos = new FileInputStream("newKeyStoreFileName.jks")) {
				ks.load(fos, pwdArray);
			}

			// Get KEY Store Keys
			KeyStore.ProtectionParameter password = new KeyStore.PasswordProtection(pwdArray);
			KeyStore.Entry entryKeystore = ks.getEntry("db-encryption-secret", password);
			System.out.println(entryKeystore);
		
		} catch (KeyStoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnrecoverableEntryException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
}
