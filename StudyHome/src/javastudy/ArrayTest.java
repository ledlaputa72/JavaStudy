package javastudy;

import java.util.Scanner;

public class ArrayTest {

	public static void main(String[] args) {

        Scanner sc1=new Scanner(System.in);

	    //char[] love= {'L','O','V','E'};
		System.out.println("������ �Է��ϼ���."); 
	    String str = sc1.next(); 
	    char[] love=str.toCharArray(); // �Է¹��� Sting ���ڸ� char[] �迭�� ��ȯ 
	    
	    
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
                
        
        //love���� ���////////////////////////////
        System.out.print("��ȣȭ �� ���ڴ� : ");
        for (int i = 0; i < love.length; i++) {
             System.out.print(love[i]);
        }
        System.out.println();
        
        //��ȣȭ�� love�� ���/////////////////////////
        System.out.print("��ȣȭ �� ���ڴ� : ");
        for (int i = 0; i < loveChar.length; i++) {
             System.out.print(loveChar[i]);
        }    
        System.out.println();
        
        
        //�� ��ȣȭ 
        for (int i = 0; i < loveInt.length; i++) {
             loveInt[i]=loveInt[i]-num;
        }
        
        //����>���ڷ� ��ȣȭ
        for (int i = 0; i < loveChar.length; i++) {
             loveChar[i]=(char)loveInt[i];
        }
        
        //�� ��ȣȭ�� love�� ���/////////////////////////
        System.out.print("�� ��ȣȭ�� ���ڴ� : ");
        for (int i = 0; i < loveChar.length; i++) {
             System.out.print(loveChar[i]);
        }    
        System.out.println();
        
	}

}
