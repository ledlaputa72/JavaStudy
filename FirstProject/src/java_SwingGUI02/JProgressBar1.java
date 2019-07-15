package java_SwingGUI02;

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import java.util.Timer;
import javax.swing.*;

class JPrograssBar2 extends JFrame implements ActionListener{
	//components
	JProgressBar jpb1;
	JLabel jl1;
	JButton jb1;
	int kab, kab2;
	
	//constructor
	public JPrograssBar2() {
		setLayout(new BorderLayout());
		
		jpb1=new JProgressBar();
		jpb1.setMinimum(0);
		jpb1.setMaximum(100);
		jpb1.setValue(0);
		jpb1.setBackground(Color.YELLOW);
		jpb1.setForeground(Color.BLUE);
		
		jpb1.setVisible(true);
		add(jpb1,"Center");
		
		//버튼과 라벨
		jl1= new JLabel("0~100중 얼마나 갔는지");
		jl1.setFont(new Font("굴림",Font.BOLD,35));
		jl1.setForeground(Color.MAGENTA);
		
		jl1.setVisible(true);
		add(jl1,"North");
		
		jb1=new JButton("가즈아");
		jb1.setFont(new Font("굴림",Font.BOLD,35));
		jb1.setForeground(Color.MAGENTA);
		
		jb1.setVisible(true);
		add(jb1,"South");
		jb1.addActionListener(this);
		
		this.setSize(700,700);
		this.setVisible(true);
	}//constructor end
	
	@Override//event
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==jb1) {
			jb1.setEnabled(false);
			Timer t1=new Timer();
			
			t1.scheduleAtFixedRate(new TimerTask(){ //일정시간을 흐르게 하는 메소드 
				public void run() {  
					kab=jpb1.getValue();
					kab++;
					jpb1.setValue(kab);
					jl1.setText("현재 나의 값은  : "+(kab-1));
				} 
			},1000,70);
		}
	}//event end 
	
}//class end

public class JProgressBar1 {

	public static void main(String[] args) {
		JPrograssBar2 jpb2=new JPrograssBar2();
	}//main end

}//main class end
