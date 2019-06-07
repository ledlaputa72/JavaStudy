package java001;

import java.util.Scanner;

public class DoWhile {

	public static void main(String[] args) {

		Scanner sc1= new Scanner(System.in);
		
//		// 메뉴가 나오는 프로그램 
//		int menu=0;
//		
//		do {
//			System.out.println("중국집에 오신것을 환영합니다. ");
//			System.out.println("1.짜장");
//			System.out.println("2.짭뽕");
//			
//			System.out.println("원하시는 메뉴를 고르세요");
//			int food1=sc1.nextInt();
//			
//			if(food1==1) {
//				System.out.println("1.짜장, 맛있게 드세요 ");
//				menu=1;
//			}
//			else if(food1==2) {
//				System.out.println("2.짬뽕, 맛있게 드세요");
//				menu=1;
//			}
//			else {
//			}
//
//		} while (menu==0);
		
		
//		// 선생님 풀이 
//		int sun1;
//		do {
//			System.out.println("1.짜장");
//			System.out.println("2.짭뽕");
//			sun1=Integer.parseInt(sc1.next()); // nextInt가 반복되면 오류가 발생해서 char로 받아 int로 변환한다. 
//		} while(sun1!=1 && sun1!=2); //1 or 2의 반대 --> !1 && !2
//		
//		System.out.println("맛있게 드세요");
		
		/*
		// ###########################
		// int 대신 string 으로  입력받아 처리 --> 아래는 답이 안나옴 (에러 발생)
		String sun1; //
		do {
			System.out.println("1.짜장");
			System.out.println("2.짭뽕");
			sun1=sc1.next(); //
			System.out.println(sun1);
		} while(sun1!="1" && sun1!="2");
		
		System.out.println("맛있게 드세요");
		
		//#######################
		// int 대신 String 입력 받기 정답 
		String aa="ondal"; //Stack aa(1000번 주소) -> heap 1000 ("ondal")
		String bb="ondal"; //Stack bb(2000번 주소) -> heap 2000 ("ondal")로 기억되지 않고, 
							//이미 있는 heap1000("ondal")을 사용해서 Stack bb(1000번 주소)로 기억한다. 
							// aa와 bb는 heap의 번지도 같고, 값도 같다. 
		if(aa==bb) { // 번지가 같다. 번지 비교
			System.out.println("==갑네");
		}
		if(aa.equals(bb)) { // 함수, 메소드 , 값이 같다. 값 비교
			System.out.println("equals 같네");
		}
		// 번지와 값이 모두 같다. 
		
		//#########################
		// 값이 틀린경우 
		String aa2="ondal1";  
		String bb2="ondal2";  // 값이 틀리다. 
		
		if(aa2==bb2) { // 번지 비교 
			System.out.println("==갑네");
		}
		if(aa2.equals(bb2)) { // 값 비교
			System.out.println("equals 같네");
		}
		// 번지와 값이 모두 틀리다. 
		
		
		//##############################
		// String cc="ondal";
		String cc=new String("ondal");
		String dd=new String("ondal"); // 번지는 틀리지만 값이 같다 
		if(cc==dd) {
			System.out.println("cc==dd같네");
		}
		if(cc.equals(dd)) {
			System.out.println("cc.eqauls(dd)같네");
		}
		// 값이 같다. 
		*/
		
		// int 대신 string 으로  입력받아 처리 --> 아래는 답이 안나옴 
		String sun2; //
		do {
			System.out.println("1.짜장");
			System.out.println("2.짭뽕");
			sun2=sc1.next(); //
		} while(!sun2.equals("1") && !sun2.equals("2")); //번지를 비교
		System.out.println("맛있게 드세요");
		//번지는 틀리지만 값이 같으므로 
		
		
	}

}
