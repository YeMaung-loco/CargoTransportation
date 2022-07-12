package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Mapper.Order_mapper;
import Model.Order;
import config.DBConfig;

public class Order_service {
	private final DBConfig dbConfig;
	private final Connection connection;

	public Order_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}

	public int createOrder(Order order) {
		int status = 0;
		long millis = System.currentTimeMillis();
		try {
			PreparedStatement ps = connection.prepareStatement("Insert into cargotransportation.order "
					+ "(customer_id,destinationPrice_id,created_date,transportation_fees)VALUES(?,?,?,?)");
			ps.setInt(1, order.getCustomer().getId());
			ps.setInt(2, order.getDestination().getId());
			ps.setDate(3, new java.sql.Date(millis));
			ps.setInt(4, order.getTransportationfees());
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
					+ "customer_id=?,destinationPrice_id=?,transportation_fees=? where order_id=" + id + ";");
			ps.setInt(1, order.getCustomer().getId());
			ps.setInt(2, order.getDestination().getId());
			ps.setInt(3, order.getTransportationfees());
			status = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

	}

	public Order getlastOrder() {
		Order order = new Order();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM cargotransportation.order inner join destination_price as d on d.destinationPrice_id=order.destinationPrice_id"
							+ "inner join customer as c on c.customer_id=order.customer_id"
							+ "where order.order_id=(SELECT MAX(order.order_id) FROM cargotransportation.order);");
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

	public Order getOrderById(int Id) {
		Order order = new Order();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM cargotransportation.order"
					+ "INNER JOIN destination_price as d ON d.destinationPrice_id = order.destinationPrice_id"
					+ "inner join customer on customer.customer_id=order.customer_id"
					// +"inner join package on package.package_id=order.package_id"
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

	public List<Order> getOrderBydestinationId(int destination_id) {
		List<Order> orderList = new ArrayList<Order>();
		try {
			PreparedStatement ps = connection.prepareStatement("Select * from cargotransportation.order"
					+ "inner join destination_price on destination_price.destinationPrice_id=order.destinationPrice_id"
					+ "inner join customer on customer.customer_id=order.customer_id"
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

	public List<Order> getAllOrderlist() {
		List<Order> orderList = new ArrayList<Order>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from cargotransportation.order"
					+ "Inner join destination_price on destination_price.destinationPrice_id=order.destinationPrice_id"
					+ "inner join customer on customer.customer_id=order.customer_id");
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
