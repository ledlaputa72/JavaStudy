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

public class CreateRoomPanel extends JPanel { // 대기실에서 방만들기 버튼을 누르면 나올 다이얼로그에
												// 위치시킬 패널
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
		// 북쪽 패널
		this.add(new JLabel("방 만들기"), BorderLayout.NORTH);
		// 센터패널
		center_p = new JPanel(new BorderLayout());
		center_p_west = new JPanel(new GridLayout(4, 1));
		center_p_west.add(new JLabel("방제목"));
//		center_p_west.add(new JLabel("공개여부"));
//		center_p_west.add(new JLabel("비밀번호"));
		center_p_west.add(new JLabel("게임인원"));
		center_p.add(center_p_west, BorderLayout.WEST);

		center_p_center = new JPanel(new GridLayout(4, 1));
		center_p_center.add(gameRoomNameTf = new JTextField(20));
		String[] strArr = { "공개", "비공개" };
		publicOrPrivateCombox = new JComboBox<>(strArr);
//		center_p_center.add(publicOrPrivateCombox);
//		center_p_center.add(gameRoomPasswordTf = new JPasswordField(10));
//		gameRoomPasswordTf.setEditable(false);
		Integer[] intArr = { 4, 5, 6, 7, 8 };
		gameUserNumCombox = new JComboBox<>(intArr);
		center_p_center.add(gameUserNumCombox);
		center_p.add(center_p_center);

		this.add(center_p);
		// 남쪽 패널
		south_p = new JPanel(new FlowLayout());
		south_p.add(createBtn = new JButton("만들기"));
		south_p.add(cancelBtn = new JButton("취 소"));
		this.add(south_p, BorderLayout.SOUTH);

		cancelBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CreateRoomPanel.this.wrp.cancelCreateRoomPanel();
			}
		});
		createBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (gameRoomNameTf.getText().trim().length() < 1) {
					ShowMessageThread t = new ShowMessageThread(CreateRoomPanel.this, "방 제목을 입력하세요~");
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
					if(item.equals("공개")){
						isPublicRoom = true;
						gameRoomPasswordTf.setEditable(false);
						gameRoomPasswordTf.setText("");
					}else if(item.equals("비공개")){
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
