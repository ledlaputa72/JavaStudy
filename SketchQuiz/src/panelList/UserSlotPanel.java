package panelList;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

// 게임에서 사용자를 나타낼 하나의 슬롯 패널
public class UserSlotPanel extends JPanel { 
	
	JLabel lbNickname, lbScore;
	JPanel panelNickname, panelScore;
	
	int slotIndex;
	int hitCount = 0;
	
	// 생성자
	public UserSlotPanel(String nickName, int slotIndex) {
		
		this.slotIndex = slotIndex;

		this.setLayout(new GridLayout(2, 1));
		this.setBorder(new LineBorder(Color.black));

		panelNickname = new JPanel(new FlowLayout(FlowLayout.CENTER));
		panelScore = new JPanel(new FlowLayout(FlowLayout.CENTER));
		
		lbNickname = new JLabel(nickName);
		lbNickname.setFont(new Font("굴림", Font.BOLD, 20));
		lbScore = new JLabel("점수 : 0 점");

		panelNickname.add(lbNickname);
		panelScore.add(lbScore);
		
		this.add(panelNickname);
		this.add(panelScore);

	}

	public void setHitCount(int hitCount) {
		
		this.hitCount = hitCount;
		
		lbScore.setText("점수 : "+ hitCount * 10 + " 점");
		lbScore.invalidate();
		
	}
	
	public int getHitCount() {
		return hitCount;
	}
	
}
