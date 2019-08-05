package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

//�ޱ� ������
public class ThreadRcvClient  extends Thread{
	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
		static int w = 400, h = 400; 
		static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
		
		//�ʵ� ������Ʈ 
		Socket socket;
		BufferedImage imageRcv=null; //�ޱ�� ����
		BufferedInputStream inputStream;
		
		public ThreadRcvClient(Socket socket) throws IOException {//������////////////////
			this.socket = socket;
			inputStream = new BufferedInputStream(socket.getInputStream());
		}//������ ��
		
		public void run() {//run �޼ҵ� //////////////
		
			try {
				while(true) {
					System.out.println("###�ޱ�)���Ͽ��� ���� : " + inputStream);
					ThreadSendClient.imsi=imageRcv; //�ޱ� ���ۿ� ������� ���� ���� ���� 
					Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStream)), 0, 0, w, h, Painter.p2);
				}}
			catch(Exception e) {
				System.out.println("������� : "+ e);
			}//try end
		}//run end
}
