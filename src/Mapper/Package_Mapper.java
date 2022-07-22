package Mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import Model.Package;
import Model.Weight;

public class Package_Mapper {
	public static Package mapper(Package pack, ResultSet rs) {

	        try {
	        	pack.setPackage_id(rs.getString("package_no"));
	        	pack.setWeight(rs.getInt("weight_kg"));
//	        	Weight weight=new Weight();
//	        	weight.setWeight_kg(rs.getInt("package_weight"));
//	        	pack.setWeight(weight);
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	        return pack;
	    }
	 }
	

