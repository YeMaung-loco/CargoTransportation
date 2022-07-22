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

	public int createOrder(Order order, int customerId) {
		int status = 0;
		long millis = System.currentTimeMillis();
		try {
			System.out.println("order_no" + order.getOrder_no() + "customer_id" + order.getCustomer().getId());
			PreparedStatement ps = connection.prepareStatement("Insert into cargotransportation.order "
					+ "(order_no,customer_id,destination_id,created_date,transportation_fees,assign,status)VALUES(?,?,?,?,?,?,?)");
			ps.setString(1, order.getOrder_no());
			ps.setInt(2, customerId);
			ps.setInt(3, order.getDestination().getId());
			ps.setDate(4, new java.sql.Date(millis));
			ps.setInt(5, order.getTransportationfees());
			ps.setBoolean(6, false);
			ps.setString(7, "Transporting");
			status = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updateOrder(String order_no, Order order) {
		int status = 0;
		try {
			PreparedStatement ps = connection.prepareStatement("Update cargotransportation.order set "
					+ "transportation_fees=?  where order_no=\"" + order_no + "\";");
			// ps.setInt(1, order.getCustomer().getId());
			// ps.setInt(2, order.getDestination().getId());
			ps.setInt(1, order.getTransportationfees());
			System.out.println("Fee-" + order.getTransportationfees());
			status = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;

	}

	public int assignOrder(String order_no, boolean assign, String status) {
		int query = 0;
		try {
			PreparedStatement ps = connection.prepareStatement("Update cargotransportation.order set "
					+ "assign=?,status=?  where order_no=\"" + order_no + "\";");
			// ps.setInt(1, order.getCustomer().getId());
			// ps.setInt(2, order.getDestination().getId());
			ps.setBoolean(1, assign);
			ps.setString(2, status);
			// System.out.println("Fee-"+order.getTransportationfees());
			query = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return query;

	}

	public int getLastOrderId() {
		int id = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("SELECT MAX(order.order_id) FROM cargotransportation.order;");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				id = rs.getInt("MAX(order.order_id)");
			} else {
				PreparedStatement query = connection
						.prepareStatement("ALTER TABLE cargotransportation.order AUTO_INCREMENT = 1;");
				boolean reset = query.execute();
				System.out.println("Order Table Auto increment reset is " + reset);

			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return id;
	}

	public Order getlastOrder() {
		Order order = new Order();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM cargotransportation.order inner join destination_price as d on d.destination_id=order.destination_id "
							+ "inner join customer as c on c.customer_id=order.customer_id "
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

	public Order getOrderById(String orderNo) {
		Order order = new Order();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM cargotransportation.order "
					+ "INNER JOIN destination_price as d ON d.destination_id = order.destination_id "
					+ "inner join customer on customer.customer_id=order.customer_id " + "WHERE order_no = \"" + orderNo
					+ "\";");
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
			PreparedStatement ps = connection.prepareStatement("Select * from cargotransportation.order "
					+ "inner join destination_price on destination_price.destination_id=order.destination_id "
					+ "inner join customer on customer.customer_id=order.customer_id" + "where order.destination_id= "
					+ destination_id + ";");
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
			PreparedStatement ps = connection.prepareStatement("select * from cargotransportation.order "
					+ "Inner join destination_price on destination_price.destination_id=order.destination_id "
					+ "inner join customer on customer.customer_id=order.customer_id order by cargotransportation.order.order_id;");
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
	
	public List<Order> getOrderByStatus(String status) {
		List<Order> orderList = new ArrayList<Order>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM cargotransportation.order "
					+ "INNER JOIN destination_price ON destination_price.destination_id = order.destination_id "
					+ "inner join customer on customer.customer_id=order.customer_id " + "WHERE status = \"" + status
					+ "\";");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Order order = new Order();
				order = Order_mapper.mapper(order, rs);
				orderList.add(order);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderList;
	}
	
	public List<Order> getOrderbyAssign() {
		List<Order> orderList = new ArrayList<Order>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM cargotransportation.order "
					+ "INNER JOIN destination_price ON destination_price.destination_id = cargotransportation.order.destination_id "
					+ "inner join customer on customer.customer_id=cargotransportation.order.customer_id " + "WHERE assign =?;");
			ps.setBoolean(1,false);
			System.out.println(ps);
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				System.out.println("OrderId"+rs.getString("order_no"));
				Order order = new Order();
				order = Order_mapper.mapper(order, rs);
				orderList.add(order);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return orderList;
	}

	public int deleteOrder(String order_no) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("delete from cargotransportation.order where order_no=\"" + order_no + "\";");
			status = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return status;
	}
}