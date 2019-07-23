package Day046_Tcp_dis1_thread_1vs1;

import java.net.*;
import java.io.*;
import Day046_Tcp_dis1.TcpServer.*;

public class TcpClient {
	public static void main(String args[]) throws UnknownHostException, IOException {
      if(args.length !=2) {
          	 System.out.println("사용법은 java 파일명 ip주소 포트번호");
           	 System.exit(1);
      }
          
        Socket s1 = new Socket(args[0], Integer.parseInt(args[1]));  //ip address와 포트번호넣자는  
        
		/////////////////////////////////////////
        ThreadSend tsendcli1 = new ThreadSend(s1);//서버에서 정의됨 
          //객체만 추가하여 만들면된다 (class추가 안해도됨) 
        
		ThreadRcv trcvcli1 = new ThreadRcv(s1);  // 1: 1채팅 

		tsendcli1.start(); //Thread 
		trcvcli1.start(); //Thread 
		/////////////////////////////////////
		
	}
}
