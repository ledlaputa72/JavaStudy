package step04__SC2window_pireSendRcv_OK;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

//�÷� ����Ʈ Ŭ���� ////////////////////////////////////////////////////////
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
		f1.setTitle("Scketch Quiz Client");
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


//main class/////////////////////////////////////////////////////
public class Client {

	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	
	public static void main(String[] args) throws Exception {
		
		
		String serverip = "127.0.0.1";//���� IP
		Socket socket = null; //��� �غ� 
		System.out.println("Ŭ���̾�Ʈ �غ�Ϸ�");//�ϴ� ���ϻ���
	
		//�������� ����
		socket = new Socket(serverip, 9999); 
		System.out.println("���ӿϷ� - Ŭ���̾�Ʈ1");
		
		//�׸� ��� �۵� 
		Painter sc=new Painter(); //�׸� �׸��� �۵�
		System.out.println("�׸��� �۵� - Ŭ���̾�Ʈ");
		
		try {
			//�ް� ����ϱ� ������
			ThreadRcv threadR =new ThreadRcv(socket);
			threadR.start();
			
			//ȭ�� �̹��� ��ũ���� ���� - ������ ó�� /////////////////////////////////////////////
			ThreadSend ts1=new ThreadSend(socket);
			ts1.start();
		}
		catch(Exception e) {
			System.out.println(e);
		}//try end
	}//main end
}//Client class end



