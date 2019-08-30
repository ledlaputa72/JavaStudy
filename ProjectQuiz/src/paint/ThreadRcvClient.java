package paint;

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
	BufferedInputStream inputStreamC;
	
	public ThreadRcvClient(Socket s1) throws IOException {//������////////////////
		this.s1 = s1;
		inputStreamC = new BufferedInputStream(s1.getInputStream());
	}//������ ��
	
	public void run() {//run �޼ҵ� //////////////
		try {
			while(true) {
				System.out.println("###Ŭ�� �ޱ�1) inputStreamC: " + inputStreamC);
				PaintFrameGUI.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamC)), 0, 0, w, h, PaintFrameGUI.p2);
				}
			}
		catch(Exception e) {
			System.out.println("������� : "+ e);
		}//try end
	}//run end
}
