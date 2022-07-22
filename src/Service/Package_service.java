package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Mapper.Customer_mapper;
import Mapper.Staff_mapper;
import config.DBConfig;
import Model.Customer;
import Model.Package;
import Model.Staff;

public class Package_service {
	private final DBConfig dbConfig;
	private final Connection connection;

	public Package_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}

	public int createPackage(String packageNo, String orderNo, int weight) {
		int status = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(
					"insert into cargotransportation.package(package_no,order_no,weight_kg)values(?,?,?)");
			ps.setString(1, packageNo);
			ps.setString(2, orderNo);
			ps.setInt(3, weight);
			status = ps.executeUpdate();
			System.out.println(ps);
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public int deletePackageById(String package_no) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("delete from cargotransportation.package where package_no=?;");
			ps.setString(1, package_no);
			status = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public int deletePackageByOrderNo(String order_no) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("delete from cargotransportation.package where order_no=\"" + order_no + "\";");
			status = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public List<String> getPackageByOrderNo(String orderNo) {
		List<String> packageList = new ArrayList<String>();
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM cargotransportation.package where order_no=\"" + orderNo + "\";");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				packageList.add(rs.getString("package_no"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return packageList;

	}

	public List<Package> getPackageModelByOrderNo(String orderNo) {
		List<Package> packageList = new ArrayList<Package>();

		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM cargotransportation.package where order_no=\"" + orderNo + "\";");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Package pack = new Package();
				pack.setPackage_id(rs.getString("package_no"));
				// String order_no=rs.getString("order_no");
			//	Integer weightId = rs.getInt("weight_kg");
				
				pack.setWeight(rs.getInt("weight_kg"));
				packageList.add(pack);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return packageList;

	}

	public int getLastPackageId() {
		int id = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT MAX(package.package_id) FROM cargotransportation.package;");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("MAX(package.package_id)");
			} else {
				PreparedStatement query = connection
						.prepareStatement("ALTER TABLE cargotransportation.package AUTO_INCREMENT = 1;");
				boolean reset = query.execute();
				System.out.println("Package table Auto increment reset is " + reset);

			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

}
