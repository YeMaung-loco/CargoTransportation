package mapper;

import java.sql.ResultSet;

import Model.Destination;

public class Destination_mapper {
	public static Destination mapper(Destination dest, ResultSet rs){
		 try {
			 dest.setId(rs.getInt("destination_id"));
	            dest.setDestinationname(rs.getString("destination_name"));
	            dest.setPrice(rs.getInt("destination_price"));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return dest;
	           
}
}

	
