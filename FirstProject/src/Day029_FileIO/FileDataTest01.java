package Day029_FileIO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
//test 파일에 자료 입력
public class FileDataTest01 {

	public static void main(String[] args) throws IOException {

		Scanner sc=new Scanner(System.in);
		
		FileOutputStream fos3 = new FileOutputStream("e:/test.txt");
		DataOutputStream dos3 = new DataOutputStream(fos3);
		
		System.out.print("정수를 입력하세요 ");
		dos3.writeInt(sc.nextInt());
		
		System.out.print("float 실수를 입력하세요 ");
		dos3.writeFloat(sc.nextFloat());;
		
		System.out.print("한글을 입력하세요");
		dos3.writeUTF(sc.nextLine());
		
		dos3.close();fos3.close(); 
		
	}

}
