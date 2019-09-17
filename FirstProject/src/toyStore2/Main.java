package toyStore2;

import java.util.ArrayList;
import java.util.Scanner;

import toyStore.Car;
import toyStore.Puzzle;

public class Main {

	public static void main(String[] args) {

		ArrayList<Toys> toyArr=new ArrayList<Toys>(); //데이터를 저장하기 위한 배열
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
		
		
		/*		/////////////////////////////////////////////////////
				//객체를 이용한 방법 - 내방법 
				Caculate c1=new Caculate(); //계산을 위한 객체
				
				c1.printList(toyArr); //c1객체를 이용해서 Caculate의 메소드를 사용 - 품목 출력
				 
				 //종류 검색해서 출력하기
				 String type = null;
				 for (int i = 0; i < toyArr.size(); i++) {
					 if(i%3==0) {
						 type=toyArr.get(i).gettType(); //종류 구하기 
						 c1.typeSum2(toyArr, type); //c1객체를 이용해서 Caculate의 메소드를 사용 - 종류 합계 출력
					 }
				}
		
				 c1.sumTotal(toyArr);//c1객체를 이용해서 Caculate의 메소드를 사용 - 총합 출력 
		*/		 
		 ///////////////////////////////////////////////////////////////
		 //ToyComputer 클래스를 이용할 때--선생님 방식 
		
		int tothap=0;
		int carSum=ToyComputer.kajaKywsan(toyArr, "자동차");
		int robotSum=ToyComputer.kajaKywsan(toyArr, "로봇");
		int dollSum=ToyComputer.kajaKywsan(toyArr, "인형");
		int gameSum=ToyComputer.kajaKywsan(toyArr, "게임");
		int puzzleSum=ToyComputer.kajaKywsan(toyArr, "퍼즐");
		
		tothap=carSum+robotSum+dollSum+gameSum+puzzleSum;
		
		System.out.println("===================================");
		System.out.println("자동차합"+carSum);
		System.out.println("로봇합"+robotSum);
		System.out.println("인형합"+dollSum);
		System.out.println("게임합"+gameSum);
		System.out.println("퍼즐합"+puzzleSum);
		System.out.println("장남감 대여금 총 합계"+tothap);
		
		

	}// main end

}//class end
