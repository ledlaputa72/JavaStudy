package Day047_01_TCP_Multi;

import java.io.*;
import java.net.*;
import java.util.*;


//////////////////////////////////////////////////////////
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
			System.out.println("������ �� : " + threadList.size()+" ��");
		}// while end
	}// ������ end
	
	// ���� ���� �����忡�� chat ���� ������.
	// sendChat() �޼ҵ� ���ǹ�
	public void sendChat(String chat) throws IOException {
		
		for (int i=0; i<threadList.size(); i++)
			threadList.get(i).outputStream.writeUTF(chat);
		
	}
	
	//////////////////////////////////////////////////
	class ThreadServerClass extends Thread {
		Socket socket1;
		DataInputStream inputStream;
		DataOutputStream outputStream;

		public ThreadServerClass(Socket s1) throws IOException { //������ 
			socket1 = s1;
			inputStream = new DataInputStream(s1.getInputStream());
			outputStream = new DataOutputStream(s1.getOutputStream());
			//����� ��Ʈ��
		}//������ end
		
		public void run() { //run
			String nickname = "";
			try {
				if(inputStream != null) {
					nickname = inputStream.readUTF();
					sendChat(nickname + " �� ���� !!!(^^)");
				}
				while (inputStream !=null) {
					//System.out.printlin(inputStream.readUTF();
					sendChat(inputStream.readUTF());
					//Ŭ���̾�Ʈ�� ���� ä�� ������ ������ ��ο��� ����
				}
			}
			catch(IOException e) {
				e.printStackTrace();//�������� ����� ���Ϸ��� �ּ��ܴ�
			}
			finally {//���� �������� �ε��� ã�� 
				for (int i = 0; i < threadList.size(); i++) {
					if(socket.equals(threadList.get(i).socket1)) {
						threadList.remove(i);
						//===============
						try {
							sendChat(nickname + " �� ����~~~ (�Ф�)");
						}catch(IOException e) {
							e.printStackTrace();
						}
						//===============
					}//if end
					
				}// for end
				System.out.println("������ �� : " + threadList.size()+ " ��");
			} // finally end
		} //run end
	}// ThreadServerClass end
}// ServerClass end

public class TcpMulServer {

	public static void main(String[] args) throws IOException {
		/*if(args.length != 1) {
			System.out.println("���� : ���������� "+" \'java ��Ű����.���ϸ� ��Ʈ��ȣ\' �������� �Է�");
		}*/
		
		//new ServeClass()
		new ServerClass(8888);
		//��ü���� - �ʱ�ġ ������ 
	}

}

