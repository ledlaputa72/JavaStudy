package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

//����
public class Server {

	public static void main(String[] args) throws Exception {
		
		Painter frameClinet=new Painter(); //�׸� �׸��� ���� �۵�
		System.out.println("�׸��� �۵� - Ŭ���̾�Ʈ");
		
		new Server(); //Ŭ���̾�Ʈ��İ� �Ȱ��� ������ ȣ��
	}//main end

	public Server() throws IOException { //������////////////////
	
		//��� �غ� 
		ServerSocket socket_s = null;
		Socket socket = null;
		
		socket_s = new ServerSocket(9999); //��Ʈ ���� 
		socket = socket_s.accept(); // Listen 
		System.out.println("Ŭ���̾�Ʈ ���� �Ϸ�! - ����" + socket);

		//������////////////////////////////////////////
		try {
			//�ް� ����ϱ� ������
			ThreadRcvClient threadR =new ThreadRcvClient(socket);
			threadR.start();
			
			//ȭ�� �̹��� ��ũ���� ���� - ������ ó�� /////////////////////////////////////////////
			ThreadSendClient ts1=new ThreadSendClient(socket);
			ts1.start();
		}
		catch(Exception e) {
			System.out.println(e);
		}//try end
		//������////////////////////////////////////////
		
	}//������ end
}//Server Class end


