package java_SwingGUI;

import javax.swing.*;

public class JCheckBoxMainClass extends JFrame {
	
	public JCheckBoxMainClass() {
		JPanel jp1=new JPanel();
		JCheckBox jcb1=new JCheckBox("회원카드보유",true);
		JCheckBox jcb2=new JCheckBox("장기회원",true);
		JCheckBox jcb3=new JCheckBox("해외여행신청여부", false);
		
	}

	public static void main(String[] args) {
		JCheckBoxMainClass jcbc1 = new JCheckBoxMainClass();
		jcbc1.setTitle("체크박스라는");
		jcbc1.setSize(500, 500);
		jcbc1.setVisible(true);
	}

}
