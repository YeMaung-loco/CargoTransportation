package mapper;

import java.sql.ResultSet;

import Model.Weight;

public class Weight_mapper {
	public static Weight mapper(Weight w, ResultSet rs){
		 try {
			 w.setId(rs.getInt("weightPrice_id"));
	            w.setWeight_kg(rs.getInt("weight_kg"));
	            w.setWeightprice(rs.getInt("weightprice"));
		 }catch(Exception e) {
			 e.printStackTrace();
		 }
		 return w;
	           
}
}

	
