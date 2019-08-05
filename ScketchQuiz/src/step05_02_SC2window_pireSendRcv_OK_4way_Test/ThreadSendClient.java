package step05_02_SC2window_pireSendRcv_OK_4way_Test;

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
	Socket socket; //����
	BufferedImage imageSend=null; //������ �� ����
	static BufferedImage imsi=null; //�ӽ� ����
	Robot robot; //��ũ�� ĸ�ĸ� ���� �κ�Ʈ 
	BufferedOutputStream outputStream; //��� ��Ʈ�� Ŭ����  
	
	public ThreadSendClient(Socket socket) throws IOException, AWTException {//������ ////
		this.socket = socket;
		robot = new Robot();
		
		outputStream = new BufferedOutputStream(socket.getOutputStream()); //���� ���
	}//������ ��
	
	public void run() {

		try {
			while(true) {
				Painter.p2X=(int)Painter.p2.getLocationOnScreen().getX(); //��ǥ ������ �����  static���� ����
				Painter.p2Y=(int)Painter.p2.getLocationOnScreen().getY();
				imageSend = robot.createScreenCapture(new Rectangle(Painter.p2X-0, Painter.p2Y-400, 400, 400));//��ũ������ �� image�� ������
				System.out.println("###������)�������� ����  : " + outputStream);
				
				imsi=imageSend; //�ޱ� ���ۿ� ������� ���� ���� ���� 
				
				ImageIO.write(imageSend, "bmp", outputStream);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
				outputStream.flush(); //���ۿ� ���� �̹����� ������ ����
			}}
		catch(Exception e) {
			System.out.println("������� : "+ e);
		}//try end
	}//run end
}
