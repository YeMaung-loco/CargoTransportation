package Model;

public class Weight {
	private int weightprice;
	private int weight_kg;
	private int id;

	public Weight() {

	}

	public Weight(int weightprice, int weight_kg) {
		super();
		this.weightprice = weightprice;
		this.weight_kg = weight_kg;
	}

	public int getWeightprice() {
		return weightprice;
	}

	public void setWeightprice(int weightprice) {
		this.weightprice = weightprice;
	}

	public int getWeight_kg() {
		return weight_kg;
	}

	public void setWeight_kg(int weight_kg) {
		this.weight_kg = weight_kg;
	}

	public void setId(int id) {
		this.id=id;
		// TODO Auto-generated method stub
		
	}
	public int getId() {
		return this.id;
	}

}
