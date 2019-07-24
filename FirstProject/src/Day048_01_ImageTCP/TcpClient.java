package Day048_01_ImageTCP;

import java.io.*;
import java.net.*;

public class TcpClient {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket s1 = new Socket("127.0.0.1",37781);
		
		DataInputStream dis1=new DataInputStream(s1.getInputStream());
		
		int len1=dis1.readInt(); //서버가 보낸 파일 길이 먼저 받아옴 
		byte[] byteBae2=new byte[len1]; //길이만큼 배열을 잡음 
		dis1.readFully(byteBae2); //그리고 내용을 받아트배열로 
		
		FileOutputStream fos1 = new FileOutputStream("e:/bb.jpg");
		fos1.write(byteBae2);//받은 바이트 배열 --> 파일로 
		
		System.out.println("끝~~~");
	}
}
