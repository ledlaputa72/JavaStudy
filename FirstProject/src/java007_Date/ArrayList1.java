package java007_Date;

import java.util.*;

class SMarket{
	private String sangpum;
	private int price;
	
	public SMarket(String sangpum, int price) {
		this.sangpum = sangpum;
		this.price = price;
	}
	
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
		System.out.println();
		
		//��ü�� �־�� /////////////////////
		arr3.add(new SMarket("����",1000)); //class �ʿ� 
		System.out.println(arr3.get(4));//�߰��� ��ü Ŭ������ ����� ���� 
	} //main end
}//class end
