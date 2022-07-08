package mapper;

import java.sql.ResultSet;

import Model.destination;

public class destination_mapper {
	public static destination mapper(destination dest, ResultSet rs){
		 try {
			 dest.setId(rs.getInt("destination_id"));
	            dest.setDestinationname(rs.getString("destinationname"));
	            dest.setPrice(rs.getInt("price"));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return dest;
	           
}
}

	
