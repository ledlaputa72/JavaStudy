package java001;

import java.util.Scanner;

//�ݺ��� 

public class Repeat {

	public static void main(String[] args) {
		/*
		for (int i = 1; i <=25; i++) {
			System.out.println("�պ��޸���"+i);
		}
		// System.out.println(i); // ���� �߻� {}�� ����� i�� �ı��ܴ�.
		*/
		/*
		for (int i = 1; i <=10; i++) {
			System.out.println("I love you "+i);
		}
		*/
		
		// �������� 5�� ��� 
//		for (int i = 1; i <=9; i++) {
//				System.out.println("5*"+i+" = "+(5*i));
//			}
		
		/*
		// �г� �� ��� 
		 for (int i = 1; i <= 3; i++) {
			 System.out.println("===="+i+"�г� =====");
			 System.out.println("�г�-��");
             for (int j = 1; j <= 2; j++) {
                  System.out.println(i+" - "+j);
             }
        }
        */
		 
		/*
		 //���� �������� : �Ƕ�̵� �׸��� 
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
		 // ����2) �� �ڽ� ����� 		
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 6; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
		 */
		
		/*
		 //����3) �� �Ƕ�̵� ����� 
		 for (int i = 1; i <= 5; i++) {
			 for (int j = 1; j <= i; j++) {
				System.out.print("*");
			}
			 System.out.println();
		 }
		 */
		
		/*
		//����4) ���� ���ﰢ�� ����� 
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
		// ����1)
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
		 
		 // ����2) 
		 
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
		 //���� ������ 
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
