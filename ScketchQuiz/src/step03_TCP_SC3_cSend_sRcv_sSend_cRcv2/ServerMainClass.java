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

//���� <--> Ŭ�� �ޱ� ������ �ϳ��� ���� ###############################################
class ServerRcvSend extends Thread {
	Socket s1;

	static BufferedImage bufferImage1; //�߰�)
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
				System.out.println("SR1) ���� �̹��� ����: " + bufferImage1); //�߰�) ���۳��� Ȯ��
				
				bufferImage2=bufferImage1;
				System.out.println("����1 :  " + bufferImage1);
			}
			while(bos1!=null) {
				ImageIO.write(bufferImage2, "bmp", bos1);
				System.out.println("SS2) ������  �̹��� ���� : " + bufferImage2);
				
				bos1.flush();
				System.out.println("SS3) ������ �̹��� : " + bos1);
			}
		}
		catch(Exception e) {
			System.out.println(e);
		}
	}
}//ServerRcv end


//���� Ŭ���� #############################################################
public class ServerMainClass {

	public static void main(String[] args) throws IOException, InterruptedException{
		ServerSocket ss1 = new ServerSocket(7777);
		System.out.println("���� ����� ....");

		while (true) {
			Socket s1 = ss1.accept();
			System.out.println("������ ���� : " + s1.toString());
			//������ /////////////////////////////
			ServerRcvSend srs1 = new ServerRcvSend(s1);
			srs1.start();
			System.out.println("�������6 ");
		}
	}
}
