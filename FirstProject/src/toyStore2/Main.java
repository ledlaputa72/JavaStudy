package toyStore2;

import java.util.ArrayList;
import java.util.Scanner;

import toyStore.Car;
import toyStore.Puzzle;

public class Main {

	public static void main(String[] args) {

		ArrayList<Toys> toyArr=new ArrayList<Toys>();
		//��ǰ �Է�
		toyArr.add(new Toys("t001","����1","1",1000));
		toyArr.add(new Toys("t002","����2","1",1000));
		toyArr.add(new Toys("t003","����3","1",1000));
		
		toyArr.add(new Toys("t011","�Ǵ�1","2",2000));
		toyArr.add(new Toys("t012","�Ǵ�2","2",2000));
		toyArr.add(new Toys("t013","�Ǵ�3","2",2000));
		
		toyArr.add(new Toys("t021","�Ƿη�1","3",3000));
		toyArr.add(new Toys("t022","�Ƿη�2","3",3000));
		toyArr.add(new Toys("t023","�Ƿη�3","3",3000));
		
		toyArr.add(new Toys("t031","������1","4",4000));
		toyArr.add(new Toys("t032","������2","4",4000));
		toyArr.add(new Toys("t033","������3","4",4000));
		
		toyArr.add(new Toys("t041","����1","5",5000));
		toyArr.add(new Toys("t042","����2","5",5000));
		toyArr.add(new Toys("t043","����3","5",5000));
		
		//ǰ�� ���
		System.out.println("  ID   |      �̸�      |      ����      |     ���� ");
		System.out.println("--------------------------------------------");
		 for (int i = 0; i < toyArr.size(); i++) {
	            System.out.println(toyArr.get(i));
	       }
		 System.out.println("--------------------------------------------");
		 
		 //���� 
		 int sumToy=0;
		 int imsi=0;
		 for (int i = 0; i < toyArr.size(); i++) {
			 imsi=toyArr.get(i).gettPrice();
			 sumToy=sumToy+imsi;
		}
		 System.out.println("�峲�� �뿩�� �� �հ� : "+sumToy+"��");
		 
		 //��ǰ �˻�
		 System.out.println("--------------------------------------------");
		 System.out.println("�峭�� ���� �˻� ");
         Scanner sc=new Scanner(System.in);
         System.out.print("car, robot, doll, game, puzzle :  ");
         String sc1=sc.next(); //�Է¹��� ���� String sc1����
         //�˻�ã��
         System.out.println("�˻��� ��ǰ�� �����  �Ʒ��� �����ϴ�.");
         System.out.println("--------------------------------------------");
         int sumSearch=0;
         int imsi1=0;
         int sw=0;
         
         for (int i = 0; i < toyArr.size(); i++) {
              if (sc1.equals(toyArr.get(i).gettType())) { //�׸�  �˻�
            	  System.out.println(toyArr.get(i));
                   imsi1=toyArr.get(i).gettPrice();
                   sumSearch=sumSearch+imsi1;
                   sw=1;
              }
              else {
                   break;
              }
         }
         System.out.println("�հ� : "+sumSearch);
         if (sw==0) {
              System.out.println("!!!!!�˻��� ��ǰ�� ã�� ��  �����ϴ�.!!!!! ");
         }
         System.out.println("--------------------------------------------");
	}

}
