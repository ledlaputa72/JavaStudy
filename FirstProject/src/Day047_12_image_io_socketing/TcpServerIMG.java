package Day047_12_image_io_socketing;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

import javax.imageio.ImageIO;

public class TcpServerIMG {

	public static void main(String[] args) throws IOException {
		
		ServerSocket ss1 = new ServerSocket(57795);
		
		System.out.println("서버가 준비되어 있습니다...");
		
		while (true) {
			
			System.out.println("기다리는 중...");
			
			Socket s1 = ss1.accept();
			
			System.out.println(s1.getInetAddress() + " 에서 접속");
			
			File file1 = new File("e:/HYO/aa.jpg"); // 전송 from 서버 to client
			
			BufferedImage buffimage1 = ImageIO.read(file1); // 기존 파일 read 하여 이미지화한다.
			
			ImageIO.write(buffimage1, "jpg", s1.getOutputStream()); // 소켓의 io stream 을 통해 보낸다.
			
			s1.close();
			
			System.out.println("jpg 를 전송하였습니다.");
			
		}

	}

}
