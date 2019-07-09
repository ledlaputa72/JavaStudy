package java_SwingGUI;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

class JConponentsClass2 extends JFrame implements ActionListener{

	//기본 레이아웃 컴퍼넌트 
	private JPanel contentPane,topPane,midPane,botPane;
	GridLayout gl1,glT;
	
	//상단 컴퍼넌트 ////////
	JLabel Jlb1;
	JTextField Jtf1;
	JButton jBtn1;
	JToggleButton jtBtn1,jtBtn2,jtBtn3,jtBtn4;
	ButtonGroup bg1,bg2; //라디오버튼용 그룹
	
	//중간 컴퍼넌트 /////////
	JRadioButton jrb1,jrb2,jrb3;
	JCheckBox jcb1,jcb2,jcb3;
	JComboBox jcombo;
	
	//하단 컴퍼넌트 ////////
	JList list;
	
	//생성자
	public JConponentsClass2() {
		//기본 contentPane 설정
		contentPane = new JPanel();
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 800, 600);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		
		gl1=new GridLayout(3,1);
		contentPane.setLayout(gl1);
		
		//3개의 서브 패널 설정
		topPane = new JPanel();
		midPane = new JPanel();
		botPane = new JPanel();
		//contentPane에 패널 add
		contentPane.add(topPane);
		contentPane.add(midPane);
		contentPane.add(botPane);
		
		glT=new GridLayout(1,7,5,5);
		topPane.setLayout(glT);
		midPane.setLayout(glT);
		botPane.setLayout(glT);
		
		//top패널에 컴퍼넌트 추가 
		topPane.add(Jlb1=new JLabel("다모아"));
		topPane.add(Jtf1=new JTextField("나진행률"));
		topPane.add(jBtn1=new JButton("눌러봐"));
		topPane.add(jtBtn1=new JToggleButton("원터치버튼")); //단독으로 실행 
		topPane.add(jtBtn2=new JToggleButton("PLAY")); //3개가 연결된 토글 버튼 
		topPane.add(jtBtn3=new JToggleButton("PASUE"));
		topPane.add(jtBtn4=new JToggleButton("STOP"));
		
		//mid패널에 컴퍼넌트 추가 
		midPane.add(jrb1 = new JRadioButton("재생")); //라디오버튼
		midPane.add( jrb2 = new JRadioButton("잠시멈춤"));
		midPane.add(jrb3 = new JRadioButton("멈춤"));
		
		midPane.add(jcb1=new JCheckBox("사과",true)); //체크버튼
		midPane.add(jcb2=new JCheckBox("배",false));
		midPane.add(jcb3=new JCheckBox("감",true));
		
		//토글버튼 그룹
		bg1=new ButtonGroup();
		bg1.add(jtBtn2);
		bg1.add(jtBtn3);
		bg1.add(jtBtn4);
		jtBtn2.setSelected(true);
		
		//라디오버튼 그룹
		bg2=new ButtonGroup();
		bg2.add(jrb1);
		bg2.add(jrb2);
		bg2.add(jrb3);
		jrb1.setSelected(true);
		
		String[] comboStr={"축구","농구","야구","배구","골프"}; //콤보박스용 내용 배열 
		jcombo=new JComboBox();
		for (int i = 0; i < comboStr.length; i++) {
			jcombo.addItem(comboStr[i]); //콤보박스
		}
		midPane.add(jcombo);
		
		//bot패널에 컴퍼넌트 추가
		String[] listStr={"서울","부산","대구","광주","인천"}; //콤보박스용 내용 배열 
		list = new JList(listStr);

		//crtl 위주 선택으로 건너뛰며 선택가능, shift사용도 가능 
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
		/*//Shift위주의 선택으로 시작, 끝범위로 선택 가능, ctrl사용가능
		list.setSelectionMode(ListSelectionModel.SINGLE_INTERVAL_SELECTION);
		//하나선택 only
		list.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);*/
		botPane.add(list);
	}
	
	//이벤트 리스너 
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	
}

public class JConponentsClass {

	public static void main(String[] args) {
		JConponentsClass2 jcc=new JConponentsClass2();
		jcc.setVisible(true);
	}

}
