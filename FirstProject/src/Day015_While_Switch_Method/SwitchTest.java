package Day015_While_Switch_Method;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {

		Scanner sc1=new Scanner(System.in);
		
		
//		//예제코드) 
//		System.out.println("어디로 갈래?");
//		int kab=sc1.nextInt();
//		
//		switch(kab) {
//		case 1: // kab>3 x
//			System.out.println("종로로 가자");
//			break;
//		case 2: // 
//			System.out.println("강남으로 가자");
//			break;
//		default:
//			System.out.println("바다로 가자");
//			break;
//		}
				
//		// 문제1) 
//		System.out.println("학점을 입력하세요");
//		int score1 = sc1.nextInt();
//		
//		int score = score1/10;
//		
//		switch (score) {
//		case 10:
////			System.out.println("A학점");
////			break;
//		case 9:
//			System.out.println("A학점");
//			break;
//		case 8:
//			System.out.println("B학점");
//			break;
//		case 7:
//			System.out.println("C학점");
//			break;
//		case 6:
//			System.out.println("D학점");
//			break;	
//
//		default:
//			System.out.println("F학점");
//			break;
//		}
		
		// 문제2) 날짜 계산하기
		System.out.println("월을 입력하세요");
		int days = sc1.nextInt();
		// int days = Integer.parseInt(sc1.next()); // 입력 받은 데이터를 int로 변환 시켜주는 형변환
		
		System.out.print(days+"월의 날은 ");
		switch (days) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31일입니다. ");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30일입니다.");
		default: 
			System.out.println("28일입니다.");
			break;
		}		
		
		
		
		
	}

}
