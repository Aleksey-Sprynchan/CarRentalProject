package by.htp.sprynchan.car_rental.service.impl;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.dao.UserDao;
import by.htp.sprynchan.car_rental.dao.impl.UserDaoDBImpl;
import by.htp.sprynchan.car_rental.exeption.UserNotFoundException;
import by.htp.sprynchan.car_rental.service.UserService;

public class UserServiceImpl implements UserService {

	private static final int DUPLICATE_LOGIN_CODE = 1;
	private static final int DUPLICATE_EMAIL_CODE = 2;

	private static final String DUPLICATE_LOGIN_MESSAGE = "This username is taken. Try another";
	private static final String DUPLICATE_EMAIL_MESSAGE = "This email is already in use. Try another";

	private UserDao userDao = new UserDaoDBImpl();

	public UserServiceImpl() {
		super();
	}

	@Override
	public User getUserByLoginPassword(String login, String password) throws UserNotFoundException {

		User loggedInUser = userDao.login(login, password);
		if (loggedInUser == null) {
			throw new UserNotFoundException();
		}

		return loggedInUser;
	}

	@Override
	public String createNewUser(String login, String password, String name, String surname, String email) {

		User newUser = new User(login, password, name, surname, email);
		int code = userDao.create(newUser);
		String message = null;
		if (code == DUPLICATE_LOGIN_CODE) {
			message = DUPLICATE_LOGIN_MESSAGE;
		} else if (code == DUPLICATE_EMAIL_CODE) {
			message = DUPLICATE_EMAIL_MESSAGE;
		}
		return message;
	}

	@Override
	public void deleteUser(int id) {
		userDao.delete(id);
	}

	@Override
	public User getUser(int id) {
		return userDao.read(id);
	}

	@Override
	public String updateUserInfo(User user) {

		int code = userDao.update(user);
		String message = null;
		if (code == DUPLICATE_EMAIL_CODE) {
			message = DUPLICATE_EMAIL_MESSAGE;
		}
		return message;
	}

	@Override
	public void changeUserBalance(User user) {
		userDao.updateUserBalance(user);
	}

	@Override
	public void changeUserPassword(User user) {
		userDao.updateUserPassword(user);
	}

}
