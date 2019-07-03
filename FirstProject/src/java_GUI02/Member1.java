package java_GUI02;
//선생니 문제 풀이 
import java.awt.*;
import java.awt.event.*;

import javax.swing.JOptionPane;

class Kaja1 extends Frame implements ActionListener{
	private Button btnJoin=new Button("가입하기");
	private Button btnCancel=new Button("가입취소");
	private Label label1=new Label("이름");
	private Label label2=new Label("전화번호");
	private Label label22=new Label("주소");
	private Label label3=new Label("선호하는종목");
	private Label label4=new Label("성별");
	private Label label5=new Label("가입인사말");
	// 객체 네이밍 btnJoin, lblName, txtName 형태로 형식과이름을 쓰는게 좋다. 
	private TextField txtName, txtPhone, txtJuso;
	private Checkbox chk1 = new Checkbox("야구",true);
	private Checkbox chk2 = new Checkbox("축구",true);
	private Checkbox chk3 = new Checkbox("골프",false);
	private Checkbox chk4 = new Checkbox("테니스",false);
	private CheckboxGroup checkboxGroup=new CheckboxGroup();
	private Checkbox chkMan = new Checkbox("남",checkboxGroup,true);
	private Checkbox chkWoman = new Checkbox("여",checkboxGroup,false);
	private TextArea textArea;
	
	public Kaja1() {//생성자
		this.setLayout(null);
		
		label1.setSize(30,20); //이름라벨 크기 
		label1.setLocation(50, 50); //이름라벨 위치
		this.add(label1); //붙이기
		
		txtName=new TextField(); //이름 글상자 생성
		txtName.setSize(100, 30); //이름 글상자 크기
		txtName.setLocation(130, 50); //이름 글상자 위치
		this.add(txtName); //붙이기 
		
		label2.setSize(50,20); //전화라벨 크기 
		label2.setLocation(50, 80); //전화라벨 위치
		this.add(label2); //붙이기
		
		txtPhone=new TextField(); //전화 글상자 생성
		txtPhone.setSize(100, 30); //전화 글상자 크기
		txtPhone.setLocation(130, 80); //전화 글상자 위치
		this.add(txtPhone); //붙이기 
		
		label22.setSize(50,20); //주소라벨 크기 
		label22.setLocation(50, 110); //주소라벨 위치
		this.add(label22); //붙이기
		
		txtJuso=new TextField(); //주소 글상자 생성
		txtJuso.setSize(100, 30); //주소 글상자 크기
		txtJuso.setLocation(130, 110); //주소글상자 위치
		this.add(txtJuso); //붙이기 
		
		label3.setSize(80,30); 
		label3.setLocation(20, 130);
		this.add(label3); 
		
		chk1.setSize(60,30); 
		chk1.setLocation(20, 160);
		this.add(chk1); 
		
		chk2.setSize(60,30); 
		chk2.setLocation(80, 160);
		this.add(chk2); 
		
		chk3.setSize(60,30); 
		chk3.setLocation(140, 160);
		this.add(chk3); 
		
		chk4.setSize(90,30); 
		chk4.setLocation(200, 160);
		this.add(chk4); 
		
		label4.setSize(50,30); 
		label4.setLocation(20, 200);
		this.add(label4); 
		
		chkMan.setSize(40,30); 
		chkMan.setLocation(20, 230);
		this.add(chkMan); 
		
		chkWoman.setSize(40,30); 
		chkWoman.setLocation(50, 230);
		this.add(chkWoman); 
		
		label5.setSize(70,30); 
		label5.setLocation(50, 270);
		this.add(label5); 
		
		textArea = new TextArea(5,50);
		textArea.setSize(200, 80);
		textArea.setLocation(50, 300);
		this.add(textArea);
		
		btnJoin.setSize(40, 30);
		btnJoin.setLocation(90, 400);
		this.add(btnJoin);
		btnJoin.addActionListener(this);
		
		btnCancel.setSize(40, 30);
		btnCancel.setLocation(150, 400);
		this.add(btnCancel);
		btnCancel.addActionListener(this);
		
		this.setTitle("회원가입");
		this.setSize(300, 500);
		this.setVisible(true);
		
		//닫기
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose();
				System.exit(0);
			}
		});	
		
	}//생성자 end

	//txtName, txtPhone, txtJuso;
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==btnJoin) {
			
			String info1="\n입력내용은 다음과 같습니다. ";
            info1+= "\n이름 :"+txtName.getText();
            info1+= "\n전화 :"+txtPhone.getText();
            info1+= "\n주소 :"+txtJuso.getText();
            info1+= "\n인사말 :"+textArea.getText();
            
            JOptionPane.showMessageDialog(null,txtName.getText()+"님  환영합니다."+info1);
			/*if (chk1.getState()==true) 
				JOptionPane.showMessageDialog(null,"취미 : "+chk1.getLabel());
			if (chk2.getState()==true) 
				JOptionPane.showMessageDialog(null,"취미 : "+chk2.getLabel());
			if (chk3.getState()==true) 
				JOptionPane.showMessageDialog(null,"취미 : "+chk3.getLabel());
			if (chk4.getState()==true) 
				JOptionPane.showMessageDialog(null,"취미 : "+chk4.getLabel());
			if (chkMan.getState()==true) 
				JOptionPane.showMessageDialog(null,"성별 : "+chkMan.getLabel());
			if (chkWoman.getState()==true) 
				JOptionPane.showMessageDialog(null,"성별 : "+chkWoman.getLabel());*/
		}
		else if(e.getSource()==btnCancel) {
			JOptionPane.showMessageDialog(null, "다음에 방문해주세요.");
		}
	}//이벤트 end
}//class end

public class Member1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new Kaja1();
	}

}
