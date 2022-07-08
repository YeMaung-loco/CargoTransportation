package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DBConfig;
import Model.department;

public class department_service {
	private final DBConfig dbConfig;
	private final Connection connection;
	public department_service() throws SQLException {
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}
	    

	    public void createDepartment(department depart) {
	        try {

	            PreparedStatement ps = this.dbConfig.getConnection()
	                    .prepareStatement("INSERT INTO department(name) VALUES (?);");

	            ps.setString(1, depart.getDepartmentName());
	            ps.executeUpdate();
	            ps.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	            }
	        }

	    

	    public void updateDepartment(String id, department depart) {
	        try {

	            PreparedStatement ps = this.dbConfig.getConnection()
	                    .prepareStatement("UPDATE department SET name = ? WHERE department_id = ?");

	            ps.setString(1, depart.getDepartmentName());
	            ps.setString(2, id);
	            ps.execute();

	            ps.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public List<department> getAllDepartment() {
	        List<department> departmentList = new ArrayList<>();

	        try (Statement st = this.dbConfig.getConnection().createStatement()) {

	            String query = "SELECT * FROM department";

	            ResultSet rs = st.executeQuery(query);

	            while (rs.next()) {
	                department depart = new department();
	                depart.setId(rs.getInt("department_id"));
	                depart.setDepartmentName(rs.getString("name"));
	                departmentList.add(depart);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return departmentList;
	    }

	    public department getById(String id) {
	        department depart = new department();

	        try (Statement st = connection.createStatement()) {

	            String query = "SELECT * FROM department WHERE department_id = " + id + ";";

	            ResultSet rs = st.executeQuery(query);

	            while (rs.next()) {
	                depart.setId(rs.getInt("department_id"));
	                depart.setDepartmentName(rs.getString("name"));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return depart;
	    }

	    
}
