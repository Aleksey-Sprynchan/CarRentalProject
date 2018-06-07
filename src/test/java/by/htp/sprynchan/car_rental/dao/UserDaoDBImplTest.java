package by.htp.sprynchan.car_rental.dao;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import by.htp.sprynchan.car_rental.dao.UserDao;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;
import by.htp.sprynchan.car_rental.dao.impl.UserDaoDBImpl;
import by.htp.sprynchan.car_rental.service.util.PasswordEncryptor;

public class UserDaoDBImplTest {

	private UserDao userDao;

	@Before
	public void initUserDao() {
		userDao = new UserDaoDBImpl();
	}

	@Test
	public void checkIfAdminExist() throws DAOException {
		assertNotNull(userDao.readAll());
	}

	@Test
	public void checkAdminPassword() throws DAOException {
		int adminId = 1;
		String password = PasswordEncryptor.md5Apache("admin");
		assertEquals(password, userDao.readUserPassword(adminId));
	}

}
