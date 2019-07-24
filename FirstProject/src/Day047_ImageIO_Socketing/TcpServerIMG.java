package Day047_ImageIO_Socketing;

import java.net.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;

import javax.imageio.ImageIO;

import java.text.SimpleDateFormat;

public class TcpServerIMG {
	public static void main(String args[]) throws IOException {

		ServerSocket ss1 = new ServerSocket(57795);
		System.out.println("서버 준비되어 있음....");

		while (true) {

			System.out.println("기다리는 중....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "에서 접속");

			/////////////////////////////
			//전송 from 서버 to client
			 File file1 = new File("e:/img01.jpg");
		     //System.out.println(file1.canRead());
		   	 BufferedImage buffimage1= ImageIO.read(file1); 
		              //기존 파일 read하여   이미지화 한다음 
		      ImageIO.write(buffimage1, "jpg", s1.getOutputStream());//////
                      //소켓의 i/o stream을 통해 보냄 
			 s1.close();
		 
			System.out.println("jpg 전송했당~~~");
		}
		//////////////////////////////////
	}
}
