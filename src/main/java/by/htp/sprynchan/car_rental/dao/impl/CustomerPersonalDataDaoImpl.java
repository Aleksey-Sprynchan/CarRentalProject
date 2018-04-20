package by.htp.sprynchan.car_rental.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import by.htp.sprynchan.car_rental.bean.CustomerPersonalData;

import by.htp.sprynchan.car_rental.dao.CustomerPersonalDataDao;


public class CustomerPersonalDataDaoImpl implements CustomerPersonalDataDao {

	public CustomerPersonalDataDaoImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void create(CustomerPersonalData entity) {
		

	}

	@Override
	public CustomerPersonalData read(int id) {
		
		String sql = "SELECT * FROM customer_personal_data WHERE id=?;";

		CustomerPersonalData customerData = null;

		Connection connector = dataBaseConnection.getConnection();

		try {

			PreparedStatement ps = connector.prepareStatement(sql);
			ps.setString(1, String.valueOf(id));
			ResultSet rs = ps.executeQuery();

			if (rs.next()) {
				customerData = new CustomerPersonalData(rs.getString("name"), rs.getString("surname"),
						rs.getString("passport_numb"), rs.getDate("date_of_birth"), rs.getShort("driving_exp"));
			}

		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			dataBaseConnection.closeConnection(connector);
		}

		return customerData;
	}

	@Override
	public void update(CustomerPersonalData entity) {
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub

	}

}
