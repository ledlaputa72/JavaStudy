package java_SwingGUI;

import java.awt.AWTException;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

class CaptureClass extends JFrame{
	
	//GUI
	private Button b1=new Button("��üȭ��ĸ��");
	Robot robot1; //Ű���� ���콺 ����
	Dimension totWin1; //������Ʈ�� �ʺ�-����
	Rectangle rect1;
	BufferedImage bImage1;
	
	public CaptureClass() throws IOException, AWTException{
		add(b1);
		b1.setVisible(true);
		
		robot1=new Robot(); 
		totWin1= Toolkit.getDefaultToolkit().getScreenSize(); //��ũ�� �ľ��ϱ� //Toolkit : OS���� ��ȸ
		rect1=new Rectangle((int)totWin1.getWidth(),(int)totWin1.getHeight()); //ȭ��ũ���� �簢���� �غ�ȴ�. 
		//== new Rectangle(ȭ�鰡��, ȭ�鼼��);
		
		//ĸ���ϱ�
		bImage1 = robot1.createScreenCapture(rect1);
		ImageIO.write(bImage1, "jpg", new File("e:/aa.jpg"));
		
		setSize(200,200);
		setVisible(true);
	} //������ ����
} //Ŭ���� ���� 

public class CaptureMainClass {
	public static void main(String[] args) throws IOException, AWTException{
		CaptureClass cc1=new CaptureClass();
	}
}
