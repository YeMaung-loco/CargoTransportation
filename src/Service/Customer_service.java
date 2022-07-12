package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import config.DBConfig;
import Mapper.Customer_mapper;
import Model.Customer;

public class Customer_service {
	private final DBConfig dbConfig;
	private final Connection connection;

	public Customer_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}

	public int createcustomer(Customer customer) {
		int status=0;
		try {
			PreparedStatement ps = this.dbConfig.getConnection()
					.prepareStatement("INSERT INTO customer (c_name, c_phone, c_address) VALUES (?, ?, ?)");

			ps.setString(1, customer.getName());
			ps.setString(2, customer.getPhone());
			ps.setString(3, customer.getAddress());
			status=ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updatecustomer(String id, Customer customer) {
		int status=0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("UPDATE customer SET c_name=?, c_phone=?,c_address=? WHERE customer_id=?");

			ps.setString(1, customer.getName());
			ps.setString(2, customer.getPhone());
			ps.setString(3, customer.getAddress());
			ps.setString(4, id);
			status=ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	return status;
	}

	public Customer getById(String Id) {

		Customer customer = new Customer();

		try {
			PreparedStatement ps = connection
					.prepareStatement("select * from cargotransportation.customer where customer_id=" + Id + ";");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = Customer_mapper.mapper(customer, rs);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return customer;
	}

	public List<Customer> getAllcustomers() {

		List<Customer> customerList = new ArrayList<Customer>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from cargotransportation.customer");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Customer customer = new Customer();
				customer = Customer_mapper.mapper(customer, rs);
				customerList.add(customer);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return customerList;
	}
	public int deleteCustomer(int Id) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("delete from cargotransportation.customer where customer_id=" + Id + ";");
			status = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return status;
	}
}
