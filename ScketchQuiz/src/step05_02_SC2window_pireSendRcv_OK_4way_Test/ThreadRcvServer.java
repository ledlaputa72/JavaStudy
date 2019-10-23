package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

//서버 보내기 스레드 클래스 
public class ThreadRcvServer  extends Thread {
	// 상수 서버 화면크기, 좌표(모니터 중앙)
	static int w = 400, h = 400;
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	// 필드 컴포넌트
	Socket s1;
	BufferedImage imageRcvS; // 받기용 버퍼
//	BufferedImage imsi; // 받기용 버퍼 ####방법2)
	static BufferedInputStream inputStreamS;

	public ThreadRcvServer(Socket s1) throws IOException {// 생성자////////////////
		this.s1 = s1;
		inputStreamS = new BufferedInputStream(s1.getInputStream());
	}// 생성자 끝

	public void run() {// run 메소드 //////////////

		
		try {
			while(true) {
				System.out.println("## 서버 받기1 inputStreamS : " + inputStreamS);
				imageRcvS = ImageIO.read(inputStreamS); // 데이터를 받아서 버퍼에 저장
					System.out.println("## 서버 받기2 imageRcvS : " + imageRcvS);
				Server.imsi = imageRcvS; //임시 버퍼로 저장
					System.out.println("## 서버 받기3 Server.imsi : " + Server.imsi);
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamS)), 0, 0, w, h, Painter.p2);
				//				Thread.sleep(100);
				System.out.println("## 서버 받기4 inputStreamS : " + inputStreamS);
			}
		} catch (Exception e) {
			System.out.println("에러출력 : " + e);
		} // try end
	}// run end
}
