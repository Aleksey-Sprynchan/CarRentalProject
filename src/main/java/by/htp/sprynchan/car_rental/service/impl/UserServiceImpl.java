package by.htp.sprynchan.car_rental.service.impl;

import static by.htp.sprynchan.car_rental.service.util.ServiceInputParamNullValidator.*;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.dao.UserDao;
import by.htp.sprynchan.car_rental.dao.factory.DAOFactory;
import by.htp.sprynchan.car_rental.service.UserService;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;
import by.htp.sprynchan.car_rental.service.util.PasswordEncryptor;

public class UserServiceImpl implements UserService {

	private static final int DUPLICATE_LOGIN_CODE = 1;
	private static final int DUPLICATE_EMAIL_CODE = 2;

	private static final String DUPLICATE_LOGIN_MESSAGE = "This username is taken. Try another";
	private static final String DUPLICATE_EMAIL_MESSAGE = "This email is already in use. Try another";

	private static final String SUCCESS = "success";

	private UserDao userDao = DAOFactory.getUserDAO();

	@Override
	public User getUserByLoginPassword(String login, String password) throws ServiceException {
		validateInputParamNotNull(login, password);
		return userDao.login(login, PasswordEncryptor.md5Apache(password));
	}

	@Override
	public String createNewUser(User user) throws ServiceException {
		validateInputParamNotNull(user);
		user.setPassword(PasswordEncryptor.md5Apache(user.getPassword()));
		int code = userDao.create(user);
		String message = SUCCESS;
		if (code == DUPLICATE_LOGIN_CODE) {
			message = DUPLICATE_LOGIN_MESSAGE;
		} else if (code == DUPLICATE_EMAIL_CODE) {
			message = DUPLICATE_EMAIL_MESSAGE;
		}
		return message;
	}

	@Override
	public void deleteUser(int id) throws ServiceException {
		userDao.delete(id);
	}

	@Override
	public User getUser(int id) throws ServiceException {
		return userDao.read(id);
	}

	@Override
	public String updateUserInfo(User user) throws ServiceException {
		validateInputParamNotNull(user);
		int code = userDao.update(user);
		String message = SUCCESS;
		if (code == DUPLICATE_EMAIL_CODE) {
			message = DUPLICATE_EMAIL_MESSAGE;
		}
		return message;
	}

	@Override
	public void changeUserBalance(User user) throws ServiceException {
		validateInputParamNotNull(user);
		userDao.updateUserBalance(user);
	}

	@Override
	public void changeUserPassword(User user) throws ServiceException {
		validateInputParamNotNull(user);
		user.setPassword(PasswordEncryptor.md5Apache(user.getPassword()));
		userDao.updateUserPassword(user);
	}

	@Override
	public List<User> getUsersList() throws ServiceException {
		return userDao.readAll();
	}

	@Override
	public String getUserPassword(int id) throws ServiceException {
		return userDao.readUserPassword(id);
	}

}
