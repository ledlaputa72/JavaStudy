package homestudy03_IO;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import javax.imageio.stream.FileImageInputStream;

public class Exam03 {

	public static void main(String[] args) throws IOException {
		File dir = new File("D:\\4.Java_Study\\git\\JavaStudy\\FirstProject\\src");
		File f3 = new File(dir, "ccc.txt");
		
		FileInputStream fis = new FileInputStream(f3);
		
		while (true) {
			int res=fis.read(); //�ѱ��� �ѱ��� �ƽ�Ű �ڵ� ������ ���� 
			if(res==-1) break; //����Ʈ �Է¿� ������ ��(EDF)���� -1 �Դϴ�.
			System.out.print((char)res);
		}
	}
}
