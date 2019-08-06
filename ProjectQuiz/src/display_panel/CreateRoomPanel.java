package display_panel;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class CreateRoomPanel extends JPanel { // ���ǿ��� �游��� ��ư�� ������ ���� ���̾�α׿�
												// ��ġ��ų �г�
	JTextField gameRoomNameTf;
	JComboBox<String> publicOrPrivateCombox;
	JPasswordField gameRoomPasswordTf;
	JComboBox<Integer> gameUserNumCombox;
	JButton createBtn, cancelBtn;

	JPanel center_p, south_p;
	JPanel center_p_west, center_p_center;

	WaitingRoomPanel wrp;
	boolean isPublicRoom = true;
	int gameUserNum = 4;
	
	public CreateRoomPanel(WaitingRoomPanel wrp) {
		this.wrp = wrp;
		setLayout(new BorderLayout());
		// ���� �г�
		this.add(new JLabel("�� �����"), BorderLayout.NORTH);
		// �����г�
		center_p = new JPanel(new BorderLayout());
		center_p_west = new JPanel(new GridLayout(4, 1));
		center_p_west.add(new JLabel("������"));
//		center_p_west.add(new JLabel("��������"));
//		center_p_west.add(new JLabel("��й�ȣ"));
		center_p_west.add(new JLabel("�����ο�"));
		center_p.add(center_p_west, BorderLayout.WEST);

		center_p_center = new JPanel(new GridLayout(4, 1));
		center_p_center.add(gameRoomNameTf = new JTextField(20));
		String[] strArr = { "����", "�����" };
		publicOrPrivateCombox = new JComboBox<>(strArr);
//		center_p_center.add(publicOrPrivateCombox);
//		center_p_center.add(gameRoomPasswordTf = new JPasswordField(10));
//		gameRoomPasswordTf.setEditable(false);
		Integer[] intArr = { 4, 5, 6, 7, 8 };
		gameUserNumCombox = new JComboBox<>(intArr);
		center_p_center.add(gameUserNumCombox);
		center_p.add(center_p_center);

		this.add(center_p);
		// ���� �г�
		south_p = new JPanel(new FlowLayout());
		south_p.add(createBtn = new JButton("�����"));
		south_p.add(cancelBtn = new JButton("�� ��"));
		this.add(south_p, BorderLayout.SOUTH);

		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateRoomPanel.this.wrp.cancelCreateRoomPanel();
			}
		});
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (gameRoomNameTf.getText().trim().length() < 1) {
					ShowMessageThread t = new ShowMessageThread(CreateRoomPanel.this, "�� ������ �Է��ϼ���~");
					t.start();
				}else{
					CreateRoomPanel.this.wrp.createGameRoom(gameRoomNameTf.getText().trim(), isPublicRoom,
							"",gameUserNum);
				}
			}
		});
		publicOrPrivateCombox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					String item = (String) e.getItem();
					if(item.equals("����")){
						isPublicRoom = true;
						gameRoomPasswordTf.setEditable(false);
						gameRoomPasswordTf.setText("");
					}else if(item.equals("�����")){
						isPublicRoom = false;
						gameRoomPasswordTf.setEditable(true);
					}
				}
			}
		});
		gameUserNumCombox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					Integer num = (Integer)e.getItem();
					gameUserNum = num;
				}
			}
		});
	}
}
class ShowMessageThread extends Thread{
	String msg;
	Component com;
	public ShowMessageThread(Component com,String msg){
		this.msg = msg;
		this.com = com;
	}
	@Override
	public void run() {
		JOptionPane.showMessageDialog(com, msg);
	}
}
