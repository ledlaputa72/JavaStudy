package homestudy03_IO;

import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class Exam05 {

	public static void main(String[] args) throws IOException {
		File dir = new File("D:\\4.Java_Study\\git\\JavaStudy\\FirstProject\\src");
		File f3 = new File(dir, "ddd.txt");
		
		FileInputStream fis = new FileInputStream(f3);
		BufferedInputStream bis = new BufferedInputStream(fis);
		DataInputStream dis = new DataInputStream(bis);
		
		int a= dis.readInt();
		double b = dis.readDouble();
		String c = dis.readUTF();
		
		System.out.println("a = " + a);
		System.out.println("B = " + b);
		System.out.println("C = " + c);
		
	}

}
