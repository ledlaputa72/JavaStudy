package java003;

import java.util.Scanner;

public class hangman_test03 {

	public static void main(String[] args) { 
		
		// 행맨의 문제 단어를 직접 입력하고, 단어 길*2만큼의 시도안에 단어를 모두 맞추어라 
		
		 //내가 푼 문제 풀이 + 문제 단어 입력
        Scanner sc1=new Scanner(System.in);
		
        System.out.println("문제 단어를 입력하세요 ");
        
        String q1=sc1.next(); // 단어 입력
        // System.out.println(q1); 
        
        // 문제 입력 string은 char로 변경  
        char[] arr1=q1.toCharArray();//String arr1를 char로 변환
        
        for (int i = 0; i < arr1.length; i++) { // 단어 출력
        	System.out.print(arr1[i]+",");
		}
        System.out.println();
        System.out.println("단어의 길이"+arr1.length); // 단어의 길이 
        System.out.println("시도 기회 : "+arr1.length*2);
        
        char[] arr2=new char[arr1.length]; //String arr2를 char로 변환
        for (int i = 0; i < arr2.length; i++) {
			arr2[i]='_';
		}
//        for (int i = 0; i < arr2.length; i++) { // 단어 출력
//        	System.out.print(arr2[i]+",");
//		}
//        System.out.println();
        
        //2. 시도 횟수 카운트
        int count=0; //횟수 시도 카운트
        int success=arr2.length; //성공 횟수 판단 0이면 종료, 배열 길이의 두배
        
        //3. 정답 비교
        for (int i = 0; i < arr2.length*2; i++) { // 전체 시도 횟수
             
             if (success!=0) { //성공 유무 판단.
                  
                  // 정답 비교
                  for (int j = 0; j < arr2.length; j++) {
                        System.out.print(arr2[j]+" "); //밑줄  출력(정답 포함)
                  }
                  System.out.println();
             
                  //3. 입력 문자 받기
                  
                  System.out.print("정답을 입력하세요 : ");
                  String answer1=sc1.next();
                  char answer2 =answer1.charAt(0); //입력받은  문자
                  
                  //4. search로 배열과 입력 받은 문자 비교   arr1[0~7] == answer2
                  for (int  k= 0; k < arr1.length; k++) {  //받은 문자와 정답을 비교
                        if (arr1[k]==answer2) { // 배열과 입력  받은 문자가 같으면
                             arr2[k]=arr1[k];
                             success--;
                             break;
                        }
                  }
                  count++;
                  System.out.println(count+"번  시도했습니다.");
                  // 정답 비교 끝
                  
             } // if success !=0 반복
             else {
            	 //정답 출력 확인
                  for (int j = 0; j < arr2.length; j++) {
                	  System.out.print(arr2[j]);
				}
                  System.out.println();                  
            	  System.out.println("성공했습니다.");        
                  break;
             } //if end 성공유무 판다.
        } // for end 전체 시도 횟수
        
        if (count==arr2.length*2) {
             System.out.println("시도횟수가 모두 끝났습니다.");                
        }
        
        
	}//main end

}//class end
