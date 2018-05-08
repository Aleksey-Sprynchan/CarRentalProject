package by.htp.sprynchan.car_rental.service;



import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.exeption.UserNotFoundException;

public interface UserService {
	
	User getUserByLoginPassword (String login, String password) throws UserNotFoundException;
	
	String createNewUser(String login, String password, String name, String surname, String email);
	
	void deleteUser (int id);
	
	User getUser (int id);
	
	String updateUserInfo (User user);
	
	void changeUserBalance (User user);
	
	void changeUserPassword (User user);
	
	

}
