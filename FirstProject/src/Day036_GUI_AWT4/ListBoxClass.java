package Day036_GUI_AWT4;
//one class 
import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

public class ListBoxClass extends Frame implements ItemListener {
	
	private Label l1,l2;
	private List lst1,lst2;
	private Frame f1;

	public ListBoxClass() { //생성자
		
		f1=new Frame();
		f1.setTitle("공항 선택");
		f1.setSize(500, 500);
		f1.setLayout(null);
		f1.setVisible(true);
		
		l1=new Label("출발 공항");
		l1.setSize(100, 50);
		l1.setLocation(50, 50);
		l1.setVisible(true);
		f1.add(l1);
		
		l2=new Label("도착 공항");
		l2.setSize(100, 50);
		l2.setLocation(200, 50);
		l2.setVisible(true);
		f1.add(l2);
		
		lst1=new List();
		lst1.add("인천1");
		lst1.add("김포1");
		lst1.add("부산1");
		lst1.add("제주1");
		lst1.add("광주1");
		lst1.add("대구1");
		lst1.add("여수1");
		lst1.add("인천2");
		lst1.add("김포2");
		lst1.add("부산2");
		lst1.add("제주2");
		lst1.add("광주2");
		lst1.add("대구2");
		lst1.add("여수2");
		lst1.select(0); //시작할때 선택되어진 index 
		lst1.setSize(100, 100);
		lst1.setLocation(50, 100);
		lst1.setVisible(true);
		f1.add(lst1);
		lst1.addItemListener(this);
		
		lst2=new List();
		lst2.add("도쿄");
		lst2.add("오사카");
		lst2.add("상해");
		lst2.add("뉴욕");
		lst2.select(0);
		lst2.setSize(100, 100);
		lst2.setLocation(200, 100);
		lst2.setVisible(true);
		f1.add(lst2);
		lst2.addItemListener(this);
	
		//창 닫기 
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//창 닫기
	}
	
	public static void main(String[] args) {
		ListBoxClass airport=new ListBoxClass();
	}

	@Override
	public void itemStateChanged(ItemEvent e) {
		/*//내 문제 풀이 
		if(e.getSource()==lst1)
		JOptionPane.showMessageDialog(null, "출발 도시는 "+lst1.getSelectedItem());
		else if(e.getSource()==lst2)
		JOptionPane.showMessageDialog(null, "도착 도시는 "+lst2.getSelectedItem());*/
		
		//선생님 문제 풀이 
		//출발 공항///////////////////////////////////////////////
		if (e.getSource()==lst1) { 
			if (e.getItem().equals(new Integer(0))) {
				JOptionPane.showMessageDialog(null, "출발0번째 눌렀구만","메시지",JOptionPane.INFORMATION_MESSAGE,null);
			}
			else if(e.getItem().equals(new Integer(1))) {
				JOptionPane.showMessageDialog(null, "출발1번째 눌렀구만","메시지",JOptionPane.INFORMATION_MESSAGE,null);
			}
			else {
				JOptionPane.showMessageDialog(null, "출발0~1번이 아니네","메시지",JOptionPane.INFORMATION_MESSAGE,null);
			}
		}//lst1을 눌렀을때  - 출발 공항
		//도착 공항/////////////////////////////////////////////////
		else if(e.getSource()==lst2) { 
			if (e.getItem().equals(new Integer(0))) {
				JOptionPane.showMessageDialog(null, "도착0번째 눌렀구만","메시지",JOptionPane.INFORMATION_MESSAGE,null);
			}
			else if(e.getItem().equals(new Integer(1))) {
				JOptionPane.showMessageDialog(null, "도착1번째 눌렀구만","메시지",JOptionPane.INFORMATION_MESSAGE,null);
			}
			else {
				JOptionPane.showMessageDialog(null, "도착0~1번이 아니네","메시지",JOptionPane.INFORMATION_MESSAGE,null);
			}
		}//lst2를 눌렀을때 - 도착공항
	}

}
