package Model;

public class destination {

	private int price;
	private String destinationname;
	private int id;

	public destination() {

	}

	public destination(int price, String destinationname) {
		super();
		this.price = price;
		this.destinationname = destinationname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getDestinationname() {
		return destinationname;
	}

	public void setDestinationname(String destinationname) {
		this.destinationname = destinationname;
	}

	public void setId(int id) {
		this.id=id;
		// TODO Auto-generated method stub
		
	}

}
