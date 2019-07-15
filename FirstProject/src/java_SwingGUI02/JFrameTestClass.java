package java_SwingGUI02;

import java.awt.*;
import java.awt.event.*;
import java.awt.event.*;
import javax.swing.*;

class JFrameTest extends JFrame implements ActionListener {
	//컴퍼넌트
	JLabel jlbl1,jlbl2,jlbl3;
	JButton jbtn1,jbtn2,jbtn3;
	JButton jbtn4,jbtn5,jbtn6;
	JButton jbtn7,jbtn8;
	String[] comboStr={"10대","20대","30대이상"}; //콤보박스용 내용 배열 
	JComboBox jcb1;
	static int sum;
	static String hangmok="";
	
	
	//생성자
	public JFrameTest() {
		setLayout(new GridLayout(4,3,30,30));
		
		//1행
		jlbl1=new JLabel("KG방송주관",JLabel.CENTER);
		jlbl2=new JLabel("비담선발대회",JLabel.CENTER);
		jlbl3=new JLabel("잘한코너는",JLabel.CENTER);
		
		jlbl1.setFont(new Font("굴림",Font.BOLD,20));
		jlbl2.setFont(new Font("굴림",Font.BOLD,20));
		jlbl3.setFont(new Font("굴림",Font.BOLD,20));
		
		this.add(jlbl1);
		this.add(jlbl2);
		this.add(jlbl3);
		
		//2행
		jbtn1=new JButton("노래10점");
		jbtn2=new JButton("댄스20점");
		jbtn3=new JButton("영어웅변30점");
		jbtn1.addActionListener(this);
		jbtn2.addActionListener(this);
		jbtn3.addActionListener(this);
		this.add(jbtn1);
		this.add(jbtn2);
		this.add(jbtn3);
		
		//3행
		jbtn4=new JButton("철인삼종경기100점");
		jbtn5=new JButton("미로탈출90점");
		jbtn6=new JButton("개그80점");
		jbtn4.addActionListener(this);
		jbtn5.addActionListener(this);
		jbtn6.addActionListener(this);
		this.add(jbtn4);
		this.add(jbtn5);
		this.add(jbtn6);
		
		//4행
		jbtn7=new JButton("눌러요");
		jbtn8=new JButton("취소");
		jcb1=new JComboBox(comboStr);
		
		jbtn7.setFont(new Font("굴림",Font.BOLD,20));
		jbtn8.setFont(new Font("굴림",Font.BOLD,20));
		jbtn7.setBackground(Color.CYAN);
		jbtn8.setBackground(Color.YELLOW);
		
		jbtn7.addActionListener(this);
		jbtn8.addActionListener(this);
		jcb1.addActionListener(this);
		this.add(jbtn7);
		this.add(jbtn8);
		this.add(jcb1);

		this.setSize(700,700);
		this.setVisible(true);
	}
	//이벤트
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jbtn1) {
//			JOptionPane.showMessageDialog(jbtn1, "노래10점");
			jbtn1.setEnabled(false);
			sum=sum+10;
			hangmok=hangmok+jbtn1.getText()+"\n";
		}
		else if(e.getSource()==jbtn2) {
//			JOptionPane.showMessageDialog(jbtn2, "댄스20점");
			jbtn2.setEnabled(false);
			sum=sum+20;
			hangmok=hangmok+jbtn2.getText()+"\n";
		}
		else if(e.getSource()==jbtn3) {
//			JOptionPane.showMessageDialog(jbtn3, "영어웅변30점");
			jbtn3.setEnabled(false);
			sum=sum+30;
			hangmok=hangmok+jbtn3.getText()+"\n";
		}
		else if(e.getSource()==jbtn4) {
//			JOptionPane.showMessageDialog(jbtn4, "철인삼종경기100점");
			jbtn4.setEnabled(false);
			sum=sum+100;
			hangmok=hangmok+jbtn4.getText()+"\n";
		}
		else if(e.getSource()==jbtn5) {
//			JOptionPane.showMessageDialog(jbtn5, "미로탈출90점");
			jbtn5.setEnabled(false);
			sum=sum+90;
			hangmok=hangmok+jbtn5.getText()+"\n";
		}
		else if(e.getSource()==jbtn6) {
//			JOptionPane.showMessageDialog(jbtn6, "개그80점");
			jbtn6.setEnabled(false);
			sum=sum+80;
			hangmok=hangmok+jbtn6.getText()+"\n";
		}
		else if(e.getSource()==jbtn7) {
			JOptionPane.showMessageDialog(jbtn7, hangmok+"최종점수는"+sum);
			hangmok="";
			sum=0;
		}
		else if(e.getSource()==jbtn8) {
			hangmok="";
			sum=0;
			JOptionPane.showMessageDialog(jbtn8, "취소 되었습니다.");
			jbtn1.setEnabled(true);
			jbtn2.setEnabled(true);
			jbtn3.setEnabled(true);
			jbtn4.setEnabled(true);
			jbtn5.setEnabled(true);
			jbtn6.setEnabled(true);
		}
		else if(e.getSource()==jcb1) {
				JOptionPane.showMessageDialog(jcb1, (String)jcb1.getSelectedItem());
		}
		
	}
	
}

public class JFrameTestClass {

	public static void main(String[] args) {
		JFrameTest jtest= new JFrameTest();

	}

}
