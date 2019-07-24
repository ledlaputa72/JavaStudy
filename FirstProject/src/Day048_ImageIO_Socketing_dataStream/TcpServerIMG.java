package Day048_ImageIO_Socketing_dataStream;

import java.net.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;

import javax.imageio.ImageIO;

import java.text.SimpleDateFormat;

public class TcpServerIMG {
	public static void main(String args[]) throws IOException {

		ServerSocket ss1 = new ServerSocket(57789);
		System.out.println("서버 준비되어 있음....");

		while (true) {

			System.out.println("기다리는 중....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "에서 접속");

			/////////////////////////////
			File file1 = new File("d:/aa.jpg");
			                         ////이줄생략시 file1에 파일명써줌 
			FileInputStream fis1 = new FileInputStream(file1);
			DataInputStream dis1 = new DataInputStream(fis1);

			DataOutputStream dos1 = new DataOutputStream(s1.getOutputStream());

			 //File file1 = new File("d:/aa.jpg");
		      BufferedImage buffimage1= ImageIO.read(dis1); 
		              //기존 파일 read하여   이미지화 한다음 
		      ImageIO.write(buffimage1, "jpg", dos1);//////
                      //소켓의 i/o stream을 통해 보냄 
			 s1.close();
		 
			System.out.println("jpg 전송했당~~~");
		}

		
		//////////////////////////////////

	}
}
