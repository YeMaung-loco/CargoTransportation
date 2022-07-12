package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Customer;
import Model.Destination;
import Model.Order;
import Model.Weight;
import Model.Package;

public class Order_mapper {
	 public static Order mapper(Order order, ResultSet rs) {

	        try {
	            order.setOrder_id(rs.getInt("order_id"));
	            Customer customer=new Customer();
	            customer.setId(rs.getInt("customer_id"));
	            customer.setName(rs.getString("c_name"));
	            customer.setAddress(rs.getString("c_address"));
	            customer.setPhone(rs.getString("c_phone"));
	            order.setCustomer(customer);
	            
	            Destination destination=new Destination();
	            destination.setId(rs.getInt("destinationPrice_id"));
	            destination.setDestinationname(rs.getString("destination_name"));
	            order.setDestination(destination);
	            
	            
	           List< Package> Package = new ArrayList<>();
	            
	            order.setTransportationfees(rs.getInt("transportation_fees"));
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return order;
	    }
}

