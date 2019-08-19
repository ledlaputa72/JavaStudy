package Day025_Date;

import java.util.Calendar;
import java.util.Date;

public class CalanderStudy01 {

	public static void main(String[] args) {
		Calendar cal1=Calendar.getInstance(); //new가 없다. 
		//객체없이 클래스.메소드를 호출(static 메소드), cal1(static 객체)
		
		int year = cal1.get(Calendar.YEAR);
		int mon = cal1.get(Calendar.MONTH)+1;
		int day = cal1.get(Calendar.DAY_OF_MONTH);
		int hour = cal1.get(Calendar.HOUR_OF_DAY);
		int min = cal1.get(Calendar.MINUTE);
		int sec = cal1.get(Calendar.SECOND);
		
		System.out.println("오늘 날짜와 지금 시간은 ");
		System.out.println(year + "년 " + mon + "월 " + day + "일 ");
		System.out.println(hour + "시 " + min + "분 " + sec + "초 ");
		
		//지금까지 살아온 날 
		System.out.println("----------살아온날-------------");
		
		Calendar birth2=Calendar.getInstance();
		birth2.set(1972,Calendar.NOVEMBER,8,0,0,0);
		
		Date today=cal1.getTime();
		Date saengil=birth2.getTime();
		
		//Calendar형식을 Date형식으로  바꾸는 방법
		long cha=today.getTime()-saengil.getTime(); //getTime 이 두번 나온다. 
		long nal=cha/1000/3600/24;
		
		System.out.println((saengil.getYear()+1900)+"년 "+(saengil.getMonth()+1)+"월 "+saengil.getDate()+"일 "+"부터 살아온 날은 "+nal+"일 입니다.");
		
		//Calendar 형식을 그대로 쓰는 방법
		long cha1=cal1.getTimeInMillis()-birth2.getTimeInMillis();
		long nal2=cha1/1000/3600/24;
		
		System.out.println((birth2.get(Calendar.YEAR))+"년  "+(birth2.get(Calendar.MONTH)+1)+"월 "+birth2.get(Calendar.DAY_OF_MONTH)+"일 "+"부터 살아온 날은  "+nal2+"일 입니다.");
		
	}

}
