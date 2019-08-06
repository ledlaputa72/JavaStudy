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

	JPanel north_p, center_p, south_p; //WaitingRopomPanel �� borderLayout���� �����Ͽ� 3�κ����� ������
	JPanel input_p;   //����ڰ� ä�� ������ �Է��� �г�  : waitingRoomChatField,  sendChatBtn �� ��
	//������Ʈ ����
	JButton joinGameRoomBtn, createGameRoomBtn, exitWaitingRoomBtn;   //������, �游���, ���� ������ ��ư ����
	JScrollPane gameRoomListScrollPane, waitingRoomUserListScrollPane, waitingRoomChatScrollPane;  //�渮��Ʈ, ��������Ʈ, ä��â�� ���� ��ũ��
	JList<String> gameRoomList, waitingRoomUserList;  //���ӹ� �̸� ����Ʈ, ���� ����� �̸� ����Ʈ
	JTextArea waitingRoomChatArea;  //���ǿ��� ä�ó����� ǥ���ϱ� ���� ������Ʈ
	JTextField waitingRoomChatField;  //���ǿ��� ä���ϱ� ���� ����ڰ� ���� �Է��ϴ� �κ�
	JButton sendChatBtn;  //�Է��� ������ �����Ѵ�.
	JDialog jdialog ; //�游��� ȭ���� ������ ���̾�α� 
    public WaitingRoomPanel(MainFrame mainFrame) {
    	this.mainFrame = mainFrame;
        initComponents();
        setComponentEvent();
    }
    
    //������Ʈ�� ���� �� ���̾ƿ� ��ġ
    private void initComponents() {
    	this.setLayout(new BorderLayout());
    		final ImageIcon icon = new ImageIcon("src/images/logo_wrp.png"); 
    	north_p= new JPanel(new FlowLayout(FlowLayout.RIGHT)) { //������, �游���, ������ ��ư�� ���� ���� �г� 
    		public void paintComponent(Graphics g) {
    			g.drawImage(icon.getImage(), 0, 0, null);
    		}
    	}; 
    		Color bg = new Color(27,117,200);
    		north_p.setBackground(bg);
    	center_p = new JPanel(new BorderLayout()); //�� ��ϰ� �̿��� ��ϸ���Ʈ�� ���� ���� �г�
    	south_p = new JPanel(new BorderLayout());  //��ȭâ�� �Է¶� ������ ��ư�� ���� ���� �г�
    	
    	//���� �г� �۾�
    	north_p.add(joinGameRoomBtn = new JButton("�����ϱ�"));
    	north_p.add(createGameRoomBtn = new JButton("�游���"));
    	north_p.add(exitWaitingRoomBtn = new JButton("������"));
    	
    	//���� �г� �۾�
    	gameRoomListScrollPane =new JScrollPane(gameRoomList = new JList<>());
    	gameRoomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    	gameRoomListScrollPane.setBorder(new TitledBorder("�� ���"));
    	waitingRoomUserListScrollPane = new JScrollPane(waitingRoomUserList = new JList<>());
//    	waitingRoomUserListScrollPane.setBorder(new TitledBorder("���� �̿���"));
//    	waitingRoomUserList.setFixedCellWidth(150);
    	center_p.add(gameRoomListScrollPane);
//    	center_p.add(waitingRoomUserListScrollPane, BorderLayout.EAST);
    	
    	//���� �г� �۾�
//    	waitingRoomChatScrollPane = new JScrollPane(waitingRoomChatArea = new JTextArea(7,0));
//    	waitingRoomChatScrollPane.setBorder(new TitledBorder("��ȭâ"));
//    	waitingRoomChatArea.setEditable(false);
//    	input_p = new JPanel(new BorderLayout());
//    	input_p.add(waitingRoomChatField = new JTextField());
//    	input_p.add(sendChatBtn = new JButton("������"), BorderLayout.EAST);
//    	south_p.add(waitingRoomChatScrollPane);
//    	south_p.add(input_p, BorderLayout.SOUTH);
    	
    	this.add(north_p,BorderLayout.NORTH);  
    	this.add(center_p);
//    	this.add(south_p, BorderLayout.SOUTH);
    }            
    
    //�� ������Ʈ�� �ʿ��� �̺�Ʈ�� �����Ѵ�
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
						JOptionPane.showMessageDialog(WaitingRoomPanel.this, "�� ���� �����ϼ���");
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
					JOptionPane.showMessageDialog(WaitingRoomPanel.this, "�� ���� �����ϼ���");
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
    	gameRoomListScrollPane.setBorder(new TitledBorder("�� ���"));
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
						JOptionPane.showMessageDialog(WaitingRoomPanel.this, "�� ���� �����ϼ���");
					}
				}
			}
		});
    }
}

