package step01_ImageIO_Socketing_dataStream2;

import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;
import java.io.*;

class ImageSendThread extends Thread {
	
	Socket s1;
	
	//����Ʈ ������
	public ImageSendThread(Socket s1) throws IOException {
		this.s1 = s1;
	}

	public void run(){
		File file1 = new File("aa.png"); //������ ���� 
		try{
			BufferedImage buffimage1= ImageIO.read(file1); //������ �о�ͼ� ���ۿ� �����ϰ� 
			ImageIO.write(buffimage1, "png", s1.getOutputStream());//���� �̹����� jpg �������� ���Ͼƿ��Ѵ�. 
			s1.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

class ImageRcvThread extends Thread {
	
	Socket s1;
	
	//����Ʈ ������
	public ImageRcvThread(Socket s1) throws IOException {
		this.s1 = s1;
	}
	public void run(){
		BufferedImage buffimage1;
		try {
			buffimage1 = ImageIO.read(s1.getInputStream());
	        //������ i/o stream���� ���� �޾� 
			File file7 = new File("aa4.png"); // �����Ͽ� png�� ���� 
			ImageIO.write(buffimage1, "png", file7); //���� jpg�� ���߸� jpg������ 
			System.out.println("png��  �����"); 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}///
	}
}


public class TcpClientIMG  { //extends JFrame { ////////////////
	public static void main(String args[]) 
			    throws UnknownHostException, IOException {
		Socket s1 = new Socket("127.0.0.1", 8888);

		
		
		
	 	 s1.close();
	     System.out.println("��~~��~~~~");
	}
}
