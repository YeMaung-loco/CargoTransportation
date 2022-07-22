package Model;

import java.sql.Date;

public class OrderAssign extends Order{
	
	boolean assign;

	public OrderAssign() {

		this.assign=false;
	}

	public OrderAssign(String order_no, Destination destination, Customer customer, int transfees) {

		super( order_no,  destination,  customer,  transfees);
		this.assign=false;
		
	}
	
	public void setDate(Date date) {
		this.date = date;
	}

	public Date getDate() {
		return this.date;
	}

	public boolean getAssign() {
		return this.assign;
	}

	public void setAssign(boolean assign) {
		this.assign = assign;
	}

}