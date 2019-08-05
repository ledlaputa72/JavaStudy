package step06_02_multiServerTest_Server_ReSend_1Class_Test.copy;

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
class ThreadSend extends Thread {
	// �ʵ� ������Ʈ
	Socket socket; // ����
	BufferedImage imageSendC = null; // ������ �� ����
	Robot robot; // ��ũ�� ĸ�ĸ� ���� �κ�Ʈ
	BufferedOutputStream outputStreamC; // ��� ��Ʈ�� Ŭ����

	public ThreadSend(Socket socket) throws IOException, AWTException {// ������ ////
		this.socket = socket;
		robot = new Robot();
		outputStreamC = new BufferedOutputStream(socket.getOutputStream()); // ���� ���
	}// ������ ��

	public void run() {

		try {
			while (true) {
				// ��ǥ �ٽ�##################################################################
				Painter.p2X = (int) Painter.p1.getLocationOnScreen().getX(); // ��ǥ ������ ����� static���� ����
				Painter.p2Y = (int) Painter.p1.getLocationOnScreen().getY();
				// ###########################################################################
				imageSendC = robot.createScreenCapture(new Rectangle(Painter.p2X - 0, Painter.p2Y - 0, 400, 400));// ��ũ������ �� image�� ������
				System.out.println("###������1 : outputStreamC )�������� ����  : " + outputStreamC);
				ImageIO.write(imageSendC, "bmp", outputStreamC);// �� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
				System.out.println("###������2 : imageSendC )�������� ����  : " + imageSendC);
				outputStreamC.flush(); // ���ۿ� ���� �̹����� ������ ����
			}
		} catch (Exception e) {
			System.out.println("������� : " + e);
		} // try end
	}// run end
}// ThreadRcv end////////////////////////////////////////////

// ########################################################
// Ŭ���̾�Ʈ�� ���� �ޱ� ������
// ########################################################
class ThreadRcv extends Thread {
	// ��� ���� ȭ��ũ��, ��ǥ(����� �߾�)
	static int w = 400, h = 400;
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	// �ʵ� ������Ʈ
	Socket socket;
	BufferedImage imageRcvC = null; // �ޱ�� ����
	BufferedInputStream inputStreamC;

	public ThreadRcv(Socket socket) throws IOException {// ������////////////////
		this.socket = socket;
		inputStreamC = new BufferedInputStream(socket.getInputStream());
	}// ������ ��

	public void run() {// run �޼ҵ� //////////////

		try {
			while (true) {
				imageRcvC = ImageIO.read(inputStreamC); 
				System.out.println("$$$$$$Ŭ�� �ޱ�1)���Ͽ��� ���� : " + inputStreamC);
				Painter2.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamC)), 0, 0, w, h, Painter2.p2);
				System.out.println("$$$$$$Ŭ�� �ޱ�2)���Ͽ��� ���� : " + imageRcvC);
				Thread.sleep(200);
			}
		} catch (Exception e) {
			System.out.println("������� : " + e);
		} // try end
	}// run end
}// ThreadRcv end////////////////////////////////////////////





// ########################################################
// ������ ���� �ޱ� ������
// ########################################################
class ThreadRcvServer extends Thread {
	// ��� ���� ȭ��ũ��, ��ǥ(����� �߾�)
	static int w = 400, h = 400;
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	// �ʵ� ������Ʈ
	Socket socket;
	BufferedImage imageRcvS=null; // �ޱ�� ����
//	BufferedImage imsi=null; // �ޱ�� ���� #���1)
	static BufferedImage imsi=null; // �ޱ�� ���� ####���2)
	BufferedInputStream inputStreamS;

	public BufferedImage getImsi() {
		return imsi;
	}

	public void setImsi(BufferedImage imsi) {
		this.imsi = imsi;
	}

	public ThreadRcvServer() {// ������////////////////
		
	}// ������ ��
	
	public ThreadRcvServer(Socket socket) throws IOException {// ������////////////////
		this.socket = socket;
		inputStreamS = new BufferedInputStream(socket.getInputStream());
	}// ������ ��

	public void run() {// run �޼ҵ� //////////////

		try {
			while (true) {
				imageRcvS = ImageIO.read(inputStreamS); // �����͸� �޾Ƽ� ���ۿ� ����
				imsi = imageRcvS;
				System.out.println("$$$$$$���� �ޱ�1)���Ͽ��� ���� : " + inputStreamS);
//				ThreadSendServer.imageSend=imageRcv; //�ޱ� ���ۿ� ������� ���� ���� ����
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamS)), 0, 0, w, h, Painter.p2);
				System.out.println("$$$$$$���� �ޱ�2)���Ͽ��� ���� : " + imageRcvS);
				System.out.println("$$$$$$���� �ޱ�3)���Ͽ��� ���� : " + imsi);
				Thread.sleep(200);
			}
		} catch (Exception e) {
			System.out.println("������� : " + e);
		} // try end
	}// run end
}// ThreadRcv end////////////////////////////////////////////
	// ########################################################

/*//########################################################
//������ ���� ������ ������ 1
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
*/

//������ ���� ������ �׽�Ʈ 2 ###################################################
class ThreadSendServer extends Thread{
	Socket socket; //����
//	File inputFile = new File("e:/aa.jpg"); //������ �׽�Ʈ��
//	FileInputStream infile = new FileInputStream(inputFile); ////������ �׽�Ʈ��
	BufferedImage imageSendS; //������ �� ����
	BufferedOutputStream outputStreamServer; //��� ��Ʈ�� Ŭ����  ////
//	 File file7 = new File("e:/aa7.png");
	
	public ThreadSendServer(Socket socket) throws IOException, AWTException {//������ ////
		this.socket = socket;
		outputStreamServer = new BufferedOutputStream(socket.getOutputStream()); //���� ���
//		imageSend=ImageIO.read(infile);//���1 ������ �׽�Ʈ��
	}
	
	public void run() {
		try {
		while(true) {
			System.out.println("################���� ������ �׽�Ʈ###################");
			System.out.println("########���������� 1:imageSend )"+imageSendS);
			System.out.println("########���������� 2:outputStreamServer )"+outputStreamServer);
			
			//���0
//			imageSendS=ThreadRcvServer.imsi;
//			ImageIO.write(imageSendS, "bmp", outputStreamServer);
//			outputStreamServer.flush(); //���ۿ� ���� �̹����� ������ ����
//			Thread.sleep(100);
			
			
//			//���1 ���� ���� �׽�Ʈ ########################
//			try {
//				ImageIO.write(ThreadRcvServer.imageRcv, "png", file7);
//				outputStreamServer.flush();
//			} catch (IOException e1) {}//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
									
			
//			//��� 2 ���� �о���� #################################
//			try {
//				ImageIO.write(ImageIO.read(ImageIO.createImageInputStream(ThreadRcvServer.inputStreamServer)), "bmp", outputStreamServer);
//				outputStreamServer.flush();
//			} catch (IOException e1) {}//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
				
			
			
//			//���3 ���� ��� �о���� ###########################################
//			//���� �д� ������� ���� �õ� /////////////////////////////
//			byte[] buf = new byte[4096];
//			 
//			int read = 0;
//			//		        while((read = imageSend.read(buf,0,buf.length))!=-1){
//			    try {
//					while((read = imageSend(buf,0,buf.length))!=-1){
//					   outputStreamServer.write(buf,0,read);
//					   outputStreamServer.flush();
//					   Thread.sleep(50);
//					}
//				} catch (IOException | InterruptedException e1) {}
			//#####################################################
							       
			
				Thread.sleep(50);
			
			System.out.println("########���������� 3:imageSend )"+imageSendS);
			System.out.println("########���������� 4:outputStreamServer )"+outputStreamServer);
			System.out.println("##############################################");
		}
		} catch ( InterruptedException e) {}//�� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
	}
	
}
//###################################################



/*// ������ ���� ������ �׽�Ʈ 3 ###################################################
class ThreadSendServer extends Thread {
	Socket socket; // ����
	BufferedImage imageSendS=null; // ������ �� ����
	BufferedOutputStream outputStreamS; // ��� ��Ʈ�� Ŭ���� ////

	public ThreadSendServer(Socket socket) throws IOException, AWTException {// ������ ////
		this.socket = socket;
		outputStreamS = new BufferedOutputStream(socket.getOutputStream()); // ���� ���
//		imageSend = ThreadRcvServer.imsi; // �ޱ� ���ۿ� ������� ���� ���� ����
	}

	ThreadRcvServer trs=new ThreadRcvServer(); //���1 ) getter setter
	
	
	public void run() {
			while (true) {
				System.out.println("################���� ������ �׽�Ʈ###################");
				imageSendS = trs.getImsi(); // �ޱ� ���ۿ� ������� ���� ���� ���� //���1 ) getter setter
//				imageSendS = ThreadRcvServer.imsi; // �ޱ� ���ۿ� ������� ���� ���� ���� //���2) static���� 
				System.out.println("########���������� 1:imageSend )" + imageSendS);
				System.out.println("########���������� 2:outputStreamServer )" + outputStreamS);

				// ��� 1
				try {
					ImageIO.write(imageSendS, "bmp", outputStreamS);
					outputStreamS.flush();
//					Thread.sleep(100);

				} catch (IOException e1) {// | InterruptedException e1) {//
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

				System.out.println("########���������� 3:imageSend )" + imageSendS);
				System.out.println("########���������� 4:outputStreamServer )" + outputStreamS);
				System.out.println("##############################################");
		} // �� �̹����� png���Ϸ� ���� �ƿ�ǲ��Ʈ������ ����
	}
}*/

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

			// =====================================================

			System.out.println("������ �� : " + threadList.size() + " ��");
		} // while end
	}// ������ end

	// ���� ���� �����忡�� chat ���� ������.
	// sendChat() �޼ҵ� ���ǹ�
	static void sendChat(String chat) throws IOException {

		for (int i = 0; i < threadList.size(); i++)
			threadList.get(i).outputStream.writeUTF(chat);
	}

}// ServerClass end////////////////////////////////////////////

// ########################################################
// ThreadServerClass
// �̾ȿ� �ޱ�� ������ �����带 ���� ��Ų��.
// ########################################################
class ThreadServerClass extends Thread {
	Socket socket1;
	DataInputStream inputStream;
	DataOutputStream outputStream;
	// �̹��� �ޱ�

	public ThreadServerClass(Socket s1) throws IOException { // ������
		socket1 = s1;
		inputStream = new DataInputStream(s1.getInputStream());
		outputStream = new DataOutputStream(s1.getOutputStream());
		// ����� ��Ʈ��
	}// ������ end

	public void run() { // run
		String nickname = "";
		try {
			if (inputStream != null) {
				nickname = inputStream.readUTF();
				ServerClass.sendChat(nickname + " �� ���� !!!(^^)");
			}
			// while (inputStream !=null) {
			// //System.out.printlin(inputStream.readUTF();
			// ServerClass.sendChat(inputStream.readUTF());
			// //Ŭ���̾�Ʈ�� ���� ä�� ������ ������ ��ο��� ����
			// }
			// ##############################################
			// �ް� ����ϱ� ������
			// ##############################################
			/*//Ŭ���̾�Ʈ �ޱ� 
			ThreadRcv threadR =new ThreadRcv(socket1);
			threadR.start();
			
			//ȭ�� �̹��� ��ũ���� ���� - ������ ó��
			ThreadSend ts1=new ThreadSend(socket1);
			ts1.start();*/

			// ���� �ޱ�
			ThreadRcvServer threadRserver = new ThreadRcvServer(socket1);
			threadRserver.start();

			// ���� ������
			ThreadSendServer threadSserver = new ThreadSendServer(socket1);
			threadSserver.start();

			// ##############################################

		} catch (IOException | AWTException e) { //
			e.printStackTrace();// �������� ����� ���Ϸ��� �ּ��ܴ�
		} finally {// ���� �������� �ε��� ã��
			for (int i = 0; i < ServerClass.threadList.size(); i++) {
				if (socket1.equals(ServerClass.threadList.get(i).socket1)) {
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
	} // run end
}// ThreadServerClass end

public class TcpMulServer {

	public static void main(String[] args) throws IOException, AWTException {
		Socket socket1 = null;
		Painter frameServer = new Painter(); // �׸� �׸��� ���� �۵�
		System.out.println("�׸��� �۵� - ����");

		// new ServeClass()
		new ServerClass(8888);

	}

}
