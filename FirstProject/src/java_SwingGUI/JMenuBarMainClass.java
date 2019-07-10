package java_SwingGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import classHuman.Demon;

class JMenuBarClass extends JFrame implements ActionListener{
	
	JTextField jtextfield1=new JTextField("���� �������غ�");
	JMenuBar jmenubar1 = new JMenuBar();
	JMenu jmenu1 = new JMenu("������");
	JMenuItem[] jmenuitem1=new JMenuItem[5]; //�޴� �������� �迭�� 
	String[] selectArr= {"red��","green��","12��Ʈ","32��Ʈ","����",};
	
	//������
	public JMenuBarClass() {
		getContentPane().setLayout(new GridLayout(0,1,20,20));
		//���� �� 1���� �׸��� ���μ��� ������ ���� 20�ȼ�
		add(jtextfield1);
		//�޴� �������� �迭�� �Է� 
		for (int i = 0; i < jmenuitem1.length; i++) {
			jmenuitem1[i]=new JMenuItem(selectArr[i]); //�迭�� �޴� ������ �̸��� �Ҵ�
			jmenuitem1[i].addActionListener(this); //�Ҵ�� �޴��� �̺�Ʈ add
			jmenu1.add(jmenuitem1[i]); //�޴��� �޴� �������� add
		}
		jmenubar1.add(jmenu1);
		setJMenuBar(jmenubar1);
		
		setSize(700, 700);
		setVisible(true);
		
		//â �߾ӿ� ���� 
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		int posX=(int)(screen.getWidth()/2-this.getWidth()/2);
		int posY=(int)(screen.getHeight()/2-this.getHeight()/2);
		setLocation(posX,posY);
		
	}//������ end
	
	@Override //�̺�Ʈ ������
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jmenuitem1[0]) {
			jtextfield1.setForeground(Color.red);
		}else if (e.getSource()==jmenuitem1[1]) {
			jtextfield1.setForeground(Color.green);
		}else if (e.getSource()==jmenuitem1[2]) {
			jtextfield1.setFont(new Font("����",Font.BOLD,12));
		}else if (e.getSource()==jmenuitem1[3]) {
			jtextfield1.setFont(new Font("����",Font.BOLD,32));
		}else if (e.getSource()==jmenuitem1[4]) {
			System.exit(0);
		}
		
	}//������ end
	
}// class end

public class JMenuBarMainClass {

	public static void main(String[] args) {

		JMenuBarClass jmbc1=new JMenuBarClass();
	}

}
