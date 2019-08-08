package Day049_03_Exam;

import java.io.*;
import java.net.*;
import java.util.Scanner;

//������ ������
class ThreadSend extends Thread{
	//�ʵ� ����, �����ͽ�Ʈ��, ��Ʈ��
	Socket s1;
	DataOutputStream dos1;
	String what="";
	//������ 
	public ThreadSend (Socket s1) throws IOException {
		this.s1 = s1;
		dos1= new DataOutputStream(s1.getOutputStream());
		what="������===>";
	}
	//������ ���� 
	public void run() {
		Scanner sc=new Scanner(System.in); //���� �Է��ϱ� 
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

//�ޱ� ������ 
class ThreadRcv extends Thread{
	//�ʵ� 
	Socket s1;
	DataInputStream dis1;
	//������
	public ThreadRcv(Socket s1) throws IOException {
		this.s1=s1;
		dis1=new DataInputStream(s1.getInputStream());
	}
	//������ ����
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
            System.out.println("������ java ���ϸ� ��Ʈ��ȣ");
            System.exit(1);
        }
		
		ServerSocket ss1=new ServerSocket(Integer.parseInt(args[0]));
		System.out.println("��ȭ �غ� �Ǿ�����.....");
		
		while (true) {
			Socket s1= ss1.accept();
			System.out.println("��ȭ ��ٸ��� �� ....");
			
			System.out.println(s1.getInetAddress()+"���� ��ȭ �Գ�");
			
			//������ �۵� //////////////////////////
			
			ThreadSend ts1=new ThreadSend(s1);
			ThreadRcv tr1=new ThreadRcv(s1);
			
			ts1.start();
			tr1.start();
			
		}
	}
}
