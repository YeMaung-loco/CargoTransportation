package service;

import java.sql.Connection;
import java.sql.SQLIntegrityConstraintViolationException;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import mapper.staff_mapper;
import Model.Staff;
import dbconfig.DBConfig;

public class office_service {

	private final DBConfig dbConfig;
	private final Connection connection;

	public office_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}

	public int createstaff(Staff staff) {
		int status = 0;
		try {
			PreparedStatement ps = connection.prepareStatement(
					"INSERT INTO cargotransportation.staff (name, phone_number,address,nrc,username,password, role ,department,active) VALUES (?, ?, ?, ?, ?, ?,?,?,?)");
			ps.setString(1, staff.getName());
			ps.setString(2, staff.getPhone());
			ps.setString(3, staff.getAddress());
			ps.setString(4, staff.getNrc());
			ps.setString(5, staff.getUsername());
			ps.setString(6, staff.getPassword());
			ps.setString(7, staff.getRole());
			ps.setString(8, staff.getDepartmentId());
			ps.setBoolean(9, true);
			status = ps.executeUpdate();
			ps.close();

		} catch (Exception e) {
			 if (e instanceof SQLIntegrityConstraintViolationException ) {
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
				staff = staff_mapper.mapper(staff, rs);
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
				staff = staff_mapper.mapper(staff, rs);
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
			PreparedStatement ps = connection
					.prepareStatement("SELECT * FROM cargptansportation.staff WHERE staff_id=(SELECT MAX(staff_id) FROM cargotransportation.staff);");
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				staff = staff_mapper.mapper(staff, rs);
			}
			ps.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		return staff;
	}


	public int deletestaff(int Id) {
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

	public int updatestaff(int id, Staff staff) {
		int status = 0;
		try {
			PreparedStatement ps = this.dbConfig.getConnection().prepareStatement(
					"UPDATE cargotransportation.staff SET name=?, phone_number=?, , address=?,nrc=?, username=?, password=?,role=?, department=?,active=? WHERE staff_id="
							+ id + ";");

			ps.setString(1, staff.getName());
			ps.setString(2, staff.getPhone());
			ps.setString(3, staff.getAddress());
			ps.setString(4, staff.getNrc());
			ps.setString(5, staff.getUsername());
			ps.setString(6, staff.getPassword());
			ps.setString(7, staff.getRole());
			ps.setString(8, staff.getDepartmentId());
			ps.setBoolean(9, staff.getActive());
			
			// ps.setString(9, id);

			status=ps.executeUpdate();
			ps.close();
		} catch (SQLException e) {
			if (e instanceof SQLIntegrityConstraintViolationException)
                JOptionPane.showMessageDialog(null, "Already Exists");
            else e.printStackTrace();
        
		}
		return status;

	}

}

