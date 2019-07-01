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

public class Main {

	public static void main(String[] args) {

		ArrayList<Toys> toyArr=new ArrayList<Toys>(); //�����͸� �����ϱ� ���� �迭
		toyArr.add(new Toys("t001","����1","�ڵ���",1000));
		toyArr.add(new Toys("t002","����2","�ڵ���",1000));
		toyArr.add(new Toys("t003","����3","�ڵ���",1000));
		toyArr.add(new Toys("t011","�Ǵ�1","�κ�",2000));
		toyArr.add(new Toys("t012","�Ǵ�2","�κ�",2000));
		toyArr.add(new Toys("t013","�Ǵ�3","�κ�",2000));
		toyArr.add(new Toys("t021","�Ƿη�1","����",3000));
		toyArr.add(new Toys("t022","�Ƿη�2","����",3000));
		toyArr.add(new Toys("t023","�Ƿη�3","����",3000));
		toyArr.add(new Toys("t031","������1","����",4000));
		toyArr.add(new Toys("t032","������2","����",4000));
		toyArr.add(new Toys("t033","������3","����",4000));
		toyArr.add(new Toys("t041","����1","����",5000));
		toyArr.add(new Toys("t042","����2","����",5000));
		toyArr.add(new Toys("t043","����3","����",5000));
		
		 ///////////////////////////////////////////////////////////////
		 //ToyComputer Ŭ������ �̿��� ��
		
		ToyComputer.kajaKywsan(toyArr, "�ڵ���");
		ToyComputer.kajaKywsan(toyArr, "�κ�");
		ToyComputer.kajaKywsan(toyArr, "����");
		ToyComputer.kajaKywsan(toyArr, "����");
		ToyComputer.kajaKywsan(toyArr, "����");

		System.out.println("===================================");
		System.out.println("�ڵ�����"+ToyComputer.carTot); //Ŭ������.�Ӽ�(static) 
		//���� ��ü.�޼ұ�() //Ŭ������.����ƽ�żҵ�() ��) Sysout.out.println() 
		System.out.println("�κ���"+ToyComputer.robotTot);
		System.out.println("������"+ToyComputer.dollTot);
		System.out.println("������"+ToyComputer.gameTot);
		System.out.println("������"+ToyComputer.puzzleTot);
		System.out.println("----------------------------------");
		System.out.println("�峲�� �뿩�� �� �հ�"+ToyComputer.tothap);

	}// main end

}//class end
