package java007_Date;

import java.util.*;

public class DateExamTest02 {

	public static void main(String[] args) {
		
		Date d10=new Date(); //오늘 날짜
		Date b10=new Date(1972-1900,11-1,8); //생일
		long cha=d10.getTime()-b10.getTime(); //getTime : 1970.1.1부터의 경과시간을 ms로 변환
		long nal=cha/1000/3600/24; //초/시간/일
		
		System.out.println((b10.getYear()+1900)+"년 "+(b10.getMonth()+1)+"월 "+b10.getDate()+"일 "+"부터 살아온 날은 "+nal+"일 입니다.");
		
	}

}
