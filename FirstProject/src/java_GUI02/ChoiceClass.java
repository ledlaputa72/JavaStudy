package java_GUI02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.JOptionPane;

public class ChoiceClass extends Frame{

	public static void main(String[] args) {
		
		ChoiceClass cc1=new ChoiceClass();
		
		cc1.setTitle("콤보박스(초이스");
		Choice c1=new Choice();
		c1.add("서울");
		c1.add("경기");
		c1.add("인천");

		c1.remove(0); //index 0번 아이템 제거 
		c1.insert("대전", 0); //index 0번 위치에 아이템 삽입 
		
		cc1.add(c1); //프레임에 콤보 넣기 
		//cc1.pack();
		cc1.setSize(300, 300);
		cc1.setVisible(true);
		
		JOptionPane.showMessageDialog(null, "아이템 갯수 : "+c1.getItemCount()+"\n 0번째 아이템 : "+c1.getItem(0)); 
		System.out.println("내가 고른것 : "+c1.getSelectedItem());
		
		cc1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				cc1.dispose(); 
				System.exit(0);
			}
		});	//창 닫기

	}//main end

}//class end
