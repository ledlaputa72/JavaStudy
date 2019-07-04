package java_GUI03;

import java.awt.*;
import java.awt.event.*;

class Painter extends Frame implements MouseListener, MouseMotionListener, ActionListener{
	//�������� //////////////////////////////////////////////////////////////
	private int witchiX=0, witchiY=0; //���콺�� ��ǥ , Ŭ���� �ؿ� ���� ���� ���� 
	
	static int bgColor=0; //background color, 0:WHITE 1:BLACK 2:RED 2:BLUE 3:GREEN 4:YELLOW 5:GRAY
	static int brColor=1; //brush color
	static int brSize=10; //brush Size
	
	
	
	//���۳�Ʈ /////////////////////////////////////////////////////////////
	private Frame f1=new Frame();
	private BorderLayout blo1=new BorderLayout(); //layout for main frame (N:p1 C:p2 S:p3)
	private GridLayout glo1=new GridLayout(1,8); //p1 ��� �޴� �� 
	
	private Panel p1=new Panel();
	private Panel p2=new Panel();
	private Panel p3=new Panel();
	
	//�޴� ���۳�Ʈ
	private Button btnBG=new Button("����"); //Ŭ���ϸ� ���� �ٲٱ� 
	private Label lblBG=new Label(Integer.toString(bgColor)); //���� ��� ���� ǥ���� ��
	
	private Button btnBColor=new Button("�׻�"); //Ŭ���ϸ� ���� �ٲٱ� 
	private Label lblBColor=new Label(Integer.toString(brColor)); //���� �귯�� ���� ǥ���� ��
	
	private Label lblBSize=new Label(Integer.toString(brSize)); //���� �귯�� ����� ǥ���� �� (���ڷ�) 
	private Button btnBSizeUp=new Button("+");
	private Button btnBSizeDn=new Button("-");
	
	private Button btnReset=new Button("�׸� �����");
	
	
	public Painter() { //������//////////////////////////////////////////////////////
		f1.addMouseListener(this); //���콺 �̺�Ʈ ���
		f1.addMouseMotionListener(this); //���콺 �׼� �̺�Ʈ ���
		
		//���� ������ 
		f1.setSize(700, 700);
		f1.setTitle("Kids Painter");
		f1.setLayout(blo1);
		f1.setVisible(true);
		f1.add(p1,"North");
		f1.add(p2,"Center");
		f1.add(p3,"South");
		
		//p1 ��� �޴� 
		p1.setBackground(Color.RED);
		
		//p2 �߾� ĵ����
//		p2.setBackground(Color.GRAY);
		
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
	
}//class end


public class PainterKids {
	
	public static void main(String[] args) {
		Painter sc=new Painter();
		
	}

}//main class end
