package java010_Toy;

public class Toy {
	private String tID;
	private String tType;
	
	//����Ʈ ������
	public Toy() {
		super();
	}
	//������
	public Toy(String tID, String tType) {
		super();
		this.tID = tID;
		this.tType = tType;
	}
	
	//getter setter
	public String gettID() {
		return tID;
	}
	public void settID(String tID) {
		this.tID = tID;
	}
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	
}
