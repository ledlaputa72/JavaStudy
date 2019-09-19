package Day023_String;

import java.util.Scanner;

public class SearchExam02 {

	public static void main(String[] args) {
	
		String[] arr1= {"aa.html","bb.html","cc.html","j1.java","j2.java","j3.java",
				"js1.js","js2.js","js3.js"}; //생성된 배열
		
		Scanner sc=new Scanner(System.in);
		System.out.println("찾고 싶은 확장자는 [.html] [.java] [.js]");
		
		String[] arr2=kaja(arr1, sc.next()); //kaja(arr1, )로 배열 전체를 받아오기, return값 arr3을 받는다. 
		
		for (int i = 0; i < arr2.length; i++) { //return받은 arr2를 출력
			if(arr2[i] != null)
				System.out.println(arr2[i]);
		}
		
	}

	private static String[] kaja(String[] arr1, String next) { //반환형이 String[] 배열
		
		String[] arr3=new String[arr1.length]; //결과를 담을 배열을 만들고 크기를 넘어온 배열 arr1으로 한다. 
		
		for (int i = 0; i < arr1.length; i++) {
			if(arr1[i].endsWith(next))
				arr3[i]=arr1[i]; //조건에 맞는 배열을 결과담는 arr3에 저장
		}
		return arr3; //arr3를 return한다. 
	}

}
