package step02_TCP_SC3_BufferImage2;

import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.JFrame;

class ServerFrame extends JFrame {
	JFrame frame;
	final static int w = 800, h = 400;
	final static int x = Toolkit.getDefaultToolkit().getScreenSize().width / 2 - w / 2, y = Toolkit.getDefaultToolkit().getScreenSize().height / 2 - h / 2;

	public ServerFrame() {
		// 창을 만들고
		frame = new JFrame("server");
		frame.setBounds(x, y, w, h); // 상수 크기 받아오기
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}

}

/*class SendRcvThread extends Thread {
	//클라이언트에서 받은 데이터를 서버에서 다시 클라이언트로 보내기 
	Socket s1;
	ServerFrame sf1=new ServerFrame();
	
	BufferedImage bufferImage1;
	BufferedImage bufferImage2;
	BufferedInputStream bis1; 
	BufferedOutputStream bos1; 
	
	public SendRcvThread(Socket s1) throws IOException {
		this.s1 = s1;
		}
		
		public void run(){
	//받음 Rcv	
	try {
		bis1 = new BufferedInputStream(s1.getInputStream());
		while(true) {
			sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 400, 700, sf1.frame);
			bufferImage1 = ImageIO.read(s1.getInputStream());
		}
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.print("서버 : 클라에서 이미지 받음"+"\t");
		System.out.println("받은 파일 : " + bufferImage1);
	
		
	//보냄 Send
	try {	
		bos1 = new BufferedOutputStream(s1.getOutputStream()); 
		while(true) {
			ImageIO.write(bufferImage2, "bmp", bos1);//그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			bos1.flush(); //버퍼에 쓰인 이미지를 서버로 보
		}
		} catch (IOException e) {
			System.out.println(e);
		}
		System.out.print("서버 : 클라로 받은 이미지 보냄"+"\t");
		System.out.println("보낸 파일 : " + bufferImage2);
	}
}*/

class ServerRcv extends Thread {
	Socket s1;
	ServerFrame sf1 = new ServerFrame();

	BufferedImage bufferImage1;
	BufferedInputStream bis1;

	public ServerRcv(Socket s1) throws IOException {
		this.s1 = s1;
		bis1 = new BufferedInputStream(s1.getInputStream());
		while (true) {
			sf1.frame.getGraphics().drawImage(ImageIO.read(ImageIO.createImageInputStream(bis1)), 0, 0, 400, 700, sf1.frame);
			bufferImage1 = ImageIO.read(s1.getInputStream());
			System.out.println("받은 이미지 : " + bis1);
		}
	}

}

class ServerSend extends Thread {
	Socket s1;
	ServerFrame sf1 = new ServerFrame();

	BufferedImage bufferImage2;
	BufferedOutputStream bos1;

	public ServerSend(Socket s1) throws IOException {
		this.s1 = s1;
		bos1 = new BufferedOutputStream(s1.getOutputStream());
		while (true) {
			ImageIO.write(bufferImage2, "bmp", bos1);// 그 이미지를 png파일로 소켓 아웃풋스트림으로 쏴줌
			System.out.println("보내는 이미지 : " + bos1);
			bos1.flush(); // 버퍼에 쓰인 이미지를 서버로 보
		}
	}
}


public class ServerMainClass {

	public static void main(String[] args) throws IOException {
		ServerFrame sf = new ServerFrame();
		sf.setVisible(true);

		try {
			ServerSocket ss1 = new ServerSocket(8888);
			System.out.println("서버 대기중 ....");

			while (true) {
				Socket s1 = ss1.accept();
				System.out.println("접속자 정보 : " + s1.toString());

				ServerRcv sr1 = new ServerRcv(s1);
				ServerSend sd1 = new ServerSend(s1);
				sr1.start();
				sd1.start();
			}

		} catch (IOException e) {
			System.out.println(e);
		}

	}

}
