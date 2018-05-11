package by.htp.sprynchan.car_rental.dao.impl;

import static by.htp.sprynchan.car_rental.dao.util.TablesColumnNamesDeclaration.*;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.dao.CustomerPersonalDataDao;

public class CustomerPersonalDataDBDaoImpl implements CustomerPersonalDataDao {

	private static final String ADD_CUSTOMER_PERSONAL_DATA = "INSERT INTO customer_personal_data "
			+ "(name, surname, passport_numb, date_of_birth, driving_exp) VALUES (?, ?, ?, ?, ?);";

	private static final String READ_CUSTOMER_PERSONAL_DATA_BY_ID = "SELECT id, name, surname, passport_numb, date_of_birth, driving_exp "
			+ "FROM customer_personal_data WHERE id = ?;";

	private static final String UPDATE_CUSTOMER_PERSONAL_DATA_BY_ID = "UPDATE customer_personal_data SET name = ?, surname = ?, passport_numb =?, "
			+ "date_of_birth =?, driving_exp = ? WHERE id = ?;";

	private static final String DELETE_CUSTOMER_PERSONAL_DATA_BY_ID = "DELETE FROM customer_personal_data WHERE id = ?;";

	public CustomerPersonalDataDBDaoImpl() {
		super();
	}

	@Override
	public int create(CustomerPersonalData entity) {

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
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return id;
	}

	@Override
	public CustomerPersonalData read(int id) {

		CustomerPersonalData customerData = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_CUSTOMER_PERSONAL_DATA_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				customerData = buildCustomer(resultSet);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return customerData;
	}

	@Override
	public int update(CustomerPersonalData entity) {

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
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return 0;
	}

	@Override
	public void delete(int id) {

		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_CUSTOMER_PERSONAL_DATA_BY_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
	}

	private CustomerPersonalData buildCustomer(ResultSet resultSet) throws SQLException {

		CustomerPersonalData customer = new CustomerPersonalData();
		customer.setId(resultSet.getInt(CUSTPERSDATA_COLUMN_ID));
		customer.setName(resultSet.getString(CUSTPERSDATA_COLUMN_NAME));
		customer.setSurname(resultSet.getString(CUSTPERSDATA_COLUMN_SURNAME));
		customer.setPassportNumb(resultSet.getString(CUSTPERSDATA_COLUMN_PASSPORT_NUMB));
		customer.setDateOfBirth(LocalDate.parse(resultSet.getString(CUSTPERSDATA_COLUMN_DATE_OF_BIRTH)));
		customer.setDrivingExp(resultSet.getInt(CUSTPERSDATA_COLUMN_DRIVING_EXP));
		return customer;
	}

}
