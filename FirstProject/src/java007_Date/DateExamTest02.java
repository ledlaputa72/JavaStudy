package java007_Date;

import java.util.*;

public class DateExamTest02 {

	public static void main(String[] args) {
		
		Date d10=new Date(); //���� ��¥
		Date b10=new Date(1972-1900,11-1,8); //����
		long cha=d10.getTime()-b10.getTime(); //getTime : 1970.1.1������ ����ð��� ms�� ��ȯ
		long nal=cha/1000/3600/24; //��/�ð�/��
		
		System.out.println((b10.getYear()+1900)+"�� "+(b10.getMonth()+1)+"�� "+b10.getDate()+"�� "+"���� ��ƿ� ���� "+nal+"�� �Դϴ�.");
		
	}

}
