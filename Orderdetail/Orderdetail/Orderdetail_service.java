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

public class Orderdetail_service {
	private final DBConfig dbConfig;
	private final Connection connection;

	public Orderdetail_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}
	public Order