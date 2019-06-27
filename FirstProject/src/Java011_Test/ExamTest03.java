package Java011_Test;

import java.util.*;

class Market{
	private String s_Name;
	private int s_Price;
	private int s_In;
	private int s_Out;
	
	//생성자
	public Market() {
		super();
	}
	
	public Market(String s_Name, int s_Price, int s_In, int s_Out) {
		super();
		this.s_Name = s_Name;
		this.s_Price = s_Price;
		this.s_In = s_In;
		this.s_Out = s_Out;
	}
	
	//setter getter
	public String getS_Name() {
		return s_Name;
	}
	public void setS_Name(String s_Name) {
		this.s_Name = s_Name;
	}
	public int getS_Price() {
		return s_Price;
	}
	public void setS_Price(int s_Price) {
		this.s_Price = s_Price;
	}
	public int getS_In() {
		return s_In;
	}
	public void setS_In(int s_In) {
		this.s_In = s_In;
	}
	public int getS_Out() {
		return s_Out;
	}
	public void setS_Out(int s_Out) {
		this.s_Out = s_Out;
	}

	//출력
	@Override
	public String toString() {
		return "상품이름은 "+this.getS_Name() + ", 가격은 "+this.getS_Price()+", 입고량은 "+this.getS_In()+", 출고량은"+this.getS_Out()+"입니다.";
	}
	
}//Market class end

public class ExamTest03 {

	public static void main(String[] args) {
		
		//1-1.일반 객 내용 입력
		Market m1=new Market();
		m1.setS_Name("우유");
		m1.setS_Price(1200);
		m1.setS_In(500);
		m1.setS_Out(300);

		System.out.println("일반 배열로 1-1 ----------------------------------------");
//		System.out.println(m1.toString());
		for (int i = 0; i < args.length; i++) {
			System.out.println(m1);
		}
		
		//1-2.일반 객체 한번에 입력 
		Market m2=new Market("빵",500,1000,400);
		
		System.out.println("일반 배열로 1-2 ----------------------------------------");
		System.out.println(m2.toString());
		
		//2.Generic Collection으로 생성
		ArrayList<Market> arr1=new ArrayList<Market>();
		
		arr1.add(new Market("과자",700,300,250));
		arr1.add(new Market("쥬스",1000,1300,250));
		arr1.add(new Market("초콜렛",2000,400,150));
		arr1.add(new Market("피자빵",1700,200,50));
		arr1.add(new Market("마늘빵",900,700,150));
		
		System.out.println("컬랙션으로  --------------------------------------------");
		for (int i = 0; i < arr1.size(); i++) {
			System.out.println(arr1.get(i));
		}
		
		System.out.println("컬랙션에서 삼품의 입고량 - 출고량 ------------------------------");
		for (int i = 0; i < arr1.size(); i++) {
			int in=arr1.get(i).getS_In();
			int out=arr1.get(i).getS_Out();
			int div=in-out;
			if (div>out) {
				System.out.println("입고량"+in+"-출고량"+out+"="+div+"입니다.");
			}	
		}
		
		System.out.println("컬랙션에서 검색------------------------------------------");
		Scanner sc=new Scanner(System.in);
		System.out.print("검색이름은 : ");
		String sc1=sc.next();
		for (int i = 0; i < arr1.size(); i++) {
			if (sc1.equals(arr1.get(i).getS_Name())) {
				System.out.println(arr1.get(i));
			}
		}
		
	}

}
