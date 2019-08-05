package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.imageio.ImageIO;

//보내기 쓰레드 
public class ThreadSendClient extends Thread {
	Socket socket; //소켓
	BufferedImage imageSend=null; //보내기 용 버퍼
	static BufferedImage imsi=null; //임시 버퍼
	Robot robot; //스크린 캡쳐를 위한 로보트 
	BufferedOutputStream outputStream; //출려 스트림 클래스  
	
	public ThreadSendClient(Socket socket) throws IOException, AWTException {//생성자 ////
		this.socket = socket;
		robot = new Robot();
		
		outputStream = new BufferedOutputStream(socket.getOutputStream()); //소켓 출력
	}//생성자 끝
	
	public void run() {

		try {
			while(true) {
				Painter.p2X=(int)Painter.p2.getLocationOnScreen().getX(); //좌표 변수를 만들고  static으로 변경
				Painter.p2Y=(int)Painter.p2.getLocationOnScreen().getY();
				imageSend = robot.createScreenCapture(new Rectangle(Painter.p2X-0, Painter.p2Y-400, 400, 400));//스크린샷을 찍어서 image에 저장해
				System.out.println("###보내기)소켓으로 보냄  : " + outputStream);
				
				imsi=imageSend; //받기 버퍼에 보내기용 버퍼 내용 붙임 
				
				ImageIO.write(imageSend, "bmp", outputStream);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
				outputStream.flush(); //버퍼에 쓰인 이미지를 서버로 보냄
			}}
		catch(Exception e) {
			System.out.println("에러출력 : "+ e);
		}//try end
	}//run end
}
