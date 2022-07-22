package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import config.DBConfig;

public class Orderstaff_service {
	private DBConfig dbConfig;
	private Connection connection;

	public Orderstaff_service() {

		try {
			this.dbConfig = new DBConfig();
			this.connection = dbConfig.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public boolean createOrder_staff(List<String> orderList, int staffId) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("insert into cargotransportation.order_staff (order_no,staff_id)values(?,?)");

			for (String order : orderList) {
				ps.setString(1, order);
				ps.setInt(2, staffId);
				status += ps.executeUpdate();
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return status == orderList.size();
	}
}
