package java010;
//���ڿ� ���� ����

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileStringEx01 {
	//TextViewer 
	public static void main(String[] args) throws IOException {
		
		FileReader fr1=new FileReader("e:/aa.txt"); //���ڿ� ���� ���� read
		BufferedReader br1=new BufferedReader(fr1); //���ڿ� ����� 
		String s =null;
		//file read - ȭ�� write
		while ((s=br1.readLine())!=null) { //������ �� null, �ѱ��ھ��� �� eof, -1
			System.out.println(s);
		}
		br1.close(); fr1.close();
	}

}
