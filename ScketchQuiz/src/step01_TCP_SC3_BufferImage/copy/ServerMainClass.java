package step01_TCP_SC3_BufferImage.copy;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;

class SendRcvThread extends Thread {
	//Ŭ���̾�Ʈ���� ���� �����͸� �������� �ٽ� Ŭ���̾�Ʈ�� ������ 
	Socket s1;
	
	public SendRcvThread(Socket s1) throws IOException {
		this.s1 = s1;
	}
	
	public void run(){
	
		try {
			BufferedImage bufferImage = ImageIO.read(s1.getInputStream());//read - ��Ʈ������ ���� ���� �̹�����
			System.out.print("���� : Ŭ�󿡼� �̹��� ����"+"\t");
			System.out.println("���� ���� : " + bufferImage);
			
			ImageIO.write(bufferImage, "png", s1.getOutputStream()); //write - ��Ʈ������ �ٽ� ����
			System.out.print("���� : Ŭ��� ���� �̹��� ����"+"\t");
			System.out.println("���� ���� : " + bufferImage);
			
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}

public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		
		try {
			ServerSocket ss1=new ServerSocket(7777);
			System.out.println("���� ����� ....");
			
			while(true) {
				Socket s1=ss1.accept();
				System.out.println("������ ���� : "+s1.toString());
				
				SendRcvThread srt1=new SendRcvThread(s1);
				srt1.start();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
