package Day033_GUI_AWT1;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Frame;
import java.awt.TextField;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class TextFieldClass extends Frame {

	public TextFieldClass() { //생성자
		this.setLayout(new FlowLayout()); //this 자기자신을 참조하는 객체, FlowLayoutMainClass를 참조
		//가로 중앙정렬, 상하좌우 5픽셀간격
		//즉, 좌에서 우로 배치, 다시 다음줄 좌에서 우로 배치
		//같은 줄에서는 가운데 정렬
		//실행한 윈도우를 크기를 줄이거나 늘렸을때 자동적용 
		//setLayout(null)은 개발자 임의대로
		
		this.add(new Button("눌러봐")); //Button 내장 클래스 , 새로운 Button 객체를 만들고, add로 화면에 붙인다. 
		this.add(new Button("골라봐"));
		this.add(new Button("웬열?드립실드치지마"));
		this.add(new Button("뭥미?"));
		this.add(new Button("뭘 눌러?"));
		this.add(new Button("아무거나"));
		this.setSize(300, 300);
		this.setVisible(true);
		
		//창문 닫기 축약형/////////////////////////////////////////
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); //개발자가 직접 메모리의 내용을 지우는 명령
				System.exit(0);
			}
		});
		/////////////////////////////////////////////////////
	}//생성자 end
	
	public static void main(String[] args) {

		TextFieldClass tfc1=new TextFieldClass(); //메인프레임
		tfc1.setSize(500, 500);	
		tfc1.setTitle("텍스트필드란");
		tfc1.setLayout(new FlowLayout()); //행단위별 추가시 
		
		//TextField(글상자)///////////////////////////////////////
		TextField tf1=new TextField("길동홍으로 입력",20);
		//tf1.setEchoChar('*'); //화면에 처음 *로 출력되며 자료를 입력
		tf1.setFont(new Font("굴림",Font.BOLD, 24));
		
		tf1.setSize(200, 200);
		tf1.setVisible(true);
		
		tfc1.add(tf1);
		tfc1.setVisible(true);
		tfc1.addWindowListener(new WindowDada());
	}
}

