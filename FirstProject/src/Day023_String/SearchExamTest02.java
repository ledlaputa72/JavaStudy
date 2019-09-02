package Day023_String;

import java.util.Scanner;

public class SearchExamTest02 {

	public static void main(String[] args) {

		String s1 ="babooondal,Baeyul,강과바다,kongjoo,Marry,blue,강은우 ";
		
		kaja(s1); //1)String s1을 보냄
		//4)출력되고 나면 종료
	}// main end

	private static void kaja(String s1) {
		
		String[] arr1=s1.split(","); //2) 받은 s1의 단어를 분리해 행열로 만듬

		String words="b"; //3a) "b"를 찾는 words (문자열 찾기)
		char ch='강'; //3b) '강'을 찾는 char (문자 찾기)
		
		// 3a1)startsWith로 문자열에서 시작 단어 검색
		System.out.println("--- b로 시작하는 단어 검색 - startsWith");
		for (int i = 0; i < arr1.length; i++) {
			if (arr1[i].startsWith(words)||arr1[i].startsWith(words.toUpperCase())) { //3a2) 검색
				System.out.println(arr1[i]); //3a3) 출력
			}
		}
		
		// 3b1)charAt()으로 문자 검색
		System.out.println("--- 강으로 시작하는 단어 검색 - charAt()");
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i].charAt(0)==ch) // 3b2) 검색
				System.out.println(arr1[i]); //3b3)출력
		}
	}// kaja end
}//class end
