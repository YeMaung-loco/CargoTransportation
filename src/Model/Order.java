package Model;

import java.util.List;

public class Order {
private int order_id;
private  Destination  destination;
private Weight weight;
private Customer customer;
private int transportationfees;
private List<Package> packageList;
public Order() {
	
}
public List<Package> getPackageList() {
	return packageList;
}
public void setPackageList(List<Package> packageList) {
	this.packageList = packageList;
}
public Order(int order_id, Destination destination, Weight weight,Customer customer,Package packageList,int transfees) {
	
	this.order_id = order_id;
	this.destination = destination;
	this.weight = weight;
	this.customer=customer;
	this.transportationfees=transfees;
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
public Customer getcustomer(){
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer=customer;
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
