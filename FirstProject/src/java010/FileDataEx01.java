package java010;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileDataEx01 {

	public static void main(String[] args) throws IOException {

		FileOutputStream fos2 = new FileOutputStream("e:/cc.txt");
		DataOutputStream dos2 = new DataOutputStream(fos2);
		
	}

}
