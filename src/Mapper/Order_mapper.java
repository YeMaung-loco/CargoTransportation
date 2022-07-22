package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Customer;
import Model.Destination;
import Model.Order;

public class Order_mapper {
	public static Order mapper(Order order, ResultSet rs) {
		try {
			order.setOrder_no(rs.getString("order_no"));

			Customer customer = new Customer();
			customer.setId(rs.getInt("customer_id"));
			customer.setName(rs.getString("c_name"));
			customer.setAddress(rs.getString("c_address"));
			customer.setPhone(rs.getString("c_phone"));
			order.setCustomer(customer);

			Destination destination = new Destination();
			destination.setId(rs.getInt("destination_id"));
			destination.setDestinationName(rs.getString("destination_name"));
			order.setDestination(destination);

			order.setTransportationfees(rs.getInt("transportation_fees"));
			order.setDate(rs.getDate("created_date"));
			
			order.setAssign(rs.getBoolean("assign"));
			order.setStatus(rs.getString("status"));

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return order;
	}
}
