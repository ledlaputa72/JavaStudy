package Day046_TCP_SC1;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpServer {//저장시 .class 생성되고 실행은 x
	
	public static void main(String args[]) throws IOException {
		
	ServerSocket ss1 = new ServerSocket(7818); //port no.
		System.out.println("전화는 준비되어 있음....");
		
		while (true) {////////////
			System.out.println("전화기다리는 중....");

			Socket s1 = ss1.accept();//기다리는 중
			System.out.println(s1.getInetAddress() + "에서 전화왔네");
                               //전화기에 찍힌 상대방번호 
			BufferedWriter bw1 = 
		new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
			                               
			bw1.write ("How are you today.");////////
			bw1.newLine();   bw1.flush();///////////
			
			System.out.println("뚝~~~");
			bw1.close();	s1.close();
		}//while-end
	}
}
