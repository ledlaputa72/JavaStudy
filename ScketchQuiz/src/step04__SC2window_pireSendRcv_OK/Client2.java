package step04__SC2window_pireSendRcv_OK;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;

public class Client2 {

	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	public static void main(String[] args) throws IOException, AWTException {

		String serverip = "127.0.0.1";//���� IP
		Socket socket = null; //��� �غ� 
		System.out.println("Ŭ���̾�Ʈ �غ�Ϸ�");//�ϴ� ���ϻ���
	
			//�������� ����
			socket = new Socket(serverip, 9999); 
			System.out.println("���ӿϷ� - Ŭ���̾�Ʈ2");
			
			//�׸� ��� �۵� 
			Painter sc2=new Painter(); //�׸� �׸��� �۵�
			System.out.println("�׸��� �۵� - Ŭ���̾�Ʈ");

			//������ �Է½�Ʈ���� ���۽�Ʈ������
			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
			System.out.println("(Ŭ��)�������� ����%%%%%%%%%%%%%%%%%%%%% ");
			//�̹����� �޾ƿ��� ���ÿ� ȭ�鿡 �׸�
			while(true) {
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0, 0, w, h, Painter.p2);
			
			//ȭ�� �̹��� ��ũ���� ���� - ������ ó�� /////////////////////////////////////////////
			ThreadSend ts2=new ThreadSend(socket);
			ts2.start();
			}
	}

}
