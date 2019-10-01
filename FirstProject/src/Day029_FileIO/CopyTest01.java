package Day029_FileIO;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest01 {

	public static void main(String[] args) throws IOException {

		int imsi=0;
		FileInputStream fis1=new FileInputStream ("e:/aa.txt"); //aa.txt 오픈
		FileOutputStream fos1=new FileOutputStream ("e:/aa4.txt", false); //aa3.txt 오픈
		
		//전체 글자를 모두 복사함 . while이 필요함 
		while ((imsi=fis1.read())!=-1) {//내용이 없을때 까지   
			fos1.write(imsi);
			System.out.println(imsi+"나지금 복사중");
		}
		
		/*//첫 글자만 복사됨
		imsi=fis1.read();  
		fos1.write(imsi);*/
		
		fis1.close();fos1.close();
		
	}

}
