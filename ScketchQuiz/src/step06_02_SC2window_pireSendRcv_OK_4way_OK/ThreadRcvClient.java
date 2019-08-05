package step06_02_SC2window_pireSendRcv_OK_4way_OK;

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
	Socket s1;
	BufferedImage imageRcvC; //�ޱ�� ����
	BufferedInputStream inputStreamC;
	
	public ThreadRcvClient(Socket socket) throws IOException {//������////////////////
		this.s1 = socket;
		inputStreamC = new BufferedInputStream(socket.getInputStream());
	}//������ ��
	
	public void run() {//run �޼ҵ� //////////////
	
		try {
			while(true) {
				System.out.println("###Ŭ�� �ޱ�1) inputStreamC: " + inputStreamC);
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamC)), 0, 0, w, h, Painter.p2);
				}
			}
		catch(Exception e) {
			System.out.println("������� : "+ e);
		}//try end
	}//run end
}
