package toyStore2;

import java.util.ArrayList;

public class ToyComputer {

	public static int kajaKywsan(ArrayList toyArr, String kind){
		int tot=0;
		//새로운 객체를 꺼내서 toyArr의 객체를 대입한다. t1(Toys라는 객체 배열)==toyArr(컬렉션)
		Toys[] t1=new Toys[toyArr.size()]; //Toys라는 클래스 객체데이터형으로 되는 배열(객체 배열) 
		for (int i = 0; i < toyArr.size(); i++) {
			t1[i]=(Toys)(toyArr.get(i));
		}
		//종류를 물어봄 
		for (int i = 0; i < t1.length; i++) {
			if (t1[i].gettType().equals(kind)) {
				tot += (int)(t1[i].gettPrice());
			}
		}
		return tot;
	}
	
}
