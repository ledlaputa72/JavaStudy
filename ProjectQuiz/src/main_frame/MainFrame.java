package main_frame;

import java.awt.CardLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import protocol.CatchMindProtocol;
import protocol.UserInfo;
import display_panel.GameRoomPanel;
import display_panel.NickNamePanel;
import display_panel.WaitingRoomPanel;

public class MainFrame extends JFrame implements Runnable {
	NickNamePanel nnp;
	WaitingRoomPanel wrp;
	GameRoomPanel grp;
	CardLayout card;
	Thread thread; // 프레임이 생성 되고 사용자가 대화명을 입력하고 확인 버튼을 누를때 서버와 통신을 시작하기 위해 스레드 시작
	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;
	UserInfo userInfo;
	int frame_x = 300, frame_y = 100;
	String presentCardName = NickNamePanel.cardName;

	public MainFrame() {
		nnp = new NickNamePanel(this);
		wrp = new WaitingRoomPanel(this);
		grp = new GameRoomPanel(this);

		this.setLayout(card = new CardLayout());

		this.getContentPane().add(nnp.toString(), nnp);
		this.getContentPane().add(wrp.toString(), wrp);
		this.getContentPane().add(grp.toString(), grp);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				try {
					if (presentCardName.equals(GameRoomPanel.cardName)) {
						if (grp.isQuestioner()) {
							grp.giveUpDraw();
						}
						CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.DISCONNECT_SOCKET_ON_GAME);
						out.writeObject(cmp);
						out.flush();
					} else if (presentCardName.equals(WaitingRoomPanel.cardName)) {
						if (out != null) {
							CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.DISCONNECT_SOCKET);
							out.writeObject(cmp);
							out.flush();
						} else {
							System.exit(0);
						}
					}
				} catch (Exception e2) {
					e2.printStackTrace();
				}
			}
		});
		this.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentMoved(ComponentEvent e) {
				frame_x = getLocation().x;
				frame_y = getLocation().y;
			}
		});
		setResizable(false);
		setBounds(300, 100, nnp.getWidth(), nnp.getHeight());
		setVisible(true);
	}

	public static void main(String[] args) {
		new MainFrame();
	}

	// 카드 바꾸기를 위한 메소드.
	public void changeCard(String cardName) {
		card.show(getContentPane(), cardName);
		presentCardName = cardName;
		if (cardName.equals(nnp.toString())) {
			setBounds(frame_x, frame_y, nnp.getWidth(), nnp.getHeight());
		} else if (cardName.equals(wrp.toString())) {
			setBounds(frame_x, frame_y, wrp.getWidth(), wrp.getHeight());
		} else if (cardName.equals(grp.toString())) {
			setBounds(frame_x, frame_y, grp.getWidth(), grp.getHeight());
			grp.setFocusTf();
		}
	}

	@Override
	public void run() {
		try {
			bk: while (true) {
				CatchMindProtocol cmp = (CatchMindProtocol) in.readObject();
				switch (cmp.getCmd()) {
				case CatchMindProtocol.USER_ACCEPT:
					changeCard(WaitingRoomPanel.cardName);
					userInfo = cmp.getUserInfo();
					setTitle("접속자 대화명: " + userInfo.getNickName());
//					wrp.clearTextArea();
					break;
				case CatchMindProtocol.UPDATE_WAIT_USER_LIST:
					wrp.updateWaitingUserList(cmp.getWaitingRoomUserList());
					break;
				case CatchMindProtocol.WAIT_ROOM_SEND_MSG:
//					wrp.appendChatArea(cmp.getMsg());
					break;
				case CatchMindProtocol.USER_DUPLICATED:
					JOptionPane.showMessageDialog(getContentPane(), "중복 되는 대화명을 사용하는 유저가 있습니다.");
					break bk;
				case CatchMindProtocol.DISCONNECT_SOCKET:
					System.exit(0);
					break bk;
				case CatchMindProtocol.EXIT_WAIT_ROOM:
					changeCard(NickNamePanel.cardName);
					wrp.updateGameRoomList(cmp.getGameRoomList());
					break bk;
				case CatchMindProtocol.UPDATE_GAME_ROOM_LIST:
					wrp.updateGameRoomList(cmp.getGameRoomList());
					break;
				case CatchMindProtocol.CREATE_GAME_ROOM:
					wrp.cancelCreateRoomPanel();
					changeCard(GameRoomPanel.cardName);
					grp.setGameRoomInfo(cmp.getGameRoomInfo());
					grp.setUserInfoArr(cmp.getUserInfoArr());
					grp.updateGameRoom();
					grp.stopWatchSet();
					break;
				case CatchMindProtocol.JOIN_GAME_ROOM:
					changeCard(GameRoomPanel.cardName);
					grp.setGameRoomInfo(cmp.getGameRoomInfo());
					grp.setUserInfoArr(cmp.getUserInfoArr());
					grp.updateInGameJoinUI();
					grp.updateGameRoom();
					grp.stopWatchSet();
					break;
				case CatchMindProtocol.DRAW_LINE:
					grp.setLineSegment(cmp);
					break;
				case CatchMindProtocol.DRAW_LINE_NEW_SEGMENT:
					grp.addNewLineSegment();
					break;
				case CatchMindProtocol.GAME_START:
					grp.startGame(cmp);
					if (!grp.isStarter_out()) {
						grp.startStopWatch();
						// grp.setStarter_out(false);
					}
					break;
				case CatchMindProtocol.GAME_STOP:
					grp.stopGame(cmp);
					break;
				case CatchMindProtocol.EXIT_GAME_ROOM:
					changeCard(WaitingRoomPanel.cardName);
					grp.setStarter_out(false);
					grp.updateGameRoom();
					break;
				case CatchMindProtocol.GAME_CHAT:
					String msg = cmp.getMsg();
					int gameSlotIndex = cmp.getChatSlotIndex();
					grp.updateChatMsg(msg, gameSlotIndex);
					break;
				case CatchMindProtocol.CORRECT_ANSWER:
					grp.clearCanvas();
					grp.questionSolved(cmp);
					grp.inturruptThread();
					break;
				case CatchMindProtocol.DRAW_LINE_THICK:
					grp.setLineThick(cmp.getLineThick());
					break;
				case CatchMindProtocol.DRAW_LINE_COLOR:
					grp.setColor(cmp.getColor());
					break;
				case CatchMindProtocol.CANVAS_CLEAR:
					grp.clearCanvas();
					break;
				case CatchMindProtocol.SET_GAME_ROOM_INDEX:
					grp.setMyIndex(cmp.getIdx());
					break;
				case CatchMindProtocol.UPDATE_GAME_ROOM_UI:
					grp.setUserInfoArr(cmp.getUserInfoArr());
					grp.updateGameRoom();
					break;
				}
			}
			closed();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void closed() {
		try {
			if (in != null) {
				in.close();
				in = null;
			}
			if (out != null) {
				out.close();
				out = null;
			}
			if (s != null) {
				s.close();
				s = null;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void startThread(UserInfo userInfo) { // NickNamePanel 에서 대화명 입력 후 확인 버튼 눌렀을 때 부름
		try {
			s = new Socket("127.0.0.1", 9997);
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());

			CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.USER_ACCEPT);
			cmp.setUserInfo(userInfo);
			out.writeObject(cmp);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
		thread = new Thread(this);
		thread.start();
	}

	public void sendProtocol(CatchMindProtocol cmp) {
		try {
			out.writeObject(cmp);
			out.flush();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public int getFrame_x() {
		return frame_x;
	}

	public void setFrame_x(int frame_x) {
		this.frame_x = frame_x;
	}

	public int getFrame_y() {
		return frame_y;
	}

	public void setFrame_y(int frame_y) {
		this.frame_y = frame_y;
	}

}
