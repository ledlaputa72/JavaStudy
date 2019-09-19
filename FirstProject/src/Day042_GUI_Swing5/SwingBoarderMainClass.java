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
		//LineBorder : �ܼ��� �ܰ��� ����
		jb10=new JButton("LineBorder");
		jb11=new JButton("LineBorder");
		//BivelBorder : ��ü�� ��/�簢�� ����� ����
		jb20=new JButton("BevelBorder");
		jb21=new JButton("BevelBorder");
		jb22=new JButton("BevelBorder");
		jb23=new JButton("SoftBevelBorder");
		//��Ÿ ���� 
		jb30=new JButton("EmptyBorder"); //ȿ�� ����
		jb40=new JButton("MatteBorder"); //EmptyBorder�� ������� �߰� 
		jb50=new JButton("EtchedBorder"); //
		jb51=new JButton("EtchedBorder");
		jb60=new JButton("TitleBorder");
		jb61=new JButton("TitleBorder");
		
		jb10.setBorder(new LineBorder(Color.red));
		jb11.setBorder(new LineBorder(Color.red,10));
		
		jb20.setBorder(new BevelBorder(BevelBorder.RAISED)); //�������� �»�
		jb21.setBorder(new BevelBorder(BevelBorder.LOWERED)); //��ο���� �»�
		jb22.setBorder(new BevelBorder(BevelBorder.RAISED,Color.YELLOW,Color.BLUE)); 
		jb23.setBorder(new SoftBevelBorder(SoftBevelBorder.LOWERED)); //�����ڸ� ���� 
		
		jb30.setBorder(new EmptyBorder(10, 20, 30, 40)); //�� ���� �׵θ� ����
		jb40.setBorder(new MatteBorder(10, 20, 30, 40, Color.RED)); //�� ���� �׵θ� ����(RED)
		jb50.setBorder(new EtchedBorder());
		jb51.setBorder(new EtchedBorder(Color.CYAN, Color.MAGENTA));
		
		jb60.setBorder(new TitledBorder("Ÿ��Ʋ?"));
		jb61.setBorder(new TitledBorder(new TitledBorder("�̻�"),"����",TitledBorder.RIGHT,TitledBorder.ABOVE_TOP));
		
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
