package Day050_ScketchQuizTest2;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.border.*;

public class ImageStreamTest extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ImageStreamTest frame = new ImageStreamTest();
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
	public ImageStreamTest() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 500, 500); //window size
		
		//Frame setting
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		//label
		JLabel lblLabel = new JLabel("label01");
		lblLabel.setBounds(32, 6, 61, 16);
		contentPane.add(lblLabel);
		
		//send button
		JButton btnSend = new JButton("SendImage");
		btnSend.setBounds(245, 1, 117, 29);
		//event
		btnSend.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnSend);
		
		//receive button 
		JButton btnRcv = new JButton("ReceiveImage");
		btnRcv.setBounds(366, 1, 117, 29);
		//event
		btnRcv.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		contentPane.add(btnRcv);
		
		JPanel imgPanel = new JPanel();
		imgPanel.setBounds(6, 32, 488, 440);
		contentPane.add(imgPanel);
	}
}
