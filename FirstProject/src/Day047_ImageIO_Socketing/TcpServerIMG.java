package Day047_ImageIO_Socketing;

import java.net.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;
import javax.imageio.ImageIO;


import java.text.SimpleDateFormat;

class ImageSendThread extends Thread {
	
	Socket s1;
	
	public ImageSendThread(Socket s1) throws IOException {
		this.s1 = s1;
	}

	public void run(){
		File file1 = new File("e:/sea.jpg");
		try{
			BufferedImage buffimage1= ImageIO.read(file1); 
			ImageIO.write(buffimage1, "jpg", s1.getOutputStream());//////
			s1.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}

public class TcpServerIMG extends Thread{
	public static void main(String args[]) throws IOException {
		
		ServerSocket ss1 = new ServerSocket(5777);
		System.out.println("서버 준비되어 있음....");
		
		while (true) {

			System.out.println("기다리는 중....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "에서 접속");

			ImageSendThread tsendSer1 = new ImageSendThread(s1);//초기치 주거니, ThreadSend Class  객체 생성 
			tsendSer1.start(); //Thread 실행
		 
			System.out.println("jpg 전송했당~~~");
		}
		
	}
}
