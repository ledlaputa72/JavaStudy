package Day013; // ��Ű��

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
		
		System.out.print("���� �Է��ϼ���. : ");	
		int a=sc1.nextInt();
		
		System.out.print("�������� �Է��ϼ���. : ");
		int b=sc1.nextInt();
		
		double c=a%b;
				
		System.out.println(a+"�� "+b+"�� ����  ��������"+c+"�̴�");
		System.out.println(a+"�� "+b+"�� ����ΰ�? ");
		System.out.println(c==0); 
		*/
		
//		System.out.println(27%2==0); // 27�� 2�� ���� �������� 0�̳�? 
		
//		System.out.println(3>5 && 7>3);
		
		/*
		// ���� , 1���� 365.2422��, 0.2422*4=0.96 = �� 1�� / 4�⸶�� ������ �߻� / 100�⿡ ������� / 400�⿡ �ѹ����� �ٽ� ���� 
		// 4�� ����̸� ����, 100�� ����̸� ���, 400�� ����̸� ���� 
		
		Scanner sc1 = new Scanner(System.in);
		
		System.out.print("�⵵�� �Է��ϼ���. : ");	
		int year1=sc1.nextInt();
		
		System.out.println(year1%4==0 && year1%100!=0 || year1%400==0);
		*/
		
		/*
		int aaa1=30;
		String yokiro = (aaa1>=100) ? "100���� ũ�� " : "100���� �۳�"; // 3�� �����ڿ� ������ �Ҵ� 
		System.out.println(yokiro);
		*/
		
		/*
		int kk=100;
		kk=kk+1; //101 (kk = 100+1 )
		kk=kk+1; //102
		kk=kk-1; //101
		
		kk++; // kk=kk+1;�� ���� 
		++kk; // kk++�� ����
		
		System.out.println(kk); //103
		
		kk--; // kk=kk-1;�� ���� 
		--kk; // kk--�� ���� 
		*/		
		/*
		int yy1=300;
		yy1++;
		System.out.println(yy1); // 301
		
		
		yy1=yy1+3; //yy1++3(x) ������ 1�� ������ ���� 
		yy1+=3; // yy1=yy1+3�� ���� 
		
		yy1=yy1*2;
		yy1*=2; //yy1=yy1*2;�� ����
		*/
		
		//1�� ���
		int yy2=300;
		yy2++;
		System.out.println(yy2); // 301
		
		//2�� ��� 
		System.out.println(++yy2); // 302, �� 82,83�� ��ģ ǥ��
		System.out.println(yy2++); // 303�� �ƴ϶� 302�� ����		
		System.out.println(yy2); // 303�� ���� 
		
		System.out.println(((3+6)*7)-23/(45*3));
		
	}

}
