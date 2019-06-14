package java005;

import java.util.Scanner;

public class StringExam {

	public static void main(String[] args) {
		//Wrapper 
		int aa=100; //객체형태로 aa에 100을 넣고 싶을때, 아래와 같이 한다.   
		Integer i1=new Integer(100); //int --> class화
		
		boolean bool2=true;
		Boolean bool3=new Boolean("true"); //boolean -- class화
		
		if(Character.isLowerCase('P'))
			System.out.println("소문자네");
		else
			System.out.println("대문자네");
		
		System.out.println(Integer.toBinaryString(2));
		System.out.println(Integer.toBinaryString(-32768)); //2바이트 제일 작은 수 
		System.out.println(Integer.toBinaryString(-2147483648)); //4바이트 제일 작은 수 
	}	

}
