package java001;

import java.util.Scanner;

public class Condition01 {

	public static void main(String[] args) {
		//���ǹ� 
		//if 1����
		/*
		if(aa>3)
		{
			System.out.println("aa�� 3���� ũ�� ");
		}
		
		//if 2����
		if(bb>3)
		{
			System.out.println("bb�� 3���� ũ�� ");
		}
		else
		{
			System.out.println("bb�� 3���� �۴�");
		}
		*/
		
		/*
		// 210�� 3�� �����
		int cc = 210;
		
		if(cc%3==0) {
			System.out.println("3�� ����̴�");
		}
		else
		{
			System.out.println("3�� ����� �ƴϴ� ");
		}
		
		
		if(cc%3==0) 
			System.out.println("3�� ����̴�");
		else
			System.out.println("3�� ����� �ƴϴ� ");
		 */
		
		/*
		//�񸸵� BMI 
		// 
		Scanner bmiIn = new Scanner(System.in);
		
		System.out.println("����� �����Ը� �Է��ϼ��� : ");
		float bmi1= bmiIn.nextFloat();

		System.out.println("����� Ű�� ���ͷ� �Է��ϼ��� ");
		float bmi2= bmiIn.nextFloat();

		float bmi3=bmi2/100; // ����Ű�� �ٲٱ� 
		
		float bmi = bmi1 / (bmi3*bmi3); 
		System.out.println("����� BMI ������ " +bmi+"�Դϴ�.");
		

		if ( 30.0 <= bmi) {
			System.out.println("���Դϴ�.");
		}
		else if (25.0 <= bmi && bmi < 30.0)
		{
			System.out.println("��ü���Դϴ�.");
		}
		else if(20.0 <= bmi && bmi < 25.0 )
		{
			System.out.println("�����Դϴ�.");
		}
		else
		{
			System.out.println("��ü��. ");
		}
		*/
		
		/*
		//��� �Է� Ȯ�� ���� 
		Scanner sc1 = new Scanner(System.in);
		
		System.out.println("���� �Է��ϼ��� : ");
		// int num= sc1.nextInt(); // �⺻���� ��� 
		String num0=sc1.next(); // String���� �Է� �޴´�. 
		int num=Integer.parseInt(num0); // int�� ��ȯ�Ѵ�. 
		
		if (num%3 == 0 && num%5 == 0)
			System.out.println("�ѽ�");
		else if (num%3 == 0)
			System.out.println("����");
		else if (num%5 == 0)
			System.out.println("����");
		*/
		
		
		// ����ȯ
		
		int aaa=2147483647;
		// int aaa2=2147483648; // ���� �ʰ� ���� 
		int ccc=1;
		int aaa5=aaa+ccc; // ���� �ʰ��̳� ����ǥ�ð� �ȵ� 
		
		System.out.println(aaa5);
		
		
	}

}
