package step01_TCP_SC3_BufferImage.copy;

import java.net.*;

import javax.imageio.*;
import javax.imageio.stream.ImageInputStream;
import javax.imageio.stream.ImageOutputStream;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.image.*;
import java.io.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;


class MainFrameLayout extends JFrame  implements MouseListener, MouseMotionListener, ActionListener {
	//�ʵ� ���� ##############################################
	JPanel contentPane; //���� ����������
	JPanel panelCanvas; //�׸� �׸��� �г�
	JPanel panelView; //�׸� �׸��� �г�
	
	//�׸���� ������Ʈ
	int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	int witchiX=0, witchiY=0; //���콺�� ��ǥ , Ŭ���� �ؿ� ���� ���� ����
	
	//�׸��� �ɼǿ� ������Ʈ
	Color bgColor=Color.WHITE; //background color
	Color brColor=Color.BLUE; //bruch color
	int brSize=10; //brush Size
	int sw=0; //���� sw=1, �׻� sw=2
	
	//getter setter##############################################
	public JPanel getContentPane() {
		return contentPane;
	}


	public void setContentPane(JPanel contentPane) {
		this.contentPane = contentPane;
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

	public int getW() {
		return w;
	}


	public void setW(int w) {
		this.w = w;
	}


	public int getH() {
		return h;
	}


	public void setH(int h) {
		this.h = h;
	}


	public int getWitchiX() {
		return witchiX;
	}


	public void setWitchiX(int witchiX) {
		this.witchiX = witchiX;
	}


	public int getWitchiY() {
		return witchiY;
	}


	public void setWitchiY(int witchiY) {
		this.witchiY = witchiY;
	}


	public Color getBgColor() {
		return bgColor;
	}


	public void setBgColor(Color bgColor) {
		this.bgColor = bgColor;
	}


	public Color getBrColor() {
		return brColor;
	}


	public void setBrColor(Color brColor) {
		this.brColor = brColor;
	}


	public int getBrSize() {
		return brSize;
	}


	public void setBrSize(int brSize) {
		this.brSize = brSize;
	}


	public int getSw() {
		return sw;
	}


	public void setSw(int sw) {
		this.sw = sw;
	}


	public MainFrameLayout() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		//
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
		
		//���콺 �׸��� �̺�Ʈ�� ������
		panelCanvas.addMouseListener(this); //�߿�!!!! ���콺 �̺�Ʈ ���
		panelCanvas.addMouseMotionListener(this); //�߿�!!! ���콺 �׼� �̺�Ʈ ���
		
	}
	
	
	//####################################################################
	//�̺�Ʈ 
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
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
		witchiX=e.getX(); //���콺X�� ���� ��ġ 
		witchiY=e.getY(); //���콺Y�� ���� ��ġ 
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
	}
} // MainFrameLayout end

class SendThread extends Thread {
	//Ŭ���̾�Ʈ���� ������ ����Ÿ ������ 
	Socket s1;
	MainFrameLayout mainFrame;
	
	public SendThread(Socket s1,MainFrameLayout mainFrame) throws IOException {
		this.s1 = s1;
		this.mainFrame = mainFrame;
	}
	
	public void run(){
		try {
			File file1=new File("aa.png");
			//BufferedImage bufferImage = ImageIO.read(file1); // ���� ���� read �Ͽ� �̹���ȭ�Ѵ�.
			BufferedImage bufferImage = ImageIO.read((ImageInputStream)mainFrame.getPanelCanvas()); // ĵ���� �̹����� �о� �̹������Ϳ� ����
			ImageIO.write(bufferImage, "png", s1.getOutputStream()); // ������ io stream �� ���� ������.
			
			System.out.print("Ŭ���̾�Ʈ : �̹����� ������ ����"+"\t");
			System.out.println("���� ���� : " + bufferImage);
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}


class RcvThread extends Thread {
	//Ŭ���̾�Ʈ���� ������ ���� ���� ������ ó�� 
	Socket s1;
	MainFrameLayout mainFrame;
	
	public RcvThread(Socket s1,MainFrameLayout mainFrame) throws IOException {
		this.s1 = s1;
		this.mainFrame = mainFrame;
	}
	
	public void run(){
		try {
			BufferedImage bufferImage = ImageIO.read(s1.getInputStream());//read - ��Ʈ������ ����
			ImageIO.write(bufferImage, "png", (ImageOutputStream) mainFrame.getPanelView()); //
			//ImageIO.write(bufferImage, "png", viewPanel); //viewPanel�� �׸��� 
			
			System.out.print("Ŭ���̾�Ʈ : �������� ���� �̹��� �׸���"+"\t");
			System.out.println("���� ���� : " + bufferImage);
			
		}catch(IOException e) {
			System.out.println(e);
		}
	}
}

//���� Ŭ���� #######################################################
public class CilentMainClass {
	
	public static void main(String[] args) throws IOException {
		MainFrameLayout mainFrame;
		
		mainFrame=new MainFrameLayout(); //�׸� �׸��� �۵�
		mainFrame.setVisible(true);
		
		try {
			Socket s1=new Socket("127.0.0.1", 8888);
			
			SendThread st=new SendThread(s1,mainFrame);
			RcvThread rt=new RcvThread(s1,mainFrame);
			
			st.start();
			rt.start();
			
		} catch (UnknownHostException e) {
			System.out.println(e);
		}
		System.out.println("Ŭ���̾�Ʈ ��");
	}

}
