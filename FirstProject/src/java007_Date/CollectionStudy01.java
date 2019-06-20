package java007_Date;

import java.util.Arrays;
import java.util.Enumeration;
import java.util.Vector;

public class CollectionStudy01 {

	public static void main(String[] args) {
		
		//���� �ʱ�ȭ//////////////
		Vector v7=new Vector(3); //3�� �ʱ� ���̳� ���������� �����ȴ�.  
		
		//�Է�////////////////////
		v7.add(new Integer(100)); //wrapper //boxing 
		v7.add(new Integer(20));
		v7.add(new Integer(300));
		v7.add(new Integer(700));
		
		//���/////////////////////
		for (int i = 0; i < v7.size(); i++) {
			System.out.print(v7.get(i)+"\t");
		}
		System.out.println();
		
		//����//////////////////////
		Object[] ob1=v7.toArray();//vector -> array. Sort �ϱ� ���� �迭�� �ٲٴ� �۾�
		Arrays.sort(ob1); // �迭�� �ٲ۰� ���� 
		for (int i = 0; i < ob1.length; i++) { //���
			System.out.print(ob1[i]+"\t");
		}
		System.out.println();
		
		//���̻���/////////////////
		Enumeration e1=v7.elements(); //���� �ڽ� ��ü 
		
		while (e1.hasMoreElements()) {
			System.out.println(e1.nextElement());
		}
				
		
		
		
	}

}
