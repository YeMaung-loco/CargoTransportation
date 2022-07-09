package mapper;

import java.sql.ResultSet;

import Model.Department;
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
	            department.setId(rs.getInt("department_id"));
	            department.setDepartmentName(rs.getString("department_name"));
	            staff.setDepartment(department);
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        return staff;
	}

}
