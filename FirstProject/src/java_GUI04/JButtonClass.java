package java_GUI04;
//one class 방식

import java.awt.FlowLayout;
import javax.swing.*;
 
public class JButtonClass extends JFrame{
	//컴퍼넌트 생성, 생성자 밖에서는 전역변수로
	JPanel jp1=new JPanel();
	JButton jb1=new JButton("사과"); 
	JButton jb2=new JButton("배");
	JButton jb3=new JButton("감");
	
	//생성자 
	public JButtonClass() {

		//컴퍼넌트 생성, 생성자 안에는 지역 변수로
		/*JButton jb1=new JButton("사과");
		JButton jb2=new JButton("배");
		JButton jb3=new JButton("감");*/
		
		setLayout(new FlowLayout());
		
		//JPanel위에 버튼을 붙인다. 
		jp1.add(jb1);
		jp1.add(jb2);
		jp1.add(jb3);
		//ContentPane : component가 올라가는 곳 
		//getContentPane : ContentPane을 알아내어 거기다가 add 
		getContentPane().add(jp1); 
		
		/*//JPanel이 없는 경우
		add(jb1); //this.add(jb1);과 동일 this가 생략 
		add(jb2);
		add(jb3);*/
		this.setTitle("버튼이야");
		this.setSize(300,200);
		this.setVisible(true);
		
	}
	
	public static void main(String[] args) {

		JButtonClass jbc1=new JButtonClass();
		/*		jbc1.setTitle("버튼이야");
				jbc1.setSize(300,200);
				jbc1.setVisible(true);*/
	}

}
