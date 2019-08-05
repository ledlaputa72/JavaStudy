package step06_02_SC2window_pireSendRcv_OK_4way_OK;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

public class EchoThreadServer extends Thread{
	static int w = 400, h = 400;
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	Socket s1; //소켓
	BufferedImage imageRcvS; // 받기용 버퍼
	BufferedImage imageSendS; //보내기 용 버퍼
	BufferedInputStream inputStreamS; //입력 스트림 
	BufferedOutputStream outputStreamServer; //출려 스트림
	
	public EchoThreadServer(Socket s1) throws IOException {
		this.s1 = s1;
		inputStreamS = new BufferedInputStream(s1.getInputStream());
		outputStreamServer = new BufferedOutputStream(s1.getOutputStream()); //소켓 출력
	}

	public void run() {

		try{
			while(true) {
				//받기 
						System.out.println("## 서버 받기1 inputStreamS : " + inputStreamS);
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamS)), 0, 0, w, h, Painter.p2);
						System.out.println("## 서버 받기3 inputStreamS : " + inputStreamS);
				//보내기 
				ImageIO.write(ImageIO.read(inputStreamS), "bmp", outputStreamServer); //
						System.out.println("## 서버 보내기2 outputStreamServer : " + outputStreamServer);
				outputStreamServer.flush(); //버퍼에 쓰인 이미지를d 서버로 보냄
						System.out.println("############서버 엔드 ################");
			}
		}
		catch(Exception e) {}
	}
}
