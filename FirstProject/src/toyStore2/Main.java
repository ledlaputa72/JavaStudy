package toyStore2;

import java.util.ArrayList;
import java.util.Scanner;

import toyStore.Car;
import toyStore.Puzzle;

public class Main {

	public static void main(String[] args) {

		ArrayList<Toys> toyArr=new ArrayList<Toys>();
		//제품 입력
		toyArr.add(new Toys("t001","벤츠1","1",1000));
		toyArr.add(new Toys("t002","벤츠2","1",1000));
		toyArr.add(new Toys("t003","벤츠3","1",1000));
		
		toyArr.add(new Toys("t011","건담1","2",2000));
		toyArr.add(new Toys("t012","건담2","2",2000));
		toyArr.add(new Toys("t013","건담3","2",2000));
		
		toyArr.add(new Toys("t021","뽀로로1","3",3000));
		toyArr.add(new Toys("t022","뽀로로2","3",3000));
		toyArr.add(new Toys("t023","뽀로로3","3",3000));
		
		toyArr.add(new Toys("t031","마리오1","4",4000));
		toyArr.add(new Toys("t032","마리오2","4",4000));
		toyArr.add(new Toys("t033","마리오3","4",4000));
		
		toyArr.add(new Toys("t041","레고1","5",5000));
		toyArr.add(new Toys("t042","레고2","5",5000));
		toyArr.add(new Toys("t043","레고3","5",5000));
		
		//품목 출력
		System.out.println("  ID   |      이름      |      종류      |     가격 ");
		System.out.println("--------------------------------------------");
		 for (int i = 0; i < toyArr.size(); i++) {
	            System.out.println(toyArr.get(i));
	       }
		 System.out.println("--------------------------------------------");
		 
		 //총합 
		 int sumToy=0;
		 int imsi=0;
		 for (int i = 0; i < toyArr.size(); i++) {
			 imsi=toyArr.get(i).gettPrice();
			 sumToy=sumToy+imsi;
		}
		 System.out.println("장남감 대여금 총 합계 : "+sumToy+"원");
		 
		 //상품 검색
		 System.out.println("--------------------------------------------");
		 System.out.println("장난감 종류 검색 ");
         Scanner sc=new Scanner(System.in);
         System.out.print("car, robot, doll, game, puzzle :  ");
         String sc1=sc.next(); //입력받은 값을 String sc1으로
         //검색찾기
         System.out.println("검색된 상품의 결과는  아래와 같습니다.");
         System.out.println("--------------------------------------------");
         int sumSearch=0;
         int imsi1=0;
         int sw=0;
         
         for (int i = 0; i < toyArr.size(); i++) {
              if (sc1.equals(toyArr.get(i).gettType())) { //항목  검색
            	  System.out.println(toyArr.get(i));
                   imsi1=toyArr.get(i).gettPrice();
                   sumSearch=sumSearch+imsi1;
                   sw=1;
              }
              else {
                   break;
              }
         }
         System.out.println("합계 : "+sumSearch);
         if (sw==0) {
              System.out.println("!!!!!검색한 물품을 찾을 수  없습니다.!!!!! ");
         }
         System.out.println("--------------------------------------------");
	}

}
