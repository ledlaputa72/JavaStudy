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
		System.out.println("���� �غ�Ǿ� ����....");

		while (true) {

			System.out.println("��ٸ��� ��....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "���� ����");

			/////////////////////////////
			//���� from ���� to client
			 File file1 = new File("e:/img01.jpg");
		     //System.out.println(file1.canRead());
		   	 BufferedImage buffimage1= ImageIO.read(file1); 
		              //���� ���� read�Ͽ�   �̹���ȭ �Ѵ��� 
		      ImageIO.write(buffimage1, "jpg", s1.getOutputStream());//////
                      //������ i/o stream�� ���� ���� 
			 s1.close();
		 
			System.out.println("jpg �����ߴ�~~~");
		}
		//////////////////////////////////
	}
}
