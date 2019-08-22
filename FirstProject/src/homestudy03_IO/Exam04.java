package homestudy03_IO;

import java.io.BufferedOutputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class Exam04 {

	public static void main(String[] args) throws IOException {
		File dir = new File("D:\\4.Java_Study\\git\\JavaStudy\\FirstProject\\src");
		File f3 = new File(dir, "ddd.txt");
		
		FileOutputStream fos = new FileOutputStream(f3);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		DataOutputStream dos = new DataOutputStream(bos);
		
		int a= 10;
		double b = 10.23;
		String c = "ledlaputa";
		
		dos.writeInt(a);
		dos.writeDouble(b);
		dos.writeUTF(c);
		
		dos.close();
	}

}
