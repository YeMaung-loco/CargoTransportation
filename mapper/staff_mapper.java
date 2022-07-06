package mapper;

import java.sql.ResultSet;
import Model.Staff;

public class staff_mapper {
	
	public static Staff mapper(Staff staff, ResultSet rs){
		 try {
	            staff.setId(rs.getInt("staff_id"));
	            staff.setName(rs.getString("name"));
	            staff.setPhone(rs.getString("phone_number"));
	            staff.setAddress(rs.getString("address"));
	            staff.setNrc(rs.getString("nrc"));
	            staff.setUsername(rs.getString("username"));
	            staff.setPassword(rs.getString("password"));
	            staff.setRole(rs.getString("role"));
	            staff.setDepartmentId(rs.getString("department"));
	            staff.setActive(rs.getBoolean("active"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return staff;
	}

}
