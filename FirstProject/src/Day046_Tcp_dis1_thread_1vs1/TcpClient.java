package Day046_Tcp_dis1_thread_1vs1;

import java.net.*;
import java.io.*;
import Day046_Tcp_dis1.TcpServer.*;

public class TcpClient {
	public static void main(String args[]) throws UnknownHostException, IOException {
      if(args.length !=2) {
          	 System.out.println("������ java ���ϸ� ip�ּ� ��Ʈ��ȣ");
           	 System.exit(1);
      }
          
        Socket s1 = new Socket(args[0], Integer.parseInt(args[1]));  //ip address�� ��Ʈ��ȣ���ڴ�  
        
		/////////////////////////////////////////
        ThreadSend tsendcli1 = new ThreadSend(s1);//�������� ���ǵ� 
          //��ü�� �߰��Ͽ� �����ȴ� (class�߰� ���ص���) 
        
		ThreadRcv trcvcli1 = new ThreadRcv(s1);  // 1: 1ä�� 

		tsendcli1.start(); //Thread 
		trcvcli1.start(); //Thread 
		/////////////////////////////////////
		
	}
}
