package java_GUI03;

import java.awt.*;
import java.awt.event.*;

public class PanterKids extends Frame implements MouseListener, MouseMotionListener, ActionListener{

	private int witchiX=0, witchiY=0; //���콺�� ��ǥ , Ŭ���� �ؿ� ���� ���� ���� 

	private Button btnBG=new Button("����");
	private Button btnBColor=new Button("�귯�� Į��");
	private Button btnBSizeUp=new Button("�귯��ũ��+");
	private Button btnBSizeDn=new Button("�귯��ũ��-");
	private Button btnReset=new Button("�׸� �����");
	
	private Label lblBG=new Label(""); //���� ��� ���� ǥ���� ��
	private Label lblBColor=new Label(""); //���� �귯�� ���� ǥ���� ��
	private Label lblBSize=new Label(""); //���� �귯�� ����� ǥ���� �� (���ڷ�) 
	
	
	public PanterKids() { //������
		addMouseListener(this); //���콺 �̺�Ʈ ���
		addMouseMotionListener(this); //���콺 �׼� �̺�Ʈ ���
		
		//�ݱ�
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	} //������ ��
	
	public static void main(String[] args) {
		PanterKids sc=new PanterKids();
		
		sc.setSize(700, 700);
		sc.setTitle("������� ������");
		sc.setVisible(true);
		
	}
	
	//�̺�Ʈ �ڵ鷯 
	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g=getGraphics(); //�׷����� ��ü�� ���� 
		g.setColor(Color.red); //Į�� ���� 
		Graphics2D g2d = (Graphics2D)g;
		g2d.setStroke(new BasicStroke(10));
		
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
	public void mousePressed(MouseEvent e) { //���콺�� ������ ���� ��
		witchiX=e.getX(); //���콺X�� ���� ��ġ 
		witchiY=e.getY(); //���콺Y�� ���� ��ġ 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}


}
