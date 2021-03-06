package toyStore;

public class Puzzle extends Toy{

	private String pName;
	private int pPrice;
	//생성자
	public Puzzle(String pID, String pType) {
		super(pID, pType);
	}
	//생성자
	public Puzzle(String pID, String pType, String pName, int pPrice) {
		super(pID, pType);
		this.pName = pName;
		this.pPrice = pPrice;
	}
	//getter setter
	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpPrice() {
		return pPrice;
	}

	public void setpPrice(int pPrice) {
		this.pPrice = pPrice;
	}
	
	@Override
	public String toString() {
		return  "|아이디: " + getpID() +"|이름 : " + getpName() + "|종류 : " + getpType()+"|가격 : " + getpPrice()+"|";
	}
}
