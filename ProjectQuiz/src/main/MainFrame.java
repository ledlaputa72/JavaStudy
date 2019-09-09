package main;

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

import panelList.GameRoomPanel;
import panelList.LoginPanel;
import panelList.RoomListPanel;
import protocol.SketchQuiz;
import protocol.UserInfo;

public class MainFrame extends JFrame implements Runnable {

	LoginPanel lp;
	RoomListPanel rlp;
	GameRoomPanel grp;

	CardLayout card;

	Thread thread; // 프레임이 생성 되고 사용자가 닉네임을 입력하고 확인 버튼을 누를때 서버와 통신을 시작하기 위해 스레드 시작

	Socket s;
	ObjectOutputStream out;
	ObjectInputStream in;

	UserInfo userInfo;

	int frameX = 300, frameY = 100;

	String presentCardName = LoginPanel.cardName; // 현재 cardName을 LoginPanel로 초기치 설정

	// 생성자
	public MainFrame() {

		lp = new LoginPanel(this);
		rlp = new RoomListPanel(this);
		grp = new GameRoomPanel(this);

		this.setLayout(card = new CardLayout());

		this.getContentPane().add(lp.toString(), lp);
		this.getContentPane().add(rlp.toString(), rlp);
		this.getContentPane().add(grp.toString(), grp);

		this.addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {

				try {

					if (presentCardName.equals(GameRoomPanel.cardName)) {

						if (grp.isQuestioner())
							grp.giveUpDraw();

						SketchQuiz sq = new SketchQuiz(SketchQuiz.DISCONNECT_SOCKET_ON_GAME);

						out.writeObject(sq);
						out.flush();

					}

					else if (presentCardName.equals(RoomListPanel.cardName)) {

						if (out != null) {

							SketchQuiz sq = new SketchQuiz(SketchQuiz.DISCONNECT_SOCKET);

							out.writeObject(sq);
							out.flush();

						}

						else
							System.exit(0);

					}

				} catch (Exception e2) {

					e2.printStackTrace();

				}

			}

		});

		this.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentMoved(ComponentEvent e) {

				frameX = getLocation().x;
				frameY = getLocation().y;

			}

		});

		setResizable(false);
		setBounds(300, 100, lp.getWidth(), lp.getHeight());
		setVisible(true);

	}

	public static void main(String[] args) {

		new MainFrame();

	}

	// 카드 바꾸기를 위한 메소드
	public void changeCard(String cardName) {

		card.show(getContentPane(), cardName);
		presentCardName = cardName;

		if (cardName.equals(lp.toString()))
			setBounds(frameX, frameY, lp.getWidth(), lp.getHeight());

		else if (cardName.equals(rlp.toString()))
			setBounds(frameX, frameY, rlp.getWidth(), rlp.getHeight());

		else if (cardName.equals(grp.toString())) {

			setBounds(frameX, frameY, grp.getWidth(), grp.getHeight());
			grp.setFocusTf();

		}

	}

	@Override
	public void run() {

		try {

			bk: while (true) {

				SketchQuiz sq = (SketchQuiz) in.readObject();

				switch (sq.getCmd()) {

				case SketchQuiz.USER_ACCEPT:

					changeCard(RoomListPanel.cardName);

					userInfo = sq.getUserInfo();

					setTitle("접속자 닉네임: " + userInfo.getNickName());

					grp.clearTextArea();

					break;

				case SketchQuiz.UPDATE_WAIT_USER_LIST:

					rlp.updateWaitingUserList(sq.getWaitingRoomUserList());

					break;

				case SketchQuiz.USER_DUPLICATED:

					JOptionPane.showMessageDialog(getContentPane(), "중복 되는 닉네임을 사용하는 유저가 있습니다.");

					break bk;

				case SketchQuiz.DISCONNECT_SOCKET:

					System.exit(0);

					break bk;

				case SketchQuiz.EXIT_WAIT_ROOM:

					changeCard(LoginPanel.cardName);

					rlp.updateGameRoomList(sq.getGameRoomList());

					break bk;

				case SketchQuiz.UPDATE_GAME_ROOM_LIST:

					rlp.updateGameRoomList(sq.getGameRoomList());

					break;

				case SketchQuiz.CREATE_GAME_ROOM:

					rlp.cancelCreateRoomPanel();

					changeCard(GameRoomPanel.cardName);

					grp.setGameRoomInfo(sq.getGameRoomInfo());
					grp.setUserInfoArr(sq.getUserInfoArr());
					grp.updateGameRoom();

					break;

				case SketchQuiz.JOIN_GAME_ROOM:

					changeCard(GameRoomPanel.cardName);

					grp.setGameRoomInfo(sq.getGameRoomInfo());
					grp.setUserInfoArr(sq.getUserInfoArr());
					grp.updateInGameJoinUI();
					grp.updateGameRoom();

					break;

				case SketchQuiz.DRAW_LINE:

					grp.setLineSegment(sq);

					break;

				case SketchQuiz.DRAW_LINE_NEW_SEGMENT:

					grp.addNewLineSegment();

					break;

				case SketchQuiz.GAME_START:

					grp.startGame(sq);

					if (!grp.isStarter_out())
						grp.startStopWatch();

					break;

				case SketchQuiz.GAME_STOP:

					grp.stopGame(sq);

					break;

				case SketchQuiz.EXIT_GAME_ROOM:

					changeCard(RoomListPanel.cardName);

					grp.setStarter_out(false);
					grp.updateGameRoom();

					break;

				case SketchQuiz.GAME_CHAT:

					grp.appendChatArea(sq.getMsg());

					break;

				case SketchQuiz.CORRECT_ANSWER:

					grp.clearCanvas();
					grp.questionSolved(sq);
					grp.inturruptThread();

					break;

				case SketchQuiz.DRAW_LINE_THICK:

					grp.setLineThick(sq.getLineThick());

					break;

				case SketchQuiz.DRAW_LINE_COLOR:

					grp.setColor(sq.getColor());

					break;

				case SketchQuiz.CANVAS_CLEAR:

					grp.clearCanvas();

					break;

				case SketchQuiz.SET_GAME_ROOM_INDEX:

					grp.setMyIndex(sq.getIdx());

					break;

				case SketchQuiz.UPDATE_GAME_ROOM_UI:

					grp.setUserInfoArr(sq.getUserInfoArr());

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

	// LoginPanel 에서 닉네임 입력 후 확인 버튼 눌렀을 때 호출
	public void startThread(UserInfo userInfo) {
		
		try {
			
			s = new Socket("127.0.0.1", 5000);
			in = new ObjectInputStream(s.getInputStream());
			out = new ObjectOutputStream(s.getOutputStream());

			SketchQuiz sq = new SketchQuiz(SketchQuiz.USER_ACCEPT);
			
			sq.setUserInfo(userInfo);
			
			out.writeObject(sq);
			out.flush();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
		thread = new Thread(this);
		
		thread.start();
		
	}

	public void sendProtocol(SketchQuiz sq) {
		
		try {
			
			out.writeObject(sq);
			out.flush();
			
		} catch (Exception e) {
			
			e.printStackTrace();
			
		}
		
	}

	public int getFrameX() {
		return frameX;
	}

	public void setFrameX(int frameX) {
		this.frameX = frameX;
	}

	public int getFrameY() {
		return frameY;
	}

	public void setFrameY(int frameY) {
		this.frameY = frameY;
	}

}
