package by.htp.sprynchan.car_rental.dao.impl;

import static by.htp.sprynchan.car_rental.dao.util.TablesColumnNamesDeclaration.DAMAGES_COLUMN_ORDER_ID;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.sprynchan.car_rental.bean.Damage;
import by.htp.sprynchan.car_rental.dao.DamageDao;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;
import by.htp.sprynchan.car_rental.dao.util.BeanDaoBuilders;

/**
 * Class for working with the cars table from database
 * 
 * @author Aleksey Sprynchan
 */
public class DamageDaoDBImpl extends BeanDaoBuilders implements DamageDao {

	/**
     * SQL-statements
     */
	private static final String ADD_DAMAGE = "INSERT INTO damages (order_id, car_id, damage_name, damage_cost) "
			+ "VALUES(?, ?, ?, ?);";

	private static final String READ_ORDER_DAMAGES_BY_ORDER_ID = "SELECT id, order_id, car_id, damage_name, "
			+ "damage_cost FROM damages WHERE order_id = ?";

	private static final String READ_UNIQUE_ORDERS_ID = "SELECT DISTINCT order_id FROM damages WHERE car_id = ?";

	private static final String READ_ORDER_DAMAGE_AMOUNT = "SELECT SUM(damage_cost) FROM damages WHERE order_id = ?";

	/**
	 * Error causes fields
	 */
	private static final String ERROR_IN_CREATE_DAMAGE = "Error while adding damage to database";
	private static final String ERROR_IN_READ_ORDER_DAMAGES = "Error while getting damages from database";
	private static final String ERROR_IN_READ_UNIQUE_ORDERS_ID = "Error while getting unique orders id from database";
	private static final String ERROR_IN_COUNT_DAMAGE_AMOUNT = "Error while getting damage amount from database";
	
	@Override
	public int create(Damage entity) throws DAOException {

		int id = 0;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_DAMAGE,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setInt(1, entity.getOrderId());
			preparedStatement.setInt(2, entity.getCarId());
			preparedStatement.setString(3, entity.getDamageName());
			preparedStatement.setInt(4, entity.getDamageCost());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			throw new DAOException(ERROR_IN_CREATE_DAMAGE, e);
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return id;
	}

	@Override
	public Damage read(int id) throws DAOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public int update(Damage entity) throws DAOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public void delete(int id) throws DAOException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List<Damage> readOrderDamages(int orderId) throws DAOException {

		List<Damage> orderDamagesList = new ArrayList<>();
		Damage damage = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_ORDER_DAMAGES_BY_ORDER_ID)) {

			preparedStatement.setInt(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				damage = buildDamage(resultSet);
				orderDamagesList.add(damage);
			}
		} catch (SQLException e) {
			throw new DAOException(ERROR_IN_READ_ORDER_DAMAGES, e);
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return orderDamagesList;
	}

	@Override
	public List<Integer> readUniqueOrdersId(int carId) throws DAOException {

		List<Integer> ordersIdList = new ArrayList<>();
		int id = 0;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_UNIQUE_ORDERS_ID)) {
			preparedStatement.setInt(1, carId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				id = resultSet.getInt(DAMAGES_COLUMN_ORDER_ID);
				ordersIdList.add(id);
			}
		} catch (SQLException e) {
			throw new DAOException(ERROR_IN_READ_UNIQUE_ORDERS_ID, e);
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return ordersIdList;
	}

	@Override
	public int countOrderDamageAmount(int orderId) throws DAOException {

		int totalAmount = 0;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_ORDER_DAMAGE_AMOUNT,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setInt(1, orderId);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				totalAmount = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			throw new DAOException(ERROR_IN_COUNT_DAMAGE_AMOUNT, e);
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return totalAmount;
	}

}
