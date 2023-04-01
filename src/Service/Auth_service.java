package Service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import Mapper.Auth_mapper;
import Mapper.Staff_mapper;
import Model.Authenticate;
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
	    public int checkStaffid(int staff_id,Authenticate auth) {
	    	int status=0; 
	    	try {
	    		PreparedStatement ps=connection.prepareStatement("select * from cargotransportation.authenticate where staff_id=" +staff_id+ ";");
	    		ResultSet rs=ps.executeQuery();
	    		if(rs.next()) {
	    			status=rs.getInt("staff_id");
	    		}
	    	
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    	return status;
	    }
	    
	    public int deleteLogin(int staff_id) {
	    	int status=0; 
	    	try {
	    		PreparedStatement ps=connection.prepareStatement("delete from cargotransportation.authenticate where staff_id=" +staff_id+ ";");
	    		status =ps.executeUpdate();
	    		ps.close();
	    	
	    }catch(SQLException e) {
	    	e.printStackTrace();
	    }
	    	return status;
	    }
	   
	    public int createAccount(int staff_id,Authenticate auth) {
	    	
	    	int status=0;
	    	try {
	    		PreparedStatement ps=connection.prepareStatement("insert into cargotransportation.authenticate(staff_id,username,password)values(?,?,?)");
	    		//ps.setInt(1, 2);
	    		ps.setInt(1, staff_id);
	    		ps.setString(2, auth.getUsername());
	    		ps.setString(3, auth.getPassword());
	    		status=ps.executeUpdate();
	    		ps.close();
	    		
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}
	    	return status;
	    	
	    }
	    public Authenticate getDatabyId(int temp_id) {
	    	Authenticate auth=new Authenticate();
	    	try {
	    		PreparedStatement ps=connection.prepareStatement("select * from cargotransportation.authenticate where staff_id=" +temp_id+ ";");
	    		ResultSet rs=ps.executeQuery();
	    		if(rs.next()) {
	    			
	    			auth=Auth_mapper.mapper(auth,rs);
	    		}
	    	}catch(SQLException e) {
	    			e.printStackTrace();
	    		}
	    		return auth;
	    	}
	    
	    
	    
	    public int updateAccount(int id,Authenticate auth) {
	    	int status=0;
	    	try {
	    		PreparedStatement ps=connection.prepareStatement("update cargotransportation.authenticate set username=?,password=? where staff_id=" +id+ ";");
	    		ps.setString(1, auth.getUsername());
	    		ps.setString(2, auth.getPassword());
	    		System.out.println(ps.toString());
	    		status=ps.executeUpdate();
	    		ps.close();
	    	}catch(SQLException e) {
	    		e.printStackTrace();
	    	}return status;
	    }
}


