package Day018_Search_Hangman;

import java.util.Arrays;
import java.util.Scanner;

public class SearchTest01 {

	public static void main(String[] args) { 
		
		// 배열
		System.out.println("===== 이진 검색 함수 이용 =====");
		int[] arr2= {11,84,45,78,34,9,2};
		Arrays.sort(arr2); // 배열 정렬
		
		//정렬된 배열 출력
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
		
		//찾는 숫자 입력 = ans
		Scanner sc1=new Scanner(System.in);
		System.out.print("찾을 숫자를 입력하세요 : ");
		int ans=sc1.nextInt();
		
		//함수를 이용한 방법
		if (Arrays.binarySearch(arr2, ans)>=0) { // ans는 찾는 수, >=0 : 값이 있는 경우를 의미
			System.out.print("찾는 수 "+ans+"는");
			System.out.println((Arrays.binarySearch(arr2,ans))+"번째 있다.");
		}
		else {
			System.out.println("찾는 답이 없네요");
		}
		
	}//main end

}//class end
