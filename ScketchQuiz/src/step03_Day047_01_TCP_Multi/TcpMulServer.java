package step03_Day047_01_TCP_Multi;

import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;
import javax.imageio.ImageIO;


//////////////////////////////////////////////////////////
class ServerClass {
	//collection�� ���� ���� ThreadServerClass only 
	//Vector
	//HashMap, Collection.synchronizedMap
	ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>(); //���׸�
	
	Socket socket; //Ŭ���̾�Ʈ �޾� ������ ��
	DataOutputStream outputStream; //��� ��Ʈ�� 
	
	public ServerClass(int portno) throws IOException, InterruptedException { //������ 
		Socket s1 = null;
		ServerSocket ss1 = new ServerSocket(portno); //�������� ���� Listen 
		System.out.println("��������......");
		
		while (true ) {
			s1 = ss1.accept(); //��ٸ��� �� 
			System.out.println("�����ּ� : "+ s1.getInetAddress() + ", ������Ʈ: "+s1.getPort());
			//#############################################################
			ServerRcvSend serverRS = new ServerRcvSend(s1);//s1�ʱ�ġ 
			ThreadServerClass tServer1 = new ThreadServerClass(s1);//s1�ʱ�ġ 
			serverRS.start();
			tServer1.start();
			
			threadList.add(tServer1);//�÷��ǿ� add
			//#############################################################
			System.out.println("������ �� : " + threadList.size()+" ��");
		}// while end
	}// ������ end
	
	// ���� ���� �����忡�� chat ���� ������.
	// sendChat() �޼ҵ� ���ǹ�
	public void sendChat(String chat) throws IOException {
		
		for (int i=0; i<threadList.size(); i++)
			threadList.get(i).outputStream.writeUTF(chat);
		
	}
	
	//#########################################
	//##    ������ ä�� Ŭ����                                                 ##
	//#########################################
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
	
	//#########################################
	//##    ������ �̹��� ��� Ŭ����                                       ##
	//#########################################
	class ServerRcvSend extends Thread {
		Socket s1;
		 
		BufferedInputStream bufferInput;
		BufferedOutputStream bufferOutput;
		
		BufferedImage bufferImage1; //�߰�)
		BufferedImage bufferImage2;
		 
		public ServerRcvSend(Socket s1) throws IOException, InterruptedException {
			this.s1 = s1;
			bufferInput = new BufferedInputStream(s1.getInputStream());
			bufferOutput = new BufferedOutputStream(s1.getOutputStream());
		}//������
	
		public void run() { //run
			try{
				while (true) {
					bufferImage1= ImageIO.read(bufferInput); //�߰�) ���� �����͸� ���ۿ� ����
					System.out.println("SR1) ���� �̹��� ����: " + bufferImage1); //�߰�) ���۳��� Ȯ��
					//�ޱ� ����#######################################
					System.out.println("1111################################################");
					System.out.println("SR2) ���� �̹��� ��Ʈ�� : " + bufferInput); //�߰�) ���� ��Ʈ�� ������ Ȯ�� 
					System.out.println("22222################################################");
					
					
					//���ۿ� ����############################################
					bufferImage2=bufferImage1;
					System.out.println("����1 :  " + bufferImage1);
					System.out.println("����2 :  " + bufferImage2 );
					
					
					//������##############################################
					System.out.println("SS1) ����2 :  " + bufferImage2 );
		
					ImageIO.write(bufferImage2, "bmp", bufferOutput);// �� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
					System.out.println("SS2) ������  �̹��� ���� : " + bufferImage2);
					bufferOutput.flush(); // ���ۿ� ���� �̹����� ������ ��
					System.out.println("SS3) ������ �̹��� : " + bufferOutput);
				
				}//while end
			}
			catch(Exception e) {
				System.out.println("ServerRcvSend �������� : " + e);
			}
		}//run end
	}//ServerRcv end
}// ServerClass end


public class TcpMulServer {

	public static void main(String[] args) throws IOException, InterruptedException {
		
		//new ServeClass()
		new ServerClass(9999);
		//��ü���� - �ʱ�ġ ������ 
	}

}

