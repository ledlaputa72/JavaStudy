package Day036_GUI_AWT4;

import java.awt.*;
import java.awt.event.*;

public class ImageClass extends Frame {
	
	static Image img1; //���α׷� ������� �����Ǵ� static 
	static String krim="aa.png";
	
	public void paint(Graphics g) {
		g.drawImage(img1, 0, 0, 640, 480, this);
	}
	
	public ImageClass() { //������
		//�ݱ�
		addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	}//������ end
		
	public static void main(String[] args) {
		ImageClass pc1=new ImageClass();
		img1=Toolkit.getDefaultToolkit().getImage(krim);
			//static Class //static method
			//��ü ������ �ʿ� ���� static 
		
		pc1.setTitle("�̹����ֱ�");
		pc1.setSize(640, 480);
		pc1.setResizable(true);
		pc1.setLayout(null);
		pc1.setVisible(true);
	}//main end

}//class end
