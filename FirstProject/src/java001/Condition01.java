package java001;

import java.util.Scanner;

public class Condition01 {

	public static void main(String[] args) {
		//조건문 
		//if 1형식
		/*
		if(aa>3)
		{
			System.out.println("aa가 3보다 크다 ");
		}
		
		//if 2형식
		if(bb>3)
		{
			System.out.println("bb가 3보다 크다 ");
		}
		else
		{
			System.out.println("bb가 3보다 작다");
		}
		*/
		
		/*
		// 210이 3의 배수냐
		int cc = 210;
		
		if(cc%3==0) {
			System.out.println("3의 배수이다");
		}
		else
		{
			System.out.println("3의 배수가 아니다 ");
		}
		
		
		if(cc%3==0) 
			System.out.println("3의 배수이다");
		else
			System.out.println("3의 배수가 아니다 ");
		 */
		
		/*
		//비만도 BMI 
		// 
		Scanner bmiIn = new Scanner(System.in);
		
		System.out.println("당신의 몸무게를 입력하세요 : ");
		float bmi1= bmiIn.nextFloat();

		System.out.println("당신의 키를 미터로 입력하세요 ");
		float bmi2= bmiIn.nextFloat();

		float bmi3=bmi2/100; // 미터키로 바꾸기 
		
		float bmi = bmi1 / (bmi3*bmi3); 
		System.out.println("당신의 BMI 지수는 " +bmi+"입니다.");
		

		if ( 30.0 <= bmi) {
			System.out.println("비만입니다.");
		}
		else if (25.0 <= bmi && bmi < 30.0)
		{
			System.out.println("과체중입니다.");
		}
		else if(20.0 <= bmi && bmi < 25.0 )
		{
			System.out.println("정상입니다.");
		}
		else
		{
			System.out.println("저체중. ");
		}
		*/
		
		/*
		//배수 입력 확인 문제 
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("수를 입력하세요 : ");
		// int num= sc1.nextInt(); // 기본적인 방식 
		String num0=sc1.next(); // String으로 입력 받는다. 
		int num=Integer.parseInt(num0); // int로 변환한다. 
		
		if (num%3 == 0 && num%5 == 0)
			System.out.println("앗싸");
		else if (num%3 == 0)
			System.out.println("오예");
		else if (num%5 == 0)
			System.out.println("뭐야");
		*/
		
		
		// 형변환
		
		int aaa=2147483647;
		// int aaa2=2147483648; // 범위 초과 에러 
		int ccc=1;
		int aaa5=aaa+ccc; // 범위 초과이나 에러표시가 안됨 
		
		System.out.println(aaa5);
		
		
	}

}
