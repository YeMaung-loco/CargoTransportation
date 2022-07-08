package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import config.DBConfig;
import mapper.destination_mapper;
import Model.destination;

public class destinationPrice_service {
	private final DBConfig dbConfig;
	private final Connection connection;

	public destinationPrice_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}

	public int createdestinationPrice(destination dest) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO cargotransportation.destination_price(destination_name,price)VALUES(?,?)");
			ps.setString(1, dest.getDestinationname());
			ps.setInt(2, dest.getPrice());
			status = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists");
			}
		}
		return status;
	}

	public int deletedestinationPrice(int Id) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM cargotransportation.destination_price where destination_id=" + Id + ";");
			status = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}

	public int updatedestinationPrice(int id, destination dest) {
		int status = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE cargotransportation.destination_price SET destination_name=?, price=?, WHERE destination_id=" + id
							+ ";");
			ps.setString(1, dest.getDestinationname());
			ps.setInt(2, dest.getPrice());

			status = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists");
			}
		}
		return status;
	}
	public List<destination> getAlldestinationPrice() {
		List<destination> destinationPriceList = new ArrayList<destination>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from cargotransportation.destination_price");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				destination dest = new destination();
				dest = destination_mapper.mapper(dest, rs);
				destinationPriceList.add(dest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return destinationPriceList;
	}


public destination getdestinationPriceById(int Id) {
	destination dest = new destination();
	try {
		PreparedStatement ps = connection
				.prepareStatement("select * from cargotransportation.destination_price where destination_id=" + Id + ";");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			dest = destination_mapper.mapper(dest, rs);
		}
		ps.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return dest;
}
}
