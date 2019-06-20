package java007_Date;

import java.util.*;

class SMarket{
	private String sangpum;
	private int price;
	
	//생성자
	public SMarket() { //this("나 빈칸", 0)
	}
	public SMarket(String sangpum, int price) {
		this.sangpum = sangpum;
		this.price = price;
	}
	//toString 출력 메소드
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
		
		//객체를 넣어보자 /////////////////////
		arr3.add(new SMarket("우유",1000)); //class 필요 
		System.out.println(arr3.get(4));//추가한 객체 클래스만 출력해 보기 
		//get(4).toString() 
		
		arr3.set(1, "과자"); //1번째에 "과자"를 넣어라 , 1번째 내용이 지워지고 "과자"가 들어감 
		arr3.remove(2); //2번째를 지움 
		
		for (int i = 0; i < arr3.size(); i++) {
			System.out.print(arr3.get(i)+"\t");
		}
		System.out.println();
		
		//Generic////////////////////////
		ArrayList<String> arr1=new ArrayList<String>();
		System.out.println(arr1.size()); //0
		
		arr1.add("빵");
		arr1.add("라면");
		arr1.add("우유");
		arr1.add("김밥");
		//arr1.add(30);//에러 발생, String이 아닌 int
		
		arr1.set(1,"과자"); //라면 -> 과자
		arr1.remove(2);//우유 삭제
		arr1.remove("빵"); //빵 삭제 
		
		for (int i = 0; i < arr1.size(); i++) {
			System.out.print(arr1.get(i)+"\t");
		}
		System.out.println();
		
		for(String imsi:arr1) {
			System.out.println(imsi); //과자 김밥
		}
		
		
	} //main end
}//class end
