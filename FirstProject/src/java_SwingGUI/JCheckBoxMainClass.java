package java_SwingGUI;

import javax.swing.*;

public class JCheckBoxMainClass extends JFrame {
	
	public JCheckBoxMainClass() {
		JPanel jp1=new JPanel();
		JCheckBox jcb1=new JCheckBox("ȸ��ī�庸��",true);
		JCheckBox jcb2=new JCheckBox("���ȸ��",true);
		JCheckBox jcb3=new JCheckBox("�ؿܿ����û����", false);
		
	}

	public static void main(String[] args) {
		JCheckBoxMainClass jcbc1 = new JCheckBoxMainClass();
		jcbc1.setTitle("üũ�ڽ����");
		jcbc1.setSize(500, 500);
		jcbc1.setVisible(true);
	}

}
