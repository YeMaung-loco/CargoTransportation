package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

<<<<<<< Updated upstream
import mapper.Staff_mapper;
=======
>>>>>>> Stashed changes
import Model.Staff;
import config.DBConfig;
import mapper.staff_mapper;

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
<<<<<<< Updated upstream
					"INSERT INTO cargotransportation.staff (name, phone_number,address,nrc,role_id,department_id,is_active,created_date) VALUES (?, ?, ?, ?, ?, ? , ? , ?)");
=======
					"INSERT INTO cargotransportation.staff (staff_name, phone_number,address,nrc,department_id,is_active,created_date) VALUES (?, ?, ?, ?, ?, ?,?)");
>>>>>>> Stashed changes
			ps.setString(1, staff.getName());
			ps.setString(2, staff.getPhone());
			ps.setString(3, staff.getAddress());
			ps.setString(4, staff.getNrc());
<<<<<<< Updated upstream
			ps.setInt(5, staff.getRoleId());
			ps.setInt(6, staff.getDepartmentId());
			ps.setBoolean(7, true);
			ps.setDate(8, new java.sql.Date(millis));
=======
			ps.setInt(5, staff.getDepartmentId());
			ps.setBoolean(6, true);
			ps.setDate(7, new java.sql.Date(millis));
>>>>>>> Stashed changes
			status = ps.executeUpdate();
			
			//ps=connection.prepareStatement("INSERT INTO cargotransportation.staff_role(,role_id) VALUES(?,?)");
			ps.close();

		} catch (Exception e) {
			if (e instanceof SQLIntegrityConstraintViolationException) {
				JOptionPane.showMessageDialog(null, "Already Exists");
			}
			e.printStackTrace();
		}
		return status;
	}

	public List<Staff> getAllstaff() {
		//SELECT *
//		FROM staff
//		INNER JOIN staff_role
//		ON staff.staff_id = staff_role.staff_id
//		where staff.staff_id=35;
		List<Staff> staffList = new ArrayList<Staff>();
		try {
			PreparedStatement ps = connection.prepareStatement("SELECT * FROM cargotransportation.staff\r\n"
					+ "inner join role\r\n"
					+ "on role.role_id=staff.role_id\r\n"
					+ "inner join department\r\n"
					+ "on staff.department_id=department.department_id;");
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
					.prepareStatement("SELECT * FROM cargotransportation.staff inner join role on role.role_id=staff.role_id inner join department "+
							"on staff.department_id=department.department_id "+
							"where staff.staff_id="+Id+";");
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
					"SELECT * FROM cargotransportation.staff inner join role on role.role_id=staff.role_id inner join department "+
							"on staff.department_id=department.department_id "+
							"where staff.staff_id=(SELECT MAX(staff.staff_id) FROM cargotransportation.staff);");
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
<<<<<<< Updated upstream
			ps.setInt(5, staff.getRoleId());
			ps.setInt(6, staff.getDepartmentId());
			ps.setBoolean(7, staff.getActive());
			
=======
			ps.setInt(7, staff.getRole());
			ps.setInt(8, staff.getDepartmentId());
			ps.setBoolean(9, staff.getActive());
>>>>>>> Stashed changes

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
