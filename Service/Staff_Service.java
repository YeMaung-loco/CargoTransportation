package Service;

import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import mapper.Staff_mapper;
import Model.Staff;
import config.DBConfig;

public class Staff_Service {

	private final DBConfig dbConfig;
	private final Connection connection;

	public Staff_Service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}

	public int createStaff(Staff staff) {
		int status = 0;
		long millis = System.currentTimeMillis();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO cargotransportation.staff (name, phone_number,address,nrc,role_id,department_id,is_active,created_date) VALUES (?, ?, ?, ?, ?, ?,?,?,?,?)");
			ps.setString(1, staff.getName());
			ps.setString(2, staff.getPhone());
			ps.setString(3, staff.getAddress());
			ps.setString(4, staff.getNrc());
			ps.setInt(5, staff.getRole());
			ps.setString(6, staff.getDepartmentId());
			ps.setBoolean(7, true);
			ps.setDate(8, new java.sql.Date(millis));
			status = ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists");
			}
		}
		return status;
	}

	public List<Staff> getAllstaff() {
		List<Staff> staffList = new ArrayList<Staff>();
		try {
			PreparedStatement ps = connection.prepareStatement("select * from cargotransportation.staff");
			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				Staff staff = new Staff();
				staff = Staff_mapper.mapper(staff, rs);
				staffList.add(staff);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return staffList;
	}

	public Staff getstaffById(int Id) {
		Staff staff = new Staff();
		try {
			PreparedStatement ps = connection
					.prepareStatement("select * from cargotransportation.staff where staff_id=" + Id + ";");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				staff = Staff_mapper.mapper(staff, rs);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return staff;
	}

	public Staff laststaff() {
		Staff staff = new Staff();
		try {
			PreparedStatement ps = connection.prepareStatement(
					"SELECT * FROM cargptansportation.staff WHERE staff_id=(SELECT MAX(staff_id) FROM cargotransportation.staff);");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				staff = Staff_mapper.mapper(staff, rs);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return staff;
	}

	public int deleteStaff(int Id) {
		int status = 0;
		try {
			PreparedStatement ps = connection
					.prepareStatement("delete from cargotransportation.staff where staff_id=" + Id + ";");
			status = ps.executeUpdate();
			ps.close();

		} catch (SQLException e) {
			e.printStackTrace();

		}
		return status;
	}

	public int updateStaff(int id, Staff staff) {
		int status = 0;
		try {
			PreparedStatement ps = this.dbConfig.getConnection().prepareStatement(
					"UPDATE cargotransportation.staff SET name=?, phone_number=?, address=?,nrc=?,role_id=?, department_id=?,is_active=? WHERE staff_id="+ id + ";");

			ps.setString(1, staff.getName());
			ps.setString(2, staff.getPhone());
			ps.setString(3, staff.getAddress());
			ps.setString(4, staff.getNrc());
			ps.setInt(5, staff.getRole());
			ps.setString(6, staff.getDepartmentId());
			ps.setBoolean(7, staff.getActive());
			

			// ps.setString(9, id);

			status = ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException)
				JOptionPane.showMessageDialog(null, "Already Exists");
			else
				e.printStackTrace();

		}
		return status;

	}

}
