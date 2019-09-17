package step01_TCP_SC;

import java.io.*;
import java.net.*;

public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		ServerSocket ss=null;
		Socket soc=null;
		
		try {
			ss=new ServerSocket(12345);
			System.out.println("서버 대기중 ....");
			
			while(true) {
				soc=ss.accept();
				System.out.println("접속자 정보 : "+soc.toString());
				
				//서버 받기 /////////////////////////////////////////////////////////
				/*	InputStreamReader isr=new InputStreamReader(soc.getInputStream()); //소켓에서 받은 내용을 읽어온다. 
					BufferedReader br=new BufferedReader(isr);  //읽어온 내용을 버퍼에 기록한다. 
				*/		
				BufferedReader br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
				String msg=br.readLine();  //버퍼의 내용을 읽어서 msg로 저장하기 
				System.out.println("클라이언트에서 전송된 내용 : "+msg); //버퍼 내용을 출력한다. 
				
				//서버에서 받은 내용을 다시 클라이언트로 보내주기 ///////////////////// msg  내용을 보낸다. 
				BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())); //soc를 통해 네트워크로 보냄 
				bw.write(msg+"\n"); // 보낼 내용을 기록한다. 
				bw.flush();
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
