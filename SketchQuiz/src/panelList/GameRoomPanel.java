package panelList;

import java.awt.BorderLayout;
import java.awt.Canvas;
import java.awt.Color;
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

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;

import canvas.CanvasElement;
import canvas.CanvasSegment;
import info.GameRoomInfo;
import info.SketchQuiz;
import info.UserInfo;
import main.MainFrame;

public class GameRoomPanel extends JPanel implements Runnable {
	
	public static final String cardName = "GameRoomPanel";
	
	MainFrame mainFrame;
	
	int width = 1200, height = 900;
	
	Thread thread;
	
	boolean starter_out;
	
	JPanel panelTimer, panelGame, panelChat, panelUser; // 화면을 크게 4개로 분리
	JTextArea taChat; // 여러 사람들의 채팅이 보여질 textArea
	JTextField tfChat; // 채팅하기 위해 사용자가 글을 입력할 텍스트필드
	JButton btnChat; // 입력한 내용을 전송할 버튼
	JScrollPane chatScrollPane; // 채팅창을 담을 스크롤
	JPanel panelInput; // tfChat 과 btnChat 이 들어갈 패널
	JPanel panelQuestion; // lbQuiz와 lbQuizContent 가 들어갈 패널
	JLabel lbQuiz, lbQuizContent; // 출제자에게 보여줄 문제 내용이 담겨 있는 텍스트 필드. 비활성화할 것.
	JProgressBar jpb; // 시간을 나타낼 진행 바
	UserSlotPanel[] slotArr; // 슬롯배치 패널에 넣을 슬롯 패널을 담는 배열
	JButton btnExit; // 게임 나가기 버튼
	JButton btnRestart; // 게임 재시작 버튼
	JPanel panelUserSlot; // 각 유저를 나타낼 슬롯 패널
	JPanel panelCanvas; // 그림판을 나타낼 패널
	JPanel panelCanvasTool; // 그릴 때 필요한 도구들이 들어갈 패널
	JButton[] colorBtnArr = new JButton[6]; // 6개의 칼라 버튼을 저장할 배열
	Color[] colorArr = { Color.black, Color.red, Color.blue, Color.green, Color.yellow, Color.white }; // 칼라 버튼의 색상
	JComboBox<Integer> lineThickComBox;
	JButton btnClear, btnGiveup; // 전체 지우기 버튼과 포기 버튼

	UserInfo[] userInfoArr;
	GameRoomInfo gameRoomInfo;
	Canvas can; // 게임에 사용될 캔버스 참조변수
	
	int testerIndex; // 출제자 인덱스
	int solverIndex; // 맞춘사람 인덱스
	int myIndex; // 내가 방에서 몇번에 들어가있는지 알려주는 인덱스
	UserInfo myUserInfo; // 내 유저 인포
	String question = ""; // 문제
	ArrayList<CanvasSegment> clsArr;
	int sx = -1, sy = -1;

	Integer[] lineThickArr = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20 };
	int lineThick = 5;
	Color color = Color.black;

	int i;

	// 생성자
	public GameRoomPanel(MainFrame mainFrame) {
		
		this.mainFrame = mainFrame;

		clsArr = new ArrayList<>();
		
		initComponents(); // 컴포넌트 생성 및 레이아웃 배치
		setComponentEvent(); // 각 컴포넌트에 필요한 이벤트 설정
		
	}

	// 컴포넌트 생성 및 레이아웃 배치
	private void initComponents() {
		
		this.setLayout(null);

		// panelTimer
		panelTimer = new JPanel(new BorderLayout());
		panelTimer.setBounds(0, 0, 1200, 60);
		jpb = new JProgressBar();
		jpb.setMinimum(0); // 진행바의 최솟값 설정
		jpb.setMaximum(3000); // 진행바의 최댓값 설정
		jpb.setValue(0); // 진행바의 현재 값 설정
		jpb.setForeground(Color.YELLOW); // 진행바의 진행을 노란색으로 한다.
		jpb.setBackground(Color.BLUE); // 진행바의 기본은 파란색으로 한다.
		panelTimer.add(jpb);
		btnExit = new JButton("나가기");
		panelTimer.add(btnExit, BorderLayout.EAST);
		this.add(panelTimer);

		// panelGame
		panelGame = new JPanel();
		panelGame.setBounds(0, 60, 800, 740);
		panelQuestion = new JPanel();
		lbQuiz = new JLabel("문제 : ");
		panelQuestion.add(lbQuiz);
		lbQuizContent = new JLabel();
		panelQuestion.add(lbQuizContent);
		panelQuestion.setPreferredSize(new Dimension(800, 20));
		panelGame.add(panelQuestion);
		panelCanvas = new JPanel(new BorderLayout());
		panelCanvas.add(can = new Canvas() { 
			
			@Override
			public void paint(Graphics g) {
				
				for (CanvasSegment cls : clsArr)
					cls.drawLineSegment(g);
			
			}
			
		});
		can.setBackground(Color.white);
		can.setEnabled(true);
		panelCanvas.setPreferredSize(new Dimension(800, 665));
		panelGame.add(panelCanvas);
		panelCanvasTool = new JPanel(new FlowLayout()); 
		for (int i = 0; i < colorBtnArr.length; i++) {
			
			colorBtnArr[i] = new JButton();
			
			colorBtnArr[i].setBackground(colorArr[i]);
			colorBtnArr[i].setPreferredSize(new Dimension(30, 30));
			
			panelCanvasTool.add(colorBtnArr[i]);
			
		}
		
		lineThickComBox = new JComboBox<>(lineThickArr);
		lineThickComBox.setSelectedIndex(4);
		lineThickComBox.setLightWeightPopupEnabled(false);
		panelCanvasTool.add(lineThickComBox);
		btnClear = new JButton("전체지우기");
		btnGiveup = new JButton("포기");
		panelCanvasTool.add(btnClear);
		panelCanvasTool.add(btnGiveup);
		panelCanvasTool.setPreferredSize(new Dimension(800, 35));
		panelGame.add(panelCanvasTool);
		this.add(panelGame);


		// panelChat
		panelChat = new JPanel(new BorderLayout()); // 대화창과 입력란 보내기 버튼을 담을 패널
		chatScrollPane = new JScrollPane(taChat = new JTextArea(0, 25));
		taChat.setEditable(false);
		panelInput = new JPanel(new BorderLayout());
		panelInput.add(tfChat = new JTextField());
		panelInput.add(btnChat = new JButton("보내기"), BorderLayout.EAST);
		panelChat.add(chatScrollPane);
		panelChat.add(panelInput, BorderLayout.SOUTH);
		panelChat.setBounds(800, 60, 400, 740);
		this.add(panelChat);
		
		// panelUser
		panelUser = new JPanel(new BorderLayout());
		panelUserSlot = new JPanel(new GridLayout(1, 3));
		panelUser.add(panelUserSlot);
		panelUser.setBounds(0, 800, 1200, 70);
		this.add(panelUser);
		
	}

	// 각 컴포넌트에 필요한 이벤트 설정
	private void setComponentEvent() {
		
		btnChat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				sendGameMsg();
				
			}
			
		});
		
		tfChat.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				sendGameMsg();
				
			}
			
		});

		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				// 출제자인 경우 게임을 포기 하고 나간다
				if (myIndex == testerIndex && getValidUserNum() > 3) { 
					
					starter_out = true;
					setStarter_out(starter_out);
					giveUpDraw();
					
				}
				
				SketchQuiz sq = new SketchQuiz(SketchQuiz.EXIT_GAME_ROOM);
				
				inturruptThread();
				
				mainFrame.sendProtocol(sq);
				
			}
			
		});

		can.addMouseMotionListener(new MouseMotionAdapter() {
			
			@Override
			public void mouseDragged(MouseEvent e) {
				
				if (SwingUtilities.isLeftMouseButton(e)) {
					
					SketchQuiz sq = new SketchQuiz(SketchQuiz.DRAW_LINE);
					
					sq.setCanvasLine(new CanvasElement(sx, sy, sx = e.getX(), sy = e.getY(), color, lineThick));
					
					mainFrame.sendProtocol(sq);
					
				}
				
			}
			
		});
		
		can.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mousePressed(MouseEvent e) {
				
				if (e.getButton() == MouseEvent.BUTTON1) {
					
					SketchQuiz sq = new SketchQuiz(SketchQuiz.DRAW_LINE_NEW_SEGMENT);
					
					mainFrame.sendProtocol(sq);

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
					
					SketchQuiz sq = new SketchQuiz(SketchQuiz.DRAW_LINE_COLOR);
					
					sq.setColor(((JButton) (e.getSource())).getBackground());
					
					mainFrame.sendProtocol(sq);
					
				}
				
			});
			
		}
		
		lineThickComBox.addItemListener(new ItemListener() {
			
			@Override
			public void itemStateChanged(ItemEvent e) {
				
				if (e.getStateChange() == ItemEvent.SELECTED) {
					
					SketchQuiz sq = new SketchQuiz(SketchQuiz.DRAW_LINE_THICK);
					
					sq.setLineThick((Integer) e.getItem());
					
					mainFrame.sendProtocol(sq);
					
				}
				
			}
			
		});
		
		btnClear.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				SketchQuiz sq = new SketchQuiz(SketchQuiz.CANVAS_CLEAR);
				
				mainFrame.sendProtocol(sq);
				
			}
			
		});
	
		btnGiveup.addActionListener(new ActionListener() {
			
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
		slotArr = new UserSlotPanel[gameRoomInfo.getGameUserNum()];
	}

	public void updateGameRoom() {
		
		StringBuffer sb = new StringBuffer();
		
		if (getValidUserNum() >= 3) {
			
			sb.append("접속자 닉네임 : " + userInfoArr[myIndex].getNickName() + " 게임 중 / 출제자 : " + userInfoArr[testerIndex].getNickName());
			
			mainFrame.setTitle(sb.toString());
			
		} 
		
		else if (getValidUserNum() < 3) {
			
			sb.append("접속자 닉네임 : " + userInfoArr[myIndex].getNickName() + " / 3명이 입장해야 게임이 시작됩니다.");
			
			mainFrame.setTitle(sb.toString());
			
			lbQuizContent.setText("....");
			
		}
		
		panelUserSlot.removeAll();
		
		for (int i = 0; i < slotArr.length; i++) {
			
			if (userInfoArr[i] == null) {
				
				slotArr[i] = new UserSlotPanel("",  i);
				panelUserSlot.add(slotArr[i]);

			} 
			
			else {
				
				slotArr[i] = new UserSlotPanel(userInfoArr[i].getNickName(), i);

				panelUserSlot.add(slotArr[i]);

			}
			
		}
		
		this.updateUI();
		
	}

	public void updateInGameJoinUI() {
		
		if (gameRoomInfo.isPlayingGame()) {
			
			lbQuizContent.setText("...");
			
			can.setEnabled(false);
			
			panelCanvasTool.setVisible(false);
			
		}
		
	}

	public void setLineSegment(SketchQuiz sq) {
		
		if (clsArr.size() == 0) 
			clsArr.add(new CanvasSegment());
		
		clsArr.get(clsArr.size() - 1).getCanArr().add(sq.getCanvasLine());
		
		can.repaint();
	}

	public void startGame(SketchQuiz sq) {
		
		userInfoArr = sq.getUserInfoArr();
		
		myUserInfo = userInfoArr[getMyIndex()];
		
		question = sq.getMsg();
		
		testerIndex = sq.getGameStaterIndex();
		
		StringBuffer sb = new StringBuffer();
		
		if (getValidUserNum() >= 3) {
			
			sb.append("접속자 닉네임 : " + userInfoArr[myIndex].getNickName() + " 게임 중 / 출제자 : " + userInfoArr[testerIndex].getNickName());
			
			mainFrame.setTitle(sb.toString());
			
		}
		
		if (myIndex == testerIndex) {

			lbQuizContent.setText(question);
			
			can.setEnabled(true);
			
			panelCanvasTool.setVisible(true);
			
			tfChat.setEditable(false);
			
		} 
		
		else {

			lbQuizContent.setText("......");
			
			can.setEnabled(false);
			
			panelCanvasTool.setVisible(false);
			
			tfChat.setEditable(true);
			
		}
		
		clearCanvas();

		if (getValidUserNum() > 2 && !starter_out) {
			
			String msg = userInfoArr[testerIndex].getNickName() + " 님 께서 그릴 차례 입니다.";
			jDialog(msg);
			
		}
		
	}

	public void stopGame(SketchQuiz sq) {
		
		inturruptThread();
		
		if (sq.isTimeout()) {
			
			String msg = "시간이 초과되었습니다.";
			
			jDialog(msg);
			
			sq.setTimeout(false);
			
		}
		
		can.setEnabled(true);
		
		panelCanvasTool.setVisible(true);
		
		StringBuffer sb = new StringBuffer();

		if (getValidUserNum() < 3) {
			
			sb.append("접속자 닉네임 : " + userInfoArr[myIndex].getNickName() + " / 3명이 입장해야 게임이 시작됩니다.");
			
			mainFrame.setTitle(sb.toString());
			
			ShowMessageThread t = new ShowMessageThread(GameRoomPanel.this, "3명 이상이어야 게임이 진행 됩니다.");
			
			t.start();
			
		}
		
	}

	public void jDialog(String msg) {

		JDialog jd = new JDialog();
		JLabel lb;
		
		jd.setLayout(new FlowLayout(FlowLayout.CENTER));
		jd.add(lb = new JLabel(msg));
		
		lb.setFont(new Font("", Font.BOLD, 20));
		
		jd.setBounds(GameRoomPanel.this.mainFrame.getFrameX() + 350, GameRoomPanel.this.mainFrame.getFrameY() + 350, 350, 80);
		jd.setVisible(true);
		
		try {
			
			Thread.sleep(2000);
			
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
		
		jd.setVisible(false);
		
	}

	public void addNewLineSegment() {
		
		clsArr.add(new CanvasSegment());
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
		
		String msg_game = tfChat.getText().trim();
		
		if (msg_game.length() > 0) {
			
			SketchQuiz sq = new SketchQuiz(SketchQuiz.GAME_CHAT);
			
			sq.setMsg(msg_game);
			
			tfChat.setText("");
			mainFrame.sendProtocol(sq);
			
		}
		
	}

	public UserSlotPanel[] getSlotArr() {
		return slotArr;
	}

	public void setSlotArr(UserSlotPanel[] slotArr) {
		this.slotArr = slotArr;
	}

	public boolean isStarter_out() {
		return starter_out;
	}

	public void setStarter_out(boolean starter_out) {
		this.starter_out = starter_out;
	}

	public void clearCanvas() {
		
		clsArr = new ArrayList<>();
		can.repaint();
		
	}

	public void questionSolved(SketchQuiz sq) {
		
		userInfoArr = sq.getUserInfoArr();
		
		int hitCount = slotArr[sq.getCorrectAnswerIndex()].getHitCount();
		
		hitCount += 1;
		
		slotArr[sq.getCorrectAnswerIndex()].setHitCount(hitCount);

		String msg = userInfoArr[sq.getCorrectAnswerIndex()].getNickName() + " 님 께서 정답을 맞췄습니다.";
		
		jDialog(msg);
		
	}

	public void setFocusTf() {
		tfChat.requestFocus();
	}

	public void startStopWatch() {
		
		thread = new Thread(this);
		thread.start();
		
	}

	public void inturruptThread() {
		
		if (thread != null) 
			thread.interrupt();
		
	}

	@Override
	public void run() {

		i = 0;
		
		while (i != 3001) {
			
			jpb.setValue(i);
		
			i++;
			
			if (i == 3001)
				break;
			
			try {
				
				Thread.sleep(10);
				
			} catch (Exception e) {
				
				e.printStackTrace();
				
				return;
			}
		}
	} 

	public Graphics getCanvasGraphics() {
		return can.getGraphics();
	}

	public int getMinSlotIndex() {
		
		for (int i = 0; i < userInfoArr.length; i++) {
			
			if (userInfoArr[i] != null) 
				return i;
			
		}
		
		return -1;
		
	}

	public int getValidUserNum() {
		
		int count = 0;
		
		for (int i = 0; i < userInfoArr.length; i++) {
			
			if (userInfoArr[i] != null) 
				count++;
			
		}
		
		return count;
		
	}

	public boolean isQuestioner() {
		return myIndex == testerIndex;
	}

	public void giveUpDraw() {
		
		if (getValidUserNum() >= 3) {
			
			clearCanvas();
			
			SketchQuiz sq = new SketchQuiz(SketchQuiz.GAME_STOP);
			
			sq.setTimeout(false);

			mainFrame.sendProtocol(sq);
			
		}
		
	}

	public void appendChatArea(String msg) {
		
		taChat.append(msg+"\r\n");
    	taChat.setCaretPosition(taChat.getText().length());
    	taChat.invalidate();
		
	}

	public void clearTextArea() {
		
		taChat.setText("");
		
	}
	
}