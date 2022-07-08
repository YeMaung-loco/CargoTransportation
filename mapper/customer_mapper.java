package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.customer;

public class customer_mapper {
	 public static customer mapper(customer customer, ResultSet rs) {

	        try {
	            customer.setId(rs.getInt("customer_id"));
	            customer.setName(rs.getString("name"));
	            customer.setPhone(rs.getInt("phone"));
	            customer.setAddress(rs.getString("address"));
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return customer;
	    }
}
