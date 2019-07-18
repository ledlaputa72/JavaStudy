package DAY041_GUI_Swing4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JOptionPaneClass extends JFrame implements ActionListener{
	
	private JButton jbutton1;
	private JButton jbutton2;
	private JButton jbutton3;
	String[] kwail = {"���", "��","��","����","���","����","���ξ���"};
	
	//������
	public JOptionPaneClass() {
		setLayout(new FlowLayout());
		jbutton1 = new JButton("Message ���̾�α�");
		jbutton1.addActionListener(this);
		add(jbutton1);
		
		jbutton2 = new JButton("Confirm ���̾�α�");
		jbutton2.addActionListener(this);
		add(jbutton2);
		
		jbutton3 = new JButton("Input ���̾�α�");
		jbutton3.addActionListener(this);
		add(jbutton3);
		
		setSize(700, 700);
		setVisible(true);
	}//������ end
	
	@Override //�׼Ǹ����� 
	public void actionPerformed(ActionEvent e) {
		//MessageDialog 
		if (e.getSource()==jbutton1) {
			JOptionPane.showMessageDialog(jbutton1, "���� �޽����� �����شٴ�","�޽�������",JOptionPane.INFORMATION_MESSAGE);
			//Error, Waring, Question, Plain(No mark) 
			//(jbutton1,.. -> �޽����ڽ��� jbutton1���� ���. jbutton1��ġ���� ParentComponent�� �´�.
			//JOptionPane.showMessageDialog(null, "���� �޽����� �����شٴ�","�޽�������",JOptionPane.INFORMATION_MESSAGE);
			//(null,.. -> �޽����ڽ��� ȭ�� ��� ���. 
		}
		//ConfirmDialog
		else if (e.getSource()==jbutton2) {
			int bada1 = JOptionPane.showConfirmDialog(jbutton2, "��ȭ���������", "�޽�������", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
			//yes no, yes no cancel, ok cancel
			System.out.println(bada1);
			//yes = 0 , no = 1, cancel = 2			
			if (bada1==0) {
				JOptionPane.showMessageDialog(null, "��ȭ�� �������ϴ�.");
			}
			else if(bada1==1){
				JOptionPane.showMessageDialog(null, "��ȭ�� �Ⱥ��ϴ�.");
			}
			else if(bada1==2){
				JOptionPane.showMessageDialog(null, "����� ����մϴ�.");
			}
		}
		//InputDialog
		else if (e.getSource()==jbutton3) {
			String bada2=(String)JOptionPane.showInputDialog(jbutton3, "������ ����", "�޽�������",JOptionPane.WARNING_MESSAGE,new ImageIcon("e:/color1.png"),kwail,kwail[5]); //�迭�� 5��°�� �⺻;
			System.out.println(bada2);
			if (bada2!=null) { //��Ҵ� null
				JOptionPane.showMessageDialog(null, bada2);
			}
			//�̸� �Է� 
			String irum=JOptionPane.showInputDialog("�̸�����?");
			if (irum!=null) {
				JOptionPane.showMessageDialog(null, irum+"��, �ֹ� �����մϴ�.");
			}
		}
	}//�׼Ǹ����� end
	
}//Ŭ���� end

public class JOptionPaneMainClass {

	public static void main(String[] args) {
		new JOptionPaneClass();
	}

}
