package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import config.DBConfig;
import Model.Department;

<<<<<<< Updated upstream:Service/Department_service.java
public class Department_service {
	private final DBConfig dbConfig;
	private final Connection connection;
	public Department_service() throws SQLException {
=======
public class Department_Service {
	private final DBConfig dbConfig;
	private final Connection connection;
	public Department_Service() throws SQLException {
>>>>>>> Stashed changes:Service/department_service.java
		this.dbConfig = new DBConfig();
		this.connection = dbConfig.getConnection();

	}
<<<<<<< Updated upstream:Service/Department_service.java
	 
	    public void createDepartment(Department depart) {
=======
	    public void createDepartment(department depart) {
>>>>>>> Stashed changes:Service/department_service.java
	        try {

	            PreparedStatement ps = this.dbConfig.getConnection()
	                    .prepareStatement("INSERT INTO department(depart_name) VALUES (?);");

	            ps.setString(1, depart.getDepartmentName());
	            ps.executeUpdate();
	            ps.close();

	        } catch (SQLException e) {
	            e.printStackTrace();
	            }
	        }

	    

	    public void updateDepartment(String id, Department depart) {
	        try {

	            PreparedStatement ps = this.dbConfig.getConnection()
	                    .prepareStatement("UPDATE department SET department_name = ? WHERE department_id = ?");

	            ps.setString(1, depart.getDepartmentName());
	            ps.setString(2, id);
	            ps.execute();

	            ps.close();

	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	    }

	    public List<Department> getAllDepartment() {
	        List<Department> departmentList = new ArrayList<>();

	        try (Statement st = this.dbConfig.getConnection().createStatement()) {

	            String query = "SELECT * FROM department";

	            ResultSet rs = st.executeQuery(query);

	            while (rs.next()) {
	                Department depart = new Department();
	                depart.setId(rs.getInt("department_id"));
	                depart.setDepartmentName(rs.getString("department_name"));
	                departmentList.add(depart);
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return departmentList;
	    }

	    public Department getById(String id) {
	        Department depart = new Department();

	        try (Statement st = connection.createStatement()) {

	            String query = "SELECT * FROM department WHERE department_id = " + id + ";";

	            ResultSet rs = st.executeQuery(query);

	            while (rs.next()) {
	                depart.setId(rs.getInt("department_id"));
	                depart.setDepartmentName(rs.getString("department_name"));
	            }

	        } catch (Exception e) {
	            e.printStackTrace();
	        }

	        return depart;
	    }

	    
}
