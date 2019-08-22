package paint;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.imageio.ImageIO;

//������ ������ 
public class ThreadSendClient extends Thread {
	Socket s1; //����
	BufferedImage imageSendC; //�� ����
	Robot robot; //��ũ�� ĸ�ĸ� ���� �κ�Ʈ 
	BufferedOutputStream outputStreamC; //��� ��Ʈ�� Ŭ����  
	
	public ThreadSendClient(Socket s1) throws IOException, AWTException {//������ ////
		this.s1 = s1;
		robot = new Robot();
		outputStreamC = new BufferedOutputStream(s1.getOutputStream()); //���� ���
	}//������ ��
	
	public void run() {

		try {
			while(true) {
				//��ũ��ĸ�ĸ� ���� ȭ�� ���� (�̵��� ���� ���� ��ȭ����)
				PaintFrameGUI.p2X=(int)PaintFrameGUI.p2.getLocationOnScreen().getX(); //��ǥ ������ �����  static���� ����
				PaintFrameGUI.p2Y=(int)PaintFrameGUI.p2.getLocationOnScreen().getY();
				//��ũ�� ĸ�� �޾� �̹��� ���ۿ� ���� 
				imageSendC = robot.createScreenCapture(new Rectangle(PaintFrameGUI.p2X-0, PaintFrameGUI.p2Y-400, 400, 400));//��ũ������ �� image�� ������
				ImageIO.write(imageSendC, "bmp", outputStreamC);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
				System.out.println("###Ŭ�� ������ 1) imageSendC: " + imageSendC);
				System.out.println("###Ŭ�� ������ 2) outputStreamC: " + outputStreamC);
				outputStreamC.flush(); //���ۿ� ���� �̹����� ������ ����
			}}
		catch(Exception e) {
			System.out.println("������� : "+ e);
		}//try end
	}//run end
}
