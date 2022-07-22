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
import Mapper.Destination_mapper;
import Model.Destination;

public class DestinationPrice_service {
	private final DBConfig dbConfig;
	private final Connection connection;

	public DestinationPrice_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}

	public int createdestinationPrice(Destination dest) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO cargotransportation.destination_price(destination_name,destination_price)VALUES(?,?)");
			ps.setString(1, dest.getDestinationName());
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

	public int updatedestinationPrice(int id, Destination dest) {
		int status = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(
					"UPDATE cargotransportation.destination_price SET destination_name=?, destination_price=? WHERE destination_id=" + id
							+ ";");
			ps.setString(1, dest.getDestinationName());
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
	public List<Destination> getAlldestinationPrice() {
		List<Destination> destinationPriceList = new ArrayList<Destination>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from cargotransportation.destination_price");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Destination dest = new Destination();
				dest = Destination_mapper.mapper(dest, rs);
				destinationPriceList.add(dest);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return destinationPriceList;
	}


public int getdestinationPriceById(int Id) {
	//Destination dest = new Destination();
	int price=0;
	try {
		PreparedStatement ps = connection
				.prepareStatement("select * from cargotransportation.destination_price where destination_id=" + Id + ";");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			price=rs.getInt("destination_price");
			//dest = Destination_mapper.mapper(dest, rs);
		}
		ps.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return price;
}

public Destination getDestinationByName(String destination) {
	Destination dest = new Destination();
	//int price=0;
	try {
		PreparedStatement ps = connection
				.prepareStatement("select * from cargotransportation.destination_price where destination_name=?;");
		ps.setString(1, destination);
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			//price=rs.getInt("destination_price");
			dest = Destination_mapper.mapper(dest, rs);
		}
		ps.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return dest;
}


public Destination getDestinationById(int id) {
	Destination dest = new Destination();
	//int price=0;
	try {
		PreparedStatement ps = connection
				.prepareStatement("select * from cargotransportation.destination_price where destination_id="+id+";");
		ResultSet rs = ps.executeQuery();
		if (rs.next()) {
			//price=rs.getInt("destination_price");
			dest = Destination_mapper.mapper(dest, rs);
		}
		ps.close();
	} catch (SQLException e) {
		e.printStackTrace();
	}

	return dest;
}
}
