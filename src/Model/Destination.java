package Model;

public class Destination {

	private int price;
	private String destinationname;
	private int id;

	public Destination() {

	}

	public Destination(int price, String destinationname) {
		this.price = price;
		this.destinationname = destinationname;
	}

	public int getPrice() {
		return this.price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDestinationName() {
		return destinationname;
	}

	public void setDestinationName(String destinationname) {
		this.destinationname = destinationname;
	}

	public void setId(int id) {
		this.id=id;
		// TODO Auto-generated method stub
		
	}
	public int getId() {
		return this.id;
	}

}
