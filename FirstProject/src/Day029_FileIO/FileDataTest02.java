package Day029_FileIO;
//test 파일에 자료를 출력
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileDataTest02 {

	public static void main(String[] args) throws IOException {

		FileInputStream fis3=new FileInputStream("e:/test.txt");
		DataInputStream dis3=new DataInputStream(fis3);
		
		System.out.println(dis3.readInt());
		System.out.println(dis3.readFloat());
		System.out.println(dis3.readUTF());
		
		dis3.close();fis3.close(); 
		
	}

}
