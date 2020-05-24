

package com.teko.commercial.encryption;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import org.jasypt.util.text.AES256TextEncryptor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;


public class EncodeDecode extends BCryptPasswordEncoder {

	private AES256TextEncryptor encodeDecode;
	
	
	
	public EncodeDecode() {
		 encodeDecode = new AES256TextEncryptor();
		 encodeDecode.setPassword("/.,,./+--+");
	}
	
	
	public AES256TextEncryptor getEncodeDecode() {
		return encodeDecode;
	}

	@Override
	public boolean matches(CharSequence raw, String encoded) {
		System.out.println("RAW : " + raw + " ENCODED : " + encoded);
		return encodeDecode.decrypt(encoded).equals(raw);
		}
	
	public void setEncodeDecode(AES256TextEncryptor encodeDecode) {
		this.encodeDecode = encodeDecode;
		
	}

	
	
	public String encode(String string) {return encodeDecode.encrypt(string);}
	public String decode(String string) {return encodeDecode.decrypt(string);}
	
}





