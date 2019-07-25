package Day049_03_Exam3;

import java.io.*;
import java.net.*;
import java.util.*;

//Thread 
class ThreadSend extends Thread {
	
	//fields
	Socket s1;
	DataOutputStream dos1;
	String what="";
	
	//constructor
	public ThreadSend(Socket s1) throws IOException {
		
		this.s1 = s1;
		dos1=new DataOutputStream(s1.getOutputStream());
		what="chat >>";
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
}

//Thread 
class ThreadRcv extends Thread {
	
	//fields
	Socket s1;
	DataInputStream dis1;
	
	//constructor
	public ThreadRcv(Socket s1) throws IOException {
		
		this.s1 = s1;
		dis1=new DataInputStream(s1.getInputStream());
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
}

public class TcpServer {

	public static void main(String[] args) throws  IOException {

		if (args.length != 1) {
			System.out.println("java package.javaclass portNO");
			System.exit(0);
		}
		//server intilize 
		ServerSocket ss1=new ServerSocket(Integer.parseInt(args[0]));
		System.out.println("server working well");
		
		while (true) {
			System.out.println("connection waiting...");
			Socket s1=ss1.accept();
			System.out.println(s1.getInetAddress() + " is Connection IP : Welcome in ");
			
			//Thread 
			ThreadSend ts1=new ThreadSend(s1);
			ThreadRcv tr1=new ThreadRcv(s1);
			
			ts1.start();
			tr1.start();
		}
	}
}
