package Day041_GUI_Swing4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;


class JColorChooserClass extends JFrame implements ActionListener{

	JButton jbutton1;
	JLabel jlabel1,jlabel2;
	Color color1;
	//생성자
	public JColorChooserClass() {
		setLayout(new FlowLayout());
		
		jbutton1 = new JButton("색을 골라봐");
		add(jbutton1);
		jbutton1.addActionListener(this);
		
		jlabel1 = new JLabel("나 이런색이야");
		jlabel1.setFont(new Font("굴림",Font.BOLD,32));
		add(jlabel1);
		
		jlabel2 = new JLabel("글고 color를 RGB로 표시해 볼까");
		jlabel2.setFont(new Font("굴림",Font.BOLD,32));
		add(jlabel2);
		
		setSize(700,400);
		setVisible(true);
	}//생성자 end
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jbutton1) {
			color1=JColorChooser.showDialog(jbutton1,"그림판 빠레트",Color.PINK);
			if(color1 !=null) {
			jlabel1.setForeground(color1);
//			jlabel2.setText(""+color1); //java.awt...[255,255,0]형식으로 나옴 
			jlabel2.setText("선택한 색은(R,G,B)"+color1.getRed()+","+color1.getGreen()+","+color1.getBlue());
			}
		}
	}// actionPerformed end
}//class end

public class JColorChooserMainClass {

	public static void main(String[] args) {

		new JColorChooserClass();
	}

}
