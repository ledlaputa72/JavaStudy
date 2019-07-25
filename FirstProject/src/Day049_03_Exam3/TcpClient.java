package Day049_03_Exam3;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class TcpClient {

	public static void main(String[] args) throws IOException {

		if (args.length != 2) {
			System.out.println("java package.javaclass IP portNO");
			System.exit(0);
		}
		
		Socket s1=new Socket(args[0], Integer.parseInt(args[1]));
		
		ThreadSend ts1=new ThreadSend(s1);
		ThreadRcv tr1=new ThreadRcv(s1);
		
		ts1.start();
		tr1.start();
	}

}
