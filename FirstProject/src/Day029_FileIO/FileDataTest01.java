package Day029_FileIO;

import java.io.DataOutputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;
//test ���Ͽ� �ڷ� �Է�
public class FileDataTest01 {

	public static void main(String[] args) throws IOException {

		Scanner sc=new Scanner(System.in);
		
		FileOutputStream fos3 = new FileOutputStream("e:/test.txt");
		DataOutputStream dos3 = new DataOutputStream(fos3);
		
		System.out.print("������ �Է��ϼ��� ");
		dos3.writeInt(sc.nextInt());
		
		System.out.print("float �Ǽ��� �Է��ϼ��� ");
		dos3.writeFloat(sc.nextFloat());;
		
		System.out.print("�ѱ��� �Է��ϼ���");
		dos3.writeUTF(sc.nextLine());
		
		dos3.close();fos3.close(); 
		
	}

}
