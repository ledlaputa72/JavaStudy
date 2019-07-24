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
		System.out.println("���� �غ�Ǿ� ����....");
		
		while (true) {

			System.out.println("��ٸ��� ��....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "���� ����");

			ImageSendThread tsendSer1 = new ImageSendThread(s1);//�ʱ�ġ �ְŴ�, ThreadSend Class  ��ü ���� 
			tsendSer1.start(); //Thread ����
		 
			System.out.println("jpg �����ߴ�~~~");
		}
		
	}
}
