package homestudy;

import java.awt.*;
import java.awt.event.*;

class BookStore extends Frame implements ActionListener{
	
	//Components /////////////////////////////////////////////
	private Frame mf=new Frame();
	
	private Panel p0=new Panel(); //상위 패널
	private Panel p1=new Panel(); //타이틀 패널
	private Panel p2=new Panel(); //버튼 패널
	private Panel p3=new Panel(); //텍스트 패널
	
	private BorderLayout blo= new BorderLayout();
	private FlowLayout flo=new FlowLayout();
	
	private GridLayout g0=new GridLayout(2,1); //상위 패널용
	private GridLayout g1=new GridLayout(1,1); //타이틀 패널용
	private GridLayout g2=new GridLayout(1,4); //버튼 패널용
	
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
//		lb1.setBounds(0, 50, 400, 50);
		
		//텍스트 에어리어 
		ta1.setSize(300, 300);
		ta1.setVisible(true);
		
		
		//버튼
		bt1.setFont(new Font("굴림",Font.BOLD,18));
		bt2.setFont(new Font("굴림",Font.BOLD,18));
		bt3.setFont(new Font("굴림",Font.BOLD,18));
		bt4.setFont(new Font("굴림",Font.BOLD,18));
		
		bt1.setBackground(new Color(0,255,255));
		bt2.setBackground(new Color(0,255,255));
		bt3.setBackground(new Color(0,255,255));
		bt4.setBackground(new Color(0,255,255));
		
		bt1.addActionListener(this);
		bt2.addActionListener(this);
		bt3.addActionListener(this);
		bt4.addActionListener(this);
		
		//North 패널 
		p0.setLayout(g0);
		p0.add(p1);
		p0.add(p2);
	
		//패널 타이틀 - North 
		p1.setLayout(g1);
		p1.setBackground(new Color(255,255,0));
		p1.add(lb1);
		
		//버튼  패널 - North
		p2.setLayout(g2);
		p2.add(bt1);
		p2.add(bt2);
		p2.add(bt3);
		p2.add(bt4);
		
		//패널 텍스트 
		p3.setLayout(g1);
		p3.add(ta1);
		
		//메인 프레임
		mf.setLayout(blo);
		mf.add("North",p0);
		mf.add("Center",p3);
		mf.setSize(frameWeith, frameHeigth);
		mf.setVisible(true);
		mf.setResizable(false);
		
		//닫기 
		mf.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				mf.dispose();
				System.exit(0);
			}
		});
	}//생성자 end
	
	//이벤트 핸들러 /////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e1) {
		if(e1.getSource()==bt1) {
			BookStore1 bs2=new BookStore1(500,500);
		}
		if(e1.getSource()==bt2) {
			BookStore2 bs2=new BookStore2(500,500);
		}
		if(e1.getSource()==bt3) {
			BookStore3 bs2=new BookStore3(500,500);
		}
		if(e1.getSource()==bt4) {
			BookStore4 bs2=new BookStore4(500,500);
		}
	}
	
}// BookStore class end

//서브 클래스 - BookStore1//////////////////////////////////////////
class BookStore1 extends Frame implements ActionListener{
	private Frame f1=new Frame();
	
	public BookStore1(int subFrameW, int subFrameH) {

		f1.setTitle("도서 검색");
		f1.setSize(subFrameW, subFrameH);
		f1.setVisible(true);
		f1.setResizable(false);
		
		//닫기 
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f1.dispose();
			}
		});
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}//서브 클래스 - BookStore1 end

//서브 클래스 - BookStore2 //////////////////////////////////////////////
class BookStore2 extends Frame implements ActionListener{
	private Frame f2=new Frame();
	
	public BookStore2(int subFrameW, int subFrameH) {
		
		f2.setTitle("도서 추가");
		f2.setSize(subFrameW, subFrameH);
		f2.setVisible(true);
		f2.setResizable(false);
		
		//닫기 
		f2.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f2.dispose();
			}
		});
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}//서브 클래스 - BookStore2 end

//서브 클래스 - BookStore3/////////////////////////////////////////////////////
class BookStore3 extends Frame implements ActionListener{
	private Frame f3=new Frame();
	
	public BookStore3(int subFrameW, int subFrameH) {
		
		f3.setTitle("도서 수정");
		f3.setSize(subFrameW, subFrameH);
		f3.setVisible(true);
		f3.setResizable(false);
		
		//닫기 
		f3.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f3.dispose();
			}
		});
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}//서브 클래스 - BookStore3 end

//서브 클래스 - BookStore4/////////////////////////////////////////////////////
class BookStore4 extends Frame implements ActionListener{
	private Frame f4=new Frame();
	
	public BookStore4(int subFrameW, int subFrameH) {

		f4.setTitle("도서 삭제");
		f4.setSize(subFrameW, subFrameH);
		f4.setVisible(true);
		f4.setResizable(false);
		
		//닫기 
		f4.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				f4.dispose();
			}
		});
	
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		
	}

}//서브 클래스 - BookStore3 end

// main 
public class BookStoreGUI {

	public static void main(String[] args) {
		BookStore bs1=new BookStore(700,700);
		
	}

}
