package Day049_01_FileIO;

import java.io.*;
import java.net.*;

public class TcpServerFILE {

	public static void main(String[] args) throws IOException {

		ServerSocket ss1=new ServerSocket(37799);
		System.out.println("서버 준비되어있음.....");
		
		while (true) {
			
			System.out.println("기다리는 중 ....");
			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "에서 접속");
			
			//파일 입출력 관련 DataStream 설정 ////////////////////
			File file1=new File("e:/aaa.ppt");
			FileInputStream fis1=new FileInputStream(file1); //읽기 위해
			DataInputStream dis1=new DataInputStream(fis1); //데이터를 받기 위해서 
			DataOutputStream dos1=new DataOutputStream(s1.getOutputStream()); //보내기 위해서
			//////////////////////////////////////////////
			
			int len=1024;
			byte[] byteBae=new byte[len];
			int chk;
			while ((chk=dis1.read(byteBae, 0, byteBae.length)) != -1) {
				dos1.write(byteBae); //file --> 배열에 넣어 byte로 전송
			}
			dos1.flush(); dis1.close(); dos1.close(); s1.close();
			System.out.println("전송했다....");
		} //while end
	}//main end
}
