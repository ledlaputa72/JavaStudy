package Day049_03_Exam2;

import java.io.*;
import java.net.*;

public class TcpClient {

	public static void main(String[] args) throws IOException {
		
		if(args.length != 2) {
			System.out.println("설명");
			System.exit(0);
		}
		
		Socket s1=new Socket(args[0], Integer.parseInt(args[1])); //해당 IP 포트에 연결
		
			ThreadSend ts1=new ThreadSend(s1);
			ThreadRcv tr1 = new ThreadRcv(s1);
			
			ts1.start();
			tr1.start();
		
	}

}
