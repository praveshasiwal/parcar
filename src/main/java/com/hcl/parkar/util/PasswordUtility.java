package com.hcl.parkar.util;

import java.math.BigInteger;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.hcl.parkar.exception.ParKarException;

public class PasswordUtility {

	public static String toHexString(String input) {
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("SHA-256");
			byte[] hash = md.digest(input.getBytes(StandardCharsets.UTF_8));
			BigInteger number = new BigInteger(1, hash);
			StringBuilder hexString = new StringBuilder(number.toString(16));
			while (hexString.length() < 32) {
				hexString.insert(0, '0');
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException noSuchAlgorithmException) {
			throw new ParKarException(noSuchAlgorithmException);
		}
	}
}
