package step06_04_SC2window_pireSendRcv_toDataStream;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

//받기 쓰레드
public class ThreadRcvClient  extends Thread{
	//상수 서버 화면크기, 좌표(모니터 중앙) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	//필드 컴포넌트 
	Socket s1;
	DataInputStream inputStreamC;
	
	public ThreadRcvClient(Socket socket) throws IOException {//생성자////////////////
		this.s1 = socket;
		//BufferedStream 방식을 DataStream 방식으로 바꿈 (동일한 바이트 방식이라 동작의 차이 없음) 
		inputStreamC = new DataInputStream(socket.getInputStream());
	}//생성자 끝
	
	public void run() {//run 메소드 //////////////
	
		try {
			while(true) {
				//바이트로 받기 
				/*int len1=inputStreamC.readInt(); //서버가 보낸 파일 길이 먼저  받아옴
				   byte[] byteBae2=new byte[len1]; //길이만큼 배열을 잡음
				   inputStreamC.readFully(byteBae2);*/
				
				System.out.println("###클라 받기1) inputStreamC: " + inputStreamC);
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamC)), 0, 0, w, h, Painter.p2);
				}
			}
		catch(Exception e) {
			System.out.println("에러출력 : "+ e);
		}//try end
	}//run end
}
