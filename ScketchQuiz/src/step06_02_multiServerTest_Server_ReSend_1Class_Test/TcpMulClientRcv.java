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


public class TcpMulClientRcv {

	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;


	public static void main(String[] args) throws Exception {
			
		Socket s1 = new Socket("127.0.0.1", 9999); // ip �ּ�, ��Ʈ ��ȣ
		
		System.out.println("������ ����...");
		
		//�׸� ��� �۵� 
		Painter sendClient=new Painter(); //�׸� �׸��� �۵�
		System.out.println("�׸��� �۵� - Ŭ���̾�Ʈ");
		
		/*ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, "Test"); // �г���
		Thread tsend1 = new Thread(tcc1); // ������ chat ����
		tsend1.start();*/
		
		//ȭ�� �̹��� ��ũ���� ���� - ������ ó��###############################################
		//�ް� ����ϱ� ������
		while(true) {
			ThreadRcvClient threadR =new ThreadRcvClient(s1);
			threadR.start();
			Thread.sleep(100);
		}
		//ȭ�� �̹��� ��ũ���� ���� - ������ ó�� /////////////////////////////////////////////
		/*ThreadSendClient ts1=new ThreadSendClient(s1);
		ts1.start();
		Thread.sleep(100);*/
		//#########################################################################
			
	}

}
