package step10_ScreenCaptureStreamingTest1;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

//�÷� ����Ʈ Ŭ���� ////////////////////////////////////////////////////////
class Painter extends Frame implements MouseListener, MouseMotionListener, ActionListener{
	//�������� //////////////////////////////////////////////////////////////
	static int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	static Socket ss;
	
	private int witchiX=0, witchiY=0; //���콺�� ��ǥ , Ŭ���� �ؿ� ���� ���� ���� 
	
	static  Color bgColor=Color.WHITE; //background color
	private int brSize=10; //brush Size
	static Color brColor=Color.BLUE; //bruch color
	static int sw=0; //���� sw=1, �׻� sw=2
	
	//���۳�Ʈ /////////////////////////////////////////////////////////////
	private Frame f1=new Frame();
	private BorderLayout blo1=new BorderLayout(); //layout for main frame (N:p1 C:p2 S:p3)

	static Panel p1=new Panel();
	static Panel p2=new Panel();
	static Panel p3=new Panel();
	
	static Button btnStream=new Button("ȭ�� ����");
	
	//������/////////////////////////////////////////////////////////
	public Painter() { 
		p2.addMouseListener(this); //�߿�!!!! ���콺 �̺�Ʈ ���
		p2.addMouseMotionListener(this); //�߿�!!! ���콺 �׼� �̺�Ʈ ���
		
		//���� ������ 
		f1.setSize(400, 400);
		f1.setTitle("Scketch Quiz Client");
		f1.setLayout(blo1);
		f1.setVisible(true);
		f1.add(p1,"North");
		f1.add(p2,"Center");
		f1.add(p3,"South");
		
		//p1���� 
		p1.add(btnStream); //ȭ�� ���� ��ư
		btnStream.addActionListener(this);
		
		//p2 �߾� ĵ����
		p2.setBackground(bgColor);
		
		//p3 �ϴ� ���� 
		p3.setBackground(Color.BLUE);
		
		//�ݱ�
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	} //������ ��
	
	//�̺�Ʈ �ڵ鷯 //////////////////////////////////////////////////////
	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g=p2.getGraphics(); //�߿�!!! �׷����� ��ü�� ���� (�׸��� �׸� ���)
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
		/*//ȭ�� �̹��� ��ũ���� ���� - ������ ó��  (���� �ѹ��� ���� �׵ڷ� �׸��� �ȱ׷��� )
		ThreadSend ts1;
		try {
			ts1 = new ThreadSend(ss);
			ts1.start();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (AWTException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}*/
		
	}
}//Painter class end


//main class/////////////////////////////////////////////////////
public class Client {
	
	public static void main(String[] args) {
		
		String serverip = "127.0.0.1";//���� IP
		Socket socket = null; //��� �غ� 
		System.out.println("Ŭ���̾�Ʈ �غ�Ϸ�");//�ϴ� ���ϻ���
	
	
		try {
			//�������� ����
			socket = new Socket(serverip, 12345); 
			System.out.println("���ӿϷ� - Ŭ���̾�Ʈ");
			
			
			//�׸� ��� �۵� 
			Painter sc=new Painter(); //�׸� �׸��� �۵�
			System.out.println("�׸��� �۵� - Ŭ���̾�Ʈ");
			sc.ss=socket;
			
			/*//�̹��� ���� - ��ũ������ �̿� --> server�� ThreadSend Ŭ������ ���� /////////////////////////
			BufferedImage image; //��ũ������ ����� ���۰���
			Robot r = new Robot(); //��ũ������ ��� �κ�Ŭ����
			BufferedOutputStream bout = new BufferedOutputStream(socket.getOutputStream()); //�ƿ�ǲ��Ʈ���� ���۾ƿ�ǲ����
			
			while(true) {
			image = r.createScreenCapture(new Rectangle(0, 0, 1280, 720));//��ũ������ �� image�� ������
			ImageIO.write(image, "bmp", bout);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
			bout.flush(); //���ۿ� ���� �̹����� ������ ����
			}*/
			
			//ȭ�� �̹��� ��ũ���� ���� - ������ ó�� /////////////////////////////////////////////
			ThreadSend ts1=new ThreadSend(socket);
			ts1.start();
			
		} catch (Exception e) {
			e.printStackTrace(); //���� ó��
			System.out.println("���ӽ��� - Ŭ���̾�Ʈ");
		}

	}//main class end

}//main class end
