package Day041_GUI_Swing4;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.plaf.ColorChooserUI;


class JColorChooserClass extends JFrame implements ActionListener{

	JButton jbutton1;
	JLabel jlabel1,jlabel2;
	Color color1;
	//������
	public JColorChooserClass() {
		setLayout(new FlowLayout());
		
		jbutton1 = new JButton("���� ����");
		add(jbutton1);
		jbutton1.addActionListener(this);
		
		jlabel1 = new JLabel("�� �̷����̾�");
		jlabel1.setFont(new Font("����",Font.BOLD,32));
		add(jlabel1);
		
		jlabel2 = new JLabel("�۰� color�� RGB�� ǥ���� ����");
		jlabel2.setFont(new Font("����",Font.BOLD,32));
		add(jlabel2);
		
		setSize(700,400);
		setVisible(true);
	}//������ end
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if (e.getSource()==jbutton1) {
			color1=JColorChooser.showDialog(jbutton1,"�׸��� ����Ʈ",Color.PINK);
			if(color1 !=null) {
			jlabel1.setForeground(color1);
//			jlabel2.setText(""+color1); //java.awt...[255,255,0]�������� ���� 
			jlabel2.setText("������ ����(R,G,B)"+color1.getRed()+","+color1.getGreen()+","+color1.getBlue());
			}
		}
	}// actionPerformed end
}//class end

public class JColorChooserMainClass {

	public static void main(String[] args) {

		new JColorChooserClass();
	}

}
