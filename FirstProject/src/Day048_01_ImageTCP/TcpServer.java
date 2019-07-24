package Day048_01_ImageTCP;

import java.io.*;
import java.net.*;

public class TcpServer {
	public static void main(String[] args) throws IOException {
		
		ServerSocket ss1 = new ServerSocket(37781);
		System.out.println("서버 준비되어 있음....");
		
		while (true) {
			
			System.out.println("기다리는 중...");
			
			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress()+"에서 접속");
			
			//받기 위해 처리 (입력)
			File file1=new File("e:/aa.jpg");
			FileInputStream fis1=new FileInputStream(file1);
			DataInputStream dis1=new DataInputStream(fis1);
			//DataInputStream dis1=new DataInputStream(new FileInputStream(file1));
			
			//보내기 처리  (출력)
			DataOutputStream dos1=new DataOutputStream(s1.getOutputStream());
			
			//보내기 처리 - byte 배열 이용 //////////////////////
			byte[] byteBae = new byte[(int)file1.length()]; //파일 길이만큼 배열 잡음 
			System.out.println("file ---> byte중...");
			
			//자료 받기 
			dis1.readFully(byteBae); //파일내용 -->바이트배열
			
			//자료 보내기 
			dos1.writeInt(byteBae.length); //파일 길이 먼저 전송
			dos1.write(byteBae); //바이트 배열 전송
			
			System.out.println("전송했당~~~");
			
		}//while end
	}//main end
}//class end
