package homestudy03_IO;

import java.io.*;

public class Exam01 {

	public static void main(String[] args) throws IOException {

		File f1 = new File("D:\\4.Java_Study\\git\\JavaStudy\\FirstProject\\src\\aaa.txt");
		File f2 = new File("D:\\4.Java_Study\\git\\JavaStudy\\FirstProject\\src", "bbb.txt");
		File dir = new File("D:\\4.Java_Study\\git\\JavaStudy\\FirstProject\\src");
		File f3 = new File(dir, "ccc.txt");
		
		if(f1.createNewFile() && f2.createNewFile() && f3.createNewFile()) {
			System.out.println("파일이 생성중");
		}
		else {
			System.out.println("파일이 이미 존재합니다. ");
		}
		File imsi = File.createTempFile("imsi", ".dat",dir);
		
		imsi.deleteOnExit();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		f3.delete();
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
