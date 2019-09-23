package panelList;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class CreateRoomPanel extends JPanel {

	RoomListPanel wrp;

	JLabel lbRoomName; // 방 이름 라벨
	JTextField tfRoomName; // 방 이름 텍스트 필드
	JButton btnCreate, btnCancel; // 방 만들기 버튼, 취소 버튼
	JPanel panelRoomName, panelButton; // 방 이름 입력 필드를 나타낼 패널, 방 만들기 버튼과 취소 버튼을 나타낼 패널

	int gameUserNum = 3; // 게임 인원 수를 3으로 제한

	// 생성자
	public CreateRoomPanel(RoomListPanel wrp) {

		this.wrp = wrp;

		setLayout(null);

		panelRoomName = new JPanel(new BorderLayout());
		panelRoomName.add(lbRoomName = new JLabel("방 이름   :   "), BorderLayout.WEST);
		panelRoomName.add(tfRoomName = new JTextField());
		tfRoomName.setPreferredSize(new Dimension(200, 35));
		panelRoomName.setBounds(30, 30, 220, 30);
		
		this.add(panelRoomName);

		panelButton = new JPanel(new FlowLayout());
		panelButton.add(btnCreate = new JButton("만들기"));
		btnCreate.setPreferredSize(new Dimension(80, 35));
		panelButton.add(btnCancel = new JButton("취 소"));
		btnCancel.setPreferredSize(new Dimension(80, 35));
		panelButton.setBounds(30, 90, 220, 50);
		this.add(panelButton);

		btnCancel.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {

				CreateRoomPanel.this.wrp.cancelCreateRoomPanel();

			}

		});

		btnCreate.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {

				if (tfRoomName.getText().trim().length() < 1) {

					ShowMessageThread t = new ShowMessageThread(CreateRoomPanel.this, "방 제목을 입력하세요~");

					t.start();

				}

				else
					CreateRoomPanel.this.wrp.createGameRoom(tfRoomName.getText().trim(), gameUserNum);

			}

		});

	}
}

class ShowMessageThread extends Thread {

	String msg;

	Component com;

	// 생성자
	public ShowMessageThread(Component com, String msg) {

		this.msg = msg;
		this.com = com;

	}

	@Override
	public void run() {

		JOptionPane.showMessageDialog(com, msg);

	}

}
