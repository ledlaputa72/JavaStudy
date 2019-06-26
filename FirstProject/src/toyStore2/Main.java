package toyStore2;

import java.util.ArrayList;
import java.util.Scanner;

import toyStore.Car;
import toyStore.Puzzle;

public class Main {

	public static void main(String[] args) {

		ArrayList<Toys> toyArr=new ArrayList<Toys>();
		//제품 입력
		toyArr.add(new Toys("t001","벤츠1","자동차",1000));
		toyArr.add(new Toys("t002","벤츠2","자동차",1000));
		toyArr.add(new Toys("t003","벤츠3","자동차",1000));
		
		toyArr.add(new Toys("t011","건담1","로봇",2000));
		toyArr.add(new Toys("t012","건담2","로봇",2000));
		toyArr.add(new Toys("t013","건담3","로봇",2000));
		
		toyArr.add(new Toys("t021","뽀로로1","인형",3000));
		toyArr.add(new Toys("t022","뽀로로2","인형",3000));
		toyArr.add(new Toys("t023","뽀로로3","인형",3000));
		
		toyArr.add(new Toys("t031","마리오1","게임",4000));
		toyArr.add(new Toys("t032","마리오2","게임",4000));
		toyArr.add(new Toys("t033","마리오3","게임",4000));
		
		toyArr.add(new Toys("t041","레고1","퍼즐",5000));
		toyArr.add(new Toys("t042","레고2","퍼즐",5000));
		toyArr.add(new Toys("t043","레고3","퍼즐",5000));
		
		//품목 출력
		System.out.println("  ID |  이름     |  종류     |  가격 ");
		System.out.println("------------------------------");
		 for (int i = 0; i < toyArr.size(); i++) {
	            System.out.println(toyArr.get(i));
	       }
		 System.out.println("==============================");
		 
		 //종류별 합계
		 String type = null;
		 for (int i = 0; i < toyArr.size(); i++) {
			 if(i%3==0) {
				 type=toyArr.get(i).gettType();
				 typeSum(toyArr, type);
			 }
		}
		 System.out.println("------------------------------");

		 //총합 
		 int sumToy=0;
		 int imsi=0;
		 for (int i = 0; i < toyArr.size(); i++) {
			 imsi=toyArr.get(i).gettPrice();
			 sumToy=sumToy+imsi;
		}
		 System.out.println("장남감 대여금 총 합계 : "+sumToy+"원");
		 System.out.println("------------------------------");

	}// main end

	private static void typeSum(ArrayList<Toys> toyArr, String type) {
		
        int sumSearch=0;
        int imsi1=0;
        for (int i = 0; i < toyArr.size(); i++) {
       	if((toyArr.get(i).gettType())==type){
       		imsi1=toyArr.get(i).gettPrice();
               sumSearch=sumSearch+imsi1;
       		}  	
        }
        System.out.println(type+" 합계 : "+sumSearch);
		
	}//typeSum end

}//class end
