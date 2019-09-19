package step06_04_SC2window_pireSendRcv_toDataStream;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

import javax.imageio.ImageIO;

public class EchoThreadServer extends Thread{
	static int w = 400, h = 400;
	static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;
	
	Socket s1; //����
	DataInputStream inputStreamS; //�Է� ��Ʈ�� 
	DataOutputStream outputStreamServer; //��� ��Ʈ��
	
	public EchoThreadServer(Socket s1) throws IOException {
		this.s1 = s1;
		//BufferedStream ����� DataStream ������� �ٲ� (������ ����Ʈ ����̶� ������ ���� ����) 
		inputStreamS = new DataInputStream(s1.getInputStream());
		outputStreamServer = new DataOutputStream(s1.getOutputStream()); 
	}

	public void run() {

		try{
			while(true) {
				//�ޱ�/////////////////////////// 
				System.out.println("## ���� �ޱ�1 inputStreamS : " + inputStreamS);
				Painter.p2.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(inputStreamS)), 0, 0, w, h, Painter.p2);
				System.out.println("## ���� �ޱ�2 inputStreamS : " + inputStreamS);
				
				/*//������ ó�� - byte �迭�� �̿� - 
				byte[] byteBae = new byte[inputStreamS.readInt()];  //���� ���̸�ŭ �迭 ����
				System.out.println("file ---> byte��...");
				//�ڷ� �ޱ�
				inputStreamS.readFully(byteBae); //���ϳ��� -->����Ʈ�迭
				//�ڷ� ������ 
				outputStreamServer.writeInt(byteBae.length); //(�߿�)���� ���� ����  ����, 
				    //writeInt ����Ʈ ������ ������ ����
				outputStreamServer.write(byteBae); //����Ʈ �迭 ����
				*/				
				
				//������ /////////////////////////
				ImageIO.write(ImageIO.read(inputStreamS), "bmp", outputStreamServer); //
//				outputStreamServer.write(ImageIO.read(inputStreamS).TYPE_3BYTE_BGR);
				System.out.println("## ���� ������1 outputStreamServer : " + outputStreamServer);
				outputStreamServer.flush(); //���ۿ� ���� �̹�����d ������ ����
				System.out.println("############���� ���� ################");
			}
		}
		catch(Exception e) {}
	}
}
