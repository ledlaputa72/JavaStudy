package DAY041_GUI_Swing4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

class JOptionPaneClass extends JFrame implements ActionListener{
	
	private JButton jbutton1;
	private JButton jbutton2;
	private JButton jbutton3;
	String[] kwail = {"사과", "배","감","포도","멜론","수박","파인애플"};
	
	//생성자
	public JOptionPaneClass() {
		setLayout(new FlowLayout());
		jbutton1 = new JButton("Message 다이얼로그");
		jbutton1.addActionListener(this);
		add(jbutton1);
		
		jbutton2 = new JButton("Confirm 다이얼로그");
		jbutton2.addActionListener(this);
		add(jbutton2);
		
		jbutton3 = new JButton("Input 다이얼로그");
		jbutton3.addActionListener(this);
		add(jbutton3);
		
		setSize(700, 700);
		setVisible(true);
	}//생성자 end
	
	@Override //액션리스너 
	public void actionPerformed(ActionEvent e) {
		//MessageDialog 
		if (e.getSource()==jbutton1) {
			JOptionPane.showMessageDialog(jbutton1, "나는 메시지를 보여준다는","메시지제목",JOptionPane.INFORMATION_MESSAGE);
			//Error, Waring, Question, Plain(No mark) 
			//(jbutton1,.. -> 메시지박스가 jbutton1위에 뜬다. jbutton1위치에는 ParentComponent가 온다.
			//JOptionPane.showMessageDialog(null, "나는 메시지를 보여준다는","메시지제목",JOptionPane.INFORMATION_MESSAGE);
			//(null,.. -> 메시지박스가 화면 가운데 뜬다. 
		}
		//ConfirmDialog
		else if (e.getSource()==jbutton2) {
			int bada1 = JOptionPane.showConfirmDialog(jbutton2, "영화보러갈까요", "메시지제목", JOptionPane.YES_NO_CANCEL_OPTION,JOptionPane.WARNING_MESSAGE);
			//yes no, yes no cancel, ok cancel
			System.out.println(bada1);
			//yes = 0 , no = 1, cancel = 2			
			if (bada1==0) {
				JOptionPane.showMessageDialog(null, "영화를 보러갑니다.");
			}
			else if(bada1==1){
				JOptionPane.showMessageDialog(null, "영화를 안봅니다.");
			}
			else if(bada1==2){
				JOptionPane.showMessageDialog(null, "대답을 취소합니다.");
			}
		}
		//InputDialog
		else if (e.getSource()==jbutton3) {
			String bada2=(String)JOptionPane.showInputDialog(jbutton3, "과일중 골라봐", "메시지제목",JOptionPane.WARNING_MESSAGE,new ImageIcon("e:/color1.png"),kwail,kwail[5]); //배열의 5번째가 기본;
			System.out.println(bada2);
			if (bada2!=null) { //취소는 null
				JOptionPane.showMessageDialog(null, bada2);
			}
			//이름 입력 
			String irum=JOptionPane.showInputDialog("이름은요?");
			if (irum!=null) {
				JOptionPane.showMessageDialog(null, irum+"님, 주문 감사합니다.");
			}
		}
	}//액션리스너 end
	
}//클래스 end

public class JOptionPaneMainClass {

	public static void main(String[] args) {
		new JOptionPaneClass();
	}

}
