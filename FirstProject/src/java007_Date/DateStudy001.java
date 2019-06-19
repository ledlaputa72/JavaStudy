package java007_Date;

import java.util.Date;

public class DateStudy001 {

	public static void main(String[] args) {
		
		Date d1=new Date(); //내장 class
		
		String s1=d1.toLocaleString(); //객체.메소드()
		System.out.println("현재 날짜 및 시간 : " + s1);
		System.out.println("현재 날짜 및 시간 : " + d1.toString());
		
		System.out.println(d1.getYear()+1900+"년");//119
		System.out.println(d1.getMonth()+1+"월");//5
		//System.out.println(d1.getDay()+"요일");//3, 일이 아님
		/*
		//switch를 이용한 방법
		int d2=d1.getDay();
		switch (d2) {
		case 3:
			System.out.println("수요일");
			break;
		default:
			break;
		}
		*/
		/*
		//if로 짜기 
		int d3=d1.getDay();
		if (d3==3) {
			System.out.println("수요일");
		}
		*/
		/*
		//배열로 짜기
		String[] d4={"일요일","월요일","화요일","수요일","목요일","금요일","토요일"};
		System.out.println(d4[d1.getDay()]);
		*/
		System.out.println(d1.getDate()+"일");//19일
	}

}
