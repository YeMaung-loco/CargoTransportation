package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Mapper.Staff_mapper;
import Model.Staff;
import config.DBConfig;

public class Auth_service {
	 private final DBConfig dbConfig;
	 private final Connection connection;
	


	    public Auth_service() throws SQLException {
	        dbConfig = new DBConfig();
	        this.connection = dbConfig.getConnection();
	    }

	    public  Staff login(String username, String password) {
	    	Staff staff=null;
	        String id = "";
	        try {
                    PreparedStatement ps=connection.prepareStatement(" select * from cargotransportation.staff inner join department on department.department_id=staff.department_id "
                    +"inner join role on role.role_id=staff.role_id "
                   +" where staff.staff_id= (select staff_id from cargotransportation.authenticate where username=\""+username+"\" and password=\""+password+"\");");
                    System.out.println(ps);
//	            ps.setString(1,username);
//	            ps.setString(2, password);
	            ResultSet rs= ps.executeQuery();

	            if (rs.next()) {
	            	staff=new Staff();
	            	staff=Staff_mapper.mapper( staff, rs);
	            	
	               // id = rs.getString("staff_id");
//	                staff=getstaffById(id);
	            } else {
	                JOptionPane.showMessageDialog(null, "Invalid Credential");
	            }

	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return staff;
	    }
	    public Staff getstaffById(String loggedInUserId) {
			Staff staff = new Staff();
			try {
				PreparedStatement ps = this.dbConfig.getConnection()
						.prepareStatement("SELECT * FROM cargotransportation.staff "
								+"where staff_id="+loggedInUserId+";");
				ResultSet rs = ps.executeQuery();
				if (rs.next()) {
					staff =  Staff_mapper.mapper(staff, rs);
				}
				ps.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}

			return staff;
		}
	    
}
