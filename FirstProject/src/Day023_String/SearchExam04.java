package Day023_String;

import java.util.Scanner;

public class SearchExam04 {

	public static void main(String[] args) {
		
		/*String s1="LOVE";
		System.out.println(s1.substring(1,2));*/
		
		// �̵��ϴ� ���� ����� 
		Scanner sc=new Scanner(System.in);
		System.out.println("������ ������ �Է��ϼ���");
		
		String s1=sc.nextLine(); //nextLine ������� ��� �Է� �ޱ� 
//		String s2="I LOVE YOU.";
		
		System.out.println("--------Animation--------");
		/*for (int i = 0; i < s1.length(); i++) {
			System.out.println(s1.substring(i,s1.length())+s1.substring(0,i));
		}*/
		
		//������ Ǯ�� ���
		for (int i = 0; i < s1.length(); i++) {
			s1=s1.substring(1,s1.length())+s1.substring(0,1);
			System.out.println(s1);
		}
	}
} 
