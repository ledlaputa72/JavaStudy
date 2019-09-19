package Day049_03_Exam2;

import java.io.*;
import java.net.*;
import java.util.*;

class ThreadSend extends Thread{
	Socket s1;
	DataOutputStream dos1;
	String what="";
	
	public ThreadSend (Socket s1) throws IOException {
		this.s1 = s1;
		dos1=new DataOutputStream(s1.getOutputStream());
		what="채팅:";
	}
	
	public void run() {
		Scanner sc=new Scanner(System.in);
		while (dos1!=null) {
			try {
				dos1.writeUTF(what+sc.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

class ThreadRcv  extends Thread{
	Socket s1;
	DataInputStream dis1;
	
	public ThreadRcv(Socket s1) throws IOException {
		this.s1 = s1;
		dis1=new DataInputStream(s1.getInputStream());
		
	}
	
	public void run() {
		while (dis1!=null) {
			try {
				System.out.println(dis1.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}

public class TcpServer {

	public static void main(String[] args) throws IOException {

		if(args.length != 1) {
			 System.out.println("사용 설명");
			 System.exit(0);
		}
		
		ServerSocket ss1=new ServerSocket(Integer.parseInt(args[0])); //포트 열어주기 
		System.out.println("전화기 정상 작동....");
		
		while (true) {
			System.out.println("연결 중....");
			Socket s1=ss1.accept(); //연결
						
			ThreadSend ts1=new ThreadSend(s1);
			ThreadRcv tr1 = new ThreadRcv(s1);
			
			ts1.start();
			tr1.start();
		}
	}
}
