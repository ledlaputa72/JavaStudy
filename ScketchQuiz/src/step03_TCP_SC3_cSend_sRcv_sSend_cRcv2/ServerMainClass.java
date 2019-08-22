package step03_TCP_SC3_cSend_sRcv_sSend_cRcv2;

import java.awt.Color;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

//서버 <--> 클라 받기 보내기 하나로 통한 ###############################################
class ServerRcvSend extends Thread {
	Socket s1;

	static BufferedImage bufferImage1; //추가)
	static BufferedInputStream bis1;
	
	static BufferedImage bufferImage2;
	static BufferedOutputStream bos1;
	
	public ServerRcvSend(Socket s1) throws IOException, InterruptedException {
		this.s1 = s1;
		bis1 = new BufferedInputStream(s1.getInputStream());
		bos1 = new BufferedOutputStream(s1.getOutputStream());
	}
	
	public void run() {
		try {
			while (bis1!=null) {
				bufferImage1= ImageIO.read(bis1);
				System.out.println("SR1) 받은 이미지 버퍼: " + bufferImage1); //추가) 버퍼내용 확인
				
				bufferImage2=bufferImage1;
				System.out.println("버퍼1 :  " + bufferImage1);
			}
			while(bos1!=null) {
				ImageIO.write(bufferImage2, "bmp", bos1);
				System.out.println("SS2) 보내는  이미지 버퍼 : " + bufferImage2);
				
				bos1.flush();
				System.out.println("SS3) 보내는 이미지 : " + bos1);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}//ServerRcv end


//메인 클래스 #############################################################
public class ServerMainClass {

	public static void main(String[] args) throws IOException, InterruptedException{
		ServerSocket ss1 = new ServerSocket(7777);
		System.out.println("서버 대기중 ....");

		while (true) {
			Socket s1 = ss1.accept();
			System.out.println("접속자 정보 : " + s1.toString());
			//쓰레드 /////////////////////////////
			ServerRcvSend srs1 = new ServerRcvSend(s1);
			srs1.start();
			System.out.println("쓰레드밖6 ");
		}
	}
}
