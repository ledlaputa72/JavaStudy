package java007_Date;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateExamTest01 {

	public static void main(String[] args) {
		
		//출력 포맷을 변경하는 클래스 함수 
		SimpleDateFormat sdf1=new SimpleDateFormat("G yyyy.MM.dd HH:mm:ss",Locale.KOREA); 
		
		Date d7=new Date();
		d7.setDate(d7.getDate()+100-1); //만난지 100일
		String d8=sdf1.format(d7); //설정된 포맷의 날짜로 표시 
		System.out.println(d8); 
	}

}
