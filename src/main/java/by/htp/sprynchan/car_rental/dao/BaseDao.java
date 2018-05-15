package by.htp.sprynchan.car_rental.dao;


import by.htp.sprynchan.car_rental.bean.Entity;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;
import by.htp.sprynchan.car_rental.dao.pool.ConnectionPool;

public interface BaseDao<T extends Entity>{
	
	ConnectionPool dataBaseConnection = ConnectionPool.getInstance();
	
	int create(T entity) throws DAOException;
	T read(int id) throws DAOException;
	int update(T entity) throws DAOException;
	void delete(int id) throws DAOException;
	
}
