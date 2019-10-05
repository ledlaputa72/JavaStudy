package Day033_GUI_AWT1;

import java.awt.Button;
import java.awt.Frame;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

class ButtonTest2 extends Frame implements ActionListener{
	
	private Label lb=new Label("��ư �׽�Ʈ");
	private Button b1=new Button("��������");
	
	public ButtonTest2(){
		
		this.setLayout(null);
		
		//��ư
		b1.setSize(100, 100);
		b1.setLocation(100, 200);
		this.add(b1);
		b1.addActionListener(this);
		
		//��
		lb.setSize(100, 100);
		lb.setLocation(100, 100);
		this.add(lb);
		
		//����������
		this.setSize(400, 400);
		this.setVisible(true);
		
		//â���ݱ�
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //�����ڰ� ���� �޸��� ������ ����� ���
				System.exit(0);
			}
		});
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==b1) { //��ư�� ���������� ó�� (�̺�Ʈ �ڵ鷯)
			lb.setText("������");
		}
		
	}
	
}

public class ButtonTest {

	public static void main(String[] args) {
		ButtonTest2 bt1=new ButtonTest2();
		
	}

}
