package by.htp.sprynchan.car_rental.web;

import static by.htp.sprynchan.car_rental.web.util.HttpRequestParamValidator.*;
import static org.junit.Assert.*;

import org.junit.Test;

public class HttpRequestParamValidatorTest {

	@Test
	public void validatePositiveIntTest() throws Exception {
		String test = "20";
		assertEquals(true,validatePositiveInt(test));
	}
	
	@Test
	public void validateLoginTest() throws Exception {
		String invalidLogin = "As1$";
		assertEquals(false, validateLogin(invalidLogin));
	}

}
