package java_GUI03;

import java.awt.*;
import java.awt.event.*;

class My_Painter00 extends Frame implements MouseListener, MouseMotionListener, ActionListener{

	private int witchiX=0, witchiY=0; //���콺�� ��ǥ , Ŭ���� �ؿ� ���� ���� ���� 
	private Frame f1=new Frame();
	
	public My_Painter00 () { //������
		f1.addMouseListener(this); //���콺 �̺�Ʈ ���
		f1.addMouseMotionListener(this); //���콺 �׼� �̺�Ʈ ���
		
		f1.setSize(700, 700);
		f1.setTitle("������� ������");
		f1.setVisible(true); 
		
		//�ݱ�
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	} //������ ��

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		Graphics g=f1.getGraphics(); //�׷����� ��ü�� ���� 
		g.setColor(Color.red); //Į�� ���� 
		Graphics2D g2d = (Graphics2D)g; // ����ȯ
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
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		witchiX=arg0.getX(); //���콺X�� ���� ��ġ 
		witchiY=arg0.getY(); //���콺Y�� ���� ��ġ 
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

public class My_Painter{ 

public static void main(String[] args) {
	My_Painter00 sc=new My_Painter00();
	
		/*sc.setSize(700, 700);
		sc.setTitle("������� ������");
		sc.setVisible(true);*/
	
	}
}