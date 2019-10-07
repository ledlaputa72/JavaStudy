package step06_04_SC2window_pireSendRcv_toDataStream;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

public class EchoThreadServer extends Thread{
	static int w = 400, h = 400;
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	Socket s1; //소켓
	DataInputStream inputStreamS; //입력 스트림 
	DataOutputStream outputStreamServer; //출려 스트림
	
	public EchoThreadServer(Socket s1) throws IOException {
		this.s1 = s1;
		//BufferedStream 방식을 DataStream 방식으로 바꿈 (동일한 바이트 방식이라 동작의 차이 없음) 
		inputStreamS = new DataInputStream(s1.getInputStream());
		outputStreamServer = new DataOutputStream(s1.getOutputStream()); 
	}

	public void run() {

		try{
			while(true) {
				//받기/////////////////////////// 
				System.out.println("## 서버 받기1 inputStreamS : " + inputStreamS);
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamS)), 0, 0, w, h, Painter.p2);
				System.out.println("## 서버 받기2 inputStreamS : " + inputStreamS);
				
				/*//보내기 처리 - byte 배열을 이용 - 
				byte[] byteBae = new byte[inputStreamS.readInt()];  //파일 길이만큼 배열 잡음
				System.out.println("file ---> byte중...");
				//자료 받기
				inputStreamS.readFully(byteBae); //파일내용 -->바이트배열
				//자료 보내기 
				outputStreamServer.writeInt(byteBae.length); //(중요)파일 길이 먼저  전송, 
				    //writeInt 바이트 단위로 정수로 보냄
				outputStreamServer.write(byteBae); //바이트 배열 전송
				*/				
				
				//보내기 /////////////////////////
				ImageIO.write(ImageIO.read(inputStreamS), "bmp", outputStreamServer); //
//				outputStreamServer.write(ImageIO.read(inputStreamS).TYPE_3BYTE_BGR);
				System.out.println("## 서버 보내기1 outputStreamServer : " + outputStreamServer);
				outputStreamServer.flush(); //버퍼에 쓰인 이미지를d 서버로 보냄
				System.out.println("############서버 엔드 ################");
			}
		}
		catch(Exception e) {}
	}
}
