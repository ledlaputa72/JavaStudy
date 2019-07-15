package java_SwingGUI02;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JButtonClass extends JFrame implements ActionListener{

	JLabel jl1=new JLabel("KG방송주관");
	JLabel jl2=new JLabel("비담선발대회");
	JLabel jl3=new JLabel("잘한 코너는");
	JButton jb1=new JButton("노래10점");
	JButton jb2=new JButton("댄스20점");
	JButton jb3=new JButton("영어웅변30점");
	JButton jb4=new JButton("철인삼종경기100점");
	JButton jb5=new JButton("미로탈출90점");
	JButton jb6=new JButton("개그80점");
	JButton jb7=new JButton("눌러요");
	JButton jb8=new JButton("취소");
	
	String[] age1={"10대","20대","30대이상"}; 
	JComboBox jcb1 = new JComboBox(age1);
	
	String hangmok=""; //빈문자열, 길이가 0인 문자열
	int jum=0;
	
	public JButtonClass() {
		setLayout(new GridLayout(0,3,30,30)); //0:임의의행 
		
		//1행
		jl1.setFont(new Font("굴림",Font.BOLD,25));
		add(jl1);
		jl2.setFont(new Font("굴림",Font.BOLD,25));
		add(jl2);
		jl3.setFont(new Font("굴림",Font.BOLD,25));
		add(jl3);
		//2행
		jb1.addActionListener(this);
		add(jb1);
		jb2.addActionListener(this);
		add(jb2);
		jb3.addActionListener(this);
		add(jb3);
		//3행
		jb4.addActionListener(this);
		add(jb4);
		jb5.addActionListener(this);
		add(jb5);
		jb6.addActionListener(this);
		add(jb6);
		//4행
		jb7.setFont(new Font("굴림",Font.BOLD,25));
		jb7.addActionListener(this);
		jb7.setForeground(Color.RED);
		jb7.setBackground(Color.CYAN);
		add(jb7);
		
		jb8.setFont(new Font("굴림",Font.BOLD,25));
		jb8.setForeground(Color.BLUE);
		jb8.setBackground(Color.YELLOW);
		jb8.addActionListener(this);
		add(jb8);
		 
		jcb1.addActionListener(this);
		add(jcb1);
		
		setTitle("KG방송국");
		setSize(700,700);
		setVisible(true);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource()==jb1) {
			hangmok+=jb1.getText()+"\n";
			jum=jum+10;
		}
		if (e.getSource()==jb2) {
			hangmok+=jb2.getText()+"\n";
			jum=jum+20;
		}
		if (e.getSource()==jb3) {
			hangmok+=jb3.getText()+"\n";
			jum=jum+30;
		}
		if (e.getSource()==jb4) {
			hangmok+=jb4.getText()+"\n";
			jum=jum+100;
		}
		if (e.getSource()==jb5) {
			hangmok+=jb5.getText()+"\n";
			jum=jum+90;
		}
		if (e.getSource()==jb6) {
			hangmok+=jb6.getText()+"\n";
			jum=jum+80;
		}
		if (e.getSource()==jb7) {
			String msg1=hangmok+"총점수는"+String.valueOf(jum)+"점";
			JOptionPane.showMessageDialog(jb7, msg1);
			hangmok=""; //전 처리내용 초기화
			jum=0;
		}
		if (e.getSource()==jb8) {
			hangmok=""; //전 처리내용 초기화
			jum=0;
			JOptionPane.showMessageDialog(jb8, "취소되었습니다");
		}
		//콤보박스 
		if (e.getSource()==jcb1) {
			JOptionPane.showMessageDialog(jcb1, (String)jcb1.getSelectedItem()+"이시군요");
			jum=jum+10;
		}
	}
	
}

public class JButtonMainCalss {

	public static void main(String[] args) {
		new JButtonClass();
	}

}
