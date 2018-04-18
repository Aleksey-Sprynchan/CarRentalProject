package by.htp.sprynchan.car_rental.service.impl;


import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.dao.UserDao;
import by.htp.sprynchan.car_rental.dao.impl.UserDaoImpl;
import by.htp.sprynchan.car_rental.exeption.UserNotFoundException;
import by.htp.sprynchan.car_rental.service.UserService;

public class UserServiceImpl implements UserService {

	private UserDao userDao = new UserDaoImpl();
	
	public UserServiceImpl() {}

	@Override
	public User getUserByLoginPassword(String login, String password) throws UserNotFoundException {
		
		User loggedInUser = userDao.login(login, password);
		if (loggedInUser == null) {
			throw new UserNotFoundException();
		}

		return loggedInUser;
	}

	@Override
	public void createNewUser(String login, String password, String name, String surname, String email) {
		
		User newUser = new User(login, password, name, surname, email);
		
		userDao.create(newUser);
		
	}

}
