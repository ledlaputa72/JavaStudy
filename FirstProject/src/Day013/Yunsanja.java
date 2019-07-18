package Day013; // 패키지

import java.util.Scanner;

public class Yunsanja { //java class

	public static void main(String[] args) {

		/*
		System.out.println(10+38);
		System.out.println(30*2);
		System.out.println(10/3);
		System.out.println(10%3);
		*/
		
		/*
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("수를 입력하세요. : ");	
		int a=sc1.nextInt();
		
		System.out.print("나눌수를 입력하세요. : ");
		int b=sc1.nextInt();
		
		double c=a%b;
				
		System.out.println(a+"를 "+b+"로 나눈  나머지는"+c+"이다");
		System.out.println(a+"는 "+b+"의 배수인가? ");
		System.out.println(c==0); 
		*/
		
//		System.out.println(27%2==0); // 27을 2로 나눈 나머지가 0이냐? 
		
//		System.out.println(3>5 && 7>3);
		
		/*
		// 윤년 , 1년은 365.2422일, 0.2422*4=0.96 = 약 1일 / 4년마다 윤년이 발생 / 100년에 평년으로 / 400년에 한번씩은 다시 윤년 
		// 4의 배수이면 윤년, 100의 배수이면 평년, 400의 배수이면 윤년 
		
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("년도를 입력하세요. : ");	
		int year1=sc1.nextInt();
		
		System.out.println(year1%4==0 && year1%100!=0 || year1%400==0);
		*/
		
		/*
		int aaa1=30;
		String yokiro = (aaa1>=100) ? "100보다 크네 " : "100보다 작네"; // 3항 연산자에 변수를 할당 
		System.out.println(yokiro);
		*/
		
		/*
		int kk=100;
		kk=kk+1; //101 (kk = 100+1 )
		kk=kk+1; //102
		kk=kk-1; //101
		
		kk++; // kk=kk+1;과 동일 
		++kk; // kk++와 동일
		
		System.out.println(kk); //103
		
		kk--; // kk=kk-1;과 동일 
		--kk; // kk--와 동일 
		*/		
		/*
		int yy1=300;
		yy1++;
		System.out.println(yy1); // 301
		
		
		yy1=yy1+3; //yy1++3(x) 오로지 1씩 증가할 때만 
		yy1+=3; // yy1=yy1+3과 동일 
		
		yy1=yy1*2;
		yy1*=2; //yy1=yy1*2;와 동일
		*/
		
		//1번 방식
		int yy2=300;
		yy2++;
		System.out.println(yy2); // 301
		
		//2번 방식 
		System.out.println(++yy2); // 302, 위 82,83을 합친 표현
		System.out.println(yy2++); // 303이 아니라 302가 나옴		
		System.out.println(yy2); // 303이 나옴 
		
		System.out.println(((3+6)*7)-23/(45*3));
		
	}

}
