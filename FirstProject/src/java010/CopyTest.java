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
		while ((cnt = fi1.available())>0) { //�о�ü� �ִ� ����Ʈ ����0����Ʈ �̻��̸�
			b1=new byte[cnt];
			int bada1 = fi1.read(b1); //b1ũ�⸸ŭ �б�
			if(bada1==-1) //bada�� ���̻� ������ ������ -1���� ���´�. 
				break;
			}
			
			for (int i = 0; i < b1.length; i++) {
				System.out.println(b1[i]);
			}
		/*
		while (true) {
		if (cnt>0) {
		System.out.println("�Է¹��� ������ ���̴� : "+cnt); //�Է¹��� ���� ����
		int bada2 = System.in.read(b1);
		fo1.write(b1,0,bada2);
		}
		}//while for output
		*/
		
	}

}
