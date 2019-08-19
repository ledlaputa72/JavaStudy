package toyStore;

public class Robot extends Toy{

	private String pName;
	private int pPrice;
	//������
	public Robot(String pID, String pType) {
		super(pID, pType);
	}
	//������
	public Robot(String pID, String pType, String pName, int pPrice) {
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
		return  "|���̵�: " + getpID() +"|�̸� : " + getpName() + "|���� : " + getpType()+"|���� : " + getpPrice()+"|";
	}

	
}
