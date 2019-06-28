package toyStore4;

import java.util.ArrayList;

public class ToyComputer {
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
