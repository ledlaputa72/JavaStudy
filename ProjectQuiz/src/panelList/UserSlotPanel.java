package panelList;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class UserSlotPanel extends JPanel { //���ӿ��� ����ڸ� ��Ÿ�� �ϳ��� ���� �г�
	
	JLabel lbNickname, lbHitCount;
	
	int slotIndex;
	int hitCount = 0;
	
	// ������
	public UserSlotPanel(String nickName, int slotIndex) {
		
		this.slotIndex = slotIndex;

		this.setLayout(new FlowLayout());
		this.setBorder(new LineBorder(Color.black));

		lbNickname = new JLabel(nickName);
		lbNickname.setFont(new Font("����", Font.BOLD, 20));
		lbHitCount = new JLabel(" -- ���� : 0 ��");

		this.add(lbNickname);
		this.add(lbHitCount);

	}

	public void setHitCount(int hitCount) {
		
		this.hitCount = hitCount;
		
		lbHitCount.setText("���� : "+ hitCount * 10 + " ��");
		lbHitCount.invalidate();
		
	}
	
	public int getHitCount() {
		return hitCount;
	}
	
}
