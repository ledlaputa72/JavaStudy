package java_SwingGUI02;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JToggleButton;
import javax.swing.JButton;
import javax.swing.JToolBar;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import java.awt.Font;

public class JToolBarWindow extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JToolBarWindow frame = new JToolBarWindow();
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
	public JToolBarWindow() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 646, 410);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lbl1 = new JLabel("글씨 색과 크기가 변합니다. ");
		lbl1.setFont(new Font("굴림", Font.PLAIN, 20));
		lbl1.setBounds(146, 157, 343, 65);
		contentPane.add(lbl1);
		
		JToolBar toolBar = new JToolBar();
		toolBar.setBounds(12, 10, 614, 65);
		contentPane.add(toolBar);
		//버튼1
		JButton btnButton1 = new JButton("Red");
		btnButton1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setForeground(Color.RED);
			}
		});
		btnButton1.setIcon(new ImageIcon("E:\\icon_red.png"));
		toolBar.add(btnButton1);
		//버튼2
		JButton btnButton2 = new JButton("Green");
		btnButton2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setForeground(Color.GREEN);
			}
		});
		btnButton2.setIcon(new ImageIcon("E:\\icon_green.png"));
		toolBar.add(btnButton2);
		//버튼3
		JButton btnButton3 = new JButton("12pt");
		btnButton3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lbl1.setFont(new Font("굴림",Font.BOLD,20));
			}
		});
		btnButton3.setIcon(new ImageIcon("E:\\icon_12.png"));
		toolBar.add(btnButton3);
		//버튼4
		JButton btnButton4 = new JButton("32pt");
		btnButton4.setIcon(new ImageIcon("E:\\icon_32.png"));
		btnButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lbl1.setFont(new Font("굴림",Font.BOLD,30));
			}
		});
		toolBar.add(btnButton4);
		//버튼5
		JButton btnButton5 = new JButton("exit");
		btnButton5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		btnButton5.setIcon(new ImageIcon("E:\\icon_stop.png"));
		toolBar.add(btnButton5);
	}
}
