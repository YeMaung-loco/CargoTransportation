package Model;

public class Customer {
	private String name;
	private String phone;
	private String address;
	private int id;

	public Customer() {

	}

	public Customer(String name, String phone, String address) {
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

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public void setId(int id) {
		this.id = id;// TODO Auto-generated method stub

	}
	public int getId() {
		return id;
	}

}
