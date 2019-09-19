package Day028_Excption;

import java.util.Scanner;

public class ExcptionEx01 {

	public static void main(String[] args) {
		
		try { ///////////////////////////////////
		Scanner sc1=new Scanner(System.in);
		
		System.out.print("첫번째수는 : ");
		String one1=sc1.nextLine();
		int soo1=Integer.parseInt(one1);
		// int soo1=sc1.nextInt();로 받아도 되지만 데이터형 오류 방지를 위해 Strig->int(feat, paraseInt)해준다.
		
		System.out.print("첫번째수는 : ");
		String two1=sc1.nextLine();
		int soo2=Integer.parseInt(two1);
		
		/*
	 	//main args를 활용한 예시
		int soo1=Integer.parseInt(args[0]);
		int soo2=Integer.parseInt(args[1]);
		*/
		
		System.out.println(soo1/soo2);
		
		}catch(ArithmeticException e){ // 세부 먼저 실행 
			System.out.println("0이 아닌 두개의 정수를 입력하시오");
		}catch(ArrayIndexOutOfBoundsException e){ // 세부 예외 처리는 순서 무관
			System.out.println("2개의 값을 입력하시오");
		}catch(NumberFormatException e) {
			System.out.println("숫자를 입력하세요");
		}catch(Exception e) {////예외 처리 조상
			System.out.println("그밖의 예외를 처리합니다. ");
			System.out.println(e); //.toString())
			System.out.println(e.getMessage());
			//c언어 : errno방에 4069가 들어감 : message
		}
		finally { // 생략 가능
			System.out.println("여기는 무조건 수행");
		}

	}

}
