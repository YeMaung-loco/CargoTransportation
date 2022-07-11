package mapper;

import java.sql.ResultSet;
import Model.Department;
import Model.Role;
import Model.Staff;

public class Staff_mapper {
	
	public static Staff mapper(Staff staff, ResultSet rs){
		 try {
	            staff.setId(rs.getInt("staff_id"));
	            staff.setName(rs.getString("name"));
	            staff.setNrc(rs.getString("nrc"));
	            staff.setPhone(rs.getString("phone_number"));
	            staff.setAddress(rs.getString("address"));
	            
	            Department department=new Department();
	            department.setDepartment_Id(rs.getInt("department_id"));
	            department.setDepartmentName(rs.getString("department_name"));
	            staff.setDepartment(department);
	            
	            Role role=new Role();
	            role.setRole_Id(rs.getInt("role_id"));
	            role.setRole_name(rs.getString("role_name"));
	            staff.setRole(role);
	            
	            staff.setActive(rs.getBoolean("is_active"));
	            staff.setDate(rs.getDate("created_date"));
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return staff;
	}

}