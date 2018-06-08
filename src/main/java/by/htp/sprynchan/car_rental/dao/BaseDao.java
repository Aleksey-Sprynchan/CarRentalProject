package by.htp.sprynchan.car_rental.dao;


import by.htp.sprynchan.car_rental.bean.Entity;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;
import by.htp.sprynchan.car_rental.dao.pool.ConnectionPool;

/**
 * Interface that provides CRUD methods to access data
 * from database.
 * 
 * @author Aleksey Sprynchan
 * @param <T> extends Entity
 */
public interface BaseDao<T extends Entity>{
	
	ConnectionPool dataBaseConnection = ConnectionPool.getInstance();
	
	/**
	 * Adds entity to database
	 * 
	 * @param entity
	 * @return generated id
	 * @throws DAOException
	 */
	int create(T entity) throws DAOException;
	
	/**
	 * Gets object from database
	 * 
	 * @param entity id
	 * @return T extends Entity object
	 * @throws DAOException
	 */
	T read(int id) throws DAOException;
	/**
	 * Updates information about entity in database
	 * 
	 * @param entity
	 * @return 0 if update was successful
	 * @throws DAOException
	 */
	int update(T entity) throws DAOException;
	/**
	 * Deletes entity from database
	 * 
	 * @param entity id
	 * @throws DAOException
	 */
	void delete(int id) throws DAOException;
	
}
