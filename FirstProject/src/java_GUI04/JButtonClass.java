package java_GUI04;
//one class ���

import java.awt.FlowLayout;
import javax.swing.*;
 
public class JButtonClass extends JFrame{
	//���۳�Ʈ ����, ������ �ۿ����� ����������
	JPanel jp1=new JPanel();
	JButton jb1=new JButton("���"); 
	JButton jb2=new JButton("��");
	JButton jb3=new JButton("��");
	
	//������ 
	public JButtonClass() {

		//���۳�Ʈ ����, ������ �ȿ��� ���� ������
		/*JButton jb1=new JButton("���");
		JButton jb2=new JButton("��");
		JButton jb3=new JButton("��");*/
		
		setLayout(new FlowLayout());
		
		//JPanel���� ��ư�� ���δ�. 
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		//ContentPane : component�� �ö󰡴� �� 
		//getContentPane : ContentPane�� �˾Ƴ��� �ű�ٰ� add 
		getContentPane().add(jp1); 
		
		/*//JPanel�� ���� ���
		add(jb1); //this.add(jb1);�� ���� this�� ���� 
		add(jb2);
		add(jb3);*/
		this.setTitle("��ư�̾�");
		this.setSize(300,200);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {

		JButtonClass jbc1=new JButtonClass();
		/*		jbc1.setTitle("��ư�̾�");
				jbc1.setSize(300,200);
				jbc1.setVisible(true);*/
	}

}
