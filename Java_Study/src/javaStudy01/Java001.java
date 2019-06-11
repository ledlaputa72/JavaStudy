
package javaStudy01;

import java.util.Scanner;

public class Java001 {

	public static void main(String[] args) {
		Scanner sc1 = new Scanner(System.in);
		// Class varName = new Class(
		
		System.out.println("섭씨 온도를 입력하시오 ");
		
		float cel = sc1.nextFloat();
		
		float fah=(float)((cel*1.8)+32);
		
		System.out.println("섭씨="+cel+"도 일떄, 화씨="+fah+"입니다.");
		
		
		
	}

}
