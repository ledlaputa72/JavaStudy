package homestudy03_IO;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Exam07 {

	public static void main(String[] args) throws IOException {
		File dir = new File("D:\\4.Java_Study\\git\\JavaStudy\\FirstProject\\src");
		File f3 = new File(dir, "ccc.txt");
		
		FileReader fr = new FileReader(f3);
		BufferedReader br = new BufferedReader(fr);
		
		while (true) {
			String msg = br.readLine();
			if(msg == null) break;
			Scanner sc = new Scanner(msg).useDelimiter("\\s*tt\\s*");
			//System.out.println(msg);
			
			System.out.println("�̸� : "+sc.next());
			System.out.println("���� : "+sc.nextInt());
			System.out.println("���� : "+sc.nextInt());
			System.out.println("���� : "+sc.nextInt());
		}
	}

}
