package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
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
	public int getdeli(String order_no) {
		int staffid=0;
		try {
			PreparedStatement ps=connection.prepareStatement("select staff_id from cargotransportation.order_staff"
					+ " inner join cargotransportation.order as o "
					+ "on o.order_no=order_staff.order_no where order_staff.order_no=\"" +order_no+ "\";");
			ResultSet rs=ps.executeQuery();
			System.out.println(rs.toString());
			if(rs.next()) {
				staffid=rs.getInt("staff_id");
				
						
			}
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return staffid;
	}

//	public int deleteAssignByOrderNo(String order_no) {
//		
//	}

	public int deleteAssignByOrderNo(String deleteOrderNo) {
		int status = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(
					"delete from cargotransportation.order_staff where order_no=\"" + deleteOrderNo + "\";");
			status = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
}
