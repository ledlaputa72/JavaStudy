package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.imageio.ImageIO;

//���� �ޱ� ������ Ŭ���� 
public class ThreadSendServer  extends Thread  {
	Socket s1; //����
	BufferedImage imageSendS; //������ �� ����
	BufferedOutputStream outputStreamServer; //��� ��Ʈ�� Ŭ����  ////
	
	public ThreadSendServer(Socket s1) throws IOException, AWTException {//������ ////
		this.s1 = s1;
		outputStreamServer = new BufferedOutputStream(s1.getOutputStream()); //���� ���
	}
	
	public void run() {
		
//		try {
			while(true) {
					System.out.println("## ���� ������1 Server.imsi: " + Server.imsi);
				imageSendS=Server.imsi; //�ӽ� ���ۿ��� �������� 
					System.out.println("## ���� ������2 imageSendS : " + imageSendS);
//				ImageIO.write(imageSendS, "bmp", outputStreamServer);
//					System.out.println("## ���� ������3 outputStreamServer : " + outputStreamServer);
//				outputStreamServer.flush(); //���ۿ� ���� �̹�����d ������ ����
//				Thread.sleep(100);
			}
//		} catch ( IOException e) {}
	}
}
