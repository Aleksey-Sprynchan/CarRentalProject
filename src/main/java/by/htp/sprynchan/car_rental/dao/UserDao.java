package by.htp.sprynchan.car_rental.dao;

import java.util.List;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;

public interface UserDao extends BaseDao<User> {
	
	void updateUserPassword(User entity) throws DAOException;
	void updateUserBalance(User entity) throws DAOException;
	User login(String login, String password) throws DAOException;
	List<User> readAll() throws DAOException;

}
