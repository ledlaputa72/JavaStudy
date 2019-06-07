import java.util.Scanner;

public class DataType {

	public static void main(String[] args) {
/*		
		  int aa=100; System.out.println(aa);		  
		  short bb=200; System.out.println(bb);
		  byte cc=10; System.out.println(cc);
		  long dd=12012344123L; System.out.println(dd);
		  double ee=1231.233; System.out.println(ee);
		  float ff=123.34f; System.out.println(ff);
		  boolean gg=true; System.out.println(gg);
		  char hh='A'; System.out.println(hh);		  
		  String str="ondal"; 
		  
		  System.out.println(str);
*/		  
		
/*
		  int a1=50;		  
		  int a2=70;
		  int a3=a1+a2; 
		  //a3=50+70과 동일, =의 의미 1)대입(우 -> 좌로), 2)같냐
		  int a4=a3*1000; 
		  // 변수와 수 곱하기
		  
		  System.out.println("계산 결과는 "+a3+" , "+a4);
		  
		  //자바에서 +는 붙여준다.답은 : 계산 결과는 120 ,120000
*/

		  // #문제) 달에서의 몸무게는 지구에서의 몸무게의 17%라고 할때, 달에서의 몸무게를 구하는 프로그램을 작성하시오
		  /*
		  int mom=85; // 내 몸무게
		  
		  float moon=0.17f; // 연산 방식 1) 달의 무게 연산 17%, 출력에서 계산
		  System.out.println("내 몸무게 = "+mom+"키로그램, 달에서 몸무게 ="+(mom*moon)+"키로그램");
		  
		  double dalmom=mom*0.17; // 연산 방식 2) 변수에 계산을 하여 출력
		  System.out.println("내 몸무게 = "+mom+"키로그램, 달에서 몸무게 ="+(dalmom)+"키로그램");
		  */
		
		// 문제2
		/*
		int a=10;
		int b=7;
		double c=(a*b)/2;
		
		System.out.println("밑변="+a+", 높이="+b+" 일때, 삼각형의 넓이는 "+c+"이다");
		*/
		
		//문제 3 
		// double cel=22; //섭씨 온도
		
		
		Scanner sc1= new Scanner(System.in); // 키보드 입력
		
		System.out.print("이름을 입력하세요.: ");
		String name = sc1.next();
		
		System.out.print("섭씨 온도를 입력하세요.: ");
		double cel = sc1.nextDouble();
		
		double fah=(cel*9/5)+32; //화씨를 구하는 공식 
		
		System.out.println(name+"님 반갑습니다.");
		System.out.println("온도 변화 : 섭씨="+cel+"도 일때, 화씨="+fah+"도 입니다.");
		
		
		
	}

}










