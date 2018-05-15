package by.htp.sprynchan.car_rental.service;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;

public interface UserService {
	
	User getUserByLoginPassword(String login, String password) throws ServiceException;	
	String createNewUser(User user) throws ServiceException;	
	void deleteUser(int id) throws ServiceException;	
	User getUser(int id) throws ServiceException;	
	String updateUserInfo(User user) throws ServiceException;	
	void changeUserBalance(User user) throws ServiceException;	
	void changeUserPassword(User user) throws ServiceException;	
	List<User> getUsersList() throws ServiceException;
}
