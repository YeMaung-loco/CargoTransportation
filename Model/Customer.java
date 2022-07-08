package Model;

public class Customer {
private String name;
private int phone;
private String address;
private int id;

public Customer() {
	
}


public Customer(String name, int phone, String address) {
	super();
	this.name = name;
	this.phone = phone;
	this.address = address;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public int getPhone() {
	return phone;
}
public void setPhone(int phone) {
	this.phone = phone;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}


public void setId(int id) {
	this.id=id;// TODO Auto-generated method stub
	
}

}
