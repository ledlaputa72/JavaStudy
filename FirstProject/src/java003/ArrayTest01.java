package java003;

import java.util.Scanner;

public class ArrayTest01 {

	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		
        //char[] love= {'L','O','V','E'};
        System.out.println("������ �Է��ϼ���.");
        String str = sc1.next();
        char[] love=str.toCharArray(); // �Է¹��� Sting ���ڸ�  char[] �迭�� ��ȯ
		
		//#############################################
		//���ڸ� ASCII ���ڷ� ��ȭ
		
		// love�� Ascii ���� �ڵ�� �ٲ�
		int[] loveInt= new int[love.length];
		for (int i = 0; i < love.length; i++) {
			loveInt[i]=(int)love[i];
		}
		
		//���� ���ڸ� �Է��ؼ� �ݿ��ϴ� �κ� 
		System.out.println("��ȣȭ�� ���ڸ� �Է��ϼ���"); 
		int num=Integer.parseInt(sc1.next());
		//��ȯ�� ���ڿ� +1�Ͽ� ��ȣȭ
		for (int i = 0; i < loveInt.length; i++) {
			loveInt[i]=loveInt[i]+num;
		}
		
		//����>���ڷ� ��ȣȭ
		char[] loveChar= new char[love.length];
		for (int i = 0; i < loveChar.length; i++) {
			loveChar[i]=(char)loveInt[i];
		}
		
		//love���� ���
		System.out.print("��ȣȭ�� �ܾ�� = ");
		for (int i = 0; i < love.length; i++) {
			System.out.print(love[i]);
		}
		System.out.println();
		
		//��ȣȭ�� love�� ���
		System.out.print("������ ���ڴ� ="+num+", ��ȣȭ�� ���ڴ� =");
		for (int i = 0; i < loveChar.length; i++) {
			System.out.print(loveChar[i]);
		}	
		System.out.println();
		
		
		//#########################
		//���� �ܾ��� ��ġ�� �ٲٴ� ���
		char imsi=love[1];
		love[1]=love[3];
		love[3]=imsi;
		
		for (int i = 0; i < love.length; i++) {
			System.out.print(love[i]);
		}
		System.out.println();
		
		//�ٽ� ������� ������ 
		love[3]=love[1];
		love[1]=imsi;
		
		for (int i = 0; i < love.length; i++) {
			System.out.print(love[i]);
		}
	}

}
