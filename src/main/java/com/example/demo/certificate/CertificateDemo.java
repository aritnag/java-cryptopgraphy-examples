package com.example.demo.certificate;

import java.io.FileInputStream;
import java.io.InputStream;
import java.security.cert.CertPath;
import java.security.cert.Certificate;
import java.security.cert.CertificateFactory;
import java.util.ArrayList;
import java.util.List;

public class CertificateDemo {

	public static void main(String[] args) throws Exception {
		CertificateFactory certificateFactory = CertificateFactory.getInstance("X.509");
		InputStream certificateInputStream = new FileInputStream("cert.cert");


		
		// Certificate Instance
		Certificate certificate = certificateFactory.generateCertificate(certificateInputStream);
		// System.out.println(certificate);
		List<Certificate> certificateList = new ArrayList<Certificate>();
		certificateList.add(certificate);
		
		InputStream certificateInputStreamTest = new FileInputStream("certtest.cert");
		certificateList.add(certificateFactory.generateCertificate(certificateInputStreamTest));
		
		// Certificate Path Instance
		CertPath certPath = certificateFactory.generateCertPath(certificateList);
		System.out.println(certPath);

	}
}
