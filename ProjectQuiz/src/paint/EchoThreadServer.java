package paint;

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
	BufferedInputStream inputStreamS; //입력 스트림 
	BufferedOutputStream outputStreamServer; //출려 스트림
	
	public EchoThreadServer(Socket s1) throws IOException {
		this.s1 = s1;
		inputStreamS = new BufferedInputStream(s1.getInputStream());
		outputStreamServer = new BufferedOutputStream(s1.getOutputStream());
	}
	//############################################################################
	//사용자의 포트번호를 알아야 한다. 
	//클라이언트 들은 자신의 포트 번호를 기억해야한다. 
	//그림 그리는 사람의 포트 번호를 서버가 알아야 한다. 
	//그외 유저들의 포트 번호와 유저수를 알아야 한다. 현재 게임 텀에서 유저 명단을 배열로 넣는다 (출제자 빠진 전체 인원 -1의 숫자 만큼 포트번호) 
	//보내기는 for문으로 유저수 만큼을  보내야 한다. 유저 포트번호 배열 이용 
	
	public void run() {
		try{
			while(true) {
				//받기/////////////////////////// 
				System.out.println("## 서버 받기1 inputStreamS : " + inputStreamS);
				PaintFrameGUI.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamS)), 0, 0, w, h, PaintFrameGUI.p2);
				System.out.println("## 서버 받기2 inputStreamS : " + inputStreamS);
				
				//보내기 /////////////////////////
				ImageIO.write(ImageIO.read(inputStreamS), "bmp", outputStreamServer); //
				System.out.println("## 서버 보내기1 outputStreamServer : " + outputStreamServer);
				outputStreamServer.flush(); //버퍼에 쓰인 이미지를d 서버로 보냄
				System.out.println("############서버 엔드 ################");
			}
		}
		catch(Exception e) {}
	}
}
