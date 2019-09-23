package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

//���� ������ ������ Ŭ���� 
public class ThreadRcvServer  extends Thread {
	// ��� ���� ȭ��ũ��, ��ǥ(����� �߾�)
	static int w = 400, h = 400;
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	// �ʵ� ������Ʈ
	Socket s1;
	BufferedImage imageRcvS; // �ޱ�� ����
//	BufferedImage imsi; // �ޱ�� ���� ####���2)
	static BufferedInputStream inputStreamS;

	public ThreadRcvServer(Socket s1) throws IOException {// ������////////////////
		this.s1 = s1;
		inputStreamS = new BufferedInputStream(s1.getInputStream());
	}// ������ ��

	public void run() {// run �޼ҵ� //////////////

		
		try {
			while(true) {
				System.out.println("## ���� �ޱ�1 inputStreamS : " + inputStreamS);
				imageRcvS = ImageIO.read(inputStreamS); // �����͸� �޾Ƽ� ���ۿ� ����
					System.out.println("## ���� �ޱ�2 imageRcvS : " + imageRcvS);
				Server.imsi = imageRcvS; //�ӽ� ���۷� ����
					System.out.println("## ���� �ޱ�3 Server.imsi : " + Server.imsi);
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamS)), 0, 0, w, h, Painter.p2);
				//				Thread.sleep(100);
				System.out.println("## ���� �ޱ�4 inputStreamS : " + inputStreamS);
			}
		} catch (Exception e) {
			System.out.println("������� : " + e);
		} // try end
	}// run end
}
