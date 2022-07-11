package Utility;

public enum Department_enum {
	
	KyalGaung(1), Musal(2), Mandalay(3), Yangon(4);
private Department_enum(int i) {
	// TODO Auto-generated constructor stub
}
	public String D(int i) {
		switch (i) {
		case 1: 
			return KyalGaung.toString();
		case 2:
			return Musal.toString();
		case 3:
			return Mandalay.toString();
		case 4:
			return Yangon.toString();
		default:
			throw new IllegalArgumentException("Unexpected value: " + i);
		}
		
		
		//return KyalGaung.toString();
	}
	
	public String toString() {
		switch (this) {
		case KyalGaung:
			return "KyalGaung";
		case Musal:
			return "Musal";
		case Mandalay:
			return "Mandalay";
		case Yangon:
			return "Yangon";
		}
		return "ERROR";
	}
	
	

}
