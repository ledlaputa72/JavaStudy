package step06_04_SC2window_pireSendRcv_toDataStream;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.imageio.ImageIO;

//보내기 쓰레드 
public class ThreadSendClient extends Thread {
	Socket s1; //소켓
	BufferedImage imageSendC; //용 버퍼
	Robot robot; //스크린 캡쳐를 위한 로보트 
	DataOutputStream outputStreamC; //출려 스트림 클래스  
	
	public ThreadSendClient(Socket s1) throws IOException, AWTException {//생성자 ////
		this.s1 = s1;
		robot = new Robot();
		outputStreamC = new DataOutputStream(s1.getOutputStream()); //소켓 출력
	}//생성자 끝
	
	public void run() {

		try {
			while(true) {
				Painter.p2X=(int)Painter.p2.getLocationOnScreen().getX(); //좌표 변수를 만들고  static으로 변경
				Painter.p2Y=(int)Painter.p2.getLocationOnScreen().getY();
				imageSendC = robot.createScreenCapture(new Rectangle(Painter.p2X-0, Painter.p2Y-400, 400, 400));//스크린샷을 찍어서 image에 저장해
				ImageIO.write(imageSendC, "bmp", outputStreamC);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
				System.out.println("###클라 보내기 1) imageSendC: " + imageSendC);
				System.out.println("###클라 보내기 2) outputStreamC: " + outputStreamC);
				outputStreamC.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
			}}
		catch(Exception e) {
			System.out.println("에러출력 : "+ e);
		}//try end
	}//run end
}
