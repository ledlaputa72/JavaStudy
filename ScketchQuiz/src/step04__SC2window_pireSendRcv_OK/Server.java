package step04__SC2window_pireSendRcv_OK;

import java.awt.*;
import java.awt.event.*;
import java.awt.image.*;
import java.io.*;
import java.net.*;
import javax.imageio.*;
import javax.swing.*;

//#############################################################
//                      ������ ������
//#############################################################
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
				Painter.p2X=(int)Painter.p2.getLocationOnScreen().getX(); //��ǥ ������ �����  static���� ����
				Painter.p2Y=(int)Painter.p2.getLocationOnScreen().getY();
				//###########################################################################
				imageSend = robot.createScreenCapture(new Rectangle(Painter.p2X-0, Painter.p2Y-400, 400, 400));//��ũ������ �� image�� ������
				System.out.println("###������)�������� ����  : " + outputStream);
				
				ThreadRcv.imageRcv=imageSend; //�ޱ� ���ۿ� ������� ���� ���� ���� 
				
				ImageIO.write(imageSend, "bmp", outputStream);//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
				outputStream.flush(); //���ۿ� ���� �̹����� ������ ����
			}}
		catch(Exception e) {
			System.out.println("������� : "+ e);
		}//try end
	}//run end
}//ThreadRcv end
//#############################################################

//#############################################################
//							�ޱ� ������
//#############################################################
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
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStream)), 0, 0, w, h, Painter.p2);
			}}
		catch(Exception e) {
			System.out.println("������� : "+ e);
		}//try end
	}//run end
}//ThreadRcv end
//#############################################################

//main class/////////////////////////////////////////////////////
public class Server {

	public static void main(String[] args) throws Exception {
		
		//JFrame GUI 
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

		//########### ������ ###############
		try {
			//�ް� ����ϱ� ������
			ThreadRcv threadR =new ThreadRcv(socket);
			threadR.start();
			
			//ȭ�� �̹��� ��ũ���� ���� - ������ ó�� /////////////////////////////////////////////
			ThreadSend ts1=new ThreadSend(socket);
			ts1.start();
		}
		catch(Exception e) {
			System.out.println(e);
		}//try end
		//########### ������ ###############
	}//������ end
}//Server Class end


