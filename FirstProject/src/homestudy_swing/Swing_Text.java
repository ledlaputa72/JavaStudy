package homestudy_swing;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;
import javax.swing.event.*;

class SwingClass extends JFrame implements ActionListener{

	JFrame jmf=new JFrame();
	JMenuBar mb1=new JMenuBar();
	
	JMenu m1=new JMenu("파일");
	
	JMenuItem it1=new JMenuItem("열기");
	JMenuItem it2=new JMenuItem("저장");
	JMenuItem it3=new JMenuItem("다른이름으로저장");
	JMenuItem it4=new JMenuItem("닫기");
	
	JMenu m2=new JMenu("편집");
	
	JMenuItem it5=new JMenuItem("모두선택");
    JCheckBoxMenuItem it6=new JCheckBoxMenuItem("검색"); 
    JCheckBoxMenuItem it7=new JCheckBoxMenuItem("복사");
	
	public SwingClass () {
		//메인 프레임 
		jmf.setSize(700, 700);
		jmf.setTitle("메뉴테스트");
		jmf.setVisible(true);
		
		//1번쨰 메뉴 
		it1.addActionListener(this);
		it2.addActionListener(this);
		it3.addActionListener(this);
		it4.addActionListener(this);
		
		m1.add(it1);
		m1.addSeparator();
		m1.add(it2);
		m1.add(it3);
		m1.addSeparator();
		m1.add(it4);
		
		mb1.add(m1);
		
		//2번쨰 메뉴 
        it5.addActionListener(this);
        it6.addActionListener(this);
        it7.addActionListener(this);
        
        m2.add(it5);
        m2.add(it6);
        m2.add(it7);
        
        mb1.add(m2); 
        
        setJMenuBar(mb1);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
	
}

public class Swing_Text {

	public static void main(String[] args) {
		SwingClass sc1=new SwingClass();
		
	}

}
