package Day046_CS_Arg;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

public class EchoClientArg {

	public static void main(String[] args) throws UnknownHostException, IOException {
		
		if(args.length != 2) {
			System.out.println("사용법: 명령어인자로 포트번호를 넣으세요");
			System.exit(0);
		}
		
		Scanner sc1=new Scanner(System.in);
		
		Socket s = new Socket(args[0], Integer.parseInt(args[1]));
		
		BufferedReader br1= new BufferedReader(new InputStreamReader(s.getInputStream()));

		BufferedWriter bw1= new BufferedWriter(new OutputStreamWriter(s.getOutputStream()));
		
		System.out.println(br1.readLine());
		while (true) {
			System.out.println("글자를 넣어봐");
			String bada1forServer = sc1.nextLine();
			if(bada1forServer.length()==0)
				break;
			bw1.write(bada1forServer, 0, bada1forServer.length());
			//server로 보맨 // 키보드 받은것을 0번째부터 모든 길이만큼 전부다 전송 
			
			bw1.newLine();
			bw1.flush(); 
			String bada2fromServer = br1.readLine(); //serve로 부터 받음 
			System.out.println("서버로부터 다시 왔다는 "+ bada2fromServer);
		}
		s.close();
		//서버 실행후 클라이언트 
	}

}
