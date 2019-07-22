package Day046_Client_Server2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServerArg {

	public static void main(String[] args) throws NumberFormatException, IOException{
		
		if(args.length != 1) {
			System.out.println("사용법: 명령어인자로 포트번호를 넣으세요");
			System.exit(0);
		}
		
		ServerSocket ss1=new ServerSocket(Integer.parseInt(args[0]));
		
		while (true) {
			
			Socket s1 = ss1.accept();
			String serverInfo = s1.getInetAddress().getHostAddress();
			//get Server InetAddress --> get IP Address 
			
			BufferedReader br1=new BufferedReader(new InputStreamReader(s1.getInputStream()));
			
			BufferedWriter bw1=new BufferedWriter(new OutputStreamWriter(s1.getOutputStream()));
			
			bw1.write("서버는"+serverInfo+"이네요");
			bw1.newLine();
			bw1.flush();
			
			String bada1;
			while (true) {
				bada1 = br1.readLine();
				if(bada1 == null) break;
				System.out.println(bada1);
				bw1.write(bada1);
				bw1.newLine();
				bw1.flush();
			}
			s1.close();
			//run - run configuration
		}//while true end 
		
	}//main end

}
