package display_panel;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

public class GameRoomSlotPanel extends JPanel { //게임에서 사용자를 나타낼 하나의 슬롯 패널
	
	JPanel west_p; //닉네임과 게임안에서 맞춘 횟수를 표시할 패널
	JPanel nic_p;
	JPanel tf_p;
	JLabel userImageLabel; //사용자가 선택한 이미지를 보여줄 레이블
	JTextField tf;
	int slotIndex;
	int bubble_x, bubble_y;
	JLabel lb, hitCountLb;
	int hitCount=0;
	public GameRoomSlotPanel(String nickName, String imagePath,int slotIndex){
		this.slotIndex = slotIndex;
		if(slotIndex%2==0){
			this.bubble_x = 100;
			this.bubble_y = 100;
		}else{
			this.bubble_x = -100;
			this.bubble_y = 100;
		}
		this.setLayout(new BorderLayout());
		this.setBorder(new LineBorder(Color.black));
		west_p = new JPanel(new GridLayout(3, 1));
		west_p.add(new JLabel(""));
		nic_p = new JPanel(new FlowLayout(FlowLayout.CENTER));
		nic_p.add(lb = new JLabel(nickName));
		lb.setFont(new Font("", Font.BOLD, 17));
		//nic_p.setBackground(Color.WHITE);
		this.add(nic_p,BorderLayout.NORTH);
		lb.setPreferredSize(new Dimension(80, 20));
		west_p.add(hitCountLb= new JLabel("정답 : 0"));
		final ImageIcon bubble = new ImageIcon("src/images/bubblepop.png");
		tf_p = new JPanel(new FlowLayout(FlowLayout.CENTER)) {
			public void paintComponent(Graphics g) {
				g.drawImage(bubble.getImage(), 0, 0, null);
			}
		};
		tf_p.add(tf = new JTextField(11));		
		this.add(tf_p, BorderLayout.SOUTH);
		tf.setEditable(false);
		tf.setBorder(null);
		tf.setBackground(Color.WHITE);
		tf.setBorder(null);
		this.add(west_p, BorderLayout.WEST);
		west_p.setPreferredSize(new Dimension(80, getHeight()));
		userImageLabel = new JLabel(new ImageIcon(imagePath));
		this.add(userImageLabel);
	}
	public int getBubble_x() {
		return bubble_x;
	}
	public void setBubble_x(int bubble_x) {
		this.bubble_x = bubble_x;
	}
	public int getBubble_y() {
		return bubble_y;
	}
	public void setBubble_y(int bubble_y) {
		this.bubble_y = bubble_y;
	}
	public void setHitCount(int hitCount){
		this.hitCount = hitCount;
		hitCountLb.setText("정답 : "+hitCount);
		hitCountLb.invalidate();
	}
	public int getHitCount(){
		return hitCount;
	}
}
