package homestudy03_IO;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exam02 {

	public static void main(String[] args) throws IOException {
		File dir = new File("D:\\4.Java_Study\\git\\JavaStudy\\FirstProject\\src");
		File f3 = new File(dir, "ccc.txt");
		
		FileOutputStream fos = new FileOutputStream(f3, true);
		//ture이면 이어쓰기, false면 다시쓰기 , 디폴트는 flase 
		
		//fos.write(65);
		//fos.write('B');
		
		String msg="Hello Java!";
		byte[] by=msg.getBytes();
		//fos.write(by);
		fos.write(by,6,4); //(배열, 시작위치, 길이)
	}

}
