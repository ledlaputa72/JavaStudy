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
		System.out.println("���� �غ�Ǿ� ����....");
		
		while (true) {

			System.out.println("��ٸ��� ��....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "���� ����");
			
			//������ ����
			ImageSendThread tsendSer1 = new ImageSendThread(s1);//�ʱ�ġ �ְŴ�, ThreadSend Class  ��ü ���� 
			tsendSer1.start(); //Thread ����
		 
			System.out.println("jpg �����ߴ�~~~");
		}		
	}
}
