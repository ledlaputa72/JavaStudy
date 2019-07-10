package java_SwingGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import classHuman.Demon;

class JMenuBarClass extends JFrame implements ActionListener{
	
	JTextField jtextfield1=new JTextField("나를 디자인해봐");
	JMenuBar jmenubar1 = new JMenuBar();
	JMenu jmenu1 = new JMenu("디자인");
	JMenuItem[] jmenuitem1=new JMenuItem[5]; //메뉴 아이템을 배열로 
	String[] selectArr= {"red색","green색","12폰트","32폰트","종료",};
	
	//생성자
	public JMenuBarClass() {
		getContentPane().setLayout(new GridLayout(0,1,20,20));
		//임의 행 1열로 그리고 가로세로 간격은 각각 20픽셀
		add(jtextfield1);
		//메뉴 아이템을 배열로 입력 
		for (int i = 0; i < jmenuitem1.length; i++) {
			jmenuitem1[i]=new JMenuItem(selectArr[i]); //배열로 메뉴 아이템 이름을 할당
			jmenuitem1[i].addActionListener(this); //할당된 메뉴에 이벤트 add
			jmenu1.add(jmenuitem1[i]); //메뉴에 메뉴 아이템을 add
		}
		jmenubar1.add(jmenu1);
		setJMenuBar(jmenubar1);
		
		setSize(700, 700);
		setVisible(true);
		
		//창 중앙에 오기 
		Dimension screen=Toolkit.getDefaultToolkit().getScreenSize();
		int posX=(int)(screen.getWidth()/2-this.getWidth()/2);
		int posY=(int)(screen.getHeight()/2-this.getHeight()/2);
		setLocation(posX,posY);
		
	}//생성자 end
	
	@Override //이벤트 리스너
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jmenuitem1[0]) {
			jtextfield1.setForeground(Color.red);
		}else if (e.getSource()==jmenuitem1[1]) {
			jtextfield1.setForeground(Color.green);
		}else if (e.getSource()==jmenuitem1[2]) {
			jtextfield1.setFont(new Font("굴림",Font.BOLD,12));
		}else if (e.getSource()==jmenuitem1[3]) {
			jtextfield1.setFont(new Font("굴림",Font.BOLD,32));
		}else if (e.getSource()==jmenuitem1[4]) {
			System.exit(0);
		}
		
	}//리스너 end
	
}// class end

public class JMenuBarMainClass {

	public static void main(String[] args) {

		JMenuBarClass jmbc1=new JMenuBarClass();
	}

}
