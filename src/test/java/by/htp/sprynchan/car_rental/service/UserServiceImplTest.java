package by.htp.sprynchan.car_rental.service;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.impl.UserServiceImpl;

public class UserServiceImplTest {

	private static final String SUCCESS = "success";
	private UserService userService;

	@Before
	public void initUserService() {
		userService = new UserServiceImpl();
	}

	@Test
	public void checkDuplicateAdminEmail() throws Exception {
		boolean result = false;
		String email = "a.spirt@gmail.com";
		User user = new User();
		user.setEmail(email);
		user.setPassword("password");
		if (userService.createNewUser(user) != SUCCESS) {
			result = true;
		}
		assertEquals(true, result);
	}

}
