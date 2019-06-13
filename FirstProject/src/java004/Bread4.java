package java004;

import java.util.Scanner;

class BBang4 { 
	private String jong; // 객체 속성 
	private int ka;
	
	public BBang4(String jong, int ka) { // 생성자1, 오버로딩 b1에 적용
		this.jong=jong;
		this.ka=ka;
	}
	
	public BBang4(String jong) { //생성자3, 오버로딩 b3,4 객체용
//		this.jong=jong;
//		this.ka=700;
		this(jong,700); //생성자에서 다른 생성자를 호출 (생성자 중에 인자가 2개 있는 생성자1을 찾아간다) 
	}
	
	public BBang4(int ka) { // 생성자2, 오버로딩 b2 객체용
		this("담는데로행사빵", ka);
	}

	public String getJong() {
		return jong;
	}
	public void setJong(String jong) {
		this.jong = jong;
	}
	public int getKa() {
		return ka;
	}
	public void setKa(int ka) {
		this.ka = ka;
	} 

	//출력전문 메소드 -1 (일반적인 방법) 
	public void print1() { //이 방법은 종류와 가격(객체 속성)이 public일때 가능하다. 
//		System.out.println("빵이름은 "+jong+"이고, 가격은 "+ka+"입니다."); //jong or this.jong 모두 가능에러
//		System.out.println("빵이름은 "+b1.getJong+"이고, 가격은 "+b1.getKa+"입니다."); //에러
		System.out.println("빵 이름은 "+this.getJong()+", 가격은 "+this.getKa()+"입니다."); 
		//this.getJong BBang4에 있는 getJong을 의미 
	}
	//출력전문 메소드 -2 (자주 사용하는 방법) 
	public String toString() { //조상이 가지고 있는 toString()을 오버라이딩(재정의) 하는 방법, 반환형 있음
		return "[빵 이름은]"+this.getJong()+", [가격은]"+this.getKa();
		// 20+30=50   "20"+"30"=2030  "20"+30=2030
	}
	
} //BBang4 end

public class Bread4 {
	public static void main(String[] args) {
		BBang4 b1=new BBang4("소보로빵",3000); // 객체를 만들면서 초기치를 넣고 싶을때, 생성+초기치
//		System.out.println(b1.getJong()); 
//		System.out.println(b1.getKa());
//		b1.print1(); //객체.메소드, 출력 메소드를 이용한 방법
		
		System.out.println(b1.toString()); //b1.toString은 값을 전달 받지만 찍는건 sysout으로
		System.out.println(b1); //뒤에 toString 있는것으로 간주해서 작동
		
//		BBang4 b2=new BBang4(); //초기치 없이 생성만 넣는 경우  (디폴트 생성자를 안만들어 주고 있다. 위쪽 때문에)
		
		//this() 활용
		System.out.println("=== 개업3주년 기념 무조건 700원 ===");
		BBang4 b3=new BBang4("치즈빵"); //생성자에서 가격은 700으로 통일 
		System.out.println(b3);
		
		BBang4 b4=new BBang4("케잌빵");
		System.out.println(b4);
		
		System.out.println("=== 개업5주년 기념 담는데로 사장이 가격정함 ===");
		BBang4 b5=new BBang4(7800);
		BBang4 b6=new BBang4(13000);
		System.out.println(b5);
		System.out.println(b6);
		
	}
} // Bread4 end
