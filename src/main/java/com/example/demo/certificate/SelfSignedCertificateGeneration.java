package com.example.demo.certificate;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;

import sun.security.tools.keytool.CertAndKeyGen;
import sun.security.x509.X500Name;

public class SelfSignedCertificateGeneration {
	
	public static void main(String[] args) {
		try {
			CertAndKeyGen keyGen=new CertAndKeyGen("RSA","SHA1WithRSA",null);
			keyGen.generate(1024);
            
            //Generate self signed certificate
            X509Certificate[] chain=new X509Certificate[1];
            chain[0]=keyGen.getSelfCertificate(new X500Name("CN=ROOT"), (long)365*24*3600);
             
            System.out.println("Certificate : "+chain[0].toString());
		} catch (NoSuchAlgorithmException | NoSuchProviderException e) {
			e.printStackTrace();
		} catch (InvalidKeyException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (CertificateException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SignatureException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
