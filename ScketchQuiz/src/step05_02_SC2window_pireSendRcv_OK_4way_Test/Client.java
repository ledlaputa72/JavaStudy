package step05_02_SC2window_pireSendRcv_OK_4way_Test;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

//Ŭ��
public class Client {

	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	
	public static void main(String[] args) throws Exception {
		
		
		String serverip = "127.0.0.1";//���� IP
		Socket socket = null; //��� �غ� 
		System.out.println("Ŭ���̾�Ʈ �غ�Ϸ�");//�ϴ� ���ϻ���
	
		//�������� ����
		socket = new Socket(serverip, 9999); 
		System.out.println("���ӿϷ� - Ŭ���̾�Ʈ1");
		
		//�׸� ��� �۵� 
		Painter sc=new Painter(); //�׸� �׸��� �۵�
		System.out.println("�׸��� �۵� - Ŭ���̾�Ʈ");
		
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
	}//main end
}//Client class end



