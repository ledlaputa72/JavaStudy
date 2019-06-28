package toyStore3;

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
		
		 ///////////////////////////////////////////////////////////////
		 //ToyComputer 클래스를 이용할 때
		
		ToyComputer.kajaKywsan(toyArr, "자동차");
		ToyComputer.kajaKywsan(toyArr, "로봇");
		ToyComputer.kajaKywsan(toyArr, "인형");
		ToyComputer.kajaKywsan(toyArr, "게임");
		ToyComputer.kajaKywsan(toyArr, "퍼즐");

		System.out.println("===================================");
		System.out.println("자동차합"+ToyComputer.carTot); //클래스명.속성(static) 
		//원래 객체.메소그() //클래스명.스태틱매소드() 예) Sysout.out.println() 
		System.out.println("로봇합"+ToyComputer.robotTot);
		System.out.println("인형합"+ToyComputer.dollTot);
		System.out.println("게임합"+ToyComputer.gameTot);
		System.out.println("퍼즐합"+ToyComputer.puzzleTot);
		System.out.println("----------------------------------");
		System.out.println("장남감 대여금 총 합계"+ToyComputer.tothap);

	}// main end

}//class end
