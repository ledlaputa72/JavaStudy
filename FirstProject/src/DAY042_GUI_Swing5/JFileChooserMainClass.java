package DAY042_GUI_Swing5;

import java.awt.*;
import java.awt.event.*;
import java.io.File;
import javax.swing.*;

class JFileChooserClass extends JFrame implements ActionListener {
	//components
	JFileChooser jfilechooser1; //파일 선택하는 클래스 - JFileChooser
	JButton jbutton1, jbutton2, jbutton3;
	JLabel jlabel1; 	
	
	//constructor ///////////////////////////////
	public JFileChooserClass() {
		setLayout(new FlowLayout());
		jfilechooser1 = new JFileChooser("c:");
		
		jbutton1 = new JButton("파일 골라봐");
		add(jbutton1);
		jbutton1.addActionListener(this);
		
		jbutton3 = new JButton("파일 저장");
		add(jbutton3);
		jbutton3.addActionListener(this);
		
		jlabel1 = new JLabel("파일경로가 나오는 곳");
		add(jlabel1);
		
		setSize(700,700);
		setVisible(true);
	} //constructor end
	
	@Override //event //////////////////////////
	public void actionPerformed(ActionEvent e) {
		//파일 열기
		if (e.getSource()==jbutton1) {
			int isOpenClose = jfilechooser1.showOpenDialog(jbutton1); 
			//showOpenDialog = 열기 대화상자, 반대는 showSaveDialog
			File filePath1 = jfilechooser1.getSelectedFile();
			//getSelectedFile = 대화상자에서 내가 파일을 선택하면 - 경로처리 
			//String fileString2 = jfilechooser1.getSelectedFile().getName();
			if(isOpenClose==JFileChooser.APPROVE_OPTION)
			{//0은 열기, 1은 저장
				jlabel1.setText("파일경로및 이름 :"+filePath1);
				//System.out.println(filePath1);
			}
		}
		//파일 저장
		if(e.getSource()==jbutton3) {
			int isOpenClose3 = jfilechooser1.showSaveDialog(jbutton3); 
			File filePath3 = jfilechooser1.getSelectedFile();
			if(isOpenClose3==JFileChooser.APPROVE_OPTION)
			{//0은 열기, 1은 저장
				jlabel1.setText("파일경로및 이름 :"+filePath3);
			}
		}
		
	} // event end
	
} //class end

public class JFileChooserMainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new JFileChooserClass();
		
	}//main end

}//main class end
