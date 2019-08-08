package Day047_10_tcp_thread_multiChat;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;
import java.awt.event.*;

public class JFrameTest extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameTest frame = new JFrameTest();
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
	public JFrameTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelTop = new JPanel();
		panelTop.setBackground(Color.CYAN);
		panelTop.setBounds(0, 0, 1184, 60);
		contentPane.add(panelTop);
		panelTop.setLayout(null);
		
		JPanel panelCanvas = new JPanel();
		panelCanvas.setBackground(Color.YELLOW);
		panelCanvas.setBounds(0, 60, 800, 700);
		panelCanvas.setVisible(true);
		contentPane.add(panelCanvas);
		
		JPanel panelView = new JPanel();
		panelView.setBackground(Color.RED);
		panelView.setBounds(0, 60, 800, 700);
		panelView.setVisible(false);
		contentPane.add(panelView);
		
		JPanel panelChat = new JPanel();
		panelChat.setBackground(Color.GRAY);
		panelChat.setBounds(800, 60, 384, 700);
		contentPane.add(panelChat);
		panelChat.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(0, 664, 384, 38);
		panelChat.add(textField);
		textField.setColumns(10);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(0, 0, 384, 664);
		panelChat.add(textArea);
		
		JPanel panelUsers = new JPanel();
		panelUsers.setBackground(Color.ORANGE);
		panelUsers.setBounds(0, 759, 1184, 180);
		contentPane.add(panelUsers);
		
		/*//버튼 조작으로 캔버스, 뷰어 변경 테스트
		JButton btnNewButton = new JButton("서버 클라 전환");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(panelCanvas.isVisible()==false) {
				panelCanvas.setVisible(true);
				panelView.setVisible(false);
				}else{
					panelCanvas.setVisible(false);
					panelView.setVisible(true);	
				}
			}
		});
		btnNewButton.setBounds(10, 10, 150, 25);
		panelTop.add(btnNewButton);*/
		
	}
}
