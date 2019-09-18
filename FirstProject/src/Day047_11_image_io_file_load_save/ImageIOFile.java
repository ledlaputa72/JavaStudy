package Day047_11_image_io_file_load_save;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class ImageIOFile {

	public static void main(String[] args) throws IOException {
		
		File file1 = new File("e:/HYO/img/aa.jpg"); // 원본

		BufferedImage buffimage1 = ImageIO.read(file1); // 기존 파일 read 하여 이미지화 한다.
		
		
		// 종류별 이미지 저장
		//---------------------------------------------------------------------------------
		
		File file2 = new File("e:/HYO/img/aa2.jpg"); // 사본
		
		ImageIO.write(buffimage1, "jpg", file2); // .jpg 에 이미지를 write
		
		System.out.println("jpg 가 저장되었습니다.");
		
		//---------------------------------------------------------------------------------
		
		File file3 = new File("e:/HYO/img/aa3.gif");
		
		ImageIO.write(buffimage1, "gif", file3); // .gif 에 이미지를 write
		
		System.out.println("gif 가 저장되었습니다.");

		//---------------------------------------------------------------------------------
		
		File file5 = new File("e:/HYO/img/aa5.gif");
		
		ImageIO.write(buffimage1, "png", file5); // .png 에 이미지를 write
		
		System.out.println("png 가 저장되었습니다.");
		
		
	}

}
