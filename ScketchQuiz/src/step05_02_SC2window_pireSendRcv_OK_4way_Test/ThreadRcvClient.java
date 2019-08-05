package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

//받기 쓰레드
public class ThreadRcvClient  extends Thread{
	//상수 서버 화면크기, 좌표(모니터 중앙) 
		static int w = 400, h = 400; 
		static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
		
		//필드 컴포넌트 
		Socket socket;
		BufferedImage imageRcv=null; //받기용 버퍼
		BufferedInputStream inputStream;
		
		public ThreadRcvClient(Socket socket) throws IOException {//생성자////////////////
			this.socket = socket;
			inputStream = new BufferedInputStream(socket.getInputStream());
		}//생성자 끝
		
		public void run() {//run 메소드 //////////////
		
			try {
				while(true) {
					System.out.println("###받기)소켓에서 받음 : " + inputStream);
					ThreadSendClient.imsi=imageRcv; //받기 버퍼에 보내기용 버퍼 내용 붙임 
					Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStream)), 0, 0, w, h, Painter.p2);
				}}
			catch(Exception e) {
				System.out.println("에러출력 : "+ e);
			}//try end
		}//run end
}
