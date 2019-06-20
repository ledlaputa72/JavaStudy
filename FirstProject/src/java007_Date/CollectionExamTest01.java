package java007_Date;

import java.util.*;

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
		return "상품이름은 "+sangpum+"이고, 가격은 "+price+"이고, 상품의 매대 위치는 "+wichi+"입니다.";
	}
	
} //SMarket class end


public class CollectionExamTest01 {

	public static void main(String[] args) {

		//ArrayList가 먼저 있어야 한다.
		ArrayList<SMarket1> arr1=new ArrayList<SMarket1>();
		
		//.add를 통해 값을 입력 
		arr1.add(new SMarket1("요쿠르트",2000,"A")); //집어 넣을때 .add
		//System.out.println(arr1.get(0)); //꺼낼때 .get
		arr1.add(new SMarket1("서울우유",2500,"A"));
		arr1.add(new SMarket1("액티비아",3500,"A"));
		arr1.add(new SMarket1("이오",2000,"A"));
		arr1.add(new SMarket1("매일우유",2300,"A"));
		arr1.add(new SMarket1("남양우유",2300,"A"));
		arr1.add(new SMarket1("서울치즈",4000,"B"));
		arr1.add(new SMarket1("코카콜라",1500,"C"));
		arr1.add(new SMarket1("스프라이트",1400,"C"));
		arr1.add(new SMarket1("썬키스트",4500,"D"));
		
		System.out.println("=================등록된 제품은===================");
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
		
		//검색
		//가격이 3500원 이상인 것을 모두 출력하시오 
		System.out.print("검색할 상품명을 입력하세요 : ");
 		
 		Scanner sc=new Scanner(System.in);
 		String sc1=sc.next();
	
		System.out.println("==============3500원 이상인 제품은=================");
		for (int i = 0; i < arr1.size(); i++) {
				if (sc1.equals(arr1.get(i).getSangpum())) {
					System.out.println("검색된 상품은 "+arr1.get(i));
					System.out.print("이름을 수정하세요 : ");
					String sc11=sc.next();
					System.out.print("가격을 수정하세요 : ");
					int sc12=sc.nextInt();
					System.out.print("매대를 수정하세요 : ");
					String sc13=sc.next();
					
					arr1.set(i, new SMarket1(sc11, sc12, sc13));
					System.out.println("수정된 "+arr1.get(i));
				}
			}
		
	}// main end

}//class end
