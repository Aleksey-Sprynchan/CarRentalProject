package by.htp.sprynchan.car_rental.service;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.service.exception.ServiceException;

/**
 * Interface provides methods
 * for working with Car entity.
 * 
 * @author Aleksey Sprynchan
 *
 */
public interface UserService {
	
	/**
	 * Gets user by login and password
	 * 
	 * @param login
	 * @param password
	 * @return User entity or null if user is not exist
	 * @throws ServiceException if DAOException was thrown
	 */
	User getUserByLoginPassword(String login, String password) throws ServiceException;	
	
	/**
	 * Adds new user
	 * 
	 * @param user
	 * @return message if adding is successful
	 * @throws ServiceException if DAOException was thrown
	 */
	String createNewUser(User user) throws ServiceException;	
	
	/**
	 * Deletes user by id
	 * 
	 * @param id
	 * @throws ServiceException if DAOException was thrown
	 */
	void deleteUser(int id) throws ServiceException;	
	
	/**
	 * Gets user by id
	 * 
	 * @param id
	 * @return USer entity
	 * @throws ServiceException if DAOException was thrown
	 */
	User getUser(int id) throws ServiceException;	
	
	/**
	 * Updates user data
	 * 
	 * @param user
	 * @return message if updating is successful
	 * @throws ServiceException if DAOException was thrown
	 */
	String updateUserInfo(User user) throws ServiceException;	
	
	/**
	 * Changes user balance 
	 * 
	 * @param user
	 * @throws ServiceException if DAOException was thrown
	 */
	void changeUserBalance(User user) throws ServiceException;	
	
	/**
	 * Changes user password
	 * 
	 * @param user
	 * @throws ServiceException if DAOException was thrown
	 */
	void changeUserPassword(User user) throws ServiceException;	
	
	/**
	 * Gets all existing users
	 * 
	 * @return List of users
	 * @throws ServiceException if DAOException was thrown
	 */
	List<User> getUsersList() throws ServiceException;
	
	/**
	 * Gets user password
	 * 
	 * @param id
	 * @return user password
	 * @throws ServiceException if DAOException was thrown
	 */
	String getUserPassword(int id) throws ServiceException;
}
