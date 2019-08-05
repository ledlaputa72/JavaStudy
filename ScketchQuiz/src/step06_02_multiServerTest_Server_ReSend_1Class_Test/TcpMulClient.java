package step06_02_multiServerTest_Server_ReSend_1Class_Test;

import java.awt.AWTException;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Panel;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;




class ThreadClientSendClass extends Thread {
	
	Socket s1;
	DataOutputStream DataOutputStream;
	String nickname;
	
	// �ʱ�ġ�� ���� ��ü, �г����� �Ѿ�´�.
	public ThreadClientSendClass(Socket s1, String nickname) throws IOException {

		this.s1 = s1;
		this.nickname = nickname;
		
		DataOutputStream = new DataOutputStream(s1.getOutputStream());
		
	}
	
	public void run() {
			
		Scanner in1 = new Scanner(System.in);
			
		try {
				
			if (DataOutputStream != null)
				DataOutputStream.writeUTF(nickname); // �г��� send
				
			/*while (outputStream != null) 
				outputStream.writeUTF("(** " + nickname + " **) " + in1.nextLine()); // io ��Ʈ���� ���� ���濡�� chat ������.
				*/
		} catch (IOException e) {
				
			e.printStackTrace();
		}
	}
}

public class TcpMulClient {

	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;


	public static void main(String[] args) throws NumberFormatException, IOException, AWTException {
			
		Socket s1 = new Socket("127.0.0.1", 8888); // ip �ּ�, ��Ʈ ��ȣ
		
		System.out.println("������ ����...");
		
		//�׸� ��� �۵� 
		Painter sendClient=new Painter(); //�׸� �׸��� �۵�
		System.out.println("�׸��� �۵� - Ŭ���̾�Ʈ");
		
		ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, "Test"); // �г���
		Thread tsend1 = new Thread(tcc1); // ������ chat ����
		tsend1.start();
		
		//ȭ�� �̹��� ��ũ���� ���� - ������ ó��###############################################
		//�ް� ����ϱ� ������
		ThreadRcvClient threadR =new ThreadRcvClient(s1);
		threadR.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {		}
		
		//ȭ�� �̹��� ��ũ���� ���� - ������ ó�� /////////////////////////////////////////////
		ThreadSendClient ts1=new ThreadSendClient(s1);
		ts1.start();
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {		}
		//#########################################################################
			
	}

}
