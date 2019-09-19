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

	JLabel lbTitle; // Login 글자가 들어갈 라벨
	JLabel lbNickname; // 닉네임을 입력하라는 내용이 나올 라벨

	JPanel panelTitle, panelContent; // Login 제목이 들어갈 패널, 닉네임 입력란과 접속 버튼이 들어갈 패널

	public LoginPanel(MainFrame mainFrame) {

		this.mainFrame = mainFrame;

		this.setLayout(null);

		panelTitle = new JPanel();
		panelTitle.add(lbTitle = new JLabel("LOGIN"));
		lbTitle.setFont(new Font("Serif", Font.BOLD, 30)); // Login 폰트 설정
		panelTitle.setBounds(200, 50, 100, 100); // Login 타이틀 위치 설정
		this.add(panelTitle);
		
		panelContent = new JPanel();
		panelContent.add(lbNickname = new JLabel("닉네임 : "));
		panelContent.add(tfNickname = new JTextField());
		tfNickname.setPreferredSize(new Dimension(200, 35)); // 닉네임 텍스트 필드 크기 설정
		panelContent.add(btnOk = new JButton("접속"));
		panelContent.setBounds(10, 150, 500, 100); // 닉네임 입력란과 접속 버튼이 포함된 패널 위치 설정
		btnOk.setPreferredSize(new Dimension(80, 35)); // 접속 버튼 크기 설정
		this.add(panelContent);
		
		btnOk.addActionListener(this);
		tfNickname.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		// 닉네임을 입력했다면
		if (tfNickname.getText().trim().length() > 0) { 
			
			UserInfo userInfo = new UserInfo(tfNickname.getText().trim()); // 닉네임을 읽어 userInfo 객체 생성
			LoginPanel.this.mainFrame.startThread(userInfo); // 닉네임 입력하여 접속 후 스레드 시작
			
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
