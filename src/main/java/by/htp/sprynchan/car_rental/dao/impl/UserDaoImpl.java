package by.htp.sprynchan.car_rental.dao.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.sprynchan.car_rental.bean.User;
import by.htp.sprynchan.car_rental.dao.UserDao;

public class UserDaoImpl implements UserDao {
	
	private static final String url = "jdbc:mysql://localhost/car_rental?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&useSSL=false";


	@Override
	public void create(User entity) {
		
		String sql = "INSERT INTO users (login, password, name, surname, email) VALUES (?, ?, ?, ?,?);";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")){

			PreparedStatement st = cn.prepareStatement(sql);
			st.setString(1, entity.getLogin());
			st.setString(2, entity.getPassword());
			st.setString(3, entity.getName());
			st.setString(4, entity.getSurname());
			st.setString(5, entity.getEmail());
			st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}	
			
	}

	@Override
	public User read(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void update(User entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

	@Override
	public User login(String login, String password) {
		
		User user = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}

		try (Connection cn = DriverManager.getConnection(url, "root", "ROOT")) { 

			PreparedStatement st = cn.prepareStatement("select * from users where login=? and password=?;");

			st.setString(1, login);
			st.setString(2, password);
			ResultSet rs = st.executeQuery();
			if (rs.next()) {
				if (rs.getString("login").equals(login) && rs.getString("password").equals(password)) {
					System.out.println(rs.getBoolean("isAdmin"));
					user = new User(rs.getString("login"), rs.getString("password"), rs.getBoolean("isAdmin"));
					user.setId(rs.getInt("id"));
					user.setName(rs.getString("name"));
					user.setSurname(rs.getString("surname"));
					user.setEmail(rs.getString("email"));
				}
			} 
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return user;
		
	}

}
