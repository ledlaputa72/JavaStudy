package toyStore2;

public class Toys {
	
	private String tID;
	private String tName;
	private String tType;
	private int tPrice;
	//Default Constructor
	public Toys() {
		super();
	}
	//Constructor
	public Toys(String tID, String tName, String tType, int tPrice) {
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
	@Override
	public String toString() {
		return tID + "  \t" + tName +  "  \t" + tType +  "    \t" + tPrice ;
	}
	
	

}
