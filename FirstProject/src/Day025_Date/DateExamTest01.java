package Day025_Date;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateExamTest01 {

	public static void main(String[] args) {
		long start1=System.currentTimeMillis(); //����ð� ��� 1
		//��� ������ �����ϴ� Ŭ���� �Լ� 
		SimpleDateFormat sdf1=new SimpleDateFormat("G yyyy.MM.dd hh:mm:ss a",Locale.KOREA); 
		
		Date d7=new Date();
		d7.setDate(d7.getDate()+100-1); //������ 100�� ���
		String d8=sdf1.format(d7); //������ ������ ��¥�� ǥ�� 
		System.out.println(d8); 
		long end1=System.currentTimeMillis();
		System.out.println("��� �ð��� : "+((end1-start1)/1000.0)+"��"); //����ð� ���2
	}

}
