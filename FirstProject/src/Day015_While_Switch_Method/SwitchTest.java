package Day015_While_Switch_Method;

import java.util.Scanner;

public class SwitchTest {

	public static void main(String[] args) {

		Scanner sc1=new Scanner(System.in);
		
		
//		//�����ڵ�) 
//		System.out.println("���� ����?");
//		int kab=sc1.nextInt();
//		
//		switch(kab) {
//		case 1: // kab>3 x
//			System.out.println("���η� ����");
//			break;
//		case 2: // 
//			System.out.println("�������� ����");
//			break;
//		default:
//			System.out.println("�ٴٷ� ����");
//			break;
//		}
				
//		// ����1) 
//		System.out.println("������ �Է��ϼ���");
//		int score1 = sc1.nextInt();
//		
//		int score = score1/10;
//		
//		switch (score) {
//		case 10:
////			System.out.println("A����");
////			break;
//		case 9:
//			System.out.println("A����");
//			break;
//		case 8:
//			System.out.println("B����");
//			break;
//		case 7:
//			System.out.println("C����");
//			break;
//		case 6:
//			System.out.println("D����");
//			break;	
//
//		default:
//			System.out.println("F����");
//			break;
//		}
		
		// ����2) ��¥ ����ϱ�
		System.out.println("���� �Է��ϼ���");
		int days = sc1.nextInt();
		// int days = Integer.parseInt(sc1.next()); // �Է� ���� �����͸� int�� ��ȯ �����ִ� ����ȯ
		
		System.out.print(days+"���� ���� ");
		switch (days) {
		case 1:
		case 3:
		case 5:
		case 7:
		case 8:
		case 10:
		case 12:
			System.out.println("31���Դϴ�. ");
			break;
		case 4:
		case 6:
		case 9:
		case 11:
			System.out.println("30���Դϴ�.");
		default: 
			System.out.println("28���Դϴ�.");
			break;
		}		
		
		
		
		
	}

}
