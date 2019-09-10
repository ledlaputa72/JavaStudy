package step06_04_SC2window_pireSendRcv_toDataStream;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

//�ޱ� ������
public class ThreadRcvClient  extends Thread{
	//��� ���� ȭ��ũ��, ��ǥ(����� �߾�) 
	static int w = 400, h = 400; 
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	//�ʵ� ������Ʈ 
	Socket s1;
	DataInputStream inputStreamC;
	
	public ThreadRcvClient(Socket socket) throws IOException {//������////////////////
		this.s1 = socket;
		//BufferedStream ����� DataStream ������� �ٲ� (������ ����Ʈ ����̶� ������ ���� ����) 
		inputStreamC = new DataInputStream(socket.getInputStream());
	}//������ ��
	
	public void run() {//run �޼ҵ� //////////////
	
		try {
			while(true) {
				//����Ʈ�� �ޱ� 
				/*int len1=inputStreamC.readInt(); //������ ���� ���� ���� ����  �޾ƿ�
				   byte[] byteBae2=new byte[len1]; //���̸�ŭ �迭�� ����
				   inputStreamC.readFully(byteBae2);*/
				
				System.out.println("###Ŭ�� �ޱ�1) inputStreamC: " + inputStreamC);
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamC)), 0, 0, w, h, Painter.p2);
				}
			}
		catch(Exception e) {
			System.out.println("������� : "+ e);
		}//try end
	}//run end
}
