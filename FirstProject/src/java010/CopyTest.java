package java010;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyTest {

	public static void main(String[] args) throws IOException {

		FileInputStream fi1=new FileInputStream("e:/aa.txt");
		FileOutputStream fo1=new FileOutputStream("e:/cc.txt");
		
		int cnt;
		byte[] b1=null;
		while ((cnt = fi1.available())>0) { //읽어올수 있는 바이트 수가0바이트 이상이면
			b1=new byte[cnt];
			int bada1 = fi1.read(b1); //b1크기만큼 읽기
			if(bada1==-1) //bada는 더이상 읽을게 없으면 -1값을 갖는다. 
				break;
			}
			
			for (int i = 0; i < b1.length; i++) {
				System.out.println(b1[i]);
			}
		/*
		while (true) {
		if (cnt>0) {
		System.out.println("입력받은 문자의 길이는 : "+cnt); //입력받은 문자 길이
		int bada2 = System.in.read(b1);
		fo1.write(b1,0,bada2);
		}
		}//while for output
		*/
		
	}

}
