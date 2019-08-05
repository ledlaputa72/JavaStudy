package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.imageio.ImageIO;

//���� �ޱ� ������ Ŭ���� 
public class ThreadSendServer  extends Thread  {
	Socket socket; //����
	BufferedImage imageSendS; //������ �� ����
	BufferedOutputStream outputStreamServer; //��� ��Ʈ�� Ŭ����  ////
	
	public ThreadSendServer(Socket socket) throws IOException, AWTException {//������ ////
		this.socket = socket;
		outputStreamServer = new BufferedOutputStream(socket.getOutputStream()); //���� ���
	}
	
	public void run() {
		try {
			while(true) {
				imageSendS=ThreadRcvServer.imsi; //�ӽ� ���ۿ��� �������� 
				
				ImageIO.write(imageSendS, "bmp", outputStreamServer);
				outputStreamServer.flush(); //���ۿ� ���� �̹����� ������ ����
				Thread.sleep(100);
			}
		} catch ( InterruptedException | IOException e) {}
	}
}
