package toyStore3;

import java.util.ArrayList;
import java.util.Scanner;

import toyStore.Car;
import toyStore.Puzzle;

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
