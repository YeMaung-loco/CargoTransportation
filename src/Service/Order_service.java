package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Model.Order;
import config.DBConfig;
import Mapper.Order_mapper;

public class Order_service {
	private final DBConfig dbConfig;
	private final Connection connection;

	public Order_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}

	public int createOrder(Order order) {
		int status = 0;
		try {
			PreparedStatement ps = connection.prepareStatement("Insert into cargotransportation.order "
					+ "(destinationPrice_id,weightPrice_id,transportation_fees)VALUES(?,?,?)");
			ps.setString(1, order.getDestination().getDestinationname());
			ps.setInt(2, order.getWeight().getWeight_kg());
			ps.setInt(3, order.getWeight().getWeightprice());
			status = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updateOrder(int id, Order order) {
		int status = 0;
		try {
			PreparedStatement ps = connection.prepareStatement("Update into cargotransportation.order"
					+ "destinationPrice_id=?,weightPrice_id=?,transportation_fees=? where order_id=" + id + ";");
			ps.setString(1, order.getDestination().getDestinationname());
			ps.setInt(2, order.getWeight().getWeight_kg());
			ps.setInt(3, order.getWeight().getWeightprice());
			status = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

	}

	public Order getorderById(int Id) {
		Order order = new Order();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM transportation.order"
					+ "INNER JOIN destination_price ON destination_price.destinationPrice_id = order.destinationPrice_id"
					+ "INNER JOIN weight_price ON weight_price.weightPrice_id = order.weightPrice_id"
					+ "WHERE order_id = " + Id + ";");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				order = Order_mapper.mapper(order, rs);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return order;
	}

	public List<Order> getorderBydestinationId(int destination_id) {
		List<Order> orderList = new ArrayList<Order>();
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from cargotransportation.order"
					+ "inner join destination_price on destination_price.roledestinationPrice_id=order.destinationPrice_id"
					+ "inner join weight_price on weight_price.weightPrice_id=order.weightPrice_id"
					+ "where order.destinationPrice_id=" + destination_id + ";");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				Order order = new Order();
				order = Order_mapper.mapper(order, rs);
				orderList.add(order);

			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	public List<Order> getAllorderlist() {
		List<Order> orderList = new ArrayList<Order>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from cargotransportation.order"
					+ "Inner join destination_price on destinaton_price.destinationPrice_id=order.destinationPrice_id"
					+ "inner join weight_price on weight_price.weightPrice_id=order.weightPrice_id");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order = Order_mapper.mapper(order, rs);
				orderList.add(order);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return orderList;
	}

	public int deleteOrder(int Id) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("delete from cargotransportation.order where order_id=" + Id + ";");
			status = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return status;
	}
}
