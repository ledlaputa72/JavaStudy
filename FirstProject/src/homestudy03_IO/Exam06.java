package homestudy03_IO;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class Exam06 {

	public static void main(String[] args) throws IOException {
		File dir = new File("D:\\4.Java_Study\\git\\JavaStudy\\FirstProject\\src");
		File f3 = new File(dir, "ccc.txt");
		
		FileWriter fw = new FileWriter(f3);
		BufferedWriter bw = new BufferedWriter(fw);
		PrintWriter pw = new PrintWriter(bw);
		
		pw.print("안녕하세요.");
		pw.println("정연섭입니다. ");
		pw.println(20);
		
		pw.close();
		
	}	

}
