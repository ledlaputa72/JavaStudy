package Day048_ImageIO_Socketing_dataStream;

import java.net.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.Date;

import javax.imageio.ImageIO;

import java.text.SimpleDateFormat;

public class TcpServerIMG {
	public static void main(String args[]) throws IOException {

		ServerSocket ss1 = new ServerSocket(57789);
		System.out.println("���� �غ�Ǿ� ����....");

		while (true) {

			System.out.println("��ٸ��� ��....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "���� ����");

			/////////////////////////////
			File file1 = new File("d:/aa.jpg");
			                         ////���ٻ����� file1�� ���ϸ���� 
			FileInputStream fis1 = new FileInputStream(file1);
			DataInputStream dis1 = new DataInputStream(fis1);

			DataOutputStream dos1 = new DataOutputStream(s1.getOutputStream());

			 //File file1 = new File("d:/aa.jpg");
		      BufferedImage buffimage1= ImageIO.read(dis1); 
		              //���� ���� read�Ͽ�   �̹���ȭ �Ѵ��� 
		      ImageIO.write(buffimage1, "jpg", dos1);//////
                      //������ i/o stream�� ���� ���� 
			 s1.close();
		 
			System.out.println("jpg �����ߴ�~~~");
		}

		
		//////////////////////////////////

	}
}
