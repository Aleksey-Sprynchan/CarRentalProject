package by.htp.sprynchan.car_rental.dao;


import by.htp.sprynchan.car_rental.bean.Entity;
import by.htp.sprynchan.car_rental.dao.pool.ConnectionPool;

public interface BaseDao<T extends Entity>{
	
	void create(T entity);
	T read(int id);
	void update(T entity);
	void delete(int id);
	
	ConnectionPool dataBaseConnection = ConnectionPool.getInstance();
}
