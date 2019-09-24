package Day049_03_Exam4;

import java.io.*;
import java.net.*;
import java.util.*;

class ThreadSend extends Thread {
	//Fields 
	Socket s1;
	DataOutputStream dos1;
	String what="";
	
	//constructor 
	public ThreadSend(Socket s1) throws IOException {
		this.s1 = s1;
		dos1 = new DataOutputStream(s1.getOutputStream());
		what="chat>>";
	}
	
	//run 
	public void run() {
		Scanner sc=new Scanner(System.in);
		while (dos1!=null) {
			try {
				dos1.writeUTF(what + sc.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} 
		}
	}
} //ThreadSend end

class ThreadRcv extends Thread {
	//Fields 
	Socket s1;
	DataInputStream dis1;
	
	//constructor 
	public ThreadRcv(Socket s1) throws IOException {
		this.s1 = s1;
		dis1 = new DataInputStream(s1.getInputStream());
	}
	
	//run 
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
} //ThreadRcv end

public class TcpServer {

	public static void main(String[] args) throws  IOException {

		if (args.length != 1) {
			System.out.println("java package.class portNO");
			System.exit(0);
		}
		
		ServerSocket ss1=new ServerSocket(Integer.parseInt(args[0])); //port 오픈 
		System.out.println("서버가 정상 가동됩니다. ");
		
		while (true) {
			System.out.println("Waiting ....");
			Socket s1=ss1.accept();
			System.out.println(s1.getInetAddress() + "에서 접속함");
			
			//Thread 
			ThreadSend ts1=new ThreadSend(s1);
			ThreadRcv tr1=new ThreadRcv(s1);
			
			ts1.start();
			tr1.start();
		}
	}

}
