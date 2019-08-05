package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

//클라
public class Client {

	//상수 서버 화면크기, 좌표(모니터 중앙) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	
	public static void main(String[] args) throws Exception {
		
		
		String serverip = "127.0.0.1";//접속 IP
		Socket socket = null; //통신 준비 
		System.out.println("클라이언트 준비완료");//일단 소켓생성
	
		//소켓으로 접속
		socket = new Socket(serverip, 9999); 
		System.out.println("접속완료 - 클라이언트1");
		
		//그림 기능 작동 
		Painter sc=new Painter(); //그림 그리기 작동
		System.out.println("그림판 작동 - 클라이언트");
		
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
	}//main end
}//Client class end



