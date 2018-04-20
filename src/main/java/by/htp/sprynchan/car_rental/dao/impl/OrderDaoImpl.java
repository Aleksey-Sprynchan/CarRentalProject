package by.htp.sprynchan.car_rental.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;
import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.dao.OrderDao;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class OrderDaoImpl implements OrderDao {

	private static final String url = "jdbc:mysql://localhost/car_rental?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

	@Override
	public void create(Order entity) {

		String sql1 = "INSERT INTO customer_personal_data (name, surname, passport_numb, date_of_birth, driving_exp)"
				+ " VALUES (?, ?, ?, ?, ?);";

		String sql2 = "SELECT LAST_INSERT_ID();";

		String sql3 = "INSERT INTO orders (status, order_date, user_id, car_id, start_date, end_date, customer_id)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?);";

		Connection connector = dataBaseConnection.getConnection();

		PreparedStatement customerCreateStatement = null;
		ResultSet rs = null;
		PreparedStatement orderCreateStatement = null;

		try {

			connector.setAutoCommit(false);

			try {

				customerCreateStatement = connector.prepareStatement(sql1);
				customerCreateStatement.setString(1, entity.getCustomer().getName());
				customerCreateStatement.setString(2, entity.getCustomer().getSurname());
				customerCreateStatement.setString(3, entity.getCustomer().getPassportNumb());
				customerCreateStatement.setString(4, entity.getCustomer().getDateOfBirth().toString());
				customerCreateStatement.setInt(5, entity.getCustomer().getDrivingExp());
				customerCreateStatement.executeUpdate();
				
				

				rs = connector.createStatement().executeQuery(sql2);
				if (rs.next()) {
					entity.getCustomer().setId(rs.getInt(1));
					System.out.println("!!!!!!!!!!!!!" + rs.getInt(1));
				}

				orderCreateStatement = connector.prepareStatement(sql3);
				orderCreateStatement.setString(1, entity.getStatus().toString());
				orderCreateStatement.setString(2, entity.getOrderDate().toString());
				orderCreateStatement.setInt(3, entity.getUserId());
				orderCreateStatement.setInt(4, entity.getCarId());
				orderCreateStatement.setString(5, entity.getStartDate().toString());
				orderCreateStatement.setString(6, entity.getEndDate().toString());
				orderCreateStatement.setInt(7, entity.getCustomer().getId());
				orderCreateStatement.executeUpdate();

				connector.commit();

			} catch (SQLException e) {
				connector.rollback();
				e.printStackTrace();
			} finally {
				connector.setAutoCommit(true);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connector);
		}

	}

	@Override
	public Order read(int id) {

		String sql = "SELECT * FROM orders WHERE id=?;";

		Order order = null;

		Connection connector = dataBaseConnection.getConnection();

		try {

			PreparedStatement ps = connector.prepareStatement(sql);
			ps.setString(1, String.valueOf(id));
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				order = new Order(OrderStatusEnum.valueOf(rs.getString("status")), rs.getDate("order_date"),
						rs.getInt("user_id"), rs.getInt("car_id"), rs.getDate("start_date"), rs.getDate("end_date"),
						new CustomerPersonalData(rs.getInt("customer_id")), rs.getInt("total_price"),
						rs.getBoolean("isDamaged"), rs.getInt("damage_amount"), rs.getString("rejection_reason"));
				order.setId(rs.getInt("id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connector);
		}

		return order;
	}

	@Override
	public void update(Order entity) {

		String sql = "UPDATE orders SET status=?, order_date=?, user_id=?, car_id=?, "
				+ "start_date=?, end_date=?, customer_id=?, total_price=?, "
				+ "isDamaged=?, damage_amount=?, rejection_reason=? WHERE id=?";

		Connection connector = dataBaseConnection.getConnection();

		try {

			PreparedStatement ps = connector.prepareStatement(sql);

			ps.setString(1, entity.getStatus().toString());
			ps.setString(2, entity.getOrderDate().toString());
			ps.setInt(3, entity.getUserId());
			ps.setInt(4, entity.getCarId());
			ps.setString(5, entity.getStartDate().toString());
			ps.setString(6, entity.getEndDate().toString());
			ps.setInt(7, entity.getCustomer().getId());
			ps.setInt(8, entity.getTotalPrice());
			ps.setBoolean(9, entity.isDamaged());
			ps.setInt(10, entity.getDamageAmount());
			ps.setString(11, entity.getRejectionReason());
			ps.setInt(12, entity.getId());
			ps.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connector);
		}

	}

	@Override
	public void delete(int id) {
		
		String sql = "DELETE FROM orders WHERE ID=?;";
		
		Connection connector = dataBaseConnection.getConnection();
		try {
			PreparedStatement statement = connector.prepareStatement(sql);
			statement.setInt(1, id);
			statement.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<Order> readAll() {
		
		String sql = "SELECT o.id, o.status, o.order_date, o.user_id, o.car_id, o.start_date, o.end_date, " + 
				"o.customer_id, o.total_price, o.isDamaged, o.damage_amount, o.rejection_reason, c.id, c.name, " + 
				"c.surname, c.passport_numb, c.date_of_birth, c.driving_exp " + 
				"FROM orders o JOIN customer_personal_data c ON o.customer_id=c.id;";

		List<Order> orderList = new ArrayList<Order>();
		Order order = null;

		Connection connector = dataBaseConnection.getConnection();

		try {
			Statement st = connector.createStatement();
			ResultSet rs = st.executeQuery(sql);

			while (rs.next()) {
				order = new Order(OrderStatusEnum.valueOf(rs.getString("status")), rs.getDate("order_date"),
						rs.getInt("user_id"), rs.getInt("car_id"), rs.getDate("start_date"), rs.getDate("end_date"),
						new CustomerPersonalData(/*rs.getInt("customer_id"), */rs.getString("name"), rs.getString("surname"),
						rs.getString("passport_numb"), rs.getDate("date_of_birth"), rs.getInt("driving_exp")), 
						rs.getInt("total_price"), rs.getBoolean("isDamaged"), rs.getInt("damage_amount"), rs.getString("rejection_reason"));
				order.setId(rs.getInt("id"));
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connector);
		}
		return orderList;
	}

//	@Override
//	public Order instantRead(Order order) {
//
//		Order orderWithId = null;
//		String sql = "SELECT * FROM orders WHERE status=? AND order_date=? AND customer_name=? AND "
//				+ "customer_surname=? AND user_id=? AND passport_numb=? AND date_of_birth=? AND "
//				+ "driving_exp=? AND car_id=? AND start_date=? AND end_date=?; ";
//
//		try {
//			Class.forName("com.mysql.cj.jdbc.Driver");
//		} catch (ClassNotFoundException e1) {
//			e1.printStackTrace();
//		}
//
//		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {
//
//			PreparedStatement st = cn.prepareStatement(sql);
//
//			st.setString(1, order.getStatus().name());
//			st.setString(2, order.getOrderDate().toString());
//			st.setString(3, order.getCustomerName());
//			st.setString(4, order.getCustomerSurname());
//			st.setInt(5, order.getUserId());
//			st.setString(6, order.getPassportNumb());
//			st.setString(7, order.getDateOfBirth().toString());
//			st.setInt(8, order.getDrivingExp());
//			st.setInt(9, order.getCarId());
//			st.setString(10, order.getStartDate().toString());
//			st.setString(11, order.getEndDate().toString());
//
//			ResultSet rs = st.executeQuery();
//
//			if (rs.next()) {
//				orderWithId = order;
//				orderWithId.setId(rs.getInt("id"));
//			}
//
//		} catch (SQLException e) {
//			e.printStackTrace();
//		}
//
//		return orderWithId;
//
//	}

	@Override
	public List<Order> readAllWithStatus(OrderStatusEnum orderStatus) {

		String sql = "SELECT * FROM orders WHERE status=?";
		List<Order> orderList = new ArrayList<Order>();
		Order order = null;

		Connection connector = dataBaseConnection.getConnection();

		try {

			PreparedStatement st = connector.prepareStatement(sql);

			st.setString(1, orderStatus.toString());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				order = new Order(OrderStatusEnum.valueOf(rs.getString("status")), rs.getDate("order_date"),
						rs.getInt("user_id"), rs.getInt("car_id"), rs.getDate("start_date"), rs.getDate("end_date"),
						new CustomerPersonalData(rs.getInt("customer_id")), rs.getInt("total_price"),
						rs.getBoolean("isDamaged"), rs.getInt("damage_amount"), rs.getString("rejection_reason"));
				order.setId(rs.getInt("id"));
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connector);
		}

		return orderList;
	}

	@Override
	public int getLastInsertId() {

		int id = 0;

		String sql2 = "SELECT LAST_INSERT_ID();";

		Connection connector = dataBaseConnection.getConnection();

		ResultSet rs = null;

		try {
			rs = connector.createStatement().executeQuery(sql2);
			if (rs.next()) {
				id = rs.getInt(1);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connector);
		}

		return id;

	}

	@Override
	public int createOrderTransaction(Order entity) {
		
		int id = 0;
		
		String sql1 = "INSERT INTO customer_personal_data (name, surname, passport_numb, date_of_birth, driving_exp)"
				+ " VALUES (?, ?, ?, ?, ?);";

		String sql2 = "SELECT LAST_INSERT_ID();";

		String sql3 = "INSERT INTO orders (status, order_date, user_id, car_id, start_date, end_date, customer_id)"
				+ " VALUES (?, ?, ?, ?, ?, ?, ?);";

		Connection connector = dataBaseConnection.getConnection();

		PreparedStatement customerCreateStatement = null;
		ResultSet rs = null;
		PreparedStatement orderCreateStatement = null;

		try {

			connector.setAutoCommit(false);

			try {

				customerCreateStatement = connector.prepareStatement(sql1);
				customerCreateStatement.setString(1, entity.getCustomer().getName());
				customerCreateStatement.setString(2, entity.getCustomer().getSurname());
				customerCreateStatement.setString(3, entity.getCustomer().getPassportNumb());
				customerCreateStatement.setString(4, entity.getCustomer().getDateOfBirth().toString());
				customerCreateStatement.setInt(5, entity.getCustomer().getDrivingExp());
				customerCreateStatement.executeUpdate();
				
				

				rs = connector.createStatement().executeQuery(sql2);
				if (rs.next()) {
					entity.getCustomer().setId(rs.getInt(1));
					System.out.println("!!!!!!!!!!!!!" + rs.getInt(1));
				}

				orderCreateStatement = connector.prepareStatement(sql3);
				orderCreateStatement.setString(1, entity.getStatus().toString());
				orderCreateStatement.setString(2, entity.getOrderDate().toString());
				orderCreateStatement.setInt(3, entity.getUserId());
				orderCreateStatement.setInt(4, entity.getCarId());
				orderCreateStatement.setString(5, entity.getStartDate().toString());
				orderCreateStatement.setString(6, entity.getEndDate().toString());
				orderCreateStatement.setInt(7, entity.getCustomer().getId());
				orderCreateStatement.executeUpdate();
				
				rs = connector.createStatement().executeQuery(sql2);
				if (rs.next()) {
					id = rs.getInt(1);
					System.out.println("!!!!!!!!!!!!!" + rs.getInt(1));
				}

				connector.commit();

			} catch (SQLException e) {
				connector.rollback();
				e.printStackTrace();
			} finally {
				connector.setAutoCommit(true);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connector);
		}
		
		return id;
		
	}

}
