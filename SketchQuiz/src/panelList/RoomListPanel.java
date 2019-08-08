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
	JButton btnJoin, btnCreate, btnExit; // ������, �游���, ���� ������ ��ư ����
	JScrollPane gameRoomListScrollPane; // �� ����Ʈ�� ���� ��ũ��
	JList<String> gameRoomList; // ���ӹ� �̸� ����Ʈ
	JDialog jdialog; // �� ����� ȭ���� ������ ���̾�α�

	// ������
	public RoomListPanel(MainFrame mainFrame) {

		this.mainFrame = mainFrame;

		initComponents(); // ������Ʈ�� ���� �� ���̾ƿ� ��ġ
		setComponentEvent(); // �� ������Ʈ�� �ʿ��� �̺�Ʈ�� ����

	}

	// ������Ʈ�� ���� �� ���̾ƿ� ��ġ
	private void initComponents() {
		
		this.setLayout(new BorderLayout());

		panelNorth = new JPanel(new FlowLayout(FlowLayout.RIGHT));

		panelCenter = new JPanel(new BorderLayout()); // �� ��ϰ� �̿��� ��ϸ���Ʈ�� ���� ���� �г�

		// ���� �г� �۾�
		panelNorth.add(btnJoin = new JButton("�����ϱ�"));
		btnJoin.setPreferredSize(new Dimension(100, 35));
		panelNorth.add(btnCreate = new JButton("�� �����"));
		btnCreate.setPreferredSize(new Dimension(100, 35));
		panelNorth.add(btnExit = new JButton("������"));
		btnExit.setPreferredSize(new Dimension(80, 35));
		this.add(panelNorth, BorderLayout.NORTH);

		// ���� �г� �۾�
		gameRoomListScrollPane = new JScrollPane(gameRoomList = new JList<>());
		gameRoomList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		gameRoomListScrollPane.setBorder(new TitledBorder("�� ���"));
		panelCenter.add(gameRoomListScrollPane);
		this.add(panelCenter);

	}

	// �� ������Ʈ�� �ʿ��� �̺�Ʈ�� �����Ѵ�
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
						JOptionPane.showMessageDialog(RoomListPanel.this, "�� ���� �����ϼ���");
				
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
					JOptionPane.showMessageDialog(RoomListPanel.this, "�� ���� �����ϼ���");
				
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
		jdialog.setTitle("�� �����");
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
		
		gameRoomListScrollPane.setBorder(new TitledBorder("�� ���"));
		
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
						JOptionPane.showMessageDialog(RoomListPanel.this, "�� ���� �����ϼ���.");
					
				}
				
			}
			
		});
		
	}
	
}