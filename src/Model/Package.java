package Model;

public class Package {
private String package_id;
private Order order;
private Weight weight;
public Package() {

}
public Package(String package_id, Order order, Weight weight) {
	
	this.package_id = package_id;
	this.order = order;
	this.weight = weight;
}
public String getPackage_id() {
	return package_id;
}
public void setPackage_id(String package_id) {
	this.package_id = package_id;
}
public Order getOrder() {
	return order;
}
public void setOrder(Order order) {
	this.order = order;
}
public Weight getWeight() {
	return weight;
}
public void setWeight(Weight weight) {
	this.weight = weight;
}



}
