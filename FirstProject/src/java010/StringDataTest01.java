package java010;

import java.io.*;

public class StringDataTest01 {

	public static void main(String[] args) throws IOException {
		
		//jum파일을 읽어온다. 
		FileReader jumR=new FileReader("e:/test/jum.txt");
		BufferedReader bffR=new BufferedReader(jumR);
		
		//jum1파일에 덮어쓴다. 
		FileWriter jumW=new FileWriter("e:/test/jum.txt", true); 
		BufferedWriter bffW=new BufferedWriter(jumW);
		PrintWriter prtW=new PrintWriter(bffW, true);
		
		int imsi=0;
		int sum=0;
		int inwon=0;
		double avg=0.00;
		
		//파일에서 점수를 분리해서 총점과 평균을 구한다. 
		String str1 =null;
		while ((str1=bffR.readLine())!=null) { 
			String[] arr1=str1.split(":"); 
			imsi=Integer.parseInt(arr1[1]);
			sum=sum+imsi;
			inwon++;
       }
		avg=sum/(inwon*1.0);
		bffR.close();jumR.close();
		
		//추가로 입력하기
		prtW.println();
		prtW.printf("총점:%d", sum);
		prtW.println();
		prtW.printf("평균:%.2f", avg);
		
		/*//선생님 방식 
		//버림의 원리  : (int)(376.237733*100) / 100.0 =376.23
		double avg0=sum/(inwon*1.0); //91.6675
		double avg1=(int)(avg0*100)/100.0; //91.66
		double avg3=Double.parseDouble(String.format("%.2f", avg1));
		prtW.println("\n총점:"+sum); //파일 추가
		prtW.println("평균:"+avg3); //파일 추가
		*/		
		prtW.close();bffW.close();jumW.close();
	}

}


