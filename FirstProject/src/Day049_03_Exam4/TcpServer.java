package Day049_03_Exam4;

import java.io.*;
import java.net.*;
import java.util.*;

class ThreadSend extends Thread{
	//필드
	Socket s1;
	DataOutputStream dos1;
	String what="";
	
	//생성자
	public ThreadSend(Socket s1) throws IOException {
		this.s1 = s1;
		dos1=new DataOutputStream(s1.getOutputStream());
		what="채팅중 >> ";
	}
	
	//run
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
} //ThreadSend end

class ThreadRcv extends Thread{
	//필드
	Socket s1;
	DataInputStream d1s1;
	
	//생성자
	public ThreadRcv(Socket s1) throws IOException {
		this.s1 = s1;
		d1s1=new DataInputStream(s1.getInputStream());
	}
	
	//run
	public void run() {
		while (d1s1!=null) {
			try {
				System.out.println(d1s1.readUTF());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
} //ThreadRcv end


public class TcpServer {

	public static void main(String[] args) throws  IOException {
		if (args.length != 1) {
			System.out.println("java 패키지.클래스 PortNo");
			System.exit(0);
		}
		
		ServerSocket ss1=new ServerSocket(Integer.parseInt(args[0]));
		System.out.println("정상 작동....");
		
		while (true) {
			System.out.println("대기중....");
			Socket s1=ss1.accept();
			System.out.println(s1.getInetAddress() + "에서 접속됨");
		
			//쓰레드 
			ThreadSend ts1=new ThreadSend(s1);
			ThreadRcv tr1=new ThreadRcv(s1);
			
			ts1.start();
			tr1.start();
		}

	}

}
