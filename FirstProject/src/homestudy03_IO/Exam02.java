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
		//ture�̸� �̾��, false�� �ٽþ��� , ����Ʈ�� flase 
		
		//fos.write(65);
		//fos.write('B');
		
		String msg="Hello Java!";
		byte[] by=msg.getBytes();
		//fos.write(by);
		fos.write(by,6,4); //(�迭, ������ġ, ����)
	}

}
