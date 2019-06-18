package java005;

import java.util.Scanner;

public class SearchExamTest005 {
	public static void main(String[] args) {
		
		String s1 ="babooondal,Baeyul,강과바다,kongjoo,Marry,blue,강은우 ";
		kaja(s1); 	
		kaja1(s1); 
	}

	private static void kaja(String s1) {
		
		String[] arr=s1.split(",");
		
		char ch0='b';
		char ch1='강';
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i].charAt(0)==ch0 || arr[i].charAt(0)==ch1  ) {
				System.out.println(arr[i]);
			}
		}
	}// kaja end
	
	private static void kaja1(String s1) {
		
		String[] arr=s1.split(",");
		
		char ch='강';
		
		for (int i = 0; i < arr.length; i++) {
			if(ch>='A' && ch<='z') {
				if(arr[i].charAt(0)==ch || arr[i].charAt(0)==ch-32)
					System.out.println(arr[i]);
			} 
			else if (ch >='\uAC00' && ch<='\uD7A3'){
				if (arr[i].charAt(0)==ch) {
					System.out.println(arr[i]);
				}
			}
		} //for end
	}//kaja1 end

}
