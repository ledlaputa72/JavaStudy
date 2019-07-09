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
	private Button b1=new Button("전체화면캡쳐");
	Robot robot1; //키보드 마우스 제어
	Dimension totWin1; //컴포넌트의 너비-높이
	Rectangle rect1;
	BufferedImage bImage1;
	
	public CaptureClass() throws IOException, AWTException{
		add(b1);
		b1.setVisible(true);
		
		robot1=new Robot(); 
		totWin1= Toolkit.getDefaultToolkit().getScreenSize(); //스크린 파악하기 //Toolkit : OS정보 조회
		rect1=new Rectangle((int)totWin1.getWidth(),(int)totWin1.getHeight()); //화면크기의 사각형이 준비된다. 
		//== new Rectangle(화면가로, 화면세로);
		
		//캡쳐하기
		bImage1 = robot1.createScreenCapture(rect1);
		ImageIO.write(bImage1, "jpg", new File("e:/aa.jpg"));
		
		setSize(200,200);
		setVisible(true);
	} //생성자 종료
} //클래스 종료 

public class CaptureMainClass {
	public static void main(String[] args) throws IOException, AWTException{
		CaptureClass cc1=new CaptureClass();
	}
}
