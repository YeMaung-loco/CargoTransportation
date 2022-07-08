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
import mapper.weight_mapper;
import Model.weight;

public class weightPrice_service {
	private final DBConfig dbConfig;
	private final Connection connection;

	public weightPrice_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}

	public int createweightPrice(weight w) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("INSERT INTO cargotransportation.weight_price(weight_kg,price)VALUES(?,?)");
			ps.setInt(1, w.getWeight_kg());
			ps.setInt(2, w.getWeightprice());
			status = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists");
			}
		}
		return status;
	}

	public int deleteweightPrice(int Id) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("DELETE FROM cargotransportation.weight_price where weight_id=" + Id + ";");
			status = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return status;
	}
//update weightprice
	public int updateweightPrice(int id, weight w) {
		int status = 0;
		try {
			PreparedStatement ps = this.dbConfig.getConnection().prepareStatement(
					"UPDATE cargotransportation.weight_price SET weight_kg=?, price=?, WHERE weight_id=" + id
							+ ";");
			ps.setInt(1, w.getWeight_kg());
			ps.setInt(2, w.getWeightprice());

			status = ps.executeUpdate();
			ps.close();
		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists");
			}
		}
		return status;
	}
	//print weightprice list
	public List<weight> getAllweightPrice() {
		List<weight> weightPriceList = new ArrayList<weight>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from cargotransportation.weight_price");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				weight w = new weight();
				w = weight_mapper.mapper(w, rs);
				weightPriceList.add(w);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return weightPriceList;
	}
	//print weightprice by id
	public weight getweightPriceById(int Id) {
		weight w = new weight();
		try {
			PreparedStatement ps = connection
					.prepareStatement("select * from cargotransportation.weight_price where weight_id=" + Id + ";");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				w = weight_mapper.mapper(w, rs);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return w;
	}
	

}

