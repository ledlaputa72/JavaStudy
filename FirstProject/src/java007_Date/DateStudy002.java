package java007_Date;

import java.util.Date;

public class DateStudy002 {

	public static void main(String[] args) {

		Date d1=new Date(); //내장 class
		String s1=d1.toLocaleString(); //객체.메소드()
		
		String[] arr={"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		String str1="오늘은 ";
		str1 += (d1.getYear()+1900)+"년 ";
		str1 += (d1.getMonth()+1)+"월 ";
		str1 += (d1.getDate())+"일 ";
		str1 += arr[d1.getDay()]+"입니다";
		System.out.println(str1);
		
		
		//기분에서 1000ms 만큼 경과한 시간
		// 기준:1970년 1월 1일 0시 0분 0초 (UTC(세계협정시), GMT(그리니치 천문대 시간))
		Date d22=new Date(1000L); //long int 8바이트, 1000L은 1000ms을 의미 
		String s22=d22.toLocaleString();
		System.out.println("기준에서 1초 지나면 : "+s22);
	}

}
