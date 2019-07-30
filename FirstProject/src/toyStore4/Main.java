package toyStore4;

import java.util.ArrayList;
import java.util.Scanner;

class Toys {
	
	private String tID;
	private String tName;
	private String tType;
	private int tPrice;
	//Default Constructor
	public Toys() {
		super();
	}
	//Constructor
	public Toys(String tID, String tName, String tType, int tPrice) {
		super();
		this.tID = tID;
		this.tName = tName;
		this.tType = tType;
		this.tPrice = tPrice;
	}
	//getter setter
	public String gettID() {
		return tID;
	}
	public void settID(String tID) {
		this.tID = tID;
	}
	public String gettName() {
		return tName;
	}
	public void settName(String tName) {
		this.tName = tName;
	}
	public String gettType() {
		return tType;
	}
	public void settType(String tType) {
		this.tType = tType;
	}
	public int gettPrice() {
		return tPrice;
	}
	public void settPrice(int tPrice) {
		this.tPrice = tPrice;
	}
	@Override
	public String toString() {
		return tID + "  \t" + tName +  "  \t" + tType +  "    \t" + tPrice ;
	}

}

class ToyComputer {
	//static 은 프로그램 종료까지 유지되는 메모리 창고 
	static int tothap=0;
	static int carTot=0;
	static int robotTot=0;
	static int dollTot=0;
	static int gameTot=0;
	static int puzzleTot=0;
	
	public static int kajaKywsan(ArrayList toyArr, String kind){
		//새로운 객체를 꺼내서 toyArr의 객체를 대입한다. t1(Toys라는 객체 배열)==toyArr(컬렉션)
		
		Toys[] t1=new Toys[toyArr.size()]; //Toys라는 클래스 객체데이터형으로 되는 배열(객체 배열) 
		for (int i = 0; i < toyArr.size(); i++) {
			t1[i]=(Toys)(toyArr.get(i));
		}
		//종류를 물어봄 
		for (int i = 0; i < t1.length; i++) {
			if (t1[i].gettType().equals(kind)) {
				if (kind.equals("자동차")) {
					carTot +=(int)(t1[i].gettPrice());
				}
				if (kind.equals("로봇")) {
					robotTot +=(int)(t1[i].gettPrice());
				}
				if (kind.equals("인형")) {
					dollTot +=(int)(t1[i].gettPrice());
				}
				if (kind.equals("게임")) {
					gameTot +=(int)(t1[i].gettPrice());
				}
				if (kind.equals("퍼즐")) {
					puzzleTot +=(int)(t1[i].gettPrice());
				}
			}
		}
		tothap=carTot+robotTot+dollTot+gameTot+puzzleTot;
		return 0;
	}
}

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
