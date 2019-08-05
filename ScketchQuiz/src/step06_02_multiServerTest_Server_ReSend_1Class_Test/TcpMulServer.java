package step06_02_multiServerTest_Server_ReSend_1Class_Test;

import java.awt.AWTException;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;
import java.util.*;

import javax.imageio.ImageIO;

// ########################################################
// ServerClass
// ########################################################
class ServerClass {
	// collection�� ���� ���� ThreadServerClass only
	// Vector
	// HashMap, Collection.synchronizedMap
	static ArrayList<ThreadServerClass> threadList = new ArrayList<ThreadServerClass>(); // ���׸�

	DataOutputStream outputStream; // ��� ��Ʈ��

	public ServerClass(int portno) throws IOException, AWTException { // ������
		Socket s1 = null;
		ServerSocket ss1 = new ServerSocket(portno); // �������� ���� Listen
		System.out.println("��������......");

		while (true) {
			s1 = ss1.accept(); // ��ٸ��� ��
			System.out.println("�����ּ� : " + s1.getInetAddress() + ", ������Ʈ: " + s1.getPort());

			// ===================================================
			ThreadServerClass tServer1 = new ThreadServerClass(s1);// s1�ʱ�ġ
			tServer1.start();
			threadList.add(tServer1);// �÷��ǿ� add

			System.out.println("������ �� : " + threadList.size() + " ��");

			// ���� �ޱ� //////////////////////////////
			EchoThreadServer ets = new EchoThreadServer(s1);
			ets.start();
			/////////////////////////////////////////
			// =====================================================

		} // while end
	}// ������ end

	// ���� ���� �����忡�� chat ���� ������.
	// sendChat() �޼ҵ� ���ǹ�
	static void sendChat(String chat) throws IOException {

		for (int i = 0; i < threadList.size(); i++)
			threadList.get(i).dataOutputStream.writeUTF(chat);
	}

}// ServerClass end////////////////////////////////////////////

// ########################################################
// ThreadServerClass
// �̾ȿ� �ޱ�� ������ �����带 ���� ��Ų��.
// ########################################################
class ThreadServerClass extends Thread {
	Socket s1;
	DataInputStream dataInputStream;
	DataOutputStream dataOutputStream;
	// �̹��� �ޱ�

	public ThreadServerClass(Socket s1) throws IOException { // ������
		this.s1 = s1;
		dataInputStream = new DataInputStream(s1.getInputStream());
		dataOutputStream = new DataOutputStream(s1.getOutputStream());
		// ����� ��Ʈ��
	}// ������ end

	public void run() {
		// run
		/*String nickname = "";
		try {
			if (dataInputStream != null) {
				nickname = dataInputStream.readUTF();
				ServerClass.sendChat(nickname + " �� ���� !!!(^^)");
			}
			
			// ���� �ޱ� //////////////////////////////
			EchoThreadServer ets=new EchoThreadServer(s1);
			ets.start();
			/////////////////////////////////////////
			
		} catch (IOException e) { //
			e.printStackTrace();// �������� ����� ���Ϸ��� �ּ��ܴ�
		} finally {// ���� �������� �ε��� ã��
			for (int i = 0; i < ServerClass.threadList.size(); i++) {
				if (s1.equals(ServerClass.threadList.get(i).s1)) {
					ServerClass.threadList.remove(i);
					// ===============
					try {
						ServerClass.sendChat(nickname + " �� ����~~~ (�Ф�)");
					} catch (IOException e) {
						e.printStackTrace();
					}
					// ===============
				} // if end
		
			} // for end
			System.out.println("������ �� : " + ServerClass.threadList.size() + " ��");
		} // finally end
		*/ } // run end
}// ThreadServerClass end

public class TcpMulServer {

	public static void main(String[] args) throws IOException, AWTException {
		Socket socket1 = null;
		Painter frameServer = new Painter(); // �׸� �׸��� ���� �۵�
		System.out.println("�׸��� �۵� - ����");

		// new ServeClass()
		new ServerClass(9999);

	}

}
