package step06_02_SC2window_pireSendRcv_OK_4way_OK;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

//����
public class Server {
	
	public static BufferedImage imsi; // �ޱ�� ���� ####���2)

	public static void main(String[] args) throws Exception {
		
		Painter frameClinet=new Painter(); //�׸� �׸��� ���� �۵�
		System.out.println("#####���� �۵�");
		
//		new Server(); //Ŭ���̾�Ʈ��İ� �Ȱ��� ������ ȣ��
		ServerSocket ss1 = null;
		Socket s1 = null;

		ss1 = new ServerSocket(9999); //��Ʈ ���� 
		
		while(true) {
			s1 = ss1.accept(); // Listen 
			System.out.println("Ŭ���̾�Ʈ ���� �Ϸ�! - ����" + s1);
			
			//������////////////////////////////////////////
			
			EchoThreadServer ets=new EchoThreadServer(s1);
			ets.start();
			
		}//������////////////////////////////////////////
		
	}//main end
}