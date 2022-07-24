package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Authenticate;

public class Auth_mapper {
	public static Authenticate mapper(Authenticate auth,ResultSet rs) {
		try {
			
			auth.setUsername(rs.getString("username"));
			auth.setPassword(rs.getString("password"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	return auth;	
	}

}
