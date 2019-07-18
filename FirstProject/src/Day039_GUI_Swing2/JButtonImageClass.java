package Day039_GUI_Swing2;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class JButtonImageClass extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JButtonImageClass frame = new JButtonImageClass();
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
	public JButtonImageClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblImage = new JLabel("ÀÌ¹ÌÁö Ã³¸® ");
		lblImage.setFont(new Font("±¼¸²", Font.PLAIN, 20));
		lblImage.setBounds(32, 10, 261, 42);
		contentPane.add(lblImage);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setIcon(new ImageIcon("bb.png"));
			}
		});
		btnNewButton.setIcon(new ImageIcon("E:\\aa.png"));
		btnNewButton.setBounds(53, 62, 653, 665);
		contentPane.add(btnNewButton);
		
		//Áß¾Ó¿¡ Ã¢ ¶ç¿ì±â 
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int posx = (int)(screen.getWidth()/2-this.getWidth()/2);
		int posy = (int)(screen.getHeight()/2-this.getHeight()/2);
		setLocation(posx, posy);
		
	}
}
