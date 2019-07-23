package menuSystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;

class MenuSystem extends JFrame implements ActionListener, ListSelectionListener {
	//라벨
	JLabel jlb1, jlb2;
	//버튼
	String[] buger=new String[4];
	int[] priceArr=new int[4];
	JButton[] jbt=new JButton[6];
	//리스트
	String[] listArr= {"종로","정로외"};
	JList jlist=new JList(listArr);
	
	static String str=""; //출력 문자열
	static int price=0;  //주문 총합
	static int num=0; //주문 수량
	
	public MenuSystem() {
		setLayout(new GridLayout(0,2,30,30));
		this.setTitle("어서와요 버거퀸입니다");
		
		//라벨과 버튼 세팅
		jlb1=new JLabel("**버커 퀸 햄버거입니다.**",JLabel.CENTER);
		jlb1.setFont(new Font("굴림",Font.BOLD,20));
		jlb2=new JLabel("드실 메뉴를 선택하세요",JLabel.CENTER);
		jlb2.setFont(new Font("굴림",Font.BOLD,20));

		buger[0]="매운 소스 햄버거 : ";
		buger[1]="더블 버퍼 햄버거 : ";
		buger[2]="야체새우 햄버거 : ";
		buger[3]="새겹토마토 햄버거 : ";
		
		priceArr[0]=5000;
		priceArr[1]=7000;
		priceArr[2]=4500;
		priceArr[3]=5500;
		
		jbt[0]=new JButton(buger[0]+ priceArr[0]);
		jbt[1]=new JButton(buger[1]+ priceArr[1]);
		jbt[2]=new JButton(buger[2]+ priceArr[2]);
		jbt[3]=new JButton(buger[3]+ priceArr[3]);
		jbt[4]=new JButton("주문합니다");
		jbt[5]=new JButton("취소합니다");
		
		jbt[4].setBackground(Color.CYAN);
		jbt[5].setBackground(Color.YELLOW);
		jbt[4].setForeground(Color.RED);
		jbt[5].setForeground(Color.BLUE);
		
		//라벨과 버튼을 추가 
		add(jlb1);
		add(jlb2);
		for (int i = 0; i < jbt.length; i++) {
			add(jbt[i]);
			jbt[i].addActionListener(this);
		}
		//리스트 추가
		add(jlist);
		jlist.addListSelectionListener(this);
		
		//프레임 세팅
		setSize(600, 800);
		setVisible(true);
	}
	//버튼 이벤트 
	@Override
	public void actionPerformed(ActionEvent e) {
		//매뉴 버튼 이벤트 
		for (int i = 0; i < 4; i++) {
			if (e.getSource()==jbt[i]) {
				str=str+(buger[i]+priceArr[i])+"\n";
				price=price+priceArr[i];
				num++;
			}
		}
		//주문 버튼 이벤트
		if (e.getSource()==jbt[4]) {
			JOptionPane.showMessageDialog(this, str+"총금액:"+price+"\n"+"총주문수량:"+num+"개", "확인하세요", 3);
			str="";
			price=0;
			num=0;
		}
		//취소 버튼 이벤트
		if (e.getSource()==jbt[5]) {
			str="";
			price=0;
			num=0;
			JOptionPane.showMessageDialog(this, "취소하였습니다.");
		}
	}
	//리스트 이벤트 
	@Override
	public void valueChanged(ListSelectionEvent e) {
		if ("종로".equals(jlist.getSelectedValue())) {
			price=price-500;
		}
		else if("정로외".equals(jlist.getSelectedValue())) {
			price=price-500;
		} 
	}
	
}//클래스 end

public class BugerStoreMenu {

	public static void main(String[] args) {
		MenuSystem myMenu=new MenuSystem();
	}

}
