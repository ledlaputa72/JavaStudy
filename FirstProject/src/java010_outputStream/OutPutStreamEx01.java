package java010_outputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStreamEx01 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fo1=new FileOutputStream("E:/dd.txt", true);
		//�޸𸮿� �ִ°� ���Ϸ� �����ϴ� �� 
		
		System.out.println("���� �Է��Ѵ�. ");
		while (true) {
			int cnt=System.in.available();
			if (cnt>0) {
				byte[] b1=new byte[cnt];
				int bada = System.in.read(b1);
				if(bada==-1) break;
				fo1.write(b1,0,bada);
				System.out.println("������");
			}
		}
		fo1.close();
	}

}
