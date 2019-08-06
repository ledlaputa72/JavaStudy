package display_panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import main_frame.MainFrame;
import protocol.UserInfo;

public class NickNamePanel extends JPanel implements ActionListener {
	public static final String cardName = "NickNamePanel";
	public static final int BORDER_SIZE = 8;
	Color bg = new Color(27, 117, 200);
	Color bg2 = new Color(14, 85, 151);
	Color choice = new Color(236, 105, 65);
	MainFrame mainFrame;
	JTextField name_tf;
	JButton ok_btn;
	int width = 500, height = 500;

	JLabel[] characterImageLabelArr = new JLabel[8];
	JLabel name_lb;
	
	JPanel center_p, south_p, logo_p;

	public NickNamePanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		this.setLayout(new BorderLayout());

		logo_p = new JPanel(new FlowLayout());
		
		this.add(logo_p, BorderLayout.NORTH);

		south_p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		south_p.add(name_lb = new JLabel("닉네임 : "));
		name_lb.setForeground(Color.WHITE);
		south_p.add(name_tf = new JTextField());
		name_tf.setPreferredSize(new Dimension(200, 35));
		south_p.add(ok_btn = new JButton("접속"));
		ok_btn.setPreferredSize(new Dimension(80, 35));
		this.add(south_p, BorderLayout.SOUTH);
		ok_btn.addActionListener(this);
		name_tf.addActionListener(this);

		center_p = new JPanel(new FlowLayout());

		this.add(center_p);

		logo_p.setBackground(bg);
		south_p.setBackground(bg2);
		center_p.setBackground(bg);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (name_tf.getText().trim().length() > 0) {
			UserInfo userInfo = new UserInfo(name_tf.getText().trim());
			NickNamePanel.this.mainFrame.startThread(userInfo);
		}
	}

	public JTextField getName_tf() {
		return name_tf;
	}

	public void setName_tf(JTextField name_tf) {
		this.name_tf = name_tf;
	}

	public JButton getOk_btn() {
		return ok_btn;
	}

	public void setOk_btn(JButton ok_btn) {
		this.ok_btn = ok_btn;
	}

	public int getWidth() {
		return width;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	@Override
	public String toString() {
		return cardName;
	}
}
