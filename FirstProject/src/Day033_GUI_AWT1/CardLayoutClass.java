package Day033_GUI_AWT1;
//one class�� ���� 
import java.awt.*;
import java.awt.event.*;

public class CardLayoutClass extends Frame implements MouseListener {
	
	//��ü ����
	Frame f1;
	Panel pan1;
	Panel pan2;
	Panel pan3;
	CardLayout clo1;
	
	public CardLayoutClass() { //������
		
		f1=new Frame("���� �������̾�");
		clo1=new CardLayout();
		f1.setLayout(clo1);//ī��� ���̾ƿ� 
		
		pan1=new Panel();
		pan1.setBackground(Color.red);
		f1.add(pan1,"pan1");//pan1�� ������ pan1
		pan1.addMouseListener(this); //���콺 �̺�Ʈ ������
		
		pan2=new Panel();
		pan2.setBackground(Color.yellow);
		f1.add(pan2,"pan2");//pan2�� ������ pan2
		pan2.addMouseListener(this); //���콺 �̺�Ʈ ������
		
		pan3=new Panel();
		pan3.setBackground(Color.blue);
		f1.add(pan3,"pan3");//pan3�� ������ pan3
		pan3.addMouseListener(this); //���콺 �̺�Ʈ ������
		
		clo1.show(f1, "pan1"); //3���� ī���߿� �ʱ⿡ ���̴� ���� pan1
		
		f1.setSize(500, 500);
		f1.setVisible(true);
		
		//�ݱ�
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	}//������ ���� 
	
	//���콺 �̺�Ʈ 
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
		clo1.previous(f1); //�� �гη� �̵�
		//clo1.next(f1); //�� �гη� �̵� 
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	//main 
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CardLayoutClass flc1=new CardLayoutClass();
	}
	
}
