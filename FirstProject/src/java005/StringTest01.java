package java005;

import java.util.Scanner;

public class StringTest01 {

	public static void main(String[] args) {
	
		Scanner sc=new Scanner(System.in);
		System.out.println("영어로 된 문장을 입력하세요 ");
		String text=sc.nextLine(); // 바꾸고 싶은 문장 입력
		
		kajalnit("i love you");
		kajalnit("you LOVE Me");
		kajalnit("Have a nice DAY");
		System.out.println("==입력받은 문장은 : "+text+" 입니다.==");
		kajalnit(text); //입력 받은 문장을 바꿔준다. 
		
    }

	private static void kajalnit(String changeText ) {

		String[] arr=changeText.split(" "); //단어 구분
		String[] arr1=new String[arr.length]; //소문자용
		String[] arr2=new String[arr.length]; //대문자용
				
		for (int i = 0; i < arr.length; i++) { //소문자 만들기
			arr1[i]=arr[i].toLowerCase(); //arr1에는 소문자
		}
		for (int i = 0; i < arr.length; i++) { //대문자 만들기
			arr2[i]=arr[i].toUpperCase(); //arr2에는 대문자 
		}
		
		//첫글자 바꾸기 메소드
		StringBuffer[] result =new StringBuffer[arr1.length];
		for (int i = 0; i < arr2.length; i++) {
			StringBuffer str=new StringBuffer(arr1[i]);
			str.replace(0,1, arr2[i].substring(0, 1));
			result[i]=str;
		}
		
		for (int i = 0; i < result.length; i++) {
			System.out.print(result[i]+" ");
		}
		System.out.println();
	}
		
}
