package java010_Toy;

public class ToyClass {
	String tID;
	String tName;
	String tType;
	int tPrice;
	
	//디폴트 생성자
	public ToyClass() {
		super();
	}
	//생성자
	public ToyClass(String tID, String tName, String tType, int tPrice) {
		super();
		this.tID = tID;
		this.tName = tName;
		this.tType = tType;
		this.tPrice = tPrice;
	}
	
	//getter setter
	public String gettID() {
		return tID;
	}
	public void settID(String tID) {
		this.tID = tID;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	public int gettPrice() {
		return tPrice;
	}
	public void settPrice(int tPrice) {
		this.tPrice = tPrice;
	}
}
