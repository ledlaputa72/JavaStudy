package Day023_String;

import java.util.Scanner;

public class SearchExam04 {

	public static void main(String[] args) {
		
		/*String s1="LOVE";
		System.out.println(s1.substring(1,2));*/
		
		// 이동하는 글자 만들기 
		Scanner sc=new Scanner(System.in);
		System.out.println("움직일 문장을 입력하세요");
		
		String s1=sc.nextLine(); //nextLine 공백없이 모두 입력 받기 
//		String s2="I LOVE YOU.";
		
		System.out.println("--------Animation--------");
		/*for (int i = 0; i < s1.length(); i++) {
			System.out.println(s1.substring(i,s1.length())+s1.substring(0,i));
		}*/
		
		//선생님 풀이 방식
		for (int i = 0; i < s1.length(); i++) {
			s1=s1.substring(1,s1.length())+s1.substring(0,1);
			System.out.println(s1);
		}
	}
} 
