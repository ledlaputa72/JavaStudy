package Day025_Date;

import java.text.SimpleDateFormat;
import java.util.*;

public class DateExamTest01 {

	public static void main(String[] args) {
		long start1=System.currentTimeMillis(); //경과시간 계산 1
		//출력 포맷을 변경하는 클래스 함수 
		SimpleDateFormat sdf1=new SimpleDateFormat("G yyyy.MM.dd hh:mm:ss a",Locale.KOREA); 
		
		Date d7=new Date();
		d7.setDate(d7.getDate()+100-1); //만난지 100일 계산
		String d8=sdf1.format(d7); //설정된 포맷의 날짜로 표시 
		System.out.println(d8); 
		long end1=System.currentTimeMillis();
		System.out.println("경과 시간은 : "+((end1-start1)/1000.0)+"초"); //경과시간 계산2
	}

}
