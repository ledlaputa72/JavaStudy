package step04_multiServerTest_GUI2;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.imageio.ImageIO;

//########################################################
//Ŭ���̾�Ʈ�� ���� ������ ������
//########################################################
class ThreadSend extends Thread{
	//�ʵ� ������Ʈ 
	Socket socket; //����
	static BufferedImage imageSend=null; //������ �� ����
	Robot robot; //��ũ�� ĸ�ĸ� ���� �κ�Ʈ 
	BufferedOutputStream outputStream; //��� ��Ʈ�� Ŭ����  
	
	public ThreadSend(Socket socket) throws IOException, AWTException {//������ ////
		this.socket = socket;
		robot = new Robot();
		
		outputStream = new BufferedOutputStream(socket.getOutputStream()); //���� ���
	}//������ ��
	
	public void run() {

		try {
			while(true) {
				//��ǥ �ٽ�##################################################################
				Painter.p2X=(int)Painter.p1.getLocationOnScreen().getX(); //��ǥ ������ �����  static���� ����
				Painter.p2Y=(int)Painter.p1.getLocationOnScreen().getY();
				//###########################################################################
				imageSend = robot.createScreenCapture(new Rectangle(Painter.p2X-0, Painter.p2Y-0, 400, 400));//��ũ������ �� image�� ������
				System.out.println("###������)�������� ����  : " + outputStream);
				
				ThreadRcv.imageRcv=imageSend; //�ޱ� ���ۿ� ������� ���� ���� ���� 
				
				ImageIO.write(imageSend, "bmp", outputStream);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
				outputStream.flush(); //���ۿ� ���� �̹����� ������ ����
			}}
		catch(Exception e) {
			System.out.println("������� : "+ e);
		}//try end
	}//run end
}//ThreadRcv end////////////////////////////////////////////

//########################################################
//Ŭ���̾�Ʈ�� ���� �ޱ� ������
//########################################################
class ThreadRcv extends Thread{
	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	//�ʵ� ������Ʈ 
	Socket socket;
	static BufferedImage imageRcv=null; //�ޱ�� ����
	BufferedInputStream inputStream;
	
	
	public ThreadRcv(Socket socket) throws IOException {//������////////////////
		this.socket = socket;
		inputStream = new BufferedInputStream(socket.getInputStream());
	}//������ ��
	
	
	public void run() {//run �޼ҵ� //////////////
	
		try {
			while(true) {
				System.out.println("###�ޱ�)���Ͽ��� ���� : " + inputStream);
				ThreadSend.imageSend=imageRcv; //�ޱ� ���ۿ� ������� ���� ���� ���� 
				Painter2.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStream)), 0, 0, w, h, Painter2.p2);
			}}
		catch(Exception e) {
			System.out.println("������� : "+ e);
		}//try end
	}//run end
}//ThreadRcv end////////////////////////////////////////////

//########################################################
//ServerClass
//########################################################
class ServerClass {
	//collection�� ���� ���� ThreadServerClass only 
	//Vector
	//HashMap, Collection.synchronizedMap
	static ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>(); //���׸�
	
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
	static void sendChat(String chat) throws IOException {
		
		for (int i=0; i<threadList.size(); i++)
			threadList.get(i).outputStream.writeUTF(chat);
	}
	
}// ServerClass end////////////////////////////////////////////


//########################################################
//������ ���� �ޱ� ������
//########################################################
class ThreadRcvServer extends Thread{
	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
		static int w = 400, h = 400; 
		static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
		
	
	//�ʵ� ������Ʈ 
	Socket socket;
	static BufferedImage imageRcv=null; //�ޱ�� ����
	BufferedInputStream inputStreamServer;
	
	public ThreadRcvServer(Socket socket) throws IOException {//������////////////////
		this.socket = socket;
		inputStreamServer = new BufferedInputStream(socket.getInputStream());
	}//������ ��
	
	public void run() {//run �޼ҵ� //////////////
	
		try {
			while(true) {
				imageRcv=ImageIO.read(inputStreamServer); //�����͸� �޾Ƽ� ���ۿ� ����
				System.out.println("$$$$$$���� �ޱ�1)���Ͽ��� ���� : " + inputStreamServer);
				ThreadSendServer.imageSend=imageRcv; //�ޱ� ���ۿ� ������� ���� ���� ����
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamServer)), 0, 0, w, h, Painter.p2);
				System.out.println("$$$$$$���� �ޱ�2)���Ͽ��� ���� : " + ThreadSendServer.imageSend);
			}}
		catch(Exception e) {
			System.out.println("������� : "+ e);
		}//try end
	}//run end
}//ThreadRcv end////////////////////////////////////////////

//########################################################
//������ ���� ������ ������
//########################################################
class ThreadSendServer extends Thread{
	//�ʵ� ������Ʈ 
	Socket socket; //����
	static BufferedImage imageSend; //������ �� ����
	BufferedOutputStream outputStreamServer; //��� ��Ʈ�� Ŭ����  
	
	public ThreadSendServer(Socket socket) throws IOException, AWTException {//������ ////
		this.socket = socket;
		outputStreamServer = new BufferedOutputStream(socket.getOutputStream()); //���� ���
		System.out.println("!!!!!!!!!!!!!!!!!!!!!!������ ���� ������ ����...");
	}//������ ��
	
	public void run() {
		try {
			while(true) {
				System.out.println("&&&&&&&&&����������1)�������� ����  : " + outputStreamServer);
//				ThreadRcvServer.imageRcv=imageSend; //�ޱ� ���ۿ� ������� ���� ���� ���� 
				System.out.println("&&&&&&&&&���� ������2)���Ͽ��� ���� : " + imageSend);
				ImageIO.write(imageSend, "bmp", outputStreamServer);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
				outputStreamServer.flush(); //���ۿ� ���� �̹����� ������ ����
			}}
		catch(Exception e) {
			System.out.println("������� : "+ e);
		}//try end
	}//run end
}//ThreadRcv end////////////////////////////////////////////

//########################################################
//ThreadServerClass
// �̾ȿ� �ޱ�� ������ �����带 ���� ��Ų��. 
//########################################################
class ThreadServerClass extends Thread {
	Socket socket1;
	DataInputStream inputStream;
	DataOutputStream outputStream;
	//�̹��� �ޱ� 

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
				ServerClass.sendChat(nickname + " �� ���� !!!(^^)");
			}
//			while (inputStream !=null) {
//				//System.out.printlin(inputStream.readUTF();
//				ServerClass.sendChat(inputStream.readUTF());
//				//Ŭ���̾�Ʈ�� ���� ä�� ������ ������ ��ο��� ����
//			}
			//##############################################
			//�ް� ����ϱ� ������
			//##############################################
			/*//Ŭ���̾�Ʈ �ޱ� 
			ThreadRcv threadR =new ThreadRcv(socket1);
			threadR.start();
			
			//ȭ�� �̹��� ��ũ���� ���� - ������ ó��
			ThreadSend ts1=new ThreadSend(socket1);
			ts1.start();*/
			//���� �ޱ�
			ThreadRcvServer threadRserver = new ThreadRcvServer(socket1);
			threadRserver.start();
			
			//���� ������
			ThreadSendServer threadSserver = new ThreadSendServer(socket1);
			threadSserver.start();
			
			//##############################################
			
			}
		catch(IOException | AWTException e) {
			e.printStackTrace();//�������� ����� ���Ϸ��� �ּ��ܴ�
			}
		finally {//���� �������� �ε��� ã�� 
			for (int i = 0; i < ServerClass.threadList.size(); i++) {
				if(socket1.equals(ServerClass.threadList.get(i).socket1)) {
					ServerClass.threadList.remove(i);
					//===============
					try {
						ServerClass.sendChat(nickname + " �� ����~~~ (�Ф�)");
					}catch(IOException e) {
						e.printStackTrace();
					}
					//===============
				}//if end
				
			}// for end
			System.out.println("������ �� : " + ServerClass.threadList.size()+ " ��");
		} // finally end
	} //run end
}// ThreadServerClass end


public class TcpMulServer {

	public static void main(String[] args) throws IOException, AWTException {
		Socket socket1 = null;
		Painter frameServer=new Painter(); //�׸� �׸��� ���� �۵�
		System.out.println("�׸��� �۵� - Ŭ���̾�Ʈ");
		
		//new ServeClass()
		new ServerClass(8888);

	}

}




