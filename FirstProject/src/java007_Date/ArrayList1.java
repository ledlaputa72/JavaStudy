package java007_Date;

import java.util.*;

class SMarket{
	private String sangpum;
	private int price;
	
	public SMarket(String sangpum, int price) {
		this.sangpum = sangpum;
		this.price = price;
	}
	
	public String toString() {
		return "슈퍼의 상품은 :"+sangpum+", 값은 "+price;
	}
}

public class ArrayList1 {

	public static void main(String[] args) {

		ArrayList arr3=new ArrayList(); 
		//다양한 데이터형 입력하기 ///////////////
		arr3.add(new Integer(300)); //정수
		arr3.add(new Double(34.7)); //실수
		arr3.add("dayday"); //문자열
		arr3.add('강'); //char 
		
		for (int i = 0; i < arr3.size(); i++) {
			System.out.print(arr3.get(i)+"\t");
		}
		System.out.println();
		
		//객체를 넣어보자 /////////////////////
		arr3.add(new SMarket("우유",1000)); //class 필요 
		System.out.println(arr3.get(4));//추가한 객체 클래스만 출력해 보기 
	} //main end
}//class end
