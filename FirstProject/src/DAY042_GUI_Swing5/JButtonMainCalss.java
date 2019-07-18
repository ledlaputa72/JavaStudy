package DAY042_GUI_Swing5;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JButtonClass extends JFrame implements ActionListener{

	JLabel jl1=new JLabel("KG����ְ�");
	JLabel jl2=new JLabel("��㼱�ߴ�ȸ");
	JLabel jl3=new JLabel("���� �ڳʴ�");
	JButton jb1=new JButton("�뷡10��");
	JButton jb2=new JButton("��20��");
	JButton jb3=new JButton("�������30��");
	JButton jb4=new JButton("ö�λ������100��");
	JButton jb5=new JButton("�̷�Ż��90��");
	JButton jb6=new JButton("����80��");
	JButton jb7=new JButton("������");
	JButton jb8=new JButton("���");
	
	String[] age1={"10��","20��","30���̻�"}; 
	JComboBox jcb1 = new JComboBox(age1);
	
	String hangmok=""; //���ڿ�, ���̰� 0�� ���ڿ�
	int jum=0;
	
	public JButtonClass() {
		setLayout(new GridLayout(0,3,30,30)); //0:�������� 
		
		//1��
		jl1.setFont(new Font("����",Font.BOLD,25));
		add(jl1);
		jl2.setFont(new Font("����",Font.BOLD,25));
		add(jl2);
		jl3.setFont(new Font("����",Font.BOLD,25));
		add(jl3);
		//2��
		jb1.addActionListener(this);
		add(jb1);
		jb2.addActionListener(this);
		add(jb2);
		jb3.addActionListener(this);
		add(jb3);
		//3��
		jb4.addActionListener(this);
		add(jb4);
		jb5.addActionListener(this);
		add(jb5);
		jb6.addActionListener(this);
		add(jb6);
		//4��
		jb7.setFont(new Font("����",Font.BOLD,25));
		jb7.addActionListener(this);
		jb7.setForeground(Color.RED);
		jb7.setBackground(Color.CYAN);
		add(jb7);
		
		jb8.setFont(new Font("����",Font.BOLD,25));
		jb8.setForeground(Color.BLUE);
		jb8.setBackground(Color.YELLOW);
		jb8.addActionListener(this);
		add(jb8);
		 
		jcb1.addActionListener(this);
		add(jcb1);
		
		setTitle("KG��۱�");
		setSize(700,700);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==jb1) {
			hangmok+=jb1.getText()+"\n";
			jum=jum+10;
		}
		if (e.getSource()==jb2) {
			hangmok+=jb2.getText()+"\n";
			jum=jum+20;
		}
		if (e.getSource()==jb3) {
			hangmok+=jb3.getText()+"\n";
			jum=jum+30;
		}
		if (e.getSource()==jb4) {
			hangmok+=jb4.getText()+"\n";
			jum=jum+100;
		}
		if (e.getSource()==jb5) {
			hangmok+=jb5.getText()+"\n";
			jum=jum+90;
		}
		if (e.getSource()==jb6) {
			hangmok+=jb6.getText()+"\n";
			jum=jum+80;
		}
		if (e.getSource()==jb7) {
			String msg1=hangmok+"��������"+String.valueOf(jum)+"��";
			JOptionPane.showMessageDialog(jb7, msg1);
			hangmok=""; //�� ó������ �ʱ�ȭ
			jum=0;
		}
		if (e.getSource()==jb8) {
			hangmok=""; //�� ó������ �ʱ�ȭ
			jum=0;
			JOptionPane.showMessageDialog(jb8, "��ҵǾ����ϴ�");
		}
		//�޺��ڽ� 
		if (e.getSource()==jcb1) {
			JOptionPane.showMessageDialog(jcb1, (String)jcb1.getSelectedItem()+"�̽ñ���");
			jum=jum+10;
		}
	}
	
}

public class JButtonMainCalss {

	public static void main(String[] args) {
		new JButtonClass();
	}

}
