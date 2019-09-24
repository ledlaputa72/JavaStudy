package Day046_Tcp_dis1;

import java.net.*;
import java.io.*;

public class TcpClient {
	public static void main(String args[]) throws UnknownHostException, IOException {

		Socket s1 = new Socket("127.0.0.1", 7778);
        
		///////////////////////////////////////////////
		DataInputStream dis1 = new DataInputStream(s1.getInputStream());
		System.out.println("As you said  " + dis1.readUTF());
         /////////////////////////////////////////////////////
		dis1.close();
		s1.close();
		System.out.println("Disconnected");

	}
}

