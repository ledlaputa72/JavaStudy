package step02_TCP_SC3_BufferImage.copy2;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.io.ObjectInputStream.*;
import java.net.*;

import javax.imageio.*;
import javax.imageio.stream.*;
import javax.swing.*;
import javax.swing.border.*;


class TestFrameClass extends JFrame implements MouseListener, MouseMotionListener, ActionListener  {
	JPanel contentPane; //���� ����������
	JPanel panelCanvas; //�׸� �׸��� �г�
	JPanel panelView; //�׸� �׸��� �г�
	
	int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	int witchiX=0, witchiY=0; //���콺�� ��ǥ , Ŭ���� �ؿ� ���� ���� ����
	
	//�׸��� �ɼǿ� ������Ʈ
	Color bgColor=Color.WHITE; //background color
	Color brColor=Color.BLUE; //bruch color
	int brSize=10; //brush Size
	int sw=0; //���� sw=1, �׻� sw=2
	
	public TestFrameClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		panelCanvas = new JPanel();
		panelCanvas.setBackground(Color.YELLOW);
		panelCanvas.setBounds(0, 60, 800, 300);
		panelCanvas.setVisible(true);
		contentPane.add(panelCanvas);//�߰�
		
		panelView = new JPanel();
		panelView.setBackground(Color.RED);
		panelView.setBounds(0, 460, 800, 300);
		panelView.setVisible(true);
		contentPane.add(panelView);//�߰�
		
		panelCanvas.addMouseListener(this); //�߿�!!!! ���콺 �̺�Ʈ ���
		panelCanvas.addMouseMotionListener(this); //�߿�!!! ���콺 �׼� �̺�Ʈ ���
		}

	
	
	public JPanel getPanelCanvas() {
		return panelCanvas;
	}



	public void setPanelCanvas(JPanel panelCanvas) {
		this.panelCanvas = panelCanvas;
	}



	public JPanel getPanelView() {
		return panelView;
	}



	public void setPanelView(JPanel panelView) {
		this.panelView = panelView;
	}



	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
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
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		witchiX=e.getX(); //���콺X�� ���� ��ġ 
		witchiY=e.getY(); //���콺Y�� ���� ��ġ 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}

//#########################################################
//������ ������ ////////////////////////////////////////
class ThreadSend extends Thread{
	
	static final int w = 800, h = 700; 
	static final int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	Socket s1;
	BufferedImage image;
	Robot robot;
	BufferedOutputStream bos1; 
	TestFrameClass mainFrame;
	
	public ThreadSend(Socket s1, TestFrameClass mainFrame) throws IOException, AWTException {
		this.s1 = s1;
		this.mainFrame = mainFrame;		
		
		robot = new Robot();
		bos1 = new BufferedOutputStream(s1.getOutputStream()); 
		
		while(true) {
			image = robot.createScreenCapture(new Rectangle(0, 60, 800, 300));//��ũ������ �� image�� ������
			ImageIO.write(image, "bmp", bos1);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			System.out.println("������ �̹��� : " + bos1);
			bos1.flush(); //���ۿ� ���� �̹����� ������ ����
			System.out.println("������ �̹��� : " + bos1);
		}
	}
}////////////////////////////////////////

//#########################################################
//�ޱ� ������ ////////////////////////////////////////
class ThreadRcv extends Thread{
	
	Socket s1;
	BufferedInputStream bis1=null;
	TestFrameClass mainFrame;
	
	public ThreadRcv(Socket s1, TestFrameClass mainFrame) throws IOException, AWTException {
		this.s1 = s1;
		this.mainFrame = mainFrame;
		bis1 = new BufferedInputStream(s1.getInputStream());
		//������ �Է½�Ʈ���� ���۽�Ʈ������

		while(true) {
			mainFrame.getPanelView().getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 360, 800, 400, mainFrame.getPanelView());
			System.out.println("���� �̹��� : " + bis1);
		}
	}
}/////////////////////////////////////////////



//#########################################################
public class ClientMainClass {
public static void main(String[] args) throws IOException, AWTException {
	
		Socket s1=new Socket("127.0.0.1", 9999);
		System.out.println("���ӿϷ� - Ŭ���̾�Ʈ");
	
		TestFrameClass mainFrame=new TestFrameClass(); //�׸� �׸��� �۵�
		mainFrame.setVisible(true);
		
		//######������ #######################################

		ThreadSend st = new ThreadSend(s1,mainFrame);
		st.start();
		
		ThreadRcv rt = new ThreadRcv(s1,mainFrame);
		rt.start();
		
		//######������ #######################################
		
		System.out.println("Ŭ���̾�Ʈ ��");
	}
	
}
