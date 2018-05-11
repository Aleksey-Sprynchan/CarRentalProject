package by.htp.sprynchan.car_rental.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.dao.UserDao;
import by.htp.sprynchan.car_rental.dao.util.BeanDaoBuilders;

public class UserDaoDBImpl extends BeanDaoBuilders implements UserDao {

	private static final String ADD_USER = "INSERT INTO users (login, password, name, surname, email)"
			+ " VALUES (?, ?, ?, ?,?);";

	private static final String FIND_USER_BY_LOGIN_PASSWORD = "SELECT id, login, password, "
			+ "name, surname, email, balance, is_admin FROM users WHERE login= ? and password = ?;";

	private static final String READ_USER_BY_ID = "SELECT id, login, password, "
			+ "name, surname, email, balance, is_admin FROM users WHERE id = ?;";

	private static final String UPDATE_USER_PERSONAL_INFO = "UPDATE users SET name = ?, surname = ?, "
			+ "email = ? WHERE id = ?;";

	private static final String UPDATE_USER_BALANCE = "UPDATE users SET balance = ? WHERE id = ?;";
	private static final String UPDATE_USER_PASSWORD = "UPDATE users SET password = ? WHERE id = ?;";
	private static final String DELETE_USER_BY_ID = "DELETE FROM users WHERE id = ?;";

	private static final int ER_DUP_ENTRY_CODE = 1062;
	private static final String ENDS_WITH_LOGIN = "key 'login'";
	private static final String ENDS_WITH_EMAIL = "key 'email'";

	public UserDaoDBImpl() {
		super();
	}

	@Override
	public int create(User entity) {

		int code = 0;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(ADD_USER)) {
			preparedStatement.setString(1, entity.getLogin());
			preparedStatement.setString(2, entity.getPassword());
			preparedStatement.setString(3, entity.getName());
			preparedStatement.setString(4, entity.getSurname());
			preparedStatement.setString(5, entity.getEmail());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == ER_DUP_ENTRY_CODE) {
				code = identifyDuplicateField(e.getMessage());
			}
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return code;
	}

	@Override
	public User read(int id) {

		User user = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = buildUser(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return user;
	}

	@Override
	public int update(User entity) {

		int code = 0;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_PERSONAL_INFO)) {
			preparedStatement.setString(1, entity.getName());
			preparedStatement.setString(2, entity.getSurname());
			preparedStatement.setString(3, entity.getEmail());
			preparedStatement.setInt(4, entity.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			if (e.getErrorCode() == ER_DUP_ENTRY_CODE) {
				code = 2;
			}
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return code;
	}

	@Override
	public void delete(int id) {

		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_USER_BY_ID);) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
	}

	@Override
	public User login(String login, String password) {

		User user = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(FIND_USER_BY_LOGIN_PASSWORD)) {
			preparedStatement.setString(1, login);
			preparedStatement.setString(2, password);

			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				user = buildUser(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return user;
	}

	@Override
	public void updateUserPassword(User entity) {

		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_PASSWORD)) {
			preparedStatement.setString(1, entity.getPassword());
			preparedStatement.setInt(2, entity.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
	}

	@Override
	public void updateUserBalance(User entity) {

		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USER_BALANCE)) {
			preparedStatement.setInt(1, entity.getBalance());
			preparedStatement.setInt(2, entity.getId());
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
	}

	private int identifyDuplicateField(String excMessage) {

		if (excMessage.endsWith(ENDS_WITH_LOGIN)) {
			return 1;
		} else if (excMessage.endsWith(ENDS_WITH_EMAIL)) {
			return 2;
		} else {
			return 0;
		}
	}

}
