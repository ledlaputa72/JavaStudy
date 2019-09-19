package panelList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import main.MainFrame;
import protocol.SketchQuiz;
import protocol.GameRoomInfo;

public class RoomListPanel extends JPanel {

	public static final String cardName = "RoomListPanel";

	MainFrame mainFrame;

	int width = 620, height = 500;

	JPanel north_p, center_p, south_p; // WaitingRopomPanel �� borderLayout���� �����Ͽ� 3�κ����� ������
	JPanel input_p; // ����ڰ� ä�� ������ �Է��� �г� : waitingRoomChatField, sendChatBtn �� ��
	// ������Ʈ ����
	JButton joinGameRoomBtn, createGameRoomBtn, exitWaitingRoomBtn; // ������, �游���, ���� ������ ��ư ����
	JScrollPane gameRoomListScrollPane, waitingRoomUserListScrollPane, waitingRoomChatScrollPane; // �渮��Ʈ, ��������Ʈ, ä��â��
																									// ���� ��ũ��
	JList<String> gameRoomList, waitingRoomUserList; // ���ӹ� �̸� ����Ʈ, ���� ����� �̸� ����Ʈ
	JTextArea waitingRoomChatArea; // ���ǿ��� ä�ó����� ǥ���ϱ� ���� ������Ʈ
	JTextField waitingRoomChatField; // ���ǿ��� ä���ϱ� ���� ����ڰ� ���� �Է��ϴ� �κ�
	JButton sendChatBtn; // �Է��� ������ �����Ѵ�.
	JDialog jdialog; // �游��� ȭ���� ������ ���̾�α�

	// ������
	public RoomListPanel(MainFrame mainFrame) {

		this.mainFrame = mainFrame;

		initComponents(); // ������Ʈ�� ���� �� ���̾ƿ� ��ġ
		setComponentEvent(); // �� ������Ʈ�� �ʿ��� �̺�Ʈ�� ����

	}

	// ������Ʈ�� ���� �� ���̾ƿ� ��ġ
	private void initComponents() {
		this.setLayout(new BorderLayout());

		north_p = new JPanel(new FlowLayout(FlowLayout.RIGHT)) { // ������, �游���, ������ ��ư�� ���� ���� �г�

		};

		center_p = new JPanel(new BorderLayout()); // �� ��ϰ� �̿��� ��ϸ���Ʈ�� ���� ���� �г�
		south_p = new JPanel(new BorderLayout()); // ��ȭâ�� �Է¶� ������ ��ư�� ���� ���� �г�

		// ���� �г� �۾�
		north_p.add(joinGameRoomBtn = new JButton("�����ϱ�"));
		joinGameRoomBtn.setPreferredSize(new Dimension(100, 35));
		north_p.add(createGameRoomBtn = new JButton("�� �����"));
		createGameRoomBtn.setPreferredSize(new Dimension(100, 35));
		north_p.add(exitWaitingRoomBtn = new JButton("������"));
		exitWaitingRoomBtn.setPreferredSize(new Dimension(80, 35));

		// ���� �г� �۾�
		gameRoomListScrollPane = new JScrollPane(gameRoomList = new JList<>());
		gameRoomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gameRoomListScrollPane.setBorder(new TitledBorder("�� ���"));
		waitingRoomUserListScrollPane = new JScrollPane(waitingRoomUserList = new JList<>());

		center_p.add(gameRoomListScrollPane);

		this.add(north_p, BorderLayout.NORTH);
		this.add(center_p);

	}

	// �� ������Ʈ�� �ʿ��� �̺�Ʈ�� �����Ѵ�
	private void setComponentEvent() {
		gameRoomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					if (gameRoomList.getSelectedIndex() != -1) {
						SketchQuiz cmp = new SketchQuiz(SketchQuiz.JOIN_GAME_ROOM);
						cmp.setGameRoomIndex(gameRoomList.getSelectedIndex());
						mainFrame.sendProtocol(cmp);
					} else {
						JOptionPane.showMessageDialog(RoomListPanel.this, "�� ���� �����ϼ���");
					}
				}
			}
		});
		joinGameRoomBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (gameRoomList.getSelectedIndex() != -1) {
					SketchQuiz cmp = new SketchQuiz(SketchQuiz.JOIN_GAME_ROOM);
					cmp.setGameRoomIndex(gameRoomList.getSelectedIndex());
					mainFrame.sendProtocol(cmp);
				} else {
					JOptionPane.showMessageDialog(RoomListPanel.this, "�� ���� �����ϼ���");
				}
			}
		});
		exitWaitingRoomBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				SketchQuiz cmp = new SketchQuiz(SketchQuiz.EXIT_WAIT_ROOM);
				mainFrame.sendProtocol(cmp);

			}
		});

		createGameRoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showCreateRoomPanel();
			}
		});
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

	public void updateWaitingUserList(String[] list) {
		if (list != null) {
			waitingRoomUserList.setListData(list);
			waitingRoomUserList.invalidate();
		} else if (list == null) {

		}
	}

	public void updateGameRoomList(String[] list) {
		if (list != null) {
			gameRoomList.setListData(list);
			gameRoomList.invalidate();
		} else if (list == null) {
			setEmptyGameRoomList();
		}
	}

	public void showCreateRoomPanel() {
		jdialog = new JDialog();
		CreateRoomPanel crp = new CreateRoomPanel(this);
		jdialog.setContentPane(crp);
		jdialog.setBounds(mainFrame.getFrameX() + 200, mainFrame.getFrameY() + 200, 300, 200);
		jdialog.setTitle("�� �����");
		jdialog.setVisible(true);
	}

	public void cancelCreateRoomPanel() {
		jdialog.setVisible(false);
	}

	public void createGameRoom(String roomName, int gameUserNum) {
		GameRoomInfo gri = new GameRoomInfo(roomName, gameUserNum);
		SketchQuiz cmp = new SketchQuiz(SketchQuiz.CREATE_GAME_ROOM);
		cmp.setGameRoomInfo(gri);
		mainFrame.sendProtocol(cmp);
	}

	public void setEmptyGameRoomList() {
		center_p.remove(gameRoomListScrollPane);
		gameRoomListScrollPane = new JScrollPane(gameRoomList = new JList<>());
		gameRoomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gameRoomListScrollPane.setBorder(new TitledBorder("�� ���"));
		center_p.add(gameRoomListScrollPane);
		center_p.invalidate();
		center_p.updateUI();
		gameRoomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
					if (gameRoomList.getSelectedIndex() != -1) {
						SketchQuiz cmp = new SketchQuiz(SketchQuiz.JOIN_GAME_ROOM);
						cmp.setGameRoomIndex(gameRoomList.getSelectedIndex());
						mainFrame.sendProtocol(cmp);
					} else {
						JOptionPane.showMessageDialog(RoomListPanel.this, "�� ���� �����ϼ���");
					}
				}
			}
		});
	}
}
