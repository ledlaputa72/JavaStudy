package toyStore2;

import java.util.ArrayList;

public class ToyComputer {

	public static int kajaKywsan(ArrayList toyArr, String kind){
		int tot=0;
		//���ο� ��ü�� ������ toyArr�� ��ü�� �����Ѵ�. t1(Toys��� ��ü �迭)==toyArr(�÷���)
		Toys[] t1=new Toys[toyArr.size()]; //Toys��� Ŭ���� ��ü������������ �Ǵ� �迭(��ü �迭) 
		for (int i = 0; i < toyArr.size(); i++) {
			t1[i]=(Toys)(toyArr.get(i));
		}
		//������ ��� 
		for (int i = 0; i < t1.length; i++) {
			if (t1[i].gettType().equals(kind)) {
				tot += (int)(t1[i].gettPrice());
			}
		}
		return tot;
	}
	
}
