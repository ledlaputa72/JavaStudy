package step06_02_multiServerTest_Server_ReSend_1Class_Test.copy;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

public class EchoThreadServer extends Thread{
	static int w = 400, h = 400;
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	Socket s1; //����
	BufferedInputStream inputStreamS; //�Է� ��Ʈ�� 
	BufferedOutputStream outputStreamServer; //��� ��Ʈ��
	
	public EchoThreadServer(Socket s1) throws IOException {
		this.s1 = s1;
		inputStreamS = new BufferedInputStream(s1.getInputStream());
		outputStreamServer = new BufferedOutputStream(s1.getOutputStream()); //���� ���
	}

	public void run() {

		try{
			while(true) {
				//�ޱ�/////////////////////////// 
				System.out.println("## ���� �ޱ�1 inputStreamS : " + inputStreamS);
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamS)), 0, 0, w, h, Painter.p2);
				System.out.println("## ���� �ޱ�2 inputStreamS : " + inputStreamS);
				//������ /////////////////////////
				ImageIO.write(ImageIO.read(inputStreamS), "bmp", outputStreamServer); //
				System.out.println("## ���� ������1 outputStreamServer : " + outputStreamServer);
				outputStreamServer.flush(); //���ۿ� ���� �̹�����d ������ ����
				System.out.println("############���� ���� ################");
			}
		}
		catch(Exception e) {}
	}
}
