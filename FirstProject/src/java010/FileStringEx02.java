package java010;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class FileStringEx02 {

	public static void main(String[] args) throws IOException {
		
		//Ű���� �Է� ����� ///////////////////////////////////////////////////
		BufferedReader br1=new BufferedReader(new InputStreamReader(System.in)); //�Ʒ� ����� (2���� 1�ٷ�)
		//InputStreamReader isr1=new InputStreamReader(System.in);
		//BufferedReader br1=new BufferedReader(isr1); //isr1 �ڸ��� new InputStreamReader(System.in) �� ��
		
		//����� ���� /////////////////////////////////////////////////////////
		FileWriter fw1=new FileWriter("e:/cc.txt", false); 
		BufferedWriter bw1=new BufferedWriter(fw1); //���(���Ͽ� ����) ����� 1
		PrintWriter pw1=new PrintWriter(bw1, true); //����� ���� ���ִ� ����� 2
		
		//ó�� 
		System.out.println("�Է��ϼ���. ������ ctrl+z");
		String st =null;
		while ((st=br1.readLine())!=null) { //Ű����� ���� ó�� �� 
			pw1.println(st);
		}
		br1.close();pw1.close(); bw1.close();fw1.close();
	}

}
