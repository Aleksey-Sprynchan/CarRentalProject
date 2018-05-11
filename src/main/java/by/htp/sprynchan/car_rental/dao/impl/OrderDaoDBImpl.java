package by.htp.sprynchan.car_rental.dao.impl;

import static by.htp.sprynchan.car_rental.dao.util.TablesColumnNamesDeclaration.ORDERS_COLUMN_START_DATE;
import static by.htp.sprynchan.car_rental.dao.util.TablesColumnNamesDeclaration.ORDERS_COLUMN_END_DATE;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.dao.OrderDao;
import by.htp.sprynchan.car_rental.dao.util.BeanDaoBuilders;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class OrderDaoDBImpl extends BeanDaoBuilders implements OrderDao {
	
	private static final String ADD_CUSTOMER_PERSONAL_DATA = "INSERT INTO customer_personal_data "
			+ "(name, surname, passport_numb, date_of_birth, driving_exp) VALUES (?, ?, ?, ?, ?);";

	private static final String ADD_ORDER = "INSERT INTO orders "
			+ "(status, order_date, user_id, car_id, start_date, end_date, customer_id, total_price, insurance)"
			+ " VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?);";

	private static final String READ_ORDER_BY_ID = "SELECT id, status, order_date, user_id, car_id, start_date, end_date, "
			+ "customer_id, total_price, insurance, is_damaged, damage_amount, rejection_reason FROM orders WHERE id = ?;";

	private static final String UPDATE_ORDER = "UPDATE orders SET status = ?, order_date = ?, user_id = ?, car_id = ?, "
			+ "start_date = ?, end_date = ?, customer_id = ?, total_price = ?, insurance = ?, "
			+ "is_damaged = ?, damage_amount = ?, rejection_reason = ? WHERE id = ?";

	private static final String DELETE_ORDER_BY_ID = "DELETE FROM orders WHERE id = ?;";

	private static final String READ_ALL_ORDERS = "SELECT o.id, o.status, o.order_date, o.user_id, o.car_id, o.start_date, "
			+ "o.end_date, o.customer_id, o.total_price, o.insurance, o.is_damaged, o.damage_amount, o.rejection_reason, c.name, "
			+ "c.surname, c.passport_numb, c.date_of_birth, c.driving_exp "
			+ "FROM orders o JOIN customer_personal_data c ON o.customer_id = c.id;";

	private static final String READ_ORDERS_WITH_STATUS = "SELECT o.id, o.status, o.order_date, o.user_id, o.car_id, "
			+ "o.start_date, o.end_date, o.customer_id, o.total_price, o.insurance, o.is_damaged, o.damage_amount, o.rejection_reason, "
			+ "c.name, c.surname, c.passport_numb, c.date_of_birth, c.driving_exp "
			+ "FROM orders o JOIN customer_personal_data c ON o.customer_id = c.id WHERE o.status = ?;";
	
	private static final String READ_USER_ORDERS_BY_USER_ID = "SELECT o.id, o.status, o.order_date, o.user_id, o.car_id, "
			+ "o.start_date, o.end_date, o.customer_id, o.total_price, o.insurance, o.is_damaged, o.damage_amount, o.rejection_reason, "
			+ "c.name, c.surname, c.passport_numb, c.date_of_birth, c.driving_exp "
			+ "FROM orders o JOIN customer_personal_data c ON o.customer_id = c.id WHERE o.user_id = ?;";
	
	private static final String READ_RESERVED_DATES_BY_CAR_ID = "SELECT s.start_date, s.end_date "
			+ "FROM (SELECT * FROM orders o WHERE o.car_id = ?) s "
			+ "WHERE s.status = 'PAID' OR s.status = 'WAITING_FOR_APPROVE' OR s.status = 'WAITING_FOR_PAYMENT';";

	public OrderDaoDBImpl() {
		super();
	}

	@Override
	public int create(Order entity) {

		int id = 0;
		Connection connection = dataBaseConnection.getConnection();

		try {
			connection.setAutoCommit(false);
			
			try (PreparedStatement customerPreparedStatement = connection.prepareStatement(ADD_CUSTOMER_PERSONAL_DATA,
					Statement.RETURN_GENERATED_KEYS);
					PreparedStatement orderPreparedStatement = connection.prepareStatement(ADD_ORDER,
							Statement.RETURN_GENERATED_KEYS)) {

				customerPreparedStatement.setString(1, entity.getCustomer().getName());
				customerPreparedStatement.setString(2, entity.getCustomer().getSurname());
				customerPreparedStatement.setString(3, entity.getCustomer().getPassportNumb());
				customerPreparedStatement.setString(4, entity.getCustomer().getDateOfBirth().toString());
				customerPreparedStatement.setInt(5, entity.getCustomer().getDrivingExp());
				customerPreparedStatement.executeUpdate();

				ResultSet resultSet = customerPreparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					entity.getCustomer().setId(resultSet.getInt(1));
				}

				orderPreparedStatement.setString(1, entity.getStatus().toString());
				orderPreparedStatement.setString(2, entity.getOrderDate().toString());
				orderPreparedStatement.setInt(3, entity.getUserId());
				orderPreparedStatement.setInt(4, entity.getCarId());
				orderPreparedStatement.setString(5, entity.getStartDate().toString());
				orderPreparedStatement.setString(6, entity.getEndDate().toString());
				orderPreparedStatement.setInt(7, entity.getCustomer().getId());
				orderPreparedStatement.setInt(8, entity.getTotalPrice());
				orderPreparedStatement.setBoolean(9, entity.isInsurance());
				orderPreparedStatement.executeUpdate();

				resultSet = orderPreparedStatement.getGeneratedKeys();
				if (resultSet.next()) {
					id = resultSet.getInt(1);
				}

				connection.commit();

			} catch (SQLException e) {
				connection.rollback();
				e.printStackTrace();
			} finally {
				connection.setAutoCommit(true);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return id;
	}

	@Override
	public Order read(int id) {

		Order order = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_ORDER_BY_ID)) {
			preparedStatement.setInt(1, id);
			ResultSet resultSet = preparedStatement.executeQuery();
			if (resultSet.next()) {
				order = buildOrder(resultSet);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return order;
	}

	@Override
	public int update(Order entity) {
		
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_ORDER)) {

			preparedStatement.setString(1, entity.getStatus().toString());
			preparedStatement.setString(2, entity.getOrderDate().toString());
			preparedStatement.setInt(3, entity.getUserId());
			preparedStatement.setInt(4, entity.getCarId());
			preparedStatement.setString(5, entity.getStartDate().toString());
			preparedStatement.setString(6, entity.getEndDate().toString());
			preparedStatement.setInt(7, entity.getCustomer().getId());
			preparedStatement.setInt(8, entity.getTotalPrice());
			preparedStatement.setBoolean(9, entity.isInsurance());
			preparedStatement.setBoolean(10, entity.isDamaged());
			preparedStatement.setInt(11, entity.getDamageAmount());
			preparedStatement.setString(12, entity.getRejectionReason());
			preparedStatement.setInt(13, entity.getId());
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
		try (PreparedStatement preparedStatement = connection.prepareStatement(DELETE_ORDER_BY_ID)) {
			preparedStatement.setInt(1, id);
			preparedStatement.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
	}

	@Override
	public List<Order> readAll() {

		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection connection = dataBaseConnection.getConnection();
		try (Statement statement = connection.createStatement()) {

			ResultSet resultSet = statement.executeQuery(READ_ALL_ORDERS);
			while (resultSet.next()) {
				order = buildOrder(resultSet);
				order.setCustomer(buildCustomer(resultSet));
				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return orderList;
	}

	@Override
	public List<Order> readAllWithStatus(OrderStatusEnum orderStatus) {

		List<Order> orderList = new ArrayList<>();
		Order order = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_ORDERS_WITH_STATUS)) {

			preparedStatement.setString(1, orderStatus.toString());
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				order = buildOrder(resultSet);
				order.setCustomer(buildCustomer(resultSet));
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return orderList;
	}


	@Override
	public List<Order> readUserOrders(int userId) {
		
		List<Order> userOrderList = new ArrayList<>();
		Order order = null;
		Connection connection = dataBaseConnection.getConnection();
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_USER_ORDERS_BY_USER_ID)) {

			preparedStatement.setInt(1, userId);
			ResultSet resultSet = preparedStatement.executeQuery();
			while (resultSet.next()) {
				order = buildOrder(resultSet);
				order.setCustomer(buildCustomer(resultSet));
				userOrderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return userOrderList;
	}
	
	@Override
	public List<Order> readReservedDatesForCar(int carId) {

		List<Order> orderDatesList = new ArrayList<>();
		Order order = null;
		Connection connection = dataBaseConnection.getConnection();		
		try (PreparedStatement preparedStatement = connection.prepareStatement(READ_RESERVED_DATES_BY_CAR_ID)) {

			preparedStatement.setInt(1, carId);
			ResultSet resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				order = new Order();
				order.setStartDate(LocalDate.parse(resultSet.getString(ORDERS_COLUMN_START_DATE)));
				order.setEndDate(LocalDate.parse(resultSet.getString(ORDERS_COLUMN_END_DATE)));
				orderDatesList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connection);
		}
		return orderDatesList;
	}
	
	
	

}
