package java003;

import java.util.Scanner;

public class hangman_test01 {

	public static void main(String[] args) {
		
		// 선생님 문제 풀이 - 아래 다시 확인 필요 제대로 못 받아 씀 
		
		String [] moonja={"p","i","c","t","u","r","e"};
       String [] jool={"_","_","_","_","_","_","_"};
	   String ip;
         
	   int cnt,sw=0;
	   
       for(int j=0; j<7;j++) //처음 줄 출력
           System.out.print(jool[j]);
       System.out.println();
       
       Scanner scan1=new Scanner(System.in);
       
       for(int i=1;i<=13;i++){ //13번 체크 
    	 cnt=0;  
   	     System.out.println("예상글자입력:"); 
         ip=scan1.next(); //////// 	 
   
	     for(int j=0; j<7;j++){ //예상글자가 문제단어에 있어?
       	   if(ip.equals(moonja[j])) 
       		        jool[j]=moonja[j];
         }
	     
         for(int j=0; j<7;j++) //있건 없건 한줄 출력해
              System.out.print(jool[j]);//줄출력	
         System.out.println("\t"+i+"번시도");
        
         for(int j=0; j<7;j++){ //문제단어와 줄글자가  7개 같아? 
        	   if(jool[j].equals(moonja[j]))
        		        cnt++;
         }
         
         if(cnt == 7){ //그러면 딱 맞추었으니 끝내자
              System.out.println("굿드");
              sw=1;/////////////////
        	  break;	   
         }
         
      }//13-for-end 
       
         if(sw==0)
              System.out.print("다음기회에");
		
	}//main end
}// class end
