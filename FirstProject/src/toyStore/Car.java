package toyStore;
//Car 종류 자식 객체
public class Car extends Toy {

	private String pName;
	private int pPrice;
	
	//디폴트 생성자
	public Car(String pID, String pType) {
		super(pID, pType);
	}
	//생성자
	public Car(String pID, String pType, String pName, int pPrice) {
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
