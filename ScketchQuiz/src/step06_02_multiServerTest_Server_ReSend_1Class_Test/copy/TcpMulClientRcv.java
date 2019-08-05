package step06_02_multiServerTest_Server_ReSend_1Class_Test.copy;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.*;

class Painter2 extends Frame {
	//�ʵ� ��
	static int w = Toolkit.getDefaultToolkit().getScreenSize().width, h = Toolkit.getDefaultToolkit().getScreenSize().height;
	static Socket ss;
	
	//���۳�Ʈ /////////////////////////////////////////////////////////////
	private Frame f1=new Frame();
	static Panel p1=new Panel();
	static Panel p2=new Panel();
	
	//������/////////////////////////////////////////////////////////
	public Painter2() { 
		
		//���� ������ 
		f1.setSize(400, 900);
		f1.setTitle("�ޱ� Ŭ���̾�Ʈ");
		f1.setLayout(null);
		f1.setVisible(true);
		f1.add(p1);
		f1.add(p2);
		f1.setAlwaysOnTop(true);
		f1.setResizable(false);
		
		
		//p2 �߾� ĵ����
		p1.setBackground(Color.BLUE);
		p1.setBounds(0,0,400,400);

		
		//p3 �ϴ� ���� 
		p2.setBackground(Color.WHITE);
		p2.setBounds(0,400,400,400);
		
		//�ݱ�
		f1.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e1) {
				f1.dispose(); 
				System.exit(0);
			}
		});	//â �ݱ�
	} //������ ��
}

public class TcpMulClientRcv {
	public static void main(String[] args) throws NumberFormatException, IOException {
		try {
			
			Socket s1 = new Socket("127.0.0.1", 8888); // ip �ּ�, ��Ʈ ��ȣ
			
			System.out.println("������ ����...");
			
			//�׸� ��� �۵� 
			Painter2 rcvClient=new Painter2(); //�ޱ⸸ �ϴ� 
			System.out.println("�׸��� �۵� - Ŭ���̾�Ʈ");
			
			ThreadClientSendClass tcc1 = new ThreadClientSendClass(s1, "Test"); // �г���
			Thread tsend1 = new Thread(tcc1); // ������ chat ����
			tsend1.start();
			
			//�ް� ����ϱ� ������
			ThreadRcv threadR =new ThreadRcv(s1);
			threadR.start();

			
		} catch (Exception e) {
			
			e.printStackTrace();
		}
	}

}
