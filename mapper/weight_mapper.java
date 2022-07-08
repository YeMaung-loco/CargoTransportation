package mapper;

import java.sql.ResultSet;

import Model.weight;

public class weight_mapper {
	public static weight mapper(weight w, ResultSet rs){
		 try {
			 w.setId(rs.getInt("weight_id"));
	            w.setWeight_kg(rs.getInt("weight_kg"));
	            w.setWeightprice(rs.getInt("price"));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return w;
	           
}
}

	
