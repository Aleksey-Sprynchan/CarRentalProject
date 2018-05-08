package by.htp.sprynchan.car_rental.dao;

import by.htp.sprynchan.car_rental.bean.User;

public interface UserDao extends BaseDao<User> {
	
	void updateUserPassword(User entity);
	void updateUserBalance(User entity);
	User login(String login, String password);

}
