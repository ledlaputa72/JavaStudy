package Day030_Test;

import java.util.Arrays;

public class ChangeCharTest {

	public static void main(String[] args) {
		char[] ch1={'S','u','N','n','Y'};
		charPrint(ch1); //원본 출력
		change(ch1); //대소문자 변환, sort 함수 
		charPrint(ch1); //수정 출력
		
	}//main end

	private static void change(char[] ch1) {
		//대소문자 변경 +32 -32
		for (int i = 0; i < ch1.length; i++) {
			if (ch1[i]>='A' && ch1[i]<='Z') { //대문자 파악 
				//ascii 영문자를 숫자로 표기 if(97<=ch1[i] && ch1[i]<=122){
                 ch1[i]=(char)(ch1[i]+32); //대문자 -> 소문자
			}
			else { //이외의 글자(소문자)
        	   ch1[i]=(char)(ch1[i]-32); //소문자 -> 대문자
			}
		}
		Arrays.sort(ch1); //정렬
	}//change() end

	private static void charPrint(char[] ch1) {
		System.out.println("---------------------");
		for (int i = 0; i < ch1.length; i++) {
			System.out.print(ch1[i]+"\t");
		}
		System.out.println();
	}//charPrint() end

}//class end
