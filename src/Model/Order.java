package Model;

import java.util.List;

public class Order {
private int order_id;
private  Destination  destination;
private Weight weight;
private Customer customer;
private List<Package> packageList;
public Order() {
	
}
public Order(int order_id, Destination destination, Weight weight) {
	super();
	this.order_id = order_id;
	this.destination = destination;
	this.weight = weight;
}
public int getOrder_id() {
	return order_id;
}
public void setOrder_id(int order_id) {
	this.order_id = order_id;
}
public Destination getDestination() {
	return destination;
}
public void setDestination(Destination dest) {
	this.destination = dest;
}
public Weight getWeight() {
	return weight;
}
public void setWeight(Weight w) {
	this.weight = w;
}



}
