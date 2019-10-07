package step04__SC2window_pireSendRcv_OK;

import java.awt.AWTException;
import java.awt.Toolkit;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.imageio.ImageIO;

public class Client2 {

	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	public static void main(String[] args) throws IOException, AWTException {

		String serverip = "127.0.0.1";//접속 IP
		Socket socket = null; //통신 준비 
		System.out.println("클라이언트 준비완료");//일단 소켓생성
	
			//소켓으로 접속
			socket = new Socket(serverip, 9999); 
			System.out.println("접속완료 - 클라이언트2");
			
			//그림 기능 작동 
			Painter sc2=new Painter(); //그림 그리기 작동
			System.out.println("그림판 작동 - 클라이언트");

			//소켓의 입력스트림을 버퍼스트림으로
			BufferedInputStream bin = new BufferedInputStream(socket.getInputStream());
			System.out.println("(클라)소켓으로 받음%%%%%%%%%%%%%%%%%%%%% ");
			//이미지를 받아오는 동시에 화면에 그림
			while(true) {
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bin)), 0, 0, w, h, Painter.p2);
			
			//화면 이미지 스크린샷 전송 - 쓰레드 처리 /////////////////////////////////////////////
			ThreadSend ts2=new ThreadSend(socket);
			ts2.start();
			}
	}

}
