package Day050_ScketchQuizTest2;

import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

public class Server {
	
	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
	final int w = 1280, h = 720; 
	final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	JFrame frame;

	//������� �ػ󵵸� �޾ƿ��� â����

	public static void main(String[] args) {

		new Server(); //Ŭ���̾�Ʈ��İ� �Ȱ��� ������ ȣ��

	}

	public Server() {
		
		//â�� �����
		frame = new JFrame("server");
		frame.setBounds(x, y, w, h); //��� ũ�� �޾ƿ��� 
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	
		//��� �غ� 
		ServerSocket socket_s = null;
		Socket socket = null;
		
		try {
			//Ŭ���̾�Ʈ�� ������
			socket_s = new ServerSocket(12345); //��Ʈ ���� 
			socket = socket_s.accept(); // Listen 
			System.out.println("Ŭ���̾�Ʈ ���� �Ϸ�! - ����" + socket);
		
			//������ �Է½�Ʈ���� ���۽�Ʈ������
			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
	
			//�̹����� �޾ƿ��� ���ÿ� ȭ�鿡 �׸�
			while(true) {
			frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0, 0, w, h, frame);

			}

		} catch (Exception e) {
		e.printStackTrace();
		}
	}
}