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
	            staff.setRoleId(rs.getInt("role_id"));
	            staff.setRoleName(rs.getString("role_name"));
	            staff.setDepartmentId(rs.getInt("department_id"));
	            staff.setDepartmentName(rs.getString("department_name"));
	            staff.setActive(rs.getBoolean("is_active")); 
	            staff.setDate(rs.getDate("created_date"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return staff;
	}

}
