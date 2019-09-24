package Day046_TCP_SC1;


import java.net.*;
import java.io.*;

public class TcpClient {
	
	public static void main(String args[]) 
			throws UnknownHostException, IOException {

		Socket s1 = new Socket("127.0.0.1", 7818);//client socket 
		
		BufferedReader br1 = 
		new BufferedReader(new InputStreamReader(s1.getInputStream()));
			//	BufferedWriter bw1 = 
	//	new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
		System.out.println(br1.readLine()+" is from server ");

		br1.close();
		s1.close();
		System.out.println("disconnected");

	}
}

