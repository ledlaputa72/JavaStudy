package Day049_01_FileIO;

import java.io.*;
import java.net.*;

public class TcpClientFILE {

	public static void main(String[] args) throws UnknownHostException, IOException {

		Socket s1 = new Socket("127.0.0.1", 37799);
		////////////////bb.docx�� ���������� �ִ�//////////
		FileOutputStream fos1 = new FileOutputStream("e:/bbb.ppt");
		DataInputStream dis1 = new DataInputStream(s1.getInputStream());
		//aa.doc�� �Ѿ���� bb.doc�� �����ϰڴ�. 
		
		byte[] byteBae=new byte[1024];
		System.out.println("byte --> file �� ....");
		int chk;
		while ((chk=dis1.read(byteBae)) != -1) {
			fos1.write(byteBae);
		}
			//byte �迭�� �ִ� ���� file�� conversion ����
		fos1.close(); dis1.close(); s1.close();
		System.out.println("��...");
	}//main end
}
