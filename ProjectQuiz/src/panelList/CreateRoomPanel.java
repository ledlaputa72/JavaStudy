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

	JLabel lbRoomName; // �� �̸� ��
	JTextField tfRoomName; // �� �̸� �ؽ�Ʈ �ʵ�
	JButton btnCreate, btnCancel; // �� ����� ��ư, ��� ��ư
	JPanel panelRoomName, panelButton; // �� �̸� �Է� �ʵ带 ��Ÿ�� �г�, �� ����� ��ư�� ��� ��ư�� ��Ÿ�� �г�

	int gameUserNum = 3; // ���� �ο� ���� 3���� ����

	// ������
	public CreateRoomPanel(RoomListPanel wrp) {

		this.wrp = wrp;

		setLayout(null);

		panelRoomName = new JPanel(new BorderLayout());
		panelRoomName.add(lbRoomName = new JLabel("�� �̸�   :   "), BorderLayout.WEST);
		panelRoomName.add(tfRoomName = new JTextField());
		tfRoomName.setPreferredSize(new Dimension(200, 35));
		panelRoomName.setBounds(30, 30, 220, 30);
		
		this.add(panelRoomName);

		panelButton = new JPanel(new FlowLayout());
		panelButton.add(btnCreate = new JButton("�����"));
		btnCreate.setPreferredSize(new Dimension(80, 35));
		panelButton.add(btnCancel = new JButton("�� ��"));
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

					ShowMessageThread t = new ShowMessageThread(CreateRoomPanel.this, "�� ������ �Է��ϼ���~");

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

	// ������
	public ShowMessageThread(Component com, String msg) {

		this.msg = msg;
		this.com = com;

	}

	@Override
	public void run() {

		JOptionPane.showMessageDialog(com, msg);

	}

}
