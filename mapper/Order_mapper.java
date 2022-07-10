package mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Customer;
import Model.Destination;
import Model.Weight;
import Model.Order;

public class Order_mapper {
	 public static Order mapper(Order order, ResultSet rs) {

	        try {
	            order.setOrder_id(rs.getInt("order_id"));
	          Destination destination=new Destination();
	            destination.setId(rs.getInt("destinationPrice_id"));
	            destination.setDestinationname(rs.getString("destination_name"));
	            Weight weight=new Weight();
	            weight.setId(rs.getInt("weightPrice_id"));
	            weight.setWeight_kg(rs.getInt("weight_kg"));
	            weight.setWeightprice(rs.getInt("weight_price"));
	            
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return order;
	    }
}

