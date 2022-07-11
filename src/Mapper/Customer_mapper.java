package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Customer;

public class Customer_mapper {
	 public static Customer mapper(Customer customer, ResultSet rs) {

	        try {
	            customer.setId(rs.getInt("customer_id"));
	            customer.setName(rs.getString("c_name"));
	            customer.setPhone(rs.getInt("c_phone"));
	            customer.setAddress(rs.getString("c_address"));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return customer;
	    }
}
