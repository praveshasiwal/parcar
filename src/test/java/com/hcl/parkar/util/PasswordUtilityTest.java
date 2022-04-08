package com.hcl.parkar.util;


import java.security.NoSuchAlgorithmException;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PasswordUtilityTest {
	
	private PasswordUtility passwordUtility = new PasswordUtility();
	
	
	@Test
	@SuppressWarnings("static-access")
	public void testPasswordUtil() throws NoSuchAlgorithmException {
		String password = "a0$69Bw";
		String sha256EncodedStr = passwordUtility.toHexString(password);
		Assertions.assertNotNull(sha256EncodedStr);
		Assertions.assertEquals("abc4f464ca168e5a2296404ef18b92a9a9a09acb2834548ad79609b5b3181abc", sha256EncodedStr);
	}
	
	@Test
	@SuppressWarnings("static-access")
	public void testPasswordUtilNegative() throws NoSuchAlgorithmException {
		String password = "a0$69Bw";
		String sha256EncodedStr = passwordUtility.toHexString(password);
		Assertions.assertNotNull(sha256EncodedStr);
		Assertions.assertNotEquals("ABC4F464CA168E5A2296404EF18B92A9A9A09ACB2834548AD79609B5B3181ABC", sha256EncodedStr);
	}
	
	@Test
	@SuppressWarnings("static-access")
	public void testPasswordUtilNegativeWrongPassword() throws NoSuchAlgorithmException {
		String password = "a0$69BW";
		String sha256EncodedStr = passwordUtility.toHexString(password);
		Assertions.assertNotNull(sha256EncodedStr);
		Assertions.assertNotEquals("abc4f464ca168e5a2296404ef18b92a9a9a09acb2834548ad79609b5b3181abc", sha256EncodedStr);
	}

	

}
