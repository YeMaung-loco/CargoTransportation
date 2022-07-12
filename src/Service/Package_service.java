package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Mapper.Staff_mapper;
import config.DBConfig;
import Model.Package;
import Model.Staff;

public class Package_service {
	private final DBConfig dbConfig;
	private final Connection connection;

	public Package_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();
		

	}
	public int createPackage(Package Package) {
		int status=0;
		try {
			PreparedStatement ps=connection.prepareStatement("insert into cargotransportation.package(order_id,weightPrice_id)values(?,?)");
			ps.setInt(1, Package.getOrder().getOrder_id());
			ps.setInt(2, Package.getWeight().weightPrice_id());
			status=ps.executeUpdate();
			ps.close();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	
	public int deletePackage(int id) {
		int status=0;
		try {
			PreparedStatement ps=connection.prepareStatement("delete from cargotransportation.package where package_id="+id+";");
		status=ps.executeUpdate();
		ps.close();
					
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
	public List<Package> getAllpackage() {
		List<Package> packageList = new ArrayList<Package>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM cargotransportation.package "
							+ "inner join weightPrice on weightPrice.weightPrice_id=package.weightPrice_id "
							+ "inner join order on order.orderid=weightPrice.order_id ");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Package park=new Package();//package is not input because system's name package is same
			park = Staff_mapper.mapper(park, rs);
				packageList.add(park);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return packageList;

	}

}
