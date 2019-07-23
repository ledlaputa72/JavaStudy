package Day047_ImageFile_Socketing;
import java.net.*;
import java.io.*;

public class TcpClientIMGFile {
	public static void main(String args[]) 
			    throws UnknownHostException, IOException {

		Socket s1 = new Socket("127.0.0.1", 37787);
        
		///////////////////////////////////////////////
		DataInputStream dis1 = new DataInputStream(s1.getInputStream());
				
		FileOutputStream fos1 = new FileOutputStream("d:/bb.jpg");//사본
		
		byte[] byteBae=new byte[1024];
	    System.out.println("byte--> file중.... ");
		int chk;
		 while((chk=dis1.read(byteBae)) !=-1)
                 fos1.write(byteBae);  //byte배열에 있는 것을  file로 conversion 저장 
	     
		 fos1.close();  dis1.close(); 	 s1.close();
	     System.out.println("끄~~읕~~~~");
	
	}
}
