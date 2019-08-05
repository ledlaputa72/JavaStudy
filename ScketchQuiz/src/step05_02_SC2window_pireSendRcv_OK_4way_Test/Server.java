package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

//서버
public class Server {
	
	public static BufferedImage imsi; // 받기용 버퍼 ####방법2)

	public static void main(String[] args) throws Exception {
		
		Painter frameClinet=new Painter(); //그림 그리기 포함 작동
		System.out.println("#####서버 작동");
		
//		new Server(); //클라이언트방식과 똑같이 생성자 호출
		ServerSocket ss1 = null;
		Socket s1 = null;

		ss1 = new ServerSocket(8989); //포트 열기 
		
		while(true) {
			s1 = ss1.accept(); // Listen 
			System.out.println("클라이언트 연결 완료! - 서버" + s1);
			
			//쓰레드////////////////////////////////////////
			
			EchoThreadServer ets=new EchoThreadServer(s1);
			ets.start();
			
			//화면 이미지 스크린샷 전송 - 쓰레드 처리 /////////////////////////////////////////////
//			ThreadSendServer threadSS=new ThreadSendServer(s1);
//			threadSS.start();
			
			//받고 출력하기 쓰레드
			/*ThreadRcvServer threadRS =new ThreadRcvServer(s1);
			threadRS.start();
			Thread.sleep(500);*/
			
		}//쓰레드////////////////////////////////////////
		
	}//main end
}