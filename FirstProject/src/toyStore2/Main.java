package toyStore2;

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
		
		
		/*		/////////////////////////////////////////////////////
				//��ü�� �̿��� ��� - ����� 
				Caculate c1=new Caculate(); //����� ���� ��ü
				
				c1.printList(toyArr); //c1��ü�� �̿��ؼ� Caculate�� �޼ҵ带 ��� - ǰ�� ���
				 
				 //���� �˻��ؼ� ����ϱ�
				 String type = null;
				 for (int i = 0; i < toyArr.size(); i++) {
					 if(i%3==0) {
						 type=toyArr.get(i).gettType(); //���� ���ϱ� 
						 c1.typeSum2(toyArr, type); //c1��ü�� �̿��ؼ� Caculate�� �޼ҵ带 ��� - ���� �հ� ���
					 }
				}
		
				 c1.sumTotal(toyArr);//c1��ü�� �̿��ؼ� Caculate�� �޼ҵ带 ��� - ���� ��� 
		*/		 
		 ///////////////////////////////////////////////////////////////
		 //ToyComputer Ŭ������ �̿��� ��--������ ��� 
		
		int tothap=0;
		int carSum=ToyComputer.kajaKywsan(toyArr, "�ڵ���");
		int robotSum=ToyComputer.kajaKywsan(toyArr, "�κ�");
		int dollSum=ToyComputer.kajaKywsan(toyArr, "����");
		int gameSum=ToyComputer.kajaKywsan(toyArr, "����");
		int puzzleSum=ToyComputer.kajaKywsan(toyArr, "����");
		
		tothap=carSum+robotSum+dollSum+gameSum+puzzleSum;
		
		System.out.println("===================================");
		System.out.println("�ڵ�����"+carSum);
		System.out.println("�κ���"+robotSum);
		System.out.println("������"+dollSum);
		System.out.println("������"+gameSum);
		System.out.println("������"+puzzleSum);
		System.out.println("�峲�� �뿩�� �� �հ�"+tothap);
		
		

	}// main end

}//class end
