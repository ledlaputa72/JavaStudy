package homestudy;

import java.awt.*;
import java.awt.event.*;

class BookStore extends Frame implements ActionListener{
	
	//Components /////////////////////////////////////////////
	private Frame f1=new Frame();
	
	private Panel p1=new Panel();
	private Panel p2=new Panel();
	private Panel p3=new Panel();
	
	private BorderLayout b1= new BorderLayout();
	private GridLayout g1=new GridLayout(1,2);
	private GridLayout g2=new GridLayout(1,4);
	
	private Label lb1=new Label("북스토어 관리 프로그램");
	private Label lb2=new Label();
	
	private Button bt1=new Button("도서 검색");
	private Button bt2=new Button("도서 추가");
	private Button bt3=new Button("도서 수정");
	private Button bt4=new Button("도서 삭제");
	
	private TextArea ta1=new TextArea("텍스트 에어리어",5,20);
	
	//생성자 //////////////////////////////////////////////////////////
	public BookStore(int frameWeith, int frameHeigth) {
		//라벨
		lb1.setText("서점 관리 프로그램");
		lb1.setFont(new Font("돋음",Font.BOLD,20));
		lb1.setAlignment(Label.CENTER);
		lb1.setBounds(0, 50, 400, 50);
		
		//텍스트 에어리어 
		ta1.setSize(300, 300);
		ta1.setVisible(true);
		
		//버튼
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		
		//패널 버튼 
		p1.setLayout(g1);
		p1.add(bt1);
		p1.add(bt2);
		p1.add(bt3);
		p1.add(bt4);
		
		//패널 타이틀 
		p2.setLayout(g2);
		p2.add(lb1);
		
		//패널 텍스트 
		p3.setLayout(g2);
		p3.add(ta1);
		
		//메인 프레임
		f1.setLayout(b1);
		f1.add("South",p1);
		f1.add("North",p2);
		f1.add("Center",p3);
		f1.setSize(frameWeith, frameHeigth);
		f1.setVisible(true);
		f1.setResizable(false);
		
		//닫기 
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f1.dispose();
				System.exit(0);
			}
		});
	}//생성자 end
	
	//이벤트 핸들러 /////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e1) {
		if(e1.getSource()==bt1) {
			
		}
	}
	
}// BookStore class end

// main 
public class BookStoreGUI {

	public static void main(String[] args) {
		BookStore bs1=new BookStore(700,700);
		
	}

}
