package step10_ScreenCaptureStreamingTest2;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

import java.awt.event.*;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

//���� GUI ������////////////////////////////////////////////////
class JFramTest2 extends JFrame implements MouseListener, MouseMotionListener, ActionListener{
	//���۳�Ʈ �ʵ�/////////////////////////////////////////////////
	//���̾ƿ��� ������Ʈ
	private JPanel contentPane;
	private JPanel panelCanvas;
	private JPanel panelView;
	private JPanel panelChat;
	private JTextField textField;
	private JTextArea textArea;
	private JPanel panelUsers;
	
	//�׸���� ������Ʈ
	static int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	private int witchiX=0, witchiY=0; //���콺�� ��ǥ , Ŭ���� �ؿ� ���� ���� ����
	
	//�׸��� �ɼǿ� ������Ʈ
	static  Color bgColor=Color.WHITE; //background color
	private int brSize=10; //brush Size
	static Color brColor=Color.BLUE; //bruch color
	static int sw=0; //���� sw=1, �׻� sw=2
	
	//��ſ� ������Ʈ
	static Socket ss;
	
	//������ - ���̾ƿ� ��� /////////////////////////////////////////////////
	public JFramTest2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel(); //contentPane ��ü ����
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		// �г� ����
		JPanel panelTop = new JPanel(); //panelTop ��ü ����
		panelTop.setBackground(Color.CYAN);
		panelTop.setBounds(0, 0, 1184, 60);
		panelTop.setLayout(null);
		contentPane.add(panelTop); //�߰�
		
		panelCanvas = new JPanel(); //panelCanvas ��ü ����
		panelCanvas.setBackground(Color.YELLOW);
		panelCanvas.setBounds(0, 60, 800, 400);
		panelCanvas.setVisible(true);
		contentPane.add(panelCanvas);//�߰�
		
		panelView = new JPanel(); //panelView ��ü ����
		panelView.setBackground(Color.RED);
		panelView.setBounds(0, 460, 800, 300);
		panelView.setVisible(false);
		contentPane.add(panelView);//�߰�
		
		panelChat = new JPanel(); //panelChat ��ü ����
		panelChat.setBackground(Color.GRAY);
		panelChat.setBounds(800, 60, 384, 700);
		panelChat.setLayout(null);
		contentPane.add(panelChat);//�߰�
		
		panelUsers = new JPanel(); // panelUsers ��ü ����
		panelUsers.setBackground(Color.ORANGE);
		panelUsers.setBounds(0, 759, 1184, 180);
		contentPane.add(panelUsers);//�߰�
		
		// ä�� �ʵ�� ����� ���� 
		textField = new JTextField(); //textField ��ü ����
		textField.setBounds(0, 664, 384, 38);
		textField.setColumns(10);
		panelChat.add(textField);//�߰�
		
		textArea = new JTextArea(); //textArea ��ü ����
		textArea.setBounds(0, 0, 384, 664);
		panelChat.add(textArea);//�߰�
		
		//���콺 �׸��� �̺�Ʈ�� ������
		panelCanvas.addMouseListener(this); //�߿�!!!! ���콺 �̺�Ʈ ���
		panelCanvas.addMouseMotionListener(this); //�߿�!!! ���콺 �׼� �̺�Ʈ ���
	}//������ ������ ///////////////////////////////////////
	
	//�̺�Ʈ �ڵ鷯 //////////////////////////////////////////////////////
	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g=panelCanvas.getGraphics(); //�߿�!!! �׷����� ��ü�� ���� (�׸��� �׸� ���)
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
}//JFramTest2 Ŭ���� ���� /////////////////////////////////////////////////////////////


//���� Ŭ���� 
public class JFrameClient {

	public static void main(String[] args) throws IOException, AWTException {
		
		//�������� ����//////////////
		Socket s1 = new Socket("127.0.0.1", 9999); 
		System.out.println("���ӿϷ� - Ŭ���̾�Ʈ");
		
		//�׸� ��� �۵�////////////// 
		JFramTest2 sc=new JFramTest2(); //�׸� �׸��� �۵�
		sc.setVisible(true);
		System.out.println("�׸��� �۵� - Ŭ���̾�Ʈ");
		JPanel panelView = new JPanel();
		panelView.setBackground(Color.RED);
		panelView.setBounds(0, 460, 800, 300);
		panelView.setVisible(false);
//		sc.setContentPane(contentPane.add(panelView));
//		contentPane.add(panelView);//�߰�
		//****panelView add �ʿ�
		
		//ȭ�� �̹��� ��ũ���� ���� - ������ ó�� /////////////////////////////////////////////
		ThreadSend ts1=new ThreadSend(s1);
		ts1.start();

	
	}//main class end
		
}

