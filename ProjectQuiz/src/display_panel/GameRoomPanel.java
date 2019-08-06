package display_panel;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.plaf.basic.BasicPopupMenuUI;

import main_frame.MainFrame;
import protocol.CatchMindProtocol;
import protocol.GameRoomInfo;
import protocol.UserInfo;
import canvas.CanvasLine;
import canvas.CanvasLineSegment;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * 
 * @author USER
 */
public class GameRoomPanel extends javax.swing.JPanel implements Runnable {
	public static final String cardName = "GameRoomPanel";
	MainFrame mainFrame;
	int width = 1040, height = 806;
	Thread thread;
	boolean starter_out;

	int[] bubbleXarr = { 130, };
	int[] bubbleYarr = { 130, };
	JComponent contentPane; // ��ǳ�� ������� ���� �����ϱ� ����
	Object hidePopupKey; // ��ǳ�� ������� ���� �����ϱ� ����
	Color bg = new Color(27, 117, 200);

	JPanel north_p; // ���� �гο��� ĳġ���ε� �ΰ�� ������ ��ư�� ��
	JLabel catchMindLogo; // ĳġ���ε� �ΰ�
	JPanel north_p_centerP; // �ΰ� ������ ���� ��Ʈ���� ���� ��ư���� �� �г�
	JButton exitGameRoomBtn; // ���� ������ ��ư
	JButton reStartGameBtn; // ���� ����� ��ư
	JPanel stopwatch; // ���Ӵ� ���� �ð��� ǥ���� �г�
	JLabel mm, ss, colon1;
	JPanel bottom_p;

	JPanel center_p; // �����гο��� ������ �����ϱ� ���� ������Ʈ�� ��ġ..
	JPanel quiz_p; // ������ ��Ÿ�� �г�, �׸��� �׸� ������Ը� ������. : north
	JLabel quizLabel; // "����" ��� ���ڿ��� ��Ÿ�� ���̺�
	JTextField quizContentTf; // �����ڿ��� ������ ���� ������ ������ �ؽ�Ʈ �ʵ�. ��Ȱ��ȭ �Ұ�.
	JPanel bottom_slot_p; // ����ȭ���� ���ʰ� ������ ������ ǥ���� �г� : west , east
	GameRoomSlotPanel[] slotArr; // ���Թ�ġ �гο� ���� �����г��� ��� �迭
	JPanel game_p; // center_p �� center�� ������ �гη� ĵ������ �׸� �� �ʿ��� UI , �����ڸ� ������
					// ����ڿ��Դ� ä���ʵ尡 ������ ����: center
	JPanel can_p;
	JPanel can_p_south, can_p_north, can_p_west, can_p_east; // canvas �׵θ��� ��
																// �гε�
	Canvas can; // ���ӿ� ���� ĵ���� �������� : game_p�� center
	JPanel game_p_southP; // game_p �� ���͸� �����ϰ� �� �г��� ������ ������ �г� : game_p�� south
	JPanel gameUI_p; // �׸��� �ʿ��� �������� �� �г� :game_p_southP �� gridLayout ù��° �г�
	JButton[] colorBtnArr = new JButton[6]; // 6���� Į�� ��ư�� ������ �迭
	Color[] colorArr = { Color.black, Color.red, Color.blue, Color.green, Color.yellow, Color.white }; // Į�� ��ư�� ����
	JComboBox<Integer> lineThickComBox;
	JButton clearAllBtn, giveUpBtn; // ��ü������ ���� ��ư
	JPanel time_chat_p;
	JPanel chat_p; // ������ ���߰ų� ä�� ������ �����ϱ� ���� UI�� ��� �г� :game_p_southP ��
					// gridLayout �ι�° �г�
	JTextArea chat_ta;
	JTextField chat_tf;
	JButton chat_btn;
	JPanel exitp;
	UserInfo[] userInfoArr;
	GameRoomInfo gameRoomInfo;

	int examinerIndex; // ������ �ε���
	int solverIndex; // ������ �ε���
	int myIndex; // ���� �濡�� ����� ���ִ��� �˷��ִ� �ε���
	UserInfo myUserInfo; // �� ���� ����
	String question = ""; // ����
	ArrayList<CanvasLineSegment> clsArr;
	int sx = -1, sy = -1;

	Integer[] lineThickArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	int lineThick = 5;
	Color color = Color.black;

	int count;

	public GameRoomPanel(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		contentPane = (JComponent) mainFrame.getContentPane();
		hidePopupKey = new JComboBox().getClientProperty("doNotCancelPopup");
		contentPane.putClientProperty("doNotCancelPopup", hidePopupKey);

		clsArr = new ArrayList<>();
		initComponents();
		setComponentEvent();
	}

	private void initComponents() {
		this.setLayout(new BorderLayout());
		// ���� �г� �۾�
//		final ImageIcon topbg = new ImageIcon("src/images/header_gr.png");
//		final ImageIcon topbg2 = new ImageIcon("src/images/header_gr2.png");
//		final ImageIcon topbg3 = new ImageIcon("src/images/midline.jpg");

		north_p = new JPanel(new BorderLayout());
		// north_p.add(catchMindLogo = new JLabel(new
		// ImageIcon("src/images/catch_logo.jpg")) , BorderLayout.WEST);
		stopwatch = new JPanel(new FlowLayout(FlowLayout.CENTER)) {
//			public void paintComponent(Graphics g) {
//				g.drawImage(topbg.getImage(), 0, 0, null);
//			}
		};
		stopwatch.add(mm = new JLabel("00"));
		stopwatch.add(colon1 = new JLabel(" : "));
		stopwatch.add(ss = new JLabel("00"));
		north_p.add(stopwatch);
		north_p_centerP = new JPanel(new FlowLayout(FlowLayout.RIGHT)) {
//			public void paintComponent(Graphics g) {
//				g.drawImage(topbg2.getImage(), 0, 0, null);
//			}
		};
		north_p_centerP.add(exitGameRoomBtn = new JButton("������"));
		// north_p_centerP.add(reStartGameBtn = new JButton("����"));
		north_p.add(north_p_centerP, BorderLayout.EAST);

		// ���� �г� �۾�
		center_p = new JPanel(new BorderLayout());
		// :north ����
		quiz_p = new JPanel(new FlowLayout(FlowLayout.LEFT)) {
//			public void paintComponent(Graphics g) {
//				g.drawImage(topbg3.getImage(), 0, 0, null);
//			}
		};
		quiz_p.add(quizLabel = new JLabel("���� : "));
		quiz_p.add(quizContentTf = new JTextField(15));
		quizContentTf.setEditable(false);
		center_p.add(quiz_p, BorderLayout.NORTH);
		// :west, eastv����
		
		bottom_p = new JPanel();
		bottom_slot_p = new JPanel(new GridLayout(1, 4));
		bottom_slot_p.setBackground(bg);

		bottom_p.add(bottom_slot_p);
		// :center ����
		game_p = new JPanel(new BorderLayout());
		game_p.setBackground(bg);
		can_p = new JPanel(new BorderLayout());
		can_p.add(can_p_south = new JPanel(new BorderLayout()), BorderLayout.SOUTH);
		can_p.add(can_p_west = new JPanel(new BorderLayout()), BorderLayout.WEST);
		can_p.add(can_p_east = new JPanel(new BorderLayout()), BorderLayout.EAST);
		can_p.add(can_p_north = new JPanel(new BorderLayout()), BorderLayout.NORTH);
//		can_p_south.add(new JLabel(
//				new ImageIcon("src/images/canvas_bottom.jpg")));
//		can_p_north.add(new JLabel(new ImageIcon("src/images/canvas_top.jpg")));
//		can_p_west.add(new JLabel(new ImageIcon("src/images/canvas_left.jpg")));
//		can_p_east
//				.add(new JLabel(new ImageIcon("src/images/canvas_right.jpg")));
		game_p.add(can_p);
		center_p.add(game_p);
		can_p.add(can = new Canvas() { // :game_p �� center
			@Override
			public void paint(Graphics g) {
				for (CanvasLineSegment cls : clsArr) {
					cls.drawLineSegment(g);
				}
			}
		});
		can.setBackground(Color.white);
		can.setEnabled(true);
		game_p_southP = new JPanel(new GridLayout(2, 1)); // :game_p �� south
		game_p_southP.setBackground(bg);
		game_p.add(game_p_southP, BorderLayout.SOUTH);
		gameUI_p = new JPanel(new FlowLayout()); // : game_p_southP�� ù��° �г�
		for (int i = 0; i < colorBtnArr.length; i++) {
			colorBtnArr[i] = new JButton();
			colorBtnArr[i].setBackground(colorArr[i]);
			colorBtnArr[i].setPreferredSize(new Dimension(30, 30));
			gameUI_p.add(colorBtnArr[i]);
		}
		lineThickComBox = new JComboBox<>(lineThickArr);
		lineThickComBox.setSelectedIndex(4);
		lineThickComBox.setLightWeightPopupEnabled(false);
		gameUI_p.add(lineThickComBox);
		gameUI_p.add(clearAllBtn = new JButton("��ü�����"));
		gameUI_p.add(giveUpBtn = new JButton("����"));
		gameUI_p.setBackground(bg);
		game_p_southP.add(gameUI_p);

		time_chat_p = new JPanel(new GridLayout(1, 2));
		JPanel time_p = new JPanel();
		// time_p.add(arg0)
		chat_p = new JPanel(new FlowLayout(FlowLayout.RIGHT)); // :
																// game_p_southP��
																// �ι�° �г�
		chat_p.add(chat_ta = new JTextArea());
		chat_p.add(chat_tf = new JTextField(20));
		chat_p.add(chat_btn = new JButton("������"));
		chat_p.setBackground(bg);
		game_p_southP.add(chat_p);

		this.add(north_p, BorderLayout.NORTH);
		this.add(center_p);
		this.add(bottom_p, BorderLayout.SOUTH);
	}

	private void setComponentEvent() {
		chat_btn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendGameMsg();
			}
		});
		chat_tf.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				sendGameMsg();
			}
		});

		exitGameRoomBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				if (myIndex == examinerIndex && getValidUserNum() > 3) { // �������� ��� ������ ���� �ϰ� ������
					starter_out = true;
					setStarter_out(starter_out);
					giveUpDraw();
				}
				CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.EXIT_GAME_ROOM);
				// starter_out = false;
				inturruptThread();
				mainFrame.sendProtocol(cmp);
			}
		});
		// reStartGameBtn.addActionListener(new ActionListener() {
		// @Override
		// public void actionPerformed(ActionEvent arg0) {
		// CatchMindProtocol cmp = new
		// CatchMindProtocol(CatchMindProtocol.GAME_STOP);
		// mainFrame.sendProtocol(cmp);
		// }
		// });
		can.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				if (SwingUtilities.isLeftMouseButton(e)) {
					CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.DRAW_LINE);
					cmp.setCanvasLine(new CanvasLine(sx, sy, sx = e.getX(), sy = e.getY(), color, lineThick));
					mainFrame.sendProtocol(cmp);
				}
			}
		});
		can.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.DRAW_LINE_NEW_SEGMENT);
					mainFrame.sendProtocol(cmp);
					// clsArr.add(new CanvasLineSegment());
					sx = e.getX();
					sy = e.getY();
				}
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					sx = -1;
					sy = -1;
				}
			}
		});

		for (int i = 0; i < colorBtnArr.length; i++) {
			colorBtnArr[i].addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.DRAW_LINE_COLOR);
					cmp.setColor(((JButton) (e.getSource())).getBackground());
					mainFrame.sendProtocol(cmp);
				}
			});
		}
		lineThickComBox.addItemListener(new ItemListener() {
			@Override
			public void itemStateChanged(ItemEvent e) {
				if (e.getStateChange() == ItemEvent.SELECTED) {
					CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.DRAW_LINE_THICK);
					cmp.setLineThick((Integer) e.getItem());
					mainFrame.sendProtocol(cmp);
				}
			}
		});
		clearAllBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.CANVAS_CLEAR);
				mainFrame.sendProtocol(cmp);
			}
		});
		PropertyChangeListener l = new PropertyChangeListener() {

			public void propertyChange(PropertyChangeEvent arg0) {
				if (count == 0) {

					if (myIndex == getMinSlotIndex()) {
						clearCanvas();

						CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.GAME_STOP);
						cmp.setTimeout(true);
						mainFrame.sendProtocol(cmp);
					}
				}
			}
		};
		ss.addPropertyChangeListener("text", l);
		giveUpBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				giveUpDraw();
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

	public UserInfo[] getUserInfoArr() {
		return userInfoArr;
	}

	public void setUserInfoArr(UserInfo[] userInfoArr) {
		this.userInfoArr = userInfoArr;
	}

	public GameRoomInfo getGameRoomInfo() {
		return gameRoomInfo;
	}

	public void setGameRoomInfo(GameRoomInfo gameRoomInfo) {
		this.gameRoomInfo = gameRoomInfo;
		slotArr = new GameRoomSlotPanel[gameRoomInfo.getGameUserNum()];
	}

	public void updateGameRoom() {
		StringBuffer sb = new StringBuffer();
		if (getValidUserNum() >= 3) {
			sb.append("������ ��ȭ��: ");
			sb.append(userInfoArr[myIndex].getNickName());
			sb.append(" =====������ �Դϴ�. ������=====>");
			sb.append(userInfoArr[examinerIndex].getNickName());
			mainFrame.setTitle(sb.toString());
		} else if (getValidUserNum() < 3) {
			sb.append("������ ��ȭ��: ");
			sb.append(userInfoArr[myIndex].getNickName());
			sb.append(":: =====3�� �̻� �־�� ������ ����˴ϴ�.=====");
			mainFrame.setTitle(sb.toString());
			quizContentTf.setText("....");
		}
		bottom_slot_p.removeAll();
		for (int i = 0; i < slotArr.length; i++) {
			if (userInfoArr[i] == null) {
				slotArr[i] = new GameRoomSlotPanel("", "src/images/empty_slot.png", i);
				bottom_slot_p.add(slotArr[i]);

			} else {
				slotArr[i] = new GameRoomSlotPanel(userInfoArr[i].getNickName(), userInfoArr[i].getImageURL(), i);

				bottom_slot_p.add(slotArr[i]);

			}
		}
		this.updateUI();
	}

	public void updateInGameJoinUI() {
		if (gameRoomInfo.isPlayingGame()) {
			quizContentTf.setText("......");
			can.setEnabled(false);
			chat_p.setVisible(false);
			gameUI_p.setVisible(false);
		}
	}

	public void setLineSegment(CatchMindProtocol cmp) {
		if (clsArr.size() == 0) {
			clsArr.add(new CanvasLineSegment());
		}
		clsArr.get(clsArr.size() - 1).getCanArr().add(cmp.getCanvasLine());
		Graphics g = can.getGraphics();
		can.repaint();
	}

	public void startGame(CatchMindProtocol cmp) {
		userInfoArr = cmp.getUserInfoArr();
		myUserInfo = userInfoArr[getMyIndex()];
		question = cmp.getMsg();
		examinerIndex = cmp.getGameStaterIndex();
		StringBuffer sb = new StringBuffer();
		if (getValidUserNum() >= 3) {
			sb.append("������ ��ȭ��: ");
			sb.append(userInfoArr[myIndex].getNickName());
			sb.append(" =====������ �Դϴ�. ������=====>");
			sb.append(userInfoArr[examinerIndex].getNickName());
			mainFrame.setTitle(sb.toString());
		}
		if (myIndex == examinerIndex) {
			// quiz_p.setVisible(true);
			quizContentTf.setText(question);
			can.setEnabled(true);
			chat_p.setVisible(false);
			gameUI_p.setVisible(true);
		} else {
			// quiz_p.setVisible(false);
			quizContentTf.setText("......");
			can.setEnabled(false);
			chat_p.setVisible(true);
			gameUI_p.setVisible(false);
		}
		clearCanvas();
//		ShowMessageThread t = new ShowMessageThread(GameRoomPanel.this,
//				userInfoArr[examinerIndex].getNickName() + " �� ���� �׸� ���� �Դϴ�.");
//		t.start();

		if (getValidUserNum() > 2 && !starter_out) {
			String msg = userInfoArr[examinerIndex].getNickName() + " �� ���� �׸� ���� �Դϴ�.";
			jDialog(msg);
		}
	}

	public void stopGame(CatchMindProtocol cmp) {
		inturruptThread();
		if (cmp.isTimeout()) {
			String msg = "�ð��� �ʰ��Ǿ����ϴ�.";
			jDialog(msg);
			cmp.setTimeout(false);
		}
		stopWatchSet();
		can.setEnabled(true);
		chat_p.setVisible(true);
		gameUI_p.setVisible(true);
		StringBuffer sb = new StringBuffer();
		System.out.println("----Ȯ����-----");
		System.out.println(getValidUserNum());
		if (getValidUserNum() < 3) {
			sb.append("������ ��ȭ��: ");
			sb.append(userInfoArr[myIndex].getNickName());
			sb.append(":: =====3�� �̻� �־�� ������ ����˴ϴ�.=====");
			mainFrame.setTitle(sb.toString());
			ShowMessageThread t = new ShowMessageThread(GameRoomPanel.this, "3�� �̻��̾�� ������ ���� �˴ϴ�.");
			t.start();
		}
	}

	public void jDialog(String msg) {

		System.out.println(msg);
		JDialog jd = new JDialog();
		JLabel lb;
		jd.setLayout(new FlowLayout(FlowLayout.CENTER));
		jd.add(lb = new JLabel(msg));
		lb.setFont(new Font("", Font.BOLD, 20));
		jd.setBounds(GameRoomPanel.this.mainFrame.getFrame_x() + 350, GameRoomPanel.this.mainFrame.getFrame_y() + 350,
				350, 80);
		jd.setVisible(true);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		jd.setVisible(false);
	}

	public void addNewLineSegment() {
		clsArr.add(new CanvasLineSegment());
	}

	public int getLineThick() {
		return lineThick;
	}

	public void setLineThick(int lineThick) {
		this.lineThick = lineThick;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}

	public int getMyIndex() {
		return myIndex;
	}

	public void setMyIndex(int myIndex) {
		this.myIndex = myIndex;
	}

	public void sendGameMsg() {
		String msg_game = chat_tf.getText().trim();
		if (msg_game.length() > 0) {
			CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.GAME_CHAT);
			cmp.setMsg(msg_game);
			chat_tf.setText("");
			mainFrame.sendProtocol(cmp);
		}
	}

	public GameRoomSlotPanel[] getSlotArr() {
		return slotArr;
	}

	public void setSlotArr(GameRoomSlotPanel[] slotArr) {
		this.slotArr = slotArr;
	}

	public boolean isStarter_out() {
		return starter_out;
	}

	public void setStarter_out(boolean starter_out) {
		this.starter_out = starter_out;
	}

	public void updateChatMsg(String msg, int index) {
		slotArr[index].tf.setText("");
		slotArr[index].tf.setText(msg);
		// BubblePopThread t = new BubblePopThread(100,100,msg, slotArr[index]);
		// t.start();
		// setFocusTf();
	}

	public void clearCanvas() {
		clsArr = new ArrayList<>();
		can.repaint();
	}

	public void questionSolved(CatchMindProtocol cmp) {
		userInfoArr = cmp.getUserInfoArr();
		int hitCount = slotArr[cmp.getCorrectAnswerIndex()].getHitCount();
		hitCount += 1;
		slotArr[cmp.getCorrectAnswerIndex()].setHitCount(hitCount);

//		ShowMessageThread t = new ShowMessageThread(GameRoomPanel.this,
//				userInfoArr[cmp.getCorrectAnswerIndex()].getNickName()
//						+ " �� ���� ������ ������ϴ�.");
//		t.start();

		String msg = userInfoArr[cmp.getCorrectAnswerIndex()].getNickName() + " �� ���� ������ ������ϴ�.";
		jDialog(msg);
	}

	public void setFocusTf() {
		chat_tf.requestFocus();
	}

	public void stopWatchSet() {
		mm.setFont(new Font("Serif", Font.BOLD, 50));
		mm.setForeground(Color.WHITE);
		ss.setFont(new Font("Serif", Font.BOLD, 50));
		ss.setForeground(Color.WHITE);
		colon1.setFont(new Font("Serif", Font.BOLD, 50));
		colon1.setForeground(Color.WHITE);
		mm.setText("00");
		ss.setText("00");
	}

	public void startStopWatch() {
		thread = new Thread(this);
		thread.start();
	}

	public void inturruptThread() {
		if (thread != null) {
			thread.interrupt();
		}
	}

	@Override
	public void run() {
		count = 90;
		int i_min = 0;
		String s_min = "";
		String s_sec = "";
		while (count != -1) {

			i_min = count / 60;
			s_min = String.format("%02d", i_min);
			s_sec = String.format("%02d", count % 60);
			ss.setText(s_sec);
			mm.setText(s_min);
			count--;

			if (count == -1) {
				break;
			}
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				return;
			}
		}
	} // run

	public Graphics getCanvasGraphics() {
		return can.getGraphics();
	}

	public int getMinSlotIndex() {
		for (int i = 0; i < userInfoArr.length; i++) {
			if (userInfoArr[i] != null) {
				return i;
			}
		}
		return -1;
	}

	public int getValidUserNum() {
		int count = 0;
		for (int i = 0; i < userInfoArr.length; i++) {
			if (userInfoArr[i] != null) {
				count++;
			}
		}
		return count;
	}

	public boolean isQuestioner() {
		return myIndex == examinerIndex;
	}

	public void giveUpDraw() {
		if (getValidUserNum() >= 3) {
			clearCanvas();
			CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.GAME_STOP);
			cmp.setTimeout(false);
			// cmp.setStarter_out(starter_out);
			mainFrame.sendProtocol(cmp);
		}
	}
}

class BubblePopThread extends Thread {
	SpeechBubbleJPopupMenu bubble;
	Component comp;
	int x, y;

	public BubblePopThread(int x, int y, String msg, Component comp) {
		bubble = new SpeechBubbleJPopupMenu(msg);
		bubble.setLightWeightPopupEnabled(false);
		bubble.setFocusable(false);

		BasicPopupMenuUI ui = (BasicPopupMenuUI) bubble.getUI();

		this.x = x;
		this.y = y;
		this.comp = comp;

	}

	public SpeechBubbleJPopupMenu getBubble() {
		return bubble;
	}

	public void setBubble(SpeechBubbleJPopupMenu bubble) {
		this.bubble = bubble;
	}

	@Override
	public void run() {
		bubble.show(comp, x, y);
		for (int i = 0; i < 5; i++) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		bubble.setVisible(false);
		comp.invalidate();
	}
}