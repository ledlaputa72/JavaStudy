package Day047_ImageIO_Socketing_dataStream;

import java.net.*;

import javax.imageio.ImageIO;

import java.awt.image.BufferedImage;
import java.io.*;

public class TcpClientIMG {
	public static void main(String args[]) 
			    throws UnknownHostException, IOException {

		Socket s1 = new Socket("127.0.0.1", 57789);
        
		///////////////////////////////////////////////
		FileOutputStream fos1 = new FileOutputStream("d:/bb.jpg");
		DataInputStream dis1 
		= new DataInputStream(s1.getInputStream());// ////////////
		//////////////////
		BufferedImage buffimage1 = ImageIO.read(dis1);//////
		            //������ i/o stream���� ���� �޾� 
		//File file7 = new File("d:/aa7.png"); // �����Ͽ� jpg�� ���� 
	    ImageIO.write(buffimage1, "jpg", fos1);
	        System.out.println("jpg��  �����"); 
	    
		 s1.close();
	     System.out.println("��~~��~~~~");
	
	}
}
// ImageIO.write(buffimage1, "jpg", fos1);
// ImageIcon imgicon1 = new ImageIcon(buffimage1);
//jlabel1.setIcon(imgicon1);
