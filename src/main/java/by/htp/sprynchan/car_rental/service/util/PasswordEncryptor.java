package by.htp.sprynchan.car_rental.service.util;

import org.apache.commons.codec.digest.DigestUtils;

public final class PasswordEncryptor {

	public static String md5Apache(String st) {
	    return DigestUtils.md5Hex(st);
	}

}
