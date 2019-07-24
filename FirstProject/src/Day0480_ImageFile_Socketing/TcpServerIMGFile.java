package Day0480_ImageFile_Socketing;
import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpServerIMGFile {
	public static void main(String args[]) throws IOException {

		ServerSocket ss1 = new ServerSocket(37787);
		System.out.println("서버 준비되어 있음....");

		while (true) {

			System.out.println("기다리는 중....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "에서 접속");

						/////////////////////////////
			File file1 = new File("d:/aa.jpg"); //원본파일 
			                        //.doc  
			//파일 input 준비
			FileInputStream fis1 = new FileInputStream(file1);
			DataInputStream dis1 = new DataInputStream(fis1);

			 //output 준비 
			DataOutputStream dos1 =
					 new DataOutputStream(s1.getOutputStream());
             
			//파일 전송 시작
			int len = 1024;
			byte[] byteBae = new byte[len];
			int chk;
			while ((chk = dis1.read(byteBae, 0, byteBae.length)) != -1) {
				dos1.write(byteBae); //file ---> 배열에 넣어 byte 전송 
			}
			//이것도 당연히 가능
			// dis1.readFully(byteBae);//파일을 바이트 읽어내어 배열로
			// dos1.write(byteBae);//전송
             dos1.flush(); 
             dis1.close(); dos1.close(); s1.close();
			 
			System.out.println("전송했당~~~");
		}

		
		//////////////////////////////////

	}
}
