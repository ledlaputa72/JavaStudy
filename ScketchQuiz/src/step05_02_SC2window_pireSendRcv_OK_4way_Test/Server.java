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

	public static void main(String[] args) throws Exception {
		
		Painter frameClinet=new Painter(); //그림 그리기 포함 작동
		System.out.println("그림판 작동 - 클라이언트");
		
		new Server(); //클라이언트방식과 똑같이 생성자 호출
	}//main end

	public Server() throws IOException { //생성자////////////////
	
		//통신 준비 
		ServerSocket socket_s = null;
		Socket socket = null;
		
		socket_s = new ServerSocket(9999); //포트 열기 
		socket = socket_s.accept(); // Listen 
		System.out.println("클라이언트 연결 완료! - 서버" + socket);

		//쓰레드////////////////////////////////////////
		try {
			//받고 출력하기 쓰레드
			ThreadRcvClient threadR =new ThreadRcvClient(socket);
			threadR.start();
			
			//화면 이미지 스크린샷 전송 - 쓰레드 처리 /////////////////////////////////////////////
			ThreadSendClient ts1=new ThreadSendClient(socket);
			ts1.start();
		}
		catch(Exception e) {
			System.out.println(e);
		}//try end
		//쓰레드////////////////////////////////////////
		
	}//생성자 end
}//Server Class end


