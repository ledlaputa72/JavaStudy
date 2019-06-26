package java010;

import java.io.*;

public class StringDataTest01 {

	public static void main(String[] args) throws IOException {
		
		//jum������ �о�´�. 
		FileReader jumR=new FileReader("e:/test/jum.txt");
		BufferedReader bffR=new BufferedReader(jumR);
		
		//jum1���Ͽ� �����. 
		FileWriter jumW=new FileWriter("e:/test/jum.txt", true); 
		BufferedWriter bffW=new BufferedWriter(jumW);
		PrintWriter prtW=new PrintWriter(bffW, true);
		
		int imsi=0;
		int sum=0;
		int inwon=0;
		double avg=0.00;
		
		//���Ͽ��� ������ �и��ؼ� ������ ����� ���Ѵ�. 
		String str1 =null;
		while ((str1=bffR.readLine())!=null) { 
			String[] arr1=str1.split(":"); 
			imsi=Integer.parseInt(arr1[1]);
			sum=sum+imsi;
			inwon++;
       }
		avg=sum/(inwon*1.0);
		bffR.close();jumR.close();
		
		//�߰��� �Է��ϱ�
		prtW.println();
		prtW.printf("����:%d", sum);
		prtW.println();
		prtW.printf("���:%.2f", avg);
		
		/*//������ ��� 
		//������ ����  : (int)(376.237733*100) / 100.0 =376.23
		double avg0=sum/(inwon*1.0); //91.6675
		double avg1=(int)(avg0*100)/100.0; //91.66
		double avg3=Double.parseDouble(String.format("%.2f", avg1));
		prtW.println("\n����:"+sum); //���� �߰�
		prtW.println("���:"+avg3); //���� �߰�
		*/		
		prtW.close();bffW.close();jumW.close();
	}

}


