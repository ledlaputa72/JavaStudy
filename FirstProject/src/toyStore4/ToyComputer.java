package toyStore4;

import java.util.ArrayList;

public class ToyComputer {
	//static �� ���α׷� ������� �����Ǵ� �޸� â�� 
	static int tothap=0;
	static int carTot=0;
	static int robotTot=0;
	static int dollTot=0;
	static int gameTot=0;
	static int puzzleTot=0;
	
	public static int kajaKywsan(ArrayList toyArr, String kind){
		//���ο� ��ü�� ������ toyArr�� ��ü�� �����Ѵ�. t1(Toys��� ��ü �迭)==toyArr(�÷���)
		
		Toys[] t1=new Toys[toyArr.size()]; //Toys��� Ŭ���� ��ü������������ �Ǵ� �迭(��ü �迭) 
		for (int i = 0; i < toyArr.size(); i++) {
			t1[i]=(Toys)(toyArr.get(i));
		}
		//������ ��� 
		for (int i = 0; i < t1.length; i++) {
			if (t1[i].gettType().equals(kind)) {
				if (kind.equals("�ڵ���")) {
					carTot +=(int)(t1[i].gettPrice());
				}
				if (kind.equals("�κ�")) {
					robotTot +=(int)(t1[i].gettPrice());
				}
				if (kind.equals("����")) {
					dollTot +=(int)(t1[i].gettPrice());
				}
				if (kind.equals("����")) {
					gameTot +=(int)(t1[i].gettPrice());
				}
				if (kind.equals("����")) {
					puzzleTot +=(int)(t1[i].gettPrice());
				}
			}
		}
		tothap=carTot+robotTot+dollTot+gameTot+puzzleTot;
		return 0;
	}
}
