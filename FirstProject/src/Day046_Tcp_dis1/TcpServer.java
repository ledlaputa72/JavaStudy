package Day046_Tcp_dis1;

import java.net.*;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;

public class TcpServer {
	public static void main(String args[]) throws IOException {

		ServerSocket ss1 = new ServerSocket(7777);
		System.out.println("전화는 준비되어 있음....");

		while (true) {

			System.out.println("전화기다리는 중....");

			Socket s1 = ss1.accept();
			System.out.println(s1.getInetAddress() + "에서 전화왔네");
             
			/////////////////////////////
			DataOutputStream dos1 = new DataOutputStream(s1.getOutputStream());

			dos1.writeUTF("Long time no see man");//경석과미래
			
            //////////////////////////////////
			
			dos1.close();
			s1.close();

		}
	}
}
