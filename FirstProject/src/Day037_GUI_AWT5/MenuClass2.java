package Day037_GUI_AWT5;
//one class 방식 
import java.awt.CheckboxMenuItem;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class MenuClass2 extends Frame implements ActionListener{
	
	TextArea ta1;
	//생성자
	public MenuClass2 () {
		
		MenuBar mb1=new MenuBar(); //메뉴바 객체
		
		//1번째 메뉴 : 파일 메뉴의 객체, 아이템과 이벤트 리스너
		Menu m1=new Menu("파일");//1번 메뉴 객체 상위 
		
		MenuItem it1=new MenuItem("열기");
		MenuItem it2=new MenuItem("저장");
		MenuItem it3=new MenuItem("다름이름으로저장");
		MenuItem it4=new MenuItem("종료");
		
		it1.addActionListener(this);
		it2.addActionListener(this);
		it3.addActionListener(this);
		it4.addActionListener(this);
		
		m1.add(it1); //m1에 부메뉴 add (열기)
		m1.addSeparator();
		m1.add(it2); //저장
		m1.add(it3); //다름이름저장
		m1.addSeparator();
		m1.add(it4); //종료
		
		mb1.add(m1); //주메뉴(m1)를 메뉴바(mb1)에다 add
		
		//2번째 메뉴
		Menu m2=new Menu("편집");//2번 메뉴 객체 상위 
		
		MenuItem it5=new MenuItem("모두선택");
		CheckboxMenuItem it6=new CheckboxMenuItem("검색"); //메뉴 앞에 V(체크)가 표시되는 토글 방식 메뉴 아이템이다. 
		CheckboxMenuItem it7=new CheckboxMenuItem("복사");
		
		it5.addActionListener(this);
		it6.addActionListener(this);
		it7.addActionListener(this);
		
		m2.add(it5); 
		m2.add(it6); 
		m2.add(it7); 
		
		mb1.add(m2); //주메뉴(m1)를 부메뉴바(mb2)에다 add
		
		setMenuBar(mb1);
		
		ta1=new TextArea();
		add(ta1);
	
		
		//닫기
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); 
				System.exit(0);
			}
		});	//창 닫기
	}//생성자 종료
	

	public static void main(String[] args) {
		
		MenuClass2 mc1=new MenuClass2();
		mc1.setSize(500, 500);
		mc1.setTitle("메뉴");
		//mc1.pack();
		mc1.setVisible(true);
		
		
	}
	
	//이벤트 핸들러 //////////////////////////////////////////////////////////////////////////
	@Override
	public void actionPerformed(ActionEvent e) {
		//파일 열기 ///////////////////////////////////////////////////////////////////////
		if("열기".equals(e.getActionCommand())) { 
			FileDialog fd1= new FileDialog(this, "나 파일열기라는", FileDialog.LOAD); 
			fd1.setVisible(true);
			if (fd1.getFile()==null) {
				return; 
			}
			String fname1=fd1.getDirectory()+fd1.getFile();
			BufferedReader br1=null;
				try {
					br1 = new BufferedReader(new FileReader(fname1)); 
				} catch (FileNotFoundException e1) {
					e1.printStackTrace();
				} 
				ta1.setText(""); 
				
				//파일에서 읽어서 쓰기  ////////////////////////////////////////////
				String s1;
				try {
					while ((s1=br1.readLine())!=null) { 
						ta1.append(s1+"\n");
					}
				} catch (IOException e1) {
					e1.printStackTrace();
				}
				
				//읽기가 끝난 br1은 닫음 
				try {
					br1.close(); 
				} catch (IOException e1) {
					e1.printStackTrace();
				} 
				setTitle("열은파일은 "+fd1.getFile()); 
		}//파일 열기 끝
		
		
		
		//파일 다른이름으로 저장하기 
		else if("다름이름으로저장".equals(e.getActionCommand())) {
			FileDialog fd2= new FileDialog(this, "나 파일저장이라는", FileDialog.SAVE); 
			fd2.setVisible(true);
			if (fd2.getFile()==null) {
				return; //파일을 선택하지 않으면 종료 
			}
			
			//저장 위치를 선택한다. 
			String fname2=fd2.getDirectory()+fd2.getFile(); //저장할 폴더와 파일
			BufferedWriter bw1=null;
				try {
					bw1 = new BufferedWriter(new FileWriter(fname2)); //이줄만 치고나서 try~catch를 자동 생성
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} //
				
			try {
				bw1.write(ta1.getText());
				//이미 TextArea에 넣을때 이미 lineSkip(\n)이 있으므로 저장시에 줄바꿈이 된다. 
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				bw1.close();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			setTitle("저장파일은 "+fd2.getFile());
		}//파일 저장 종료
		
		//종료 버튼 
		else if ("종료".equals(e.getActionCommand())) {
			System.exit(0);
		}
	}//ActionPerformed() end
}//class end

