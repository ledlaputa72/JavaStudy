package panelList;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class UserSlotPanel extends JPanel { //게임에서 사용자를 나타낼 하나의 슬롯 패널
	
	JLabel lbNickname, lbHitCount;
	
	int slotIndex;
	int hitCount = 0;
	
	// 생성자
	public UserSlotPanel(String nickName, int slotIndex) {
		
		this.slotIndex = slotIndex;

		this.setLayout(new FlowLayout());
		this.setBorder(new LineBorder(Color.black));

		lbNickname = new JLabel(nickName);
		lbNickname.setFont(new Font("굴림", Font.BOLD, 20));
		lbHitCount = new JLabel(" -- 점수 : 0 점");

		this.add(lbNickname);
		this.add(lbHitCount);

	}

	public void setHitCount(int hitCount) {
		
		this.hitCount = hitCount;
		
		lbHitCount.setText("점수 : "+ hitCount * 10 + " 점");
		lbHitCount.invalidate();
		
	}
	
	public int getHitCount() {
		return hitCount;
	}
	
}
