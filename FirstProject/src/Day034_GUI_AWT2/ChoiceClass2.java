package Day034_GUI_AWT2;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class ChoiceClass2 extends Frame implements ItemListener{
	
	public static void main(String[] args) {
		
		ChoiceClass2 cc1=new ChoiceClass2();
		cc1.setTitle("콤보박스(초이스");
		
		Choice c1=new Choice();
		c1.add("출발지역을 선택하세요");
		c1.add("서울");
		c1.add("경기");
		c1.add("인천");
		c1.addItemListener(cc1);
		
		cc1.add(c1); //프레임에 선택버튼 넣기 
		cc1.setSize(300, 350);
		cc1.setVisible(true);
		
		//닫기
		cc1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				cc1.dispose(); 
				System.exit(0);
			}
		});	//창 닫기

	}//main end

	//Item에 대한 이벤트 처리 
	@Override
	public void itemStateChanged(ItemEvent e) {
		if(e.getItem().equals("서울"))
		JOptionPane.showMessageDialog(null, "1번째 눌렀구만","메시지",JOptionPane.INFORMATION_MESSAGE, null);
		else if(e.getItem().equals("경기"))
		JOptionPane.showMessageDialog(null, "2번째 눌렀구만","메시지",JOptionPane.INFORMATION_MESSAGE, null);
		else if(e.getItem().equals("인천"))
		JOptionPane.showMessageDialog(null, "3번째 눌렀구만","메시지",JOptionPane.INFORMATION_MESSAGE, null);
	}

}//class end
