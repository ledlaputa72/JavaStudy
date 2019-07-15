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
		
		//��ư�� ��
		jl1= new JLabel("0~100�� �󸶳� ������");
		jl1.setFont(new Font("����",Font.BOLD,35));
		jl1.setForeground(Color.MAGENTA);
		
		jl1.setVisible(true);
		add(jl1,"North");
		
		jb1=new JButton("�����");
		jb1.setFont(new Font("����",Font.BOLD,35));
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
			
			t1.scheduleAtFixedRate(new TimerTask(){ //�����ð��� �帣�� �ϴ� �޼ҵ� 
				public void run() {  
					kab=jpb1.getValue();
					kab++;
					jpb1.setValue(kab);
					jl1.setText("���� ���� ����  : "+(kab-1));
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
