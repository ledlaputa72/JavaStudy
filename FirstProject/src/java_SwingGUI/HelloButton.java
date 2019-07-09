package java_SwingGUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import javax.swing.JList;
import javax.swing.JComboBox;

public class HelloButton extends JFrame {
	
	private JPanel contentPane;
	private JLabel lblNewLabel = new JLabel(""); //lblNewLabel를 전역 변수로 변경
	private final JList list = new JList();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HelloButton frame = new HelloButton();
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
	public HelloButton() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnImsi = new JButton("\uB20C\uB7EC\uBD10"); //한글 유니코드
		btnImsi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				//라벨 객체.메소드() 
				lblNewLabel.setText("안녕 자바");
			}
		});
		btnImsi.setBounds(164, 188, 97, 23);
		contentPane.add(btnImsi);
		
//		JLabel lblNewLabel = new JLabel(""); //lblNewLabel가 지역 변수 -> 전역 변수로 변경 필요 18번 라인트로 이동
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 25));
		lblNewLabel.setBounds(115, 36, 199, 54);
		contentPane.add(lblNewLabel);
		list.setBounds(29, 64, 88, 97);
		
		contentPane.add(list);
		
	}
}
