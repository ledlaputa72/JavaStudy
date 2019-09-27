package Day042_GUI_Swing5;

import java.awt.*;
import javax.swing.*;
import javax.swing.border.*;

public class SwingBoarderMainClass extends JFrame{
	
	JButton jb10,jb20,jb30,jb40,jb50,jb60;
	JButton jb11,jb21,jb22,jb23,jb51,jb61;
	TitledBorder tboarder10;
	
	public SwingBoarderMainClass() {
		getContentPane().setLayout(new GridLayout(0,5,20,20));
		//LineBorder : 단순한 외곽선 보더
		jb10=new JButton("LineBorder");
		jb11=new JButton("LineBorder");
		//BivelBorder : 입체로 음/양각이 생기는 보더
		jb20=new JButton("BevelBorder");
		jb21=new JButton("BevelBorder");
		jb22=new JButton("BevelBorder");
		jb23=new JButton("SoftBevelBorder");
		//기타 보더 
		jb30=new JButton("EmptyBorder"); //효과 없음
		jb40=new JButton("MatteBorder"); //EmptyBorder에 색상등을 추가 
		jb50=new JButton("EtchedBorder"); //
		jb51=new JButton("EtchedBorder");
		jb60=new JButton("TitleBorder");
		jb61=new JButton("TitleBorder");
		
		jb10.setBorder(new LineBorder(Color.red));
		jb11.setBorder(new LineBorder(Color.red,10));
		
		jb20.setBorder(new BevelBorder(BevelBorder.RAISED)); //밝은것이 좌상
		jb21.setBorder(new BevelBorder(BevelBorder.LOWERED)); //어두운것이 좌상
		jb22.setBorder(new BevelBorder(BevelBorder.RAISED,Color.YELLOW,Color.BLUE)); 
		jb23.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED)); //가장자리 음각 
		
		jb30.setBorder(new EmptyBorder(10, 20, 30, 40)); //각 방향 테두리 공간
		jb40.setBorder(new MatteBorder(10, 20, 30, 40, Color.RED)); //각 방향 테두리 공간(RED)
		jb50.setBorder(new EtchedBorder());
		jb51.setBorder(new EtchedBorder(Color.CYAN, Color.MAGENTA));
		
		jb60.setBorder(new TitledBorder("타이틀?"));
		jb61.setBorder(new TitledBorder(new TitledBorder("미생"),"오예",TitledBorder.RIGHT,TitledBorder.ABOVE_TOP));
		
		getContentPane().add(jb10);
		getContentPane().add(jb11);
		getContentPane().add(jb20);
		getContentPane().add(jb21);
		getContentPane().add(jb22);
		getContentPane().add(jb23);
		getContentPane().add(jb30);
		getContentPane().add(jb40);
		getContentPane().add(jb50);
		getContentPane().add(jb51);
		getContentPane().add(jb60);
		getContentPane().add(jb61);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SwingBoarderMainClass sbc1=new SwingBoarderMainClass();
		sbc1.setSize(800, 800);
		sbc1.setVisible(true);
	}

}
