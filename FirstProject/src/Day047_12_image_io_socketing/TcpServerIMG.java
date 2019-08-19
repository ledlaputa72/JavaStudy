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
		
		System.out.println("������ �غ�Ǿ� �ֽ��ϴ�...");
		
		while (true) {
			
			System.out.println("��ٸ��� ��...");
			
			Socket s1 = ss1.accept();
			
			System.out.println(s1.getInetAddress() + " ���� ����");
			
			File file1 = new File("e:/HYO/aa.jpg"); // ���� from ���� to client
			
			BufferedImage buffimage1 = ImageIO.read(file1); // ���� ���� read �Ͽ� �̹���ȭ�Ѵ�.
			
			ImageIO.write(buffimage1, "jpg", s1.getOutputStream()); // ������ io stream �� ���� ������.
			
			s1.close();
			
			System.out.println("jpg �� �����Ͽ����ϴ�.");
			
		}

	}

}
