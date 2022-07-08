package mapper;

import java.sql.ResultSet;
import Model.Staff;

public class Staff_mapper {
	
	public static Staff mapper(Staff staff, ResultSet rs){
		 try {
	            staff.setId(rs.getInt("staff_id"));
	            staff.setName(rs.getString("name"));
	            staff.setPhone(rs.getString("phone_number"));
	            staff.setAddress(rs.getString("address"));
	            staff.setNrc(rs.getString("nrc"));
	            staff.setRole(rs.getInt("role_id"));
	            staff.setDepartmentId(rs.getString("department_id"));
	            staff.setActive(rs.getBoolean("is_active"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return staff;
	}

}
