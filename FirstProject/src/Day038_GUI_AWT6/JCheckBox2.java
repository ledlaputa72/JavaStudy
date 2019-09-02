package Day038_GUI_AWT6;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JCheckBox2 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JCheckBox2 frame = new JCheckBox2();
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
	public JCheckBox2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(12, 10, 410, 130);
		contentPane.add(panel1);
		panel1.setLayout(null);
		
		javax.swing.JCheckBox ch1 = new javax.swing.JCheckBox("회원카드보유");
		ch1.setBounds(55, 14, 135, 23);
		panel1.add(ch1);
		ch1.setSelected(true);
		
		javax.swing.JCheckBox ch2 = new javax.swing.JCheckBox("장기회원");
		ch2.setBounds(55, 48, 135, 23);
		panel1.add(ch2);
		ch2.setSelected(true);
		
		javax.swing.JCheckBox ch3 = new javax.swing.JCheckBox("해외여행신청여부");
		ch3.setBounds(54, 84, 136, 23);
		panel1.add(ch3);
		
		javax.swing.JCheckBox ch4 = new javax.swing.JCheckBox("이벤트 대상자");
		ch4.setBounds(237, 84, 135, 23);
		panel1.add(ch4);
		
		javax.swing.JCheckBox ch5 = new javax.swing.JCheckBox("이달의 고객");
		ch5.setBounds(237, 14, 135, 23);
		panel1.add(ch5);
		ch5.setSelected(true);
		
		JPanel panel2 = new JPanel();
		panel2.setBounds(12, 173, 410, 61);
		contentPane.add(panel2);
		panel2.setLayout(null);
		
		JButton btnAll = new JButton("All");
		btnAll.setBounds(112, 23, 63, 23);
		panel2.add(btnAll);
		
		JButton btnNone = new JButton("None");
		btnNone.setBounds(228, 23, 63, 23);
		panel2.add(btnNone);
		btnNone.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ch1.setSelected(false);
				ch2.setSelected(false);
				ch3.setSelected(false);
				ch4.setSelected(false);
				ch5.setSelected(false);
			}
		});
		btnAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ch1.setSelected(true);
				ch2.setSelected(true);
				ch3.setSelected(true);
				ch4.setSelected(true);
				ch5.setSelected(true);
			}
		});
		
	}
}
