package Model;

import java.sql.Date;

public class Order {
	private int order_id;
	private Destination destination;
	private Customer customer;
	private int transportationfees;
	Date date;

	public Order() {

	}

	public Order(int order_id, Destination destination, Customer customer, int transfees) {

		this.order_id = order_id;
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

	public int getOrder_id() {
		return order_id;
	}

	public void setOrder_id(int order_id) {
		this.order_id = order_id;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Destination getDestination() {
		return destination;
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

}