package java001;

import java.util.Scanner;

//반복문 

public class Repeat {

	public static void main(String[] args) {
		/*
		for (int i = 1; i <=25; i++) {
			System.out.println("왕복달리기"+i);
		}
		// System.out.println(i); // 에러 발생 {}를 벗어나면 i는 파괴단다.
		*/
		/*
		for (int i = 1; i <=10; i++) {
			System.out.println("I love you "+i);
		}
		*/
		
		// 구구단의 5단 출력 
//		for (int i = 1; i <=9; i++) {
//				System.out.println("5*"+i+" = "+(5*i));
//			}
		
		/*
		// 학년 반 찍기 
		 for (int i = 1; i <= 3; i++) {
			 System.out.println("===="+i+"학년 =====");
			 System.out.println("학년-반");
             for (int j = 1; j <= 2; j++) {
                  System.out.println(i+" - "+j);
             }
        }
        */
		 
		/*
		 //개인 연습과제 : 피라미드 그리기 
		 for (int i = 0; i <= 5; i++) {
			 for (int j = 1; j <= 5-i; j++) {
				System.out.print(" ");
			}
			 for (int k = 1; k <= i*2+1; k++) {
					System.out.print("*");
				}
			 System.out.println();
		 }
		 */
			
		
			 
		/*
		 // 문제2) 별 박스 만들기 		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		 */
		
		/*
		 //문제3) 별 피라미드 만들기 
		 for (int i = 1; i <= 5; i++) {
			 for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			 System.out.println();
		 }
		 */
		
		/*
		//문제4) 직각 역삼각형 만들기 
		 for (int i = 0; i <= 5; i++) {
			 for (int k = i; k <= 5; k++) {
			//for(int j=6-1; j>=1; j--){
					System.out.print("*");
				}
			 System.out.println();
		 }
		 
		 for (int i = 1; i <= 5; i++) {
			 for (int l = 1; l <= (6-i); l++) {
					System.out.print("*");
				}
			 System.out.println();
		 }
		
		 for (int i = 5; i >= 1; i--) {
			 for (int m = 1; m <= i; m++) {
					System.out.print("*");
				}
			 System.out.println();
		 }
		 */
		
		/*
		// 과제1)
		 for (int i = 0; i <= 5; i++) {
			 for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}
			 for (int k = i; k <= 4; k++) {
					System.out.print("*");
				}
			 System.out.println();
		 }
		 */
		 
		 // 과제2) 
		 
		 for (int i = 0; i <= 5; i++) {
			 for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			 for (int k = 1; k <= i; k++) {
					System.out.print("*");
				}
			 System.out.println();
		 }
		 for (int i = 0; i <= 5; i++) {
			 for (int j = 1; j <= 5-i; j++) {
				System.out.print(" ");
			}
			 for (int k = 1; k <= i*2+1; k++) {
					System.out.print("*");
				}
			 System.out.println();
		 }
		 
		 /*
		 //도전 마름모 
		 for (int i = 0; i <= 5; i++) {
			 for (int j = 1; j <= 5-i; j++) {
				System.out.print(" ");
			}
			 for (int k = 1; k <= i*2+1; k++) {
					System.out.print("*");
				}
			 System.out.println();
		 }
		 for (int i = 0; i <= 5; i++) {
			 for (int j = 1; j <= i; j++) {
				System.out.print(" ");
			}
			 for (int k = i; k <= 10-(i*2+1); k++) {
					System.out.print("*");
				}
			 System.out.println();
		 }
		*/
		
	}

}
