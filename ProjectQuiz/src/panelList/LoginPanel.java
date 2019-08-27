package panelList;

import java.awt.Dimension;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import main.MainFrame;
import protocol.UserInfo;

public class LoginPanel extends JPanel implements ActionListener {

	public static final String cardName = "LoginPanel";

	MainFrame mainFrame;

	JTextField tfNickname;
	JButton btnOk;

	int width = 500, height = 300;

	JLabel lbTitle; // Login ���ڰ� �� ��
	JLabel lbNickname; // �г����� �Է��϶�� ������ ���� ��

	JPanel panelTitle, panelContent; // Login ������ �� �г�, �г��� �Է¶��� ���� ��ư�� �� �г�

	public LoginPanel(MainFrame mainFrame) {

		this.mainFrame = mainFrame;

		this.setLayout(null);

		panelTitle = new JPanel();
		panelTitle.add(lbTitle = new JLabel("LOGIN"));
		lbTitle.setFont(new Font("Serif", Font.BOLD, 30)); // Login ��Ʈ ����
		panelTitle.setBounds(200, 50, 100, 100); // Login Ÿ��Ʋ ��ġ ����
		this.add(panelTitle);
		
		panelContent = new JPanel();
		panelContent.add(lbNickname = new JLabel("�г��� : "));
		panelContent.add(tfNickname = new JTextField());
		tfNickname.setPreferredSize(new Dimension(200, 35)); // �г��� �ؽ�Ʈ �ʵ� ũ�� ����
		panelContent.add(btnOk = new JButton("����"));
		panelContent.setBounds(10, 150, 500, 100); // �г��� �Է¶��� ���� ��ư�� ���Ե� �г� ��ġ ����
		btnOk.setPreferredSize(new Dimension(80, 35)); // ���� ��ư ũ�� ����
		this.add(panelContent);
		
		btnOk.addActionListener(this);
		tfNickname.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// �г����� �Է��ߴٸ�
		if (tfNickname.getText().trim().length() > 0) { 
			
			UserInfo userInfo = new UserInfo(tfNickname.getText().trim()); // �г����� �о� userInfo ��ü ����
			LoginPanel.this.mainFrame.startThread(userInfo); // �г��� �Է��Ͽ� ���� �� ������ ����
			
		}
		
	}

	public JTextField getTfNickname() {
		return tfNickname;
	}

	public void setTfNickname(JTextField tfNickname) {
		this.tfNickname = tfNickname;
	}

	public JButton getBtnOk() {
		return btnOk;
	}

	public void setBtnOk(JButton btnOk) {
		this.btnOk = btnOk;
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
