package Day040_GUI_Swing3;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Dimension;

public class WindowOpenClass extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					WindowOpenClass frame = new WindowOpenClass();
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
	public WindowOpenClass() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBackground(Color.ORANGE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btn1 = new JButton("새창으로 가자");
		btn1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose(); //지금창 해제
				setVisible(false); //지금창 안보이게
				new WindowOpenClass2().setVisible(true);
			}
		});
		btn1.setBounds(96, 49, 247, 58);
		contentPane.add(btn1);
		
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		int posX=(int)(screen.getWidth()/2-this.getWidth()/2);
		int posY=(int)(screen.getHeight()/2-this.getHeight()/2);
		setLocation(posX, posY);
	}

}
