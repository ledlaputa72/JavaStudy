package java003;

import java.util.Scanner;

public class ArrayTest01 {

	public static void main(String[] args) {
		Scanner sc1=new Scanner(System.in);
		
        //char[] love= {'L','O','V','E'};
        System.out.println("문장을 입력하세요.");
        String str = sc1.next();
        char[] love=str.toCharArray(); // 입력받은 Sting 문자를  char[] 배열로 변환
		
		//#############################################
		//문자를 ASCII 숫자로 변화
		
		// love를 Ascii 숫자 코드로 바꿈
		int[] loveInt= new int[love.length];
		for (int i = 0; i < love.length; i++) {
			loveInt[i]=(int)love[i];
		}
		
		//더할 숫자를 입력해서 반영하는 부분 
		System.out.println("암호화할 숫자를 입력하세요"); 
		int num=Integer.parseInt(sc1.next());
		//변환된 숫자에 +1하여 암호화
		for (int i = 0; i < loveInt.length; i++) {
			loveInt[i]=loveInt[i]+num;
		}
		
		//숫자>문자로 안호화
		char[] loveChar= new char[love.length];
		for (int i = 0; i < loveChar.length; i++) {
			loveChar[i]=(char)loveInt[i];
		}
		
		//love원본 출력
		System.out.print("암호화할 단어는 = ");
		for (int i = 0; i < love.length; i++) {
			System.out.print(love[i]);
		}
		System.out.println();
		
		//암호화된 love를 출력
		System.out.print("더해진 숫자는 ="+num+", 암호화된 글자는 =");
		for (int i = 0; i < loveChar.length; i++) {
			System.out.print(loveChar[i]);
		}	
		System.out.println();
		
		
		//#########################
		//글자 단어의 위치를 바꾸는 방법
		char imsi=love[1];
		love[1]=love[3];
		love[3]=imsi;
		
		for (int i = 0; i < love.length; i++) {
			System.out.print(love[i]);
		}
		System.out.println();
		
		//다시 원래대로 돌리기 
		love[3]=love[1];
		love[1]=imsi;
		
		for (int i = 0; i < love.length; i++) {
			System.out.print(love[i]);
		}
	}

}
