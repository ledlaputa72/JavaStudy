package display_panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.Icon;
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

import main_frame.MainFrame;
import protocol.CatchMindProtocol;
import protocol.GameRoomInfo;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author USER
 */
public class WaitingRoomPanel extends javax.swing.JPanel {
	public static final String cardName  = "WaitingRoomPanel";
	MainFrame mainFrame;
	int width =620,height= 500;

	JPanel north_p, center_p, south_p; //WaitingRopomPanel 을 borderLayout으로 설정하여 3부분으로 나눈다
	JPanel input_p;   //사용자가 채팅 내용을 입력할 패널  : waitingRoomChatField,  sendChatBtn 이 들어감
	//컴포넌트 선언
	JButton joinGameRoomBtn, createGameRoomBtn, exitWaitingRoomBtn;   //방참여, 방만들기, 대기실 나가기 버튼 선언
	JScrollPane gameRoomListScrollPane, waitingRoomUserListScrollPane, waitingRoomChatScrollPane;  //방리스트, 유저리스트, 채팅창을 담을 스크롤
	JList<String> gameRoomList, waitingRoomUserList;  //게임방 이름 리스트, 대기실 사용자 이름 리스트
	JTextArea waitingRoomChatArea;  //대기실에서 채팅내용을 표시하기 위한 컴포넌트
	JTextField waitingRoomChatField;  //대기실에서 채팅하기 위해 사용자가 글을 입력하는 부분
	JButton sendChatBtn;  //입력한 내용을 전송한다.
	JDialog jdialog ; //방만들기 화면을 보여줄 다이얼로그 
    public WaitingRoomPanel(MainFrame mainFrame) {
    	this.mainFrame = mainFrame;
        initComponents();
        setComponentEvent();
    }
    
    //컴포넌트의 생성 및 레이아웃 배치
    private void initComponents() {
    	this.setLayout(new BorderLayout());
    		final ImageIcon icon = new ImageIcon("src/images/logo_wrp.png"); 
    	north_p= new JPanel(new FlowLayout(FlowLayout.RIGHT)) { //방참여, 방만들기, 나가기 버튼을 담을 북쪽 패널 
    		public void paintComponent(Graphics g) {
    			g.drawImage(icon.getImage(), 0, 0, null);
    		}
    	}; 
    		Color bg = new Color(27,117,200);
    		north_p.setBackground(bg);
    	center_p = new JPanel(new BorderLayout()); //방 목록과 이용자 목록리스트를 담을 센터 패널
    	south_p = new JPanel(new BorderLayout());  //대화창과 입력란 보내기 버튼을 담을 남쪽 패널
    	
    	//북쪽 패널 작업
    	north_p.add(joinGameRoomBtn = new JButton("참여하기"));
    	north_p.add(createGameRoomBtn = new JButton("방만들기"));
    	north_p.add(exitWaitingRoomBtn = new JButton("나가기"));
    	
    	//센터 패널 작업
    	gameRoomListScrollPane =new JScrollPane(gameRoomList = new JList<>());
    	gameRoomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	gameRoomListScrollPane.setBorder(new TitledBorder("방 목록"));
    	waitingRoomUserListScrollPane = new JScrollPane(waitingRoomUserList = new JList<>());
//    	waitingRoomUserListScrollPane.setBorder(new TitledBorder("대기실 이용자"));
//    	waitingRoomUserList.setFixedCellWidth(150);
    	center_p.add(gameRoomListScrollPane);
//    	center_p.add(waitingRoomUserListScrollPane, BorderLayout.EAST);
    	
    	//남쪽 패널 작업
//    	waitingRoomChatScrollPane = new JScrollPane(waitingRoomChatArea = new JTextArea(7,0));
//    	waitingRoomChatScrollPane.setBorder(new TitledBorder("대화창"));
//    	waitingRoomChatArea.setEditable(false);
//    	input_p = new JPanel(new BorderLayout());
//    	input_p.add(waitingRoomChatField = new JTextField());
//    	input_p.add(sendChatBtn = new JButton("보내기"), BorderLayout.EAST);
//    	south_p.add(waitingRoomChatScrollPane);
//    	south_p.add(input_p, BorderLayout.SOUTH);
    	
    	this.add(north_p,BorderLayout.NORTH);  
    	this.add(center_p);
//    	this.add(south_p, BorderLayout.SOUTH);
    }            
    
    //각 컴포넌트에 필요한 이벤트를 설정한다
    private void setComponentEvent(){
    	gameRoomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					if(gameRoomList.getSelectedIndex()!=-1){
						CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.JOIN_GAME_ROOM);
						cmp.setGameRoomIndex(gameRoomList.getSelectedIndex());
						mainFrame.sendProtocol(cmp);
					}else{
						JOptionPane.showMessageDialog(WaitingRoomPanel.this, "들어갈 방을 선택하세요");
					}
				}
			}
		});
    	joinGameRoomBtn.addActionListener(new ActionListener() {
    		@Override
    		public void actionPerformed(ActionEvent arg0) {
    			if(gameRoomList.getSelectedIndex()!=-1){
					CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.JOIN_GAME_ROOM);
					cmp.setGameRoomIndex(gameRoomList.getSelectedIndex());
					mainFrame.sendProtocol(cmp);
				}else{
					JOptionPane.showMessageDialog(WaitingRoomPanel.this, "들어갈 방을 선택하세요");
				}
    		}
    	});
    	exitWaitingRoomBtn.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.EXIT_WAIT_ROOM);
				mainFrame.sendProtocol(cmp);
//				mainFrame.changeCard(NickNamePanel.cardName);
			}
		});
//    	waitingRoomChatField.addActionListener(new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				CatchMindProtocol cmp = getMsgProtocol();
//				if(cmp!=null){
//					mainFrame.sendProtocol(cmp);
//					waitingRoomChatField.setText("");
//				}
//			}
//		});
//    	sendChatBtn.addActionListener(new ActionListener() {
//    		@Override
//    		public void actionPerformed(ActionEvent e) {
//    			CatchMindProtocol cmp = getMsgProtocol();
//    			if(cmp!=null){
//    				mainFrame.sendProtocol(cmp);
//    				waitingRoomChatField.setText("");
//    				waitingRoomChatField.requestFocus();
//    			}
//    		}
//    	});
    	createGameRoomBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				showCreateRoomPanel();
			}
		});
    }
//    public CatchMindProtocol getMsgProtocol(){
//    	CatchMindProtocol cmd = null;
//    	if(waitingRoomChatField.getText().trim().length()>0){
//    		cmd =new CatchMindProtocol(CatchMindProtocol.WAIT_ROOM_SEND_MSG);
//    		cmd.setMsg(waitingRoomChatField.getText().trim());
//    	}
//    	return cmd;
//    }
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
    public void updateWaitingUserList(String[] list){
    	if(list != null){
    		waitingRoomUserList.setListData(list);
    		waitingRoomUserList.invalidate();
    	}
    	else if(list == null){
    		
    	}
    }
    public void updateGameRoomList(String[] list){
    	if(list != null){
    		gameRoomList.setListData(list);
    		gameRoomList.invalidate();
    	}
    	else if(list ==null){
    		setEmptyGameRoomList();
    	}
    }
//    public void appendChatArea(String msg){
//    	waitingRoomChatArea.append(msg+"\r\n");
//    	waitingRoomChatArea.setCaretPosition(waitingRoomChatArea.getText().length());
//    	waitingRoomChatArea.invalidate();
//    }
    public void clearTextArea(){
//    	waitingRoomChatArea.setText("");
    }
    public void showCreateRoomPanel(){
    	jdialog = new JDialog();
    	CreateRoomPanel crp = new CreateRoomPanel(this);
    	jdialog.setContentPane(crp);
    	jdialog.setBounds(mainFrame.getFrame_x()+200, mainFrame.getFrame_y()+200, 300, 200);
    	jdialog.setVisible(true);
    }
    public void cancelCreateRoomPanel(){
    	jdialog.setVisible(false);
    }
    public void createGameRoom(String roomName, boolean isPublicGameRoom, String gamePassword, int gameUserNum){
    	GameRoomInfo gri = new GameRoomInfo(roomName, isPublicGameRoom, gamePassword, gameUserNum);
    	CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.CREATE_GAME_ROOM);
    	cmp.setGameRoomInfo(gri);
    	mainFrame.sendProtocol(cmp);
    }
    public void setEmptyGameRoomList(){
    	center_p.remove(gameRoomListScrollPane);
		gameRoomListScrollPane =new JScrollPane(gameRoomList = new JList<>());
    	gameRoomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	gameRoomListScrollPane.setBorder(new TitledBorder("방 목록"));
    	center_p.add(gameRoomListScrollPane);
    	center_p.invalidate();
    	center_p.updateUI();
    	gameRoomList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				if(e.getClickCount() == 2){
					if(gameRoomList.getSelectedIndex()!=-1){
						CatchMindProtocol cmp = new CatchMindProtocol(CatchMindProtocol.JOIN_GAME_ROOM);
						cmp.setGameRoomIndex(gameRoomList.getSelectedIndex());
						mainFrame.sendProtocol(cmp);
					}else{
						JOptionPane.showMessageDialog(WaitingRoomPanel.this, "들어갈 방을 선택하세요");
					}
				}
			}
		});
    }
}

