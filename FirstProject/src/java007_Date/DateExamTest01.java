package java007_Date;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateExamTest01 {

	public static void main(String[] args) {
		
		//��� ������ �����ϴ� Ŭ���� �Լ� 
		SimpleDateFormat sdf1=new SimpleDateFormat("G yyyy.MM.dd HH:mm:ss",Locale.KOREA); 
		
		Date d7=new Date();
		d7.setDate(d7.getDate()+100-1); //������ 100��
		String d8=sdf1.format(d7); //������ ������ ��¥�� ǥ�� 
		System.out.println(d8); 
	}

}
