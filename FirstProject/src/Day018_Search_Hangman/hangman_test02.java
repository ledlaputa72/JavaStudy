package Day018_Search_Hangman;

import java.util.Scanner;

public class hangman_test02 {

	 public static void main(String[] args) { 
         
		 //내가 푼 문제 풀이 
		 
         //1. 배열에 picture 입력
         char[] arr1={'p', 'i', 'c', 't', 'u', 'r', 'e'}; //  배열에 입력
         char[] arr2= {'_','_','_','_','_','_','_'}; //정답  표시
         
         //2. 시도 횟수 카운트
         int count=0; //횟수 시도 카운트
         int success=7; //성공 횟수 판단 0이면 종료
         
         //3. 정답 비교
         for (int i = 0; i < 13; i++) { // 전체 시도 횟수
              
              if (success!=0) { //성공 유무 판단.
                   
                   // 정답 비교
                   for (int j = 0; j < arr2.length; j++) {
                         System.out.print(arr2[j]+" "); //밑줄  출력(정답 포함)
                   }
                   System.out.println();
              
                   //3. 입력 문자 받기
                   Scanner sc1=new Scanner(System.in);
                   
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
                   System.out.println("성공했습니다.");        
                   break;
              } //if end 성공유무 판다.
         } // for end 전체 시도 횟수
         
         if (count==13) {
              System.out.println("시도횟수가 모두 끝났습니다.");                
         }
   } //main end

}
