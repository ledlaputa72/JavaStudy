package Day029_FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest01 {

	public static void main(String[] args) throws IOException {

		int imsi=0;
		FileInputStream fis1=new FileInputStream ("e:/aa.txt"); //aa.txt ����
		FileOutputStream fos1=new FileOutputStream ("e:/aa4.txt", false); //aa3.txt ����
		
		//��ü ���ڸ� ��� ������ . while�� �ʿ��� 
		while ((imsi=fis1.read())!=-1) {//������ ������ ����   
			fos1.write(imsi);
			System.out.println(imsi+"������ ������");
		}
		
		/*//ù ���ڸ� �����
		imsi=fis1.read();  
		fos1.write(imsi);*/
		
		fis1.close();fos1.close();
		
	}

}
