package Day049_03_Exam;

import java.io.*;
import java.net.*;
import java.util.Scanner;

//보내기 쓰레드
class ThreadSend extends Thread{
	//필드 소켓, 데이터스트림, 스트링
	Socket s1;
	DataOutputStream dos1;
	String what="";
	//생성자 
	public ThreadSend (Socket s1) throws IOException {
		this.s1 = s1;
		dos1= new DataOutputStream(s1.getOutputStream());
		what="미팅중===>";
	}
	//쓰레드 실행 
	public void run() {
		Scanner sc=new Scanner(System.in); //글자 입력하기 
		while (dos1 != null) {
			try {
				dos1.writeUTF(what+sc.nextLine());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
}

//받기 쓰레드 
class ThreadRcv extends Thread{
	//필드 
	Socket s1;
	DataInputStream dis1;
	//생성자
	public ThreadRcv(Socket s1) throws IOException {
		this.s1=s1;
		dis1=new DataInputStream(s1.getInputStream());
	}
	//쓰레드 실행
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
		// TODO Auto-generated method stub
		
		if(args.length !=1) {
            System.out.println("사용법은 java 파일명 포트번호");
            System.exit(1);
        }
		
		ServerSocket ss1=new ServerSocket(Integer.parseInt(args[0]));
		System.out.println("전화 준비 되어있음.....");
		
		while (true) {
			Socket s1= ss1.accept();
			System.out.println("전화 기다리는 중 ....");
			
			System.out.println(s1.getInetAddress()+"에서 전화 왔네");
			
			//쓰레드 작동 //////////////////////////
			
			ThreadSend ts1=new ThreadSend(s1);
			ThreadRcv tr1=new ThreadRcv(s1);
			
			ts1.start();
			tr1.start();
			
		}
	}
}
