package java007_Date;

import java.util.Date;

public class DateStudy001 {

	public static void main(String[] args) {
		
		Date d1=new Date(); //���� class
		
		String s1=d1.toLocaleString(); //��ü.�޼ҵ�()
		System.out.println("���� ��¥ �� �ð� : " + s1);
		System.out.println("���� ��¥ �� �ð� : " + d1.toString());
		
		System.out.println(d1.getYear()+1900+"��");//119
		System.out.println(d1.getMonth()+1+"��");//5
		//System.out.println(d1.getDay()+"����");//3, ���� �ƴ�
		/*
		//switch�� �̿��� ���
		int d2=d1.getDay();
		switch (d2) {
		case 3:
			System.out.println("������");
			break;
		default:
			break;
		}
		*/
		/*
		//if�� ¥�� 
		int d3=d1.getDay();
		if (d3==3) {
			System.out.println("������");
		}
		*/
		/*
		//�迭�� ¥��
		String[] d4={"�Ͽ���","������","ȭ����","������","�����","�ݿ���","�����"};
		System.out.println(d4[d1.getDay()]);
		*/
		System.out.println(d1.getDate()+"��");//19��
	}

}
