package toyStore2;

import java.util.ArrayList;
import java.util.Scanner;

import toyStore.Car;
import toyStore.Puzzle;

public class Main {

	public static void main(String[] args) {

		ArrayList<Toys> toyArr=new ArrayList<Toys>();
		//��ǰ �Է�
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
		
		//ǰ�� ���
		System.out.println("  ID |  �̸�     |  ����     |  ���� ");
		System.out.println("------------------------------");
		 for (int i = 0; i < toyArr.size(); i++) {
	            System.out.println(toyArr.get(i));
	       }
		 System.out.println("==============================");
		 
		 //������ �հ�
		 String type = null;
		 for (int i = 0; i < toyArr.size(); i++) {
			 if(i%3==0) {
				 type=toyArr.get(i).gettType();
				 typeSum(toyArr, type);
			 }
		}
		 System.out.println("------------------------------");

		 //���� 
		 int sumToy=0;
		 int imsi=0;
		 for (int i = 0; i < toyArr.size(); i++) {
			 imsi=toyArr.get(i).gettPrice();
			 sumToy=sumToy+imsi;
		}
		 System.out.println("�峲�� �뿩�� �� �հ� : "+sumToy+"��");
		 System.out.println("------------------------------");

	}// main end

	private static void typeSum(ArrayList<Toys> toyArr, String type) {
		
        int sumSearch=0;
        int imsi1=0;
        for (int i = 0; i < toyArr.size(); i++) {
       	if((toyArr.get(i).gettType())==type){
       		imsi1=toyArr.get(i).gettPrice();
               sumSearch=sumSearch+imsi1;
       		}  	
        }
        System.out.println(type+" �հ� : "+sumSearch);
		
	}//typeSum end

}//class end
