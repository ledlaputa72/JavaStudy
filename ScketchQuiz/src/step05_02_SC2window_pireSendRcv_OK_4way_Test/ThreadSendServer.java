package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.AWTException;
import java.awt.image.BufferedImage;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;
import javax.imageio.ImageIO;

//서버 받기 스레드 클래스 
public class ThreadSendServer  extends Thread  {
	Socket s1; //소켓
	BufferedImage imageSendS; //보내기 용 버퍼
	BufferedOutputStream outputStreamServer; //출려 스트림 클래스  ////
	
	public ThreadSendServer(Socket s1) throws IOException, AWTException {//생성자 ////
		this.s1 = s1;
		outputStreamServer = new BufferedOutputStream(s1.getOutputStream()); //소켓 출력
	}
	
	public void run() {
		
//		try {
			while(true) {
					System.out.println("## 서버 보내기1 Server.imsi: " + Server.imsi);
				imageSendS=Server.imsi; //임시 버퍼에서 가져오기 
					System.out.println("## 서버 보내기2 imageSendS : " + imageSendS);
//				ImageIO.write(imageSendS, "bmp", outputStreamServer);
//					System.out.println("## 서버 보내기3 outputStreamServer : " + outputStreamServer);
//				outputStreamServer.flush(); //버퍼에 쓰인 이미지를d 서버로 보냄
//				Thread.sleep(100);
			}
//		} catch ( IOException e) {}
	}
}
