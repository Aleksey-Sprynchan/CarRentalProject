package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;

/**
 * Interface that provides additional methods 
 * to access user data from database.
 * 
 * @author Aleksey Sprynchan
 */
public interface UserDao extends BaseDao<User> {
	
	/**
	 * Updates user password
	 * 
	 * @param User entity
	 * @throws DAOException
	 */
	void updateUserPassword(User entity) throws DAOException;
	
	/**
	 * Updates user balance
	 * 
	 * @param User entity
	 * @throws DAOException
	 */
	void updateUserBalance(User entity) throws DAOException;
	
	/**
	 * Finds user by login and password
	 * 
	 * @param user login
	 * @param user password
	 * @return User entity
	 * @throws DAOException
	 */
	User login(String login, String password) throws DAOException;
	
	/**
	 * Gets all users from database
	 * 
	 * @return List of all users
	 * @throws DAOException
	 */
	List<User> readAll() throws DAOException;
	
	/**
	 * Gets user password
	 * 
	 * @param user id
	 * @return user password
	 * @throws DAOException
	 */
	String readUserPassword (int id) throws DAOException;

}
