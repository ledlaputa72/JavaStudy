package Day046_Client_Server1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClient {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Scanner sc1=new Scanner(System.in);
		
		Socket s = new Socket("127.0.0.1", 7111); //connect 상태, Server의 ServerSocket이 대응하므로  
		// throws UnknownHostException, IOException 필요 
		
		BufferedReader br1= new BufferedReader(new InputStreamReader(s.getInputStream()));

		BufferedWriter bw1= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		while (true) {
			System.out.println("글자를 넣어봐");
			String bada1forServer = sc1.nextLine();
			if(bada1forServer.length()==0)
				break;
			bw1.write(bada1forServer, 0, bada1forServer.length());
			//server로 보냄 // 키보드 받은 것을 01번째부터 모든 길이만큼 전부다 전송
			bw1.newLine(); //줄바꿈도 보내고
			bw1.flush(); //무조건 전송한후 buffer비움 
			String bada2fromServer = br1.readLine(); //serve로 부터 받음 
			System.out.println("서버로부터 다시 왔다는 "+ bada2fromServer);
		}
		s.close();
		//실행은 서버먼저 run한 후  클라이언트 run
	}

}
