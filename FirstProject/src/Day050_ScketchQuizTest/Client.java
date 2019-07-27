package Day050_ScketchQuizTest;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.net.Socket;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JTextField;

public class Client {

	final int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;

	//��Ŷ���� ��ǻ���� �ػ󵵸� �޾ƿ� (ȭ�� ĸ�Ŀ� �ʿ���)

	JFrame frame;
	JTextField text;
	JButton button;

	//â, ip�� �Է��� �ؽ�Ʈ�ʵ�, ���ӹ�ư

	public static void main(String[] args) {
	new Client();
	//���ο����� Ŭ���̾�Ʈ �����ڸ� ��������ָ� ��
	}

	//���ο��� ȣ���Ų �����ںκ�
	public Client() {
		frame = new JFrame("Client"); //â ����
		frame.setBounds(0, 0, 300, 100);//â ��ġ,ũ�� ����
		frame.setLayout(null); //���̾ƿ� ���� ��.
		//JFrame ������â �ʱ�ȭ
		text = new JTextField(); //�ؽ�Ʈ���� ����
		text.setVisible(true); //����
		text.setBounds(25, 15, 100, 50);//��ġ ũ�� ����
		//ip�� �Է��� �ؽ�Ʈ�ʵ� ����
		button = new JButton("����");
		button.setVisible(true);
		button.setBounds(125, 15, 50, 50);
		button.addActionListener(new ActionListener() {
		//�׼Ǹ����� �͸�Ŭ���� ��ư�� Ŭ���Ǿ����� �ൿ�� ������
			
		@Override
		public void actionPerformed(ActionEvent arg0) {
		//�̷��� �������̵� �ؼ� ��ȸ������ �������ִ°ž�
		// TODO Auto-generated method stub
		Client.this.client_work();
		//�����ϰ� �ؿ� Ŭ���̾�Ʈ ����� ���ĳ��� �޼ҵ� ȣ��
			}
		});
	
		frame.add(text);
		frame.add(button);
		frame.setVisible(true);
		//������(������ â)�� �ؽ�Ʈ�����ϰ� ��ư�� �߰��� �� ���̰� ����.
	}


	//Ŭ���̾�Ʈ�� ��ɵ��� ���� �ھƳ��� â��

	public void client_work() {

		String serverip = text.getText();//�ؽ�Ʈ���ڿ��� �ؽ�Ʈ�� �޾ƿͼ� ����
		Socket socket = null;
		System.out.println("Ŭ���̾�Ʈ �غ�Ϸ�");//�ϴ� ���ϻ���
	
		try {
		socket = new Socket(serverip, 12345);
		//���� �ؽ�Ʈ���ڿ��� �޾ƿ� �����Ƿ� ����
		System.out.println("���ӿϷ� - Ŭ���̾�Ʈ");
		//BufferedImage image = new BufferedImage(1280, 720, BufferedImage.TYPE_3BYTE_BGR);
		BufferedImage image; //��ũ������ ����� ���۰���
		Robot r = new Robot(); //��ũ������ ��� �κ�Ŭ����
		BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream());
		//�ƿ�ǲ��Ʈ���� ���۾ƿ�ǲ����
	
			while(true) {
			//image.getGraphics().drawImage(r.createScreenCapture(new Rectangle(0,0,w,h)).getScaledInstance(1280, 720, Image.SCALE_SMOOTH), 0, 0, null);
			image = r.createScreenCapture(new Rectangle(0, 0, w, h));
			//��ũ������ �� image�� ������
			ImageIO.write(image, "bmp", bout);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			bout.flush();   //���ۿ� ���� �̹����� ������ ����
			}
	
		} catch (Exception e) {
		e.printStackTrace(); //���� ó��
		System.out.println("���ӽ��� - Ŭ���̾�Ʈ");
		}
	}
}