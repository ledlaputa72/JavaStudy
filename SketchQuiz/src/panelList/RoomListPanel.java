package panelList;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.border.TitledBorder;

import info.GameRoomInfo;
import info.SketchQuiz;
import main.MainFrame;

public class RoomListPanel extends JPanel {

	public static final String cardName = "RoomListPanel";

	MainFrame mainFrame;

	int width = 500, height = 300;

	JPanel panelNorth, panelCenter;
	JButton btnJoin, btnCreate, btnExit; // 방참여, 방만들기, 대기실 나가기 버튼 선언
	JScrollPane gameRoomListScrollPane; // 방 리스트를 담을 스크롤
	JList<String> gameRoomList; // 게임방 이름 리스트
	JDialog jdialog; // 방 만들기 화면을 보여줄 다이얼로그

	// 생성자
	public RoomListPanel(MainFrame mainFrame) {

		this.mainFrame = mainFrame;

		initComponents(); // 컴포넌트의 생성 및 레이아웃 배치
		setComponentEvent(); // 각 컴포넌트에 필요한 이벤트를 설정

	}

	// 컴포넌트의 생성 및 레이아웃 배치
	private void initComponents() {
		
		this.setLayout(new BorderLayout());

		panelNorth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		panelCenter = new JPanel(new BorderLayout()); // 방 목록과 이용자 목록리스트를 담을 센터 패널

		// 북쪽 패널 작업
		panelNorth.add(btnJoin = new JButton("참여하기"));
		btnJoin.setPreferredSize(new Dimension(100, 35));
		panelNorth.add(btnCreate = new JButton("방 만들기"));
		btnCreate.setPreferredSize(new Dimension(100, 35));
		panelNorth.add(btnExit = new JButton("나가기"));
		btnExit.setPreferredSize(new Dimension(80, 35));
		this.add(panelNorth, BorderLayout.NORTH);

		// 센터 패널 작업
		gameRoomListScrollPane = new JScrollPane(gameRoomList = new JList<>());
		gameRoomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gameRoomListScrollPane.setBorder(new TitledBorder("방 목록"));
		panelCenter.add(gameRoomListScrollPane);
		this.add(panelCenter);

	}

	// 각 컴포넌트에 필요한 이벤트를 설정한다
	private void setComponentEvent() {
		
		gameRoomList.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 2) {
					
					if (gameRoomList.getSelectedIndex() != -1) {
						
						SketchQuiz sq = new SketchQuiz(SketchQuiz.JOIN_GAME_ROOM);
						
						sq.setGameRoomIndex(gameRoomList.getSelectedIndex());
						
						mainFrame.sendProtocol(sq);
						
					} 
					
					else 
						JOptionPane.showMessageDialog(RoomListPanel.this, "들어갈 방을 선택하세요");
				
				}
				
			}
			
		});
		
		btnJoin.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
				if (gameRoomList.getSelectedIndex() != -1) {
					
					SketchQuiz sq = new SketchQuiz(SketchQuiz.JOIN_GAME_ROOM);
					
					sq.setGameRoomIndex(gameRoomList.getSelectedIndex());
					
					mainFrame.sendProtocol(sq);
					
				} 
				
				else 
					JOptionPane.showMessageDialog(RoomListPanel.this, "들어갈 방을 선택하세요");
				
			}
			
		});
		
		btnExit.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				SketchQuiz sq = new SketchQuiz(SketchQuiz.EXIT_WAIT_ROOM);
				
				mainFrame.sendProtocol(sq);

			}
			
		});

		btnCreate.addActionListener(new ActionListener() {
			
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

	public void updateGameRoomList(String[] list) {
		
		if (list != null) {
			
			gameRoomList.setListData(list);
			gameRoomList.invalidate();
			
		} 
		
		else if (list == null) 
			setEmptyGameRoomList();
		
	}

	public void showCreateRoomPanel() {
		
		jdialog = new JDialog();
		
		CreateRoomPanel crp = new CreateRoomPanel(this);
		
		jdialog.setContentPane(crp);
		jdialog.setBounds(mainFrame.getFrameX() + 200, mainFrame.getFrameY() + 200, 300, 200);
		jdialog.setTitle("방 만들기");
		jdialog.setVisible(true);
		
	}

	public void cancelCreateRoomPanel() {
		
		jdialog.setVisible(false);
		
	}

	public void createGameRoom(String roomName, int gameUserNum) {
		
		GameRoomInfo gri = new GameRoomInfo(roomName, gameUserNum);
		
		SketchQuiz sq = new SketchQuiz(SketchQuiz.CREATE_GAME_ROOM);
		
		sq.setGameRoomInfo(gri);
		
		mainFrame.sendProtocol(sq);
		
	}

	public void setEmptyGameRoomList() {
		
		panelCenter.remove(gameRoomListScrollPane);
		
		gameRoomListScrollPane = new JScrollPane(gameRoomList = new JList<>());
		
		gameRoomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		
		gameRoomListScrollPane.setBorder(new TitledBorder("방 목록"));
		
		panelCenter.add(gameRoomListScrollPane);
		panelCenter.invalidate();
		panelCenter.updateUI();
		
		gameRoomList.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if (e.getClickCount() == 2) {
					
					if (gameRoomList.getSelectedIndex() != -1) {
						
						SketchQuiz sq = new SketchQuiz(SketchQuiz.JOIN_GAME_ROOM);
						
						sq.setGameRoomIndex(gameRoomList.getSelectedIndex());
						
						mainFrame.sendProtocol(sq);
						
					} 
					
					else 
						JOptionPane.showMessageDialog(RoomListPanel.this, "들어갈 방을 선택하세요.");
					
				}
				
			}
			
		});
		
	}
	
}