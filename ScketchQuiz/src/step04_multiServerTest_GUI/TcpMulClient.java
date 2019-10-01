package step04_multiServerTest_GUI;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

class Painter extends Frame implements MouseListener, MouseMotionListener, ActionListener{
	//�ʵ� ��
	static int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	static Socket ss;
	static int p2X;
	static int p2Y;
	
	private int witchiX=0, witchiY=0; //���콺�� ��ǥ , Ŭ���� �ؿ� ���� ���� ���� 
	
	static  Color bgColor=Color.WHITE; //background color
	private int brSize=10; //brush Size
	static Color brColor=Color.BLUE; //bruch color
	static int sw=0; //���� sw=1, �׻� sw=2
	
	//���۳�Ʈ /////////////////////////////////////////////////////////////
	private Frame f1=new Frame();
	static Panel p1=new Panel();
	static Panel p2=new Panel();
	
	//������/////////////////////////////////////////////////////////
	public Painter() { 
		p1.addMouseListener(this); //�߿�!!!! ���콺 �̺�Ʈ ���
		p1.addMouseMotionListener(this); //�߿�!!! ���콺 �׼� �̺�Ʈ ���
		
		//���� ������ 
		f1.setSize(400, 900);
		f1.setTitle("������ Ŭ���̾�Ʈ");
		f1.setLayout(null);
		f1.setVisible(true);
		f1.add(p1);
		f1.add(p2);
		f1.setAlwaysOnTop(true);
		f1.setResizable(false);
		
		
		//p2 �߾� ĵ����
		p1.setBackground(Color.YELLOW);
		p1.setBounds(0,0,400,400);

		
		//p3 �ϴ� ���� 
		p2.setBackground(Color.CYAN);
		p2.setBounds(0,400,400,400);
		
		//�ݱ�
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	} //������ ��
	
	//�̺�Ʈ �ڵ鷯  ######################################
	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g=p1.getGraphics(); //�߿�!!! �׷����� ��ü�� ���� (�׸��� �׸� ���)
		g.setColor(brColor); //Į�� ���� 
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(brSize));
		
		//whichiX,whichiY : ó����ġ 
		int badaX=e.getX(); //���(��) ���콺 ��ġ 
		int badaY=e.getY();
		
		g.drawLine(witchiX, witchiY, badaX, badaY); //ó�� -> �� ��ġ���� �� �׸���
		witchiX=badaX; //�ٽ� ó�� ��ġ ���� �� ���� �ִ´�. 
		witchiY=badaY;
		//�ٽ� ���� ���� �ݺ��Ѵ�. 
	}

	@Override
	public void mouseMoved(MouseEvent e) {
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}

	@Override
	public void mousePressed(MouseEvent e) { //���콺�� ������ ���� ��
		witchiX=e.getX(); //���콺X�� ���� ��ġ 
		witchiY=e.getY(); //���콺Y�� ���� ��ġ 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
	}
}//Painter class end

class ThreadClientSendClass extends Thread {
	
	Socket socket;
	DataOutputStream outputStream;
	String nickname;
	
	// �ʱ�ġ�� ���� ��ü, �г����� �Ѿ�´�.
	public ThreadClientSendClass(Socket socket, String nickname) throws IOException {

		this.socket = socket;
		this.nickname = nickname;
		
		outputStream = new DataOutputStream(socket.getOutputStream());
		
	}
	
	public void run() {
			
		Scanner in1 = new Scanner(System.in);
			
		try {
				
			if (outputStream != null)
				outputStream.writeUTF(nickname); // �г��� send
				
			/*while (outputStream != null) 
				outputStream.writeUTF("(** " + nickname + " **) " + in1.nextLine()); // io ��Ʈ���� ���� ���濡�� chat ������.
				*/
		} catch (IOException e) {
				
			e.printStackTrace();
		}
	}
		
}
	
/*class ThreadClientRcvClass extends Thread {

	Socket socket;
	DataInputStream inputStream;
	
	// ������
	public ThreadClientRcvClass(Socket socket) throws IOException {
		
		this.socket = socket;
		
		inputStream = new DataInputStream(socket.getInputStream()); // read
		
	}
	
	public void run() {
		
		while (inputStream != null) {
			
			try {
				
				System.out.println(inputStream.readUTF());
				
			} catch (IOException e) {
				
				e.printStackTrace();
			}
		}
	}

}*/

public class TcpMulClient {

	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;


	public static void main(String[] args) throws NumberFormatException, IOException {

			
		try {
			
			Socket s1 = new Socket("127.0.0.1", 8888); // ip �ּ�, ��Ʈ ��ȣ
			
			System.out.println("������ ����...");
			
			//�׸� ��� �۵� 
			Painter sendClient=new Painter(); //�׸� �׸��� �۵�
			System.out.println("�׸��� �۵� - Ŭ���̾�Ʈ");
			
			ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, "Test"); // �г���
			Thread tsend1 = new Thread(tcc1); // ������ chat ����
			tsend1.start();
			
			/*//�ް� ����ϱ� ������
			ThreadRcv threadR =new ThreadRcv(s1);
			threadR.start();*/
			
			//ȭ�� �̹��� ��ũ���� ���� - ������ ó�� /////////////////////////////////////////////
			ThreadSend threadS=new ThreadSend(s1);
			threadS.start();
			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
