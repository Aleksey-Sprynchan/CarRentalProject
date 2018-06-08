package by.htp.sprynchan.car_rental.service.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * Class that encrypt password using MD5 algorithm
 * 
 * @author Aleksey Sprynchan
 *      
 */
public final class PasswordEncryptor {

	public static String md5Apache(String st) {
	    return DigestUtils.md5Hex(st);
	}

}
