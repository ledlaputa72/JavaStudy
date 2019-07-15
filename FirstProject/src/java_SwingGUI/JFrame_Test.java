package java_SwingGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class JFrame_Test extends JFrame implements ActionListener{

	private JPanel contentPane;
	private final Action action = new SwingAction();
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrame_Test frame = new JFrame_Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public JFrame_Test() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 640, 480);
		//�޴���
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		//���� �޴� 
		JMenu menu = new JMenu("����");
		menuBar.add(menu);
		
		JMenuItem menuItem_1 = new JMenuItem("������");
		menu.add(menuItem_1);
		
		JMenuItem menuItem_2 = new JMenuItem("����");
		menu.add(menuItem_2);
		
		menu.addSeparator();
		
		JMenuItem menuItem_3 = new JMenuItem("����");
		menu.add(menuItem_3);
		
		JMenuItem menuItem_4 = new JMenuItem("���̸���������");
		menu.add(menuItem_4);
		
		menu.addSeparator();
		
		JMenuItem menuItem_5 = new JMenuItem("����");
		menu.add(menuItem_5);
		
		//���� �޴� �׼� 
		menuItem_1.addActionListener(this);
		menuItem_2.addActionListener(this);
		menuItem_3.addActionListener(this);
		menuItem_4.addActionListener(this);
		menuItem_5.addActionListener(this);
		
		//���� �޴�
		JMenu menu_1 = new JMenu("����");
		menuBar.add(menu_1);
		
		JMenuItem menuItem_6 = new JMenuItem("��μ���");
		menu_1.add(menuItem_6);
		
		JMenuItem menuItem_7 = new JMenuItem("����");
		menu_1.add(menuItem_7);
		
		JMenuItem menuItem_8 = new JMenuItem("���̱�");
		menu_1.add(menuItem_8);
		
		//���� �޴� �׼�
		menuItem_6.addActionListener(this);
		menuItem_7.addActionListener(this);
		menuItem_8.addActionListener(this);
		
		//���� �޴�
		JMenu menu_2 = new JMenu("����");
		menuBar.add(menu_2);
		
		JMenuItem menuItem_9 = new JMenuItem("����");
		menu_2.add(menuItem_9);
		
		JMenuItem menuItem_10 = new JMenuItem("��������");
		menu_2.add(menuItem_10);
		
		//���� �޴� �׼�
		menuItem_9.addActionListener(this);
		menuItem_10.addActionListener(this);
		
		//������ �г� ����
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblTest = new JLabel("test");
		lblTest.setBounds(295, 208, 61, 16);
		contentPane.add(lblTest);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	
	//�̺�Ʈ �ڵ鷯 
	@Override
	public void actionPerformed(ActionEvent e) {
		if ("������".equals(e.getActionCommand()))  {
			
		}
		else if ("����".equals(e.getActionCommand()))  {
			
		}
		
		else if ("����".equals(e.getActionCommand()))  {
			
		}
		
		else if ("���̸���������".equals(e.getActionCommand())) {
			
		}
		else if("����".equals(e.getActionCommand())) {
			System.exit(0);
		}
		
		else if ("��μ���".equals(e.getActionCommand())) {
			
		}
		
		else if ("����".equals(e.getActionCommand())) {
			
		}
		
		else if ("����".equals(e.getActionCommand())) {
			
		}
		
		else if ("��������".equals(e.getActionCommand())) {
			
		}
		
		else{
			
		}
		
		
	}
}
