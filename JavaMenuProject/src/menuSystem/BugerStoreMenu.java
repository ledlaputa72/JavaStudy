package menuSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MenuSystem extends JFrame implements ActionListener, ListSelectionListener {
	//��
	JLabel jlb1, jlb2;
	//��ư
	String[] buger=new String[4];
	int[] priceArr=new int[4];
	JButton[] jbt=new JButton[6];
	//����Ʈ
	String[] listArr= {"����","���ο�"};
	JList jlist=new JList(listArr);
	
	static String str=""; //��� ���ڿ�
	static int price=0;  //�ֹ� ����
	static int num=0; //�ֹ� ����
	
	public MenuSystem() {
		setLayout(new GridLayout(0,2,30,30));
		this.setTitle("��Ϳ� �������Դϴ�");
		
		//�󺧰� ��ư ����
		jlb1=new JLabel("**��Ŀ �� �ܹ����Դϴ�.**",JLabel.CENTER);
		jlb1.setFont(new Font("����",Font.BOLD,20));
		jlb2=new JLabel("��� �޴��� �����ϼ���",JLabel.CENTER);
		jlb2.setFont(new Font("����",Font.BOLD,20));

		buger[0]="�ſ� �ҽ� �ܹ��� : ";
		buger[1]="���� ���� �ܹ��� : ";
		buger[2]="��ü���� �ܹ��� : ";
		buger[3]="�����丶�� �ܹ��� : ";
		
		priceArr[0]=5000;
		priceArr[1]=7000;
		priceArr[2]=4500;
		priceArr[3]=5500;
		
		jbt[0]=new JButton(buger[0]+ priceArr[0]);
		jbt[1]=new JButton(buger[1]+ priceArr[1]);
		jbt[2]=new JButton(buger[2]+ priceArr[2]);
		jbt[3]=new JButton(buger[3]+ priceArr[3]);
		jbt[4]=new JButton("�ֹ��մϴ�");
		jbt[5]=new JButton("����մϴ�");
		
		jbt[4].setBackground(Color.CYAN);
		jbt[5].setBackground(Color.YELLOW);
		jbt[4].setForeground(Color.RED);
		jbt[5].setForeground(Color.BLUE);
		
		//�󺧰� ��ư�� �߰� 
		add(jlb1);
		add(jlb2);
		for (int i = 0; i < jbt.length; i++) {
			add(jbt[i]);
			jbt[i].addActionListener(this);
		}
		//����Ʈ �߰�
		add(jlist);
		jlist.addListSelectionListener(this);
		
		//������ ����
		setSize(600, 800);
		setVisible(true);
	}
	//��ư �̺�Ʈ 
	@Override
	public void actionPerformed(ActionEvent e) {
		//�Ŵ� ��ư �̺�Ʈ 
		for (int i = 0; i < 4; i++) {
			if (e.getSource()==jbt[i]) {
				str=str+(buger[i]+priceArr[i])+"\n";
				price=price+priceArr[i];
				num++;
			}
		}
		//�ֹ� ��ư �̺�Ʈ
		if (e.getSource()==jbt[4]) {
			JOptionPane.showMessageDialog(this, str+"�ѱݾ�:"+price+"\n"+"���ֹ�����:"+num+"��", "Ȯ���ϼ���", 3);
			str="";
			price=0;
			num=0;
		}
		//��� ��ư �̺�Ʈ
		if (e.getSource()==jbt[5]) {
			str="";
			price=0;
			num=0;
			JOptionPane.showMessageDialog(this, "����Ͽ����ϴ�.");
		}
	}
	//����Ʈ �̺�Ʈ 
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if ("����".equals(jlist.getSelectedValue())) {
			price=price-500;
		}
		else if("���ο�".equals(jlist.getSelectedValue())) {
			price=price-500;
		} 
	}
	
}//Ŭ���� end

public class BugerStoreMenu {

	public static void main(String[] args) {
		MenuSystem myMenu=new MenuSystem();
	}

}
