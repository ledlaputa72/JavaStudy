package Day025_Date;

import java.util.Calendar;
import java.util.Date;

public class CalanderStudy01 {

	public static void main(String[] args) {
		Calendar cal1=Calendar.getInstance(); //new�� ����. 
		//��ü���� Ŭ����.�޼ҵ带 ȣ��(static �޼ҵ�), cal1(static ��ü)
		
		int year = cal1.get(Calendar.YEAR);
		int mon = cal1.get(Calendar.MONTH)+1;
		int day = cal1.get(Calendar.DAY_OF_MONTH);
		int hour = cal1.get(Calendar.HOUR_OF_DAY);
		int min = cal1.get(Calendar.MINUTE);
		int sec = cal1.get(Calendar.SECOND);
		
		System.out.println("���� ��¥�� ���� �ð��� ");
		System.out.println(year + "�� " + mon + "�� " + day + "�� ");
		System.out.println(hour + "�� " + min + "�� " + sec + "�� ");
		
		//���ݱ��� ��ƿ� �� 
		System.out.println("----------��ƿ³�-------------");
		
		Calendar birth2=Calendar.getInstance();
		birth2.set(1972,Calendar.NOVEMBER,8,0,0,0);
		
		Date today=cal1.getTime();
		Date saengil=birth2.getTime();
		
		//Calendar������ Date��������  �ٲٴ� ���
		long cha=today.getTime()-saengil.getTime(); //getTime �� �ι� ���´�. 
		long nal=cha/1000/3600/24;
		
		System.out.println((saengil.getYear()+1900)+"�� "+(saengil.getMonth()+1)+"�� "+saengil.getDate()+"�� "+"���� ��ƿ� ���� "+nal+"�� �Դϴ�.");
		
		//Calendar ������ �״�� ���� ���
		long cha1=cal1.getTimeInMillis()-birth2.getTimeInMillis();
		long nal2=cha1/1000/3600/24;
		
		System.out.println((birth2.get(Calendar.YEAR))+"��  "+(birth2.get(Calendar.MONTH)+1)+"�� "+birth2.get(Calendar.DAY_OF_MONTH)+"�� "+"���� ��ƿ� ����  "+nal2+"�� �Դϴ�.");
		
	}

}
