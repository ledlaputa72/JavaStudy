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
			int res=fis.read(); //한글자 한글자 아스키 코드 갑으로 받음 
			if(res==-1) break; //바이트 입력에 파일의 끝(EDF)값은 -1 입니다.
			System.out.print((char)res);
		}
	}
}
