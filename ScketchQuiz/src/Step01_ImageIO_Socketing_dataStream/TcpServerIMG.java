package Step01_ImageIO_Socketing_dataStream;

import java.net.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import javax.imageio.ImageIO;


import java.text.SimpleDateFormat;



public class TcpServerIMG {
	public static void main(String args[]) throws IOException {
		
		ServerSocket ss1 = new ServerSocket(5999);
		System.out.println("서버 준비되어 있음....");
		
		while (true) {

			System.out.println("기다리는 중....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "에서 접속");
			
			//쓰레드 구동
			ImageSendThread tsendSer1 = new ImageSendThread(s1);//초기치 주거니, ThreadSend Class  객체 생성 
			tsendSer1.start(); //Thread 실행
		 
			System.out.println("jpg 전송했당~~~");
		}		
	}
}
