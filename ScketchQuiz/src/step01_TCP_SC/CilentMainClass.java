package step01_TCP_SC;

import java.net.*;
import java.io.*;

public class CilentMainClass {

	public static void main(String[] args) throws IOException {
		
		InetAddress ia=null;
		Socket soc=null;
		
		try {
			ia=InetAddress.getByName("localhost");
			soc=new Socket(ia, 12345);
			
			String msg="자바 네트워크 프로그램입니다."; //서버에서 받을 값 
			
			//클라이언트에서 서버로 내보내기 /////////////////////////////////////
			/*OutputStreamWriter osw=new OutputStreamWriter(soc.getOutputStream()); //soc(소켓)으로 내용을 내보낸다. 
			BufferedWriter bw=new BufferedWriter(osw); //버퍼에 담은 내용을 스트림으로 보낸다.  */	
					
			BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(soc.getOutputStream())); //soc를 통해 네트워크로 보냄 
			bw.write(msg+"\n"); // 보낼 내용을 기록한다. 
			bw.flush();//계속해서 보낸다. 
			
			//서버에서 온 메시지 //////////////////////////////////////////////
			BufferedReader br=new BufferedReader(new InputStreamReader(soc.getInputStream()));
			String msg2=br.readLine();
			System.out.println("서버에서 전송된 내용 : "+msg2); //버퍼 내용을 출력한다. 
			
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("클라이언트 끝");
	}

}
