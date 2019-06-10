package java003;

import java.util.Arrays;
import java.util.Scanner;

public class SearchTest {

	public static void main(String[] args) {

		//순차 검색
		System.out.println("===== 순차 검색 =====");
		int[] arr={10,20,30,40,50};
		int findsoo=30; //찾는 수, Scanner로 입력 받아도 된다. 
		
		for (int i = 0; i < arr.length; i++) {
			if (arr[i]==findsoo) {
				System.out.println(i+"번 째");
			}
		} //for end
		// 순차 검색 완료 

		
		// 이진 검색
		System.out.println("===== 이진 검색 =====");
		int[] arr2= {11,84,45,78,34,9,2};
		Arrays.sort(arr2); // 배열 정렬
		
		for (int i = 0; i < arr2.length; i++) {
			System.out.print(arr2[i]+"\t");
		}
		System.out.println();
		
		//찾는 숫자 입력 
		Scanner sc1=new Scanner(System.in);
		System.out.print("찾고 싶은 숫자 입력 : ");
		int soo=Integer.parseInt(sc1.next()); //입력 받은 문자를 int형으로 
		
		//배열의 가운데를 찾는 방법
		int f=0;//first 기준
		int l=arr2.length-1; //last 기준 , arr2[6]번이 마지막 0번 부터이니 전체 길이 -1
		int m; //가운데
		
		int sw=0; // 스위치 기법 
		int cnt=1;
		
		while (f<=l) { //f(시작)이 l(끝)보다 작거나 같은 경우까지만 찾기 (교차되면 답이 없음) 
			m=(f+l)/2;
			if(soo==arr2[m]) {
				System.out.println(soo+"는 배열"+m+" 번째 있다. ");
				sw=1; //찾으며 sw를 바꿔 뒤에 표시를 하지 않는다 
				break;
			}
			else if(soo<arr2[m]) {
				l=m-1;				
			}
			else if(soo>arr2[m]) {
				f=m+1;
			}
			cnt++;
		}//while end
		System.out.println(cnt+"번째 찾기");
		
		if(sw==0) { //답이 없는 경우 표시, 있으면 sw=1이 되어 이 if문은 표시하지 않는다. 
			System.out.println(soo+"는 없어");
		}
		// 이진 검색 완료
		
	} //main end

}//class end
