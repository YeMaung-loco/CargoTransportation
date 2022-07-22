package Model;

import java.sql.Date;

public class Order {
	String order_no;
	Destination destination;
	Customer customer;
	int transportationfees;
	Date date;
	boolean assign;
	String status;

	public Order() {
	//	this.assign = false;
	}

	public Order(String order_no, Destination destination, Customer customer, int transfees) {

		this.order_no = order_no;
		this.destination = destination;
		this.customer = customer;
		this.transportationfees = transfees;
	}

	public int getTransportationfees() {
		return transportationfees;
	}

	public void setTransportationfees(int transportationfees) {
		this.transportationfees = transportationfees;
	}

	public String getOrder_no() {
		return this.order_no;
	}

	public void setOrder_no(String order_no) {
		this.order_no = order_no;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Destination getDestination() {
		return this.destination;
	}

	public void setDestination(Destination dest) {
		this.destination = dest;
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

	public void setAssign(boolean assigning) {
		this.assign = assigning;
	}

	public String getStatus() {
		return this.status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}