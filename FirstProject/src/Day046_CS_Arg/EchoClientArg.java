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
		
		if(args.length != 2) { //명령인자가 2개 IP/port 
			System.out.println("사용법: 명령어인자로 포트번호를 넣으세요");
			System.exit(0);
		}
		
		Scanner sc1=new Scanner(System.in);
		
		Socket s = new Socket(args[0], Integer.parseInt(args[1])); //IP/port 인자를 받는다. 
		
		BufferedReader br1= new BufferedReader(new InputStreamReader(s.getInputStream())); //글자 입력 --> 서버 보내기 
		// 버퍼리더 객체 = new 버퍼리더(new 인풋스트림리더(소스));

		BufferedWriter bw1= new BufferedWriter(new OutputStreamWriter(s.getOutputStream())); //글자 출력 <-- 서버에서 받아오기 
		
		System.out.println(br1.readLine()); // 받아온 br1소스를 출력 
		
		while (true) {
			//글자 입력 --> 서버로 보냄 
			System.out.println("글자를 넣어봐");
			String bada1forServer = sc1.nextLine(); //입력한 글자를 저장 
			if(bada1forServer.length()==0)   break; //읽을 글자가 없으면 나가기 
			bw1.write(bada1forServer, 0, bada1forServer.length());
			//server로 보냄 // 키보드 받은것을 0번째부터 모든 길이만큼 전부다 전송 
			
			//글자 출력<-- 서버에서 받아옴 
			bw1.newLine();
			bw1.flush(); 
			String bada2fromServer = br1.readLine(); //serve로 부터 받음  (위 버퍼드리더) 
			System.out.println("서버로부터 다시 왔다는 "+ bada2fromServer);
		}
		s.close();
		//서버 실행후 클라이언트 
	}

}
