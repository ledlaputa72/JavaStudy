package java007_Date;

//Ŭ���� 
class SMarket1{ 
	private String sangpum;
	private int price;
	private String wichi;

	public SMarket1() { //default ������
		
	}
	
	public SMarket1(String sangpum, int price, String wichi) { //������
		super();
		this.sangpum = sangpum;
		this.price = price;
		this.wichi = wichi;
	}
	
	//getter setter
	public String getSangpum() {
		return sangpum;
	}
	public void setSangpum(String sangpum) {
		this.sangpum = sangpum;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getWichi() {
		return wichi;
	}
	public void setWichi(String wichi) {
		this.wichi = wichi;
	}
	
	/*
	@Override //�ڵ����� ������ toString, @Override�� �ڵ����� �����Ǿ����� ��Ÿ����. 
	public String toString() {
		return "SMarket1 [sangpum=" + sangpum + ", price=" + price + ", wichi=" + wichi + "]";
	}
	*/	
	
	//toString ��� �޼ҵ�
	public String toString() {
		return "������ ��ǰ "+sangpum+"�� ������ "+price+"�̰�, ��ǰ�� �Ŵ� ��ġ�� "+wichi+"�Դϴ�.";
	}
	
} //SMarket class end


public class CollectionExamTest01 {

	public static void main(String[] args) {

		
		
	}

}
