package Day049_01_FileIO;

import java.io.*;
import java.net.*;

public class TcpClientFILE {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket s1 = new Socket("127.0.0.1", 37799);
		////////////////bb.docx는 에러날수도 있다//////////
		FileOutputStream fos1 = new FileOutputStream("e:/bbb.ppt");
		DataInputStream dis1 = new DataInputStream(s1.getInputStream());
		//aa.doc가 넘어오면 bb.doc로 저장하겠다. 
		
		byte[] byteBae=new byte[1024];
		System.out.println("byte --> file 중 ....");
		int chk;
		while ((chk=dis1.read(byteBae)) != -1) {
			fos1.write(byteBae);
		}
			//byte 배열에 있는 것을 file로 conversion 저장
		fos1.close(); dis1.close(); s1.close();
		System.out.println("끝...");
	}//main end
}
