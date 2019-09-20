package toyStore;

public class Toy {

	private String pID;
	private String pType;
	
	public Toy(String pID, String pType) {
		super();
		this.pID = pID;
		this.pType = pType;
	}

	public String getpID() {
		return pID;
	}

	public void setpID(String pID) {
		this.pID = pID;
	}

	public String getpType() {
		return pType;
	}

	public void setpType(String pType) {
		this.pType = pType;
	}
	
	
	
}
