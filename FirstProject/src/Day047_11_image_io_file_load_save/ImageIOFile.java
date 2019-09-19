package Day047_11_image_io_file_load_save;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageIOFile {

	public static void main(String[] args) throws IOException {
		
		File file1 = new File("e:/HYO/img/aa.jpg"); // ����

		BufferedImage buffimage1 = ImageIO.read(file1); // ���� ���� read �Ͽ� �̹���ȭ �Ѵ�.
		
		
		// ������ �̹��� ����
		//---------------------------------------------------------------------------------
		
		File file2 = new File("e:/HYO/img/aa2.jpg"); // �纻
		
		ImageIO.write(buffimage1, "jpg", file2); // .jpg �� �̹����� write
		
		System.out.println("jpg �� ����Ǿ����ϴ�.");
		
		//---------------------------------------------------------------------------------
		
		File file3 = new File("e:/HYO/img/aa3.gif");
		
		ImageIO.write(buffimage1, "gif", file3); // .gif �� �̹����� write
		
		System.out.println("gif �� ����Ǿ����ϴ�.");

		//---------------------------------------------------------------------------------
		
		File file5 = new File("e:/HYO/img/aa5.gif");
		
		ImageIO.write(buffimage1, "png", file5); // .png �� �̹����� write
		
		System.out.println("png �� ����Ǿ����ϴ�.");
		
		
	}

}
