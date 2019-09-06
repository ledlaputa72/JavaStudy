package Day049_03_Exam;

import java.io.*;
import java.net.*;

public class TcpClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		if (args.length!=2) {
			System.out.println("사용법은 java 파일명 ip주소 포트번호 ");
			System.exit(0);
		}
		
		Socket s1=new Socket(args[0],Integer.parseInt(args[1])); //IP, Port

		//쓰레드 실행
		ThreadSend ts1=new ThreadSend(s1);
		ThreadRcv tr1=new ThreadRcv(s1);
		
		ts1.start();
		tr1.start();
	}

}
