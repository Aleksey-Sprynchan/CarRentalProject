package by.htp.sprynchan.car_rental.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import by.htp.sprynchan.car_rental.bean.Order;
import by.htp.sprynchan.car_rental.dao.OrderDao;
import by.htp.sprynchan.car_rental.web.util.OrderStatusEnum;

public class OrderDaoImpl implements OrderDao {

	private static final String url = "jdbc:mysql://localhost/car_rental?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";

	@Override
	public void create(Order entity) {

		String sql = "INSERT INTO orders (status, order_date, customer_name, "
				+ "customer_surname, user_id, passport_numb, date_of_birth, "
				+ "driving_exp, car_id, start_date, end_date) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {

			PreparedStatement st = cn.prepareStatement(sql);
			st.setString(1, entity.getStatus().name());
			st.setString(2, entity.getOrderDate().toString());
			st.setString(3, entity.getCustomerName());
			st.setString(4, entity.getCustomerSurname());
			st.setInt(5, entity.getUserId());
			st.setString(6, entity.getPassportNumb());
			st.setString(7, entity.getDateOfBirth().toString());
			st.setInt(8, entity.getDrivingExp());
			st.setInt(9, entity.getCarId());
			st.setString(10, entity.getStartDate().toString());
			st.setString(11, entity.getEndDate().toString());
		
			st.executeUpdate();
			

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public Order read(int id) {
		
		Order order = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {

			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM orders WHERE id=" + String.valueOf(id));

			if (rs.next()) {
				order = new Order(OrderStatusEnum.valueOf(rs.getString("status")), 
						rs.getDate("order_date"), 
						rs.getString("customer_name"),
						rs.getString("customer_surname"), 
						rs.getInt("user_id"), 
						rs.getString("passport_numb"),
						rs.getDate("date_of_birth"),
						rs.getInt("driving_exp"), 
						rs.getInt("car_id"),
						rs.getDate("start_date"), 
						rs.getDate("end_date"),
						rs.getString("rejection_reason"));
				order.setId(rs.getInt("id"));
				order.setTotalPrice(rs.getInt("total_price"));
				order.setDamaged(rs.getBoolean("isDamaged"));
				order.setDamageAmount(rs.getInt("damage_amount"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order;
	}

	@Override
	public void update(Order entity) {
		
		String sql = "UPDATE orders SET status=?, order_date=?, customer_name=?, "
				+ "customer_surname=?, user_id=?, passport_numb=?, date_of_birth=?, "
				+ "driving_exp=?, car_id=?, start_date=?, end_date=?, total_price=?, "
				+ "isDamaged=?, damage_amount=?, rejection_reason=? WHERE id=?";
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {

			PreparedStatement st = cn.prepareStatement(sql);
			
			st.setString(1, entity.getStatus().name());
			st.setString(2, entity.getOrderDate().toString());
			st.setString(3, entity.getCustomerName());
			st.setString(4, entity.getCustomerSurname());
			st.setInt(5, entity.getUserId());
			st.setString(6, entity.getPassportNumb());
			st.setString(7, entity.getDateOfBirth().toString());
			st.setInt(8, entity.getDrivingExp());
			st.setInt(9, entity.getCarId());
			st.setString(10, entity.getStartDate().toString());
			st.setString(11, entity.getEndDate().toString());
			st.setInt(12, entity.getTotalPrice());
			st.setBoolean(13, entity.isDamaged());
			st.setInt(14, entity.getDamageAmount());
			st.setString(15, entity.getRejectionReason());
			st.setInt(16, entity.getId());
			
			st.executeUpdate();

		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public List<Order> readAll() {
		
		List<Order> orderList = new ArrayList<Order>();
		Order order = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {

			Statement st = cn.createStatement();
			ResultSet rs = st.executeQuery("SELECT * FROM orders");
			
			while (rs.next()) {
				order = new Order(OrderStatusEnum.valueOf(rs.getString("status")), 
						rs.getDate("order_date"), 
						rs.getString("customer_name"),
						rs.getString("customer_surname"), 
						rs.getInt("user_id"), 
						rs.getString("passport_numb"),
						rs.getDate("date_of_birth"),
						rs.getInt("driving_exp"), 
						rs.getInt("car_id"),
						rs.getDate("start_date"), 
						rs.getDate("end_date"),
						rs.getString("rejection_reason"));
				order.setId(rs.getInt("id"));
				order.setTotalPrice(rs.getInt("total_price"));
				order.setDamaged(rs.getBoolean("isDamaged"));
				order.setDamageAmount(rs.getInt("damage_amount"));
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	@Override
	public Order instantRead(Order order) {
		
		Order orderWithId = null;
		String sql = "SELECT * FROM orders WHERE status=? AND order_date=? AND customer_name=? AND " 
				+ "customer_surname=? AND user_id=? AND passport_numb=? AND date_of_birth=? AND " 
				+ "driving_exp=? AND car_id=? AND start_date=? AND end_date=?; ";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {

			PreparedStatement st = cn.prepareStatement(sql);
			
			st.setString(1, order.getStatus().name());
			st.setString(2, order.getOrderDate().toString());
			st.setString(3, order.getCustomerName());
			st.setString(4, order.getCustomerSurname());
			st.setInt(5, order.getUserId());
			st.setString(6, order.getPassportNumb());
			st.setString(7, order.getDateOfBirth().toString());
			st.setInt(8, order.getDrivingExp());
			st.setInt(9, order.getCarId());
			st.setString(10, order.getStartDate().toString());
			st.setString(11, order.getEndDate().toString());
			
			ResultSet rs = st.executeQuery();

			if (rs.next()) {
				orderWithId = order;
				orderWithId.setId(rs.getInt("id"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderWithId;
		
		
	}

	@Override
	public List<Order> readAllWithStatus(OrderStatusEnum orderStatus) {
		
		String sql = "SELECT * FROM orders WHERE status=?";
		List<Order> orderList = new ArrayList<Order>();
		Order order = null;
		
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) {

			PreparedStatement st = cn.prepareStatement(sql);
			
			st.setString(1, orderStatus.toString());
			ResultSet rs = st.executeQuery();

			while (rs.next()) {
				order = new Order(OrderStatusEnum.valueOf(rs.getString("status")), 
						rs.getDate("order_date"), 
						rs.getString("customer_name"),
						rs.getString("customer_surname"), 
						rs.getInt("user_id"), 
						rs.getString("passport_numb"),
						rs.getDate("date_of_birth"),
						rs.getInt("driving_exp"), 
						rs.getInt("car_id"),
						rs.getDate("start_date"), 
						rs.getDate("end_date"),
						rs.getString("rejection_reason"));
				order.setId(rs.getInt("id"));
				order.setTotalPrice(rs.getInt("total_price"));
				order.setDamaged(rs.getBoolean("isDamaged"));
				order.setDamageAmount(rs.getInt("damage_amount"));
				orderList.add(order);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return orderList;
	}

}
