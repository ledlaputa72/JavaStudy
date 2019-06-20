package java007_Date;

//클래스 
class SMarket1{ 
	private String sangpum;
	private int price;
	private String wichi;

	public SMarket1() { //default 생성자
		
	}
	
	public SMarket1(String sangpum, int price, String wichi) { //생성자
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
	@Override //자동으로 생성한 toString, @Override는 자동으로 생성되었음을 나타낸다. 
	public String toString() {
		return "SMarket1 [sangpum=" + sangpum + ", price=" + price + ", wichi=" + wichi + "]";
	}
	*/	
	
	//toString 출력 메소드
	public String toString() {
		return "슈퍼의 상품 "+sangpum+"의 가격은 "+price+"이고, 상품의 매대 위치는 "+wichi+"입니다.";
	}
	
} //SMarket class end


public class CollectionExamTest01 {

	public static void main(String[] args) {

		
		
	}

}
