package Day050_ScketchQuizTest3;

import java.awt.*;
import java.awt.event.*;

//�÷� ����Ʈ Ŭ���� ////////////////////////////////////////////////////////
class Painter extends Frame implements MouseListener, MouseMotionListener, ActionListener{
	//�������� //////////////////////////////////////////////////////////////
	private int witchiX=0, witchiY=0; //���콺�� ��ǥ , Ŭ���� �ؿ� ���� ���� ���� 
	
	static  Color bgColor=Color.WHITE; //background color
	private int brSize=10; //brush Size
	static Color brColor=Color.BLUE; //bruch color
	static int sw=0; //���� sw=1, �׻� sw=2
	
	//���۳�Ʈ /////////////////////////////////////////////////////////////
	private Frame f1=new Frame();
	private BorderLayout blo1=new BorderLayout(); //layout for main frame (N:p1 C:p2 S:p3)
	private GridLayout glo1=new GridLayout(1,8); //p1 ��� �޴� �� 
	
	static Panel p1=new Panel();
	static Panel p2=new Panel();
	static Panel p3=new Panel();
	
	//�޴� ���۳�Ʈ
	static Button btnBG=new Button("����"); //Ŭ���ϸ� ���� �ٲٱ� 
	static Label lblBG=new Label("������",Label.CENTER); //���� ��� ���� ǥ���� ��
	
	static Button btnBColor=new Button("�׻�"); //Ŭ���ϸ� ���� �ٲٱ� 
	static Label lblBColor=new Label("�Ķ���",Label.CENTER); //���� �귯�� ���� ǥ���� ��
	
	private Label lblBSize=new Label(Integer.toString(brSize,Label.CENTER)); //���� �귯�� ����� ǥ���� �� (���ڷ�) 
	private Button btnBSizeUp=new Button("+");
	private Button btnBSizeDn=new Button("-");
	
	private Button btnReset=new Button("�׸� �����");
	
	//������/////////////////////////////////////////////////////////
	public Painter() { 
		p2.addMouseListener(this); //�߿�!!!! ���콺 �̺�Ʈ ���
		p2.addMouseMotionListener(this); //�߿�!!! ���콺 �׼� �̺�Ʈ ���
		
		//���� ������ 
		f1.setSize(700, 700);
		f1.setTitle("Kids Painter");
		f1.setLayout(blo1);
		f1.setVisible(true);
		f1.add(p1,"North");
		f1.add(p2,"Center");
		f1.add(p3,"South");
		
		//p1 ��� �޴� 
		p1.setBackground(Color.CYAN);
		p1.setLayout(glo1);
		//����
		p1.add(btnBG); //��ư
		p1.add(lblBG);
		lblBG.setBackground(bgColor);
		//�귯�� ��
		p1.add(btnBColor); //��ư
		p1.add(lblBColor);
		lblBColor.setBackground(brColor);
		//�귯�� ������
		p1.add(lblBSize); 
		p1.add(btnBSizeUp); //+��ư
		p1.add(btnBSizeDn); //-��ư
		lblBSize.setText(Integer.toString(brSize));
		
		//ȭ�� �����
		p1.add(btnReset); //��ư
		
		//p1��ư �̺�Ʈ ������
		btnBG.addActionListener(this);
		btnBColor.addActionListener(this);
		btnBSizeUp.addActionListener(this);
		btnBSizeDn.addActionListener(this);
		btnReset.addActionListener(this);
		
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
	public void actionPerformed(ActionEvent arg0) {
		if (arg0.getSource()==btnBG) { //��� Į�� 
			SubPainter.f2.setVisible(true); //Į�� ���� â ����(���̱�)
			sw=1; //��� ���� �ɼ�
		}
		else if(arg0.getSource()==btnBColor) { //�귯�� Į��
			SubPainter.f2.setVisible(true); //Į�� ���� â ����(���̱�)
			sw=2; //�� ���� �ɼ�
		}
		else if(arg0.getSource()==btnBSizeUp) { //�귯�� ������ +
			brSize=brSize+2;
			lblBSize.setText(Integer.toString(brSize));
		}
		else if(arg0.getSource()==btnBSizeDn) {//�귯�� ������-
			brSize=brSize-2;
			lblBSize.setText(Integer.toString(brSize));
		}
		else if(arg0.getSource()==btnReset) {
			p2.setBackground(Color.BLACK);
			bgColor=Color.WHITE;
			p2.setBackground(Color.WHITE);
			lblBG.setBackground(bgColor);
		}
	}
	
}//Painter class end

//���� Į�� ���� â ///////////////////////////////////////////////
class SubPainter extends Frame implements ActionListener{
	//����  ������ ȭ�鿡�� ȣ��
	static Frame f2=new Frame();
	
	//������ ��ư ���۳�Ʈ 
	private Color pickColor; //Į���� ��� �ӽ� ����� 
	private Button btnWhite=new Button("White");
	private Button btnBlack=new Button("Black");
	private Button btnRed=new Button("Red");
	private Button btnBlue=new Button("Blue");
	private Button btnYellow=new Button("Yellow");
	private Button btnGreen=new Button("Green");
	private Button btnOrange=new Button("Orange");
	private Button btnPink=new Button("Pink");
	private Button btnCyan=new Button("Cyan");
	private Button btnMagenta=new Button("Magenta");
	private Button btnLGray=new Button("LGray");
	private Button btnGray=new Button("Gray");
	private Button btnDGray=new Button("DGray");
	
	//����â ������/////////////////////////////////////////////
	public SubPainter() {
		//f2  ������ 
		f2.setSize(200, 200);
		f2.setTitle("����â");
		f2.setLayout(new GridLayout(4,5));
		f2.setVisible(false); //����Ʈ�� �Ⱥ��δ�. 
		
		//��ư 
		f2.add(btnWhite);
		f2.add(btnBlack);
		f2.add(btnRed);
		f2.add(btnBlue);
		f2.add(btnYellow);
		f2.add(btnGreen);
		f2.add(btnOrange);
		f2.add(btnPink);
		f2.add(btnCyan);
		f2.add(btnMagenta);
		f2.add(btnLGray);
		f2.add(btnGray);
		f2.add(btnDGray);
		
		//��ư �̺�Ʈ 
		btnWhite.addActionListener(this);
		btnBlack.addActionListener(this);
		btnRed.addActionListener(this);
		btnBlue.addActionListener(this);
		btnYellow.addActionListener(this);
		btnGreen.addActionListener(this);
		btnOrange.addActionListener(this);
		btnPink.addActionListener(this);
		btnCyan.addActionListener(this);
		btnMagenta.addActionListener(this);
		btnLGray.addActionListener(this);
		btnGray.addActionListener(this);
		btnDGray.addActionListener(this);
		
		//���� Į��â ������
		f2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f2.setVisible(false);
			}
		});	//â �ݱ�
	}
	
	//��ư �� �̺�Ʈ 
	@Override
	public void actionPerformed(ActionEvent e) {
		//��ư�� ���� pickColor�� �Ҵ�
		if (e.getSource()==btnWhite) {
			pickColor=Color.WHITE;
		}else if (e.getSource()==btnBlack) {
			pickColor=Color.BLACK;
		}else if (e.getSource()==btnRed) {
			pickColor=Color.RED;
		}else if (e.getSource()==btnBlue) {
			pickColor=Color.BLUE;
		}else if (e.getSource()==btnYellow) {
			pickColor=Color.YELLOW;
		}else if (e.getSource()==btnGreen) {
			pickColor=Color.GREEN;
		}else if (e.getSource()==btnOrange) {
			pickColor=Color.ORANGE;
		}else if (e.getSource()==btnPink) {
			pickColor=Color.PINK;
		}else if (e.getSource()==btnCyan) {
			pickColor=Color.CYAN;
		}else if (e.getSource()==btnMagenta) {
			pickColor=Color.MAGENTA;
		}else if (e.getSource()==btnLGray) {
			pickColor=Color.LIGHT_GRAY;
		}else if (e.getSource()==btnGray) {
			pickColor=Color.GRAY;
		}else if (e.getSource()==btnDGray) {
			pickColor=Color.DARK_GRAY;
		}else {
			
		}
		
		//������ ��ư�� ���� �ٸ� ó�� (sw=1:BG sw=2:BR)
		if (Painter.sw==1) {
			Painter.bgColor=pickColor;
			Painter.p2.setBackground(Painter.bgColor);
			Painter.lblBG.setBackground(Painter.bgColor);
		}else if (Painter.sw==2) {
			Painter.brColor=pickColor;
			Painter.lblBColor.setBackground(Painter.brColor);
		}else {
			
		}
		f2.setVisible(false); //â ������ 
	}
	
}

//main class/////////////////////////////////////////////////////
public class PainterKids {
	
	public static void main(String[] args) {
		Painter sc=new Painter();
		SubPainter sc1=new SubPainter();
		
	}

}//main class end
