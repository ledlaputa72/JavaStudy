package java005;

import java.util.Scanner;

public class StringExam {

	public static void main(String[] args) {
		//Wrapper 
		int aa=100; //��ü���·� aa�� 100�� �ְ� ������, �Ʒ��� ���� �Ѵ�.   
		Integer i1=new Integer(100); //int --> classȭ
		
		boolean bool2=true;
		Boolean bool3=new Boolean("true"); //boolean -- classȭ
		
		if(Character.isLowerCase('P'))
			System.out.println("�ҹ��ڳ�");
		else
			System.out.println("�빮�ڳ�");
		
		System.out.println(Integer.toBinaryString(2));
		System.out.println(Integer.toBinaryString(-32768)); //2����Ʈ ���� ���� �� 
		System.out.println(Integer.toBinaryString(-2147483648)); //4����Ʈ ���� ���� �� 
	}	

}
