package Day047_TCP_Multi;

import java.io.*;
import java.net.*;
import java.util.*;

class ServerClass {
	//collection�� ���� ���� ThreadServerClass only 
	//Vector
	//HashMap, Collection.synchronizedMap
	ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>(); //���׸�
	
	Socket socket; //Ŭ���̾�Ʈ �޾� ������ ��
	DataOutputStream outputStream; //��� ��Ʈ�� 
	
	public ServerClass(int portno) throws IOException { //������ 
		Socket s1 = null;
		ServerSocket ss1 = new ServerSocket(portno); //�������� ���� Listen 
		System.out.println("��������......");
		
		while (true ) {
			s1 = ss1.accept(); //��ٸ��� �� 
			System.out.println("�����ּ� : "+ s1.getInetAddress() + ", ������Ʈ: "+s1.getPort());
			//===================================================
			ThreadServerClass tServer1 = new ThreadServerClass(s1);//s1�ʱ�ġ 
			tServer1.start();
			threadList.add(tServer1);//�÷��ǿ� add
			//=====================================================
			System.out.println("������ �� : " + threadList.size());
		}//while end
	}
	
}

class ThreadServerClass{

	public ThreadServerClass(Socket s1) {
		
	}
	
}


public class TcpMulServer {

	public static void main(String[] args) throws NumberFormatException, IOException {
		if(args.length != 1) {
			System.out.println("���� : ���������� "+" \'java ��Ű����.���ϸ� ��Ʈ��ȣ\' �������� �Է�");
		}
		
		//new ServeClass()
		new ServerClass(Integer.parseInt(args[0]));
		//��ü���� - �ʱ�ġ ������ 
	}

}

