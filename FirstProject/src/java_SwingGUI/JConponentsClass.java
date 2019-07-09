package java_SwingGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class JConponentsClass2 extends JFrame implements ActionListener{

	//�⺻ ���̾ƿ� ���۳�Ʈ 
	private JPanel contentPane,topPane,midPane,botPane;
	GridLayout gl1,glT;
	
	//��� ���۳�Ʈ ////////
	JLabel Jlb1;
	JTextField Jtf1;
	JButton jBtn1;
	JToggleButton jtBtn1,jtBtn2,jtBtn3,jtBtn4;
	ButtonGroup bg1,bg2; //������ư�� �׷�
	
	//�߰� ���۳�Ʈ /////////
	JRadioButton jrb1,jrb2,jrb3;
	JCheckBox jcb1,jcb2,jcb3;
	JComboBox jcombo;
	
	//�ϴ� ���۳�Ʈ ////////
	JList list;
	
	//������
	public JConponentsClass2() {
		//�⺻ contentPane ����
		contentPane = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		
		gl1=new GridLayout(3,1);
		contentPane.setLayout(gl1);
		
		//3���� ���� �г� ����
		topPane = new JPanel();
		midPane = new JPanel();
		botPane = new JPanel();
		//contentPane�� �г� add
		contentPane.add(topPane);
		contentPane.add(midPane);
		contentPane.add(botPane);
		
		glT=new GridLayout(1,7,5,5);
		topPane.setLayout(glT);
		midPane.setLayout(glT);
		botPane.setLayout(glT);
		
		//top�гο� ���۳�Ʈ �߰� 
		topPane.add(Jlb1=new JLabel("�ٸ��"));
		topPane.add(Jtf1=new JTextField("�������"));
		topPane.add(jBtn1=new JButton("������"));
		topPane.add(jtBtn1=new JToggleButton("����ġ��ư")); //�ܵ����� ���� 
		topPane.add(jtBtn2=new JToggleButton("PLAY")); //3���� ����� ��� ��ư 
		topPane.add(jtBtn3=new JToggleButton("PASUE"));
		topPane.add(jtBtn4=new JToggleButton("STOP"));
		
		//mid�гο� ���۳�Ʈ �߰� 
		midPane.add(jrb1 = new JRadioButton("���")); //������ư
		midPane.add( jrb2 = new JRadioButton("��ø���"));
		midPane.add(jrb3 = new JRadioButton("����"));
		
		midPane.add(jcb1=new JCheckBox("���",true)); //üũ��ư
		midPane.add(jcb2=new JCheckBox("��",false));
		midPane.add(jcb3=new JCheckBox("��",true));
		
		//��۹�ư �׷�
		bg1=new ButtonGroup();
		bg1.add(jtBtn2);
		bg1.add(jtBtn3);
		bg1.add(jtBtn4);
		jtBtn2.setSelected(true);
		
		//������ư �׷�
		bg2=new ButtonGroup();
		bg2.add(jrb1);
		bg2.add(jrb2);
		bg2.add(jrb3);
		jrb1.setSelected(true);
		
		String[] comboStr={"�౸","��","�߱�","�豸","����"}; //�޺��ڽ��� ���� �迭 
		jcombo=new JComboBox();
		for (int i = 0; i < comboStr.length; i++) {
			jcombo.addItem(comboStr[i]); //�޺��ڽ�
		}
		midPane.add(jcombo);
		
		//bot�гο� ���۳�Ʈ �߰�
		String[] listStr={"����","�λ�","�뱸","����","��õ"}; //�޺��ڽ��� ���� �迭 
		list = new JList(listStr);

		//crtl ���� �������� �ǳʶٸ� ���ð���, shift��뵵 ���� 
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		/*//Shift������ �������� ����, �������� ���� ����, ctrl��밡��
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		//�ϳ����� only
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);*/
		botPane.add(list);
	}
	
	//�̺�Ʈ ������ 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

public class JConponentsClass {

	public static void main(String[] args) {
		JConponentsClass2 jcc=new JConponentsClass2();
		jcc.setVisible(true);
	}

}
