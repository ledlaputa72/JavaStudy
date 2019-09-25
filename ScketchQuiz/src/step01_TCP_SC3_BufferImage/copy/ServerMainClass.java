package step01_TCP_SC3_BufferImage.copy;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;

class SendRcvThread extends Thread {
	//클라이언트에서 받은 데이터를 서버에서 다시 클라이언트로 보내기 
	Socket s1;
	
	public SendRcvThread(Socket s1) throws IOException {
		this.s1 = s1;
	}
	
	public void run(){
	
		try {
			BufferedImage bufferImage = ImageIO.read(s1.getInputStream());//read - 네트웍에서 받은 버퍼 이미지를
			System.out.print("서버 : 클라에서 이미지 받음"+"\t");
			System.out.println("받은 파일 : " + bufferImage);
			
			ImageIO.write(bufferImage, "png", s1.getOutputStream()); //write - 네트웍으로 다시 보냄
			System.out.print("서버 : 클라로 받은 이미지 보냄"+"\t");
			System.out.println("보낸 파일 : " + bufferImage);
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		
		try {
			ServerSocket ss1=new ServerSocket(7777);
			System.out.println("서버 대기중 ....");
			
			while(true) {
				Socket s1=ss1.accept();
				System.out.println("접속자 정보 : "+s1.toString());
				
				SendRcvThread srt1=new SendRcvThread(s1);
				srt1.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
