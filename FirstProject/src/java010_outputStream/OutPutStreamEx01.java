package java010_outputStream;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutPutStreamEx01 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fo1=new FileOutputStream("E:/dd.txt", true);
		//메모리에 있는걸 파일로 저장하는 것 
		
		System.out.println("글자 입력한다. ");
		while (true) {
			int cnt=System.in.available();
			if (cnt>0) {
				byte[] b1=new byte[cnt];
				int bada = System.in.read(b1);
				if(bada==-1) break;
				fo1.write(b1,0,bada);
				System.out.println("수록중");
			}
		}
		fo1.close();
	}

}
