package java007_Date;

import java.util.*;

class SMarket{
	private String sangpum;
	private int price;
	
	//������
	public SMarket() { //this("�� ��ĭ", 0)
	}
	public SMarket(String sangpum, int price) {
		this.sangpum = sangpum;
		this.price = price;
	}
	//toString ��� �޼ҵ�
	public String toString() {
		return "������ ��ǰ�� :"+sangpum+", ���� "+price;
	}
}

public class ArrayList1 {

	public static void main(String[] args) {

		ArrayList arr3=new ArrayList(); 
		//�پ��� �������� �Է��ϱ� ///////////////
		arr3.add(new Integer(300)); //����
		arr3.add(new Double(34.7)); //�Ǽ�
		arr3.add("dayday"); //���ڿ�
		arr3.add('��'); //char 
		
		for (int i = 0; i < arr3.size(); i++) {
			System.out.print(arr3.get(i)+"\t");
		}
		
		//��ü�� �־�� /////////////////////
		arr3.add(new SMarket("����",1000)); //class �ʿ� 
		System.out.println(arr3.get(4));//�߰��� ��ü Ŭ������ ����� ���� 
		//get(4).toString() 
		
		arr3.set(1, "����"); //1��°�� "����"�� �־�� , 1��° ������ �������� "����"�� �� 
		arr3.remove(2); //2��°�� ���� 
		
		for (int i = 0; i < arr3.size(); i++) {
			System.out.print(arr3.get(i)+"\t");
		}
		System.out.println();
		
		//Generic////////////////////////
		ArrayList<String> arr1=new ArrayList<String>();
		System.out.println(arr1.size()); //0
		
		arr1.add("��");
		arr1.add("���");
		arr1.add("����");
		arr1.add("���");
		//arr1.add(30);//���� �߻�, String�� �ƴ� int
		
		arr1.set(1,"����"); //��� -> ����
		arr1.remove(2);//���� ����
		arr1.remove("��"); //�� ���� 
		
		for (int i = 0; i < arr1.size(); i++) {
			System.out.print(arr1.get(i)+"\t");
		}
		System.out.println();
		
		for(String imsi:arr1) {
			System.out.println(imsi); //���� ���
		}
		
		
	} //main end
}//class end
