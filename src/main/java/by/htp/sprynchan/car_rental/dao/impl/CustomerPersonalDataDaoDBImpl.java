package by.htp.sprynchan.car_rental.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.dao.CustomerPersonalDataDao;
import by.htp.sprynchan.car_rental.dao.exception.DAOException;
import by.htp.sprynchan.car_rental.dao.util.BeanDaoBuilders;

/**
 * Class for working with the customer_personal_data table from database
 * @author Aleksey Sprynchan
 */
public class CustomerPersonalDataDaoDBImpl extends BeanDaoBuilders implements CustomerPersonalDataDao {

	/**
     * SQL-statements
     */
	private static final String ADD_CUSTOMER_PERSONAL_DATA = "INSERT INTO customer_personal_data "
			+ "(name, surname, passport_numb, date_of_birth, driving_exp) VALUES (?, ?, ?, ?, ?);";

	private static final String READ_CUSTOMER_PERSONAL_DATA_BY_ID = "SELECT id, name, surname, passport_numb, date_of_birth, driving_exp "
			+ "FROM customer_personal_data WHERE id = ?;";

	private static final String UPDATE_CUSTOMER_PERSONAL_DATA_BY_ID = "UPDATE customer_personal_data SET name = ?, surname = ?, passport_numb =?, "
			+ "date_of_birth =?, driving_exp = ? WHERE id = ?;";

	private static final String DELETE_CUSTOMER_PERSONAL_DATA_BY_ID = "DELETE FROM customer_personal_data WHERE id = ?;";
	
	/**
	 * Error causes fields
	 */
	private static final String ERROR_IN_CREATE_CPDATA = "Error while adding customer personal data to database";
	private static final String ERROR_IN_READ_CPDATA = "Error while getting customer personal data from database";
	private static final String ERROR_IN_UPDATE_CPDATA = "Error while trying to edit customer personal data in database";
	private static final String ERROR_IN_DELETE_CPDATA = "Error while deleting customer personal data from database";
	

	@Override
	public int create(CustomerPersonalData entity) throws DAOException {
		int id = 0;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_CUSTOMER_PERSONAL_DATA,
				Statement.RETURN_GENERATED_KEYS)) {
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setString(2, entity.getSurname());
			preparedStatement.setString(3, entity.getPassportNumb());
			preparedStatement.setString(4, entity.getDateOfBirth().toString());
			preparedStatement.setInt(5, entity.getDrivingExp());
			preparedStatement.executeUpdate();
			ResultSet resultSet = preparedStatement.getGeneratedKeys();
			if (resultSet.next()) {
				id = resultSet.getInt(1);
			}
		} catch (SQLException e) {
			throw new DAOException(ERROR_IN_CREATE_CPDATA, e);
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return id;
	}

	@Override
	public CustomerPersonalData read(int id) throws DAOException {
		CustomerPersonalData customerData = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_CUSTOMER_PERSONAL_DATA_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customerData = buildCustomer(resultSet);
			}
		} catch (SQLException e) {
			throw new DAOException(ERROR_IN_READ_CPDATA, e);
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return customerData;
	}

	@Override
	public int update(CustomerPersonalData entity) throws DAOException {
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_CUSTOMER_PERSONAL_DATA_BY_ID)) {
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setString(2, entity.getSurname());
			preparedStatement.setString(3, entity.getPassportNumb());
			preparedStatement.setString(4, entity.getDateOfBirth().toString());
			preparedStatement.setInt(5, entity.getDrivingExp());
			preparedStatement.setInt(6, entity.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(ERROR_IN_UPDATE_CPDATA, e);
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return 0;
	}

	@Override
	public void delete(int id) throws DAOException {
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_PERSONAL_DATA_BY_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			throw new DAOException(ERROR_IN_DELETE_CPDATA, e);
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
	}

}
