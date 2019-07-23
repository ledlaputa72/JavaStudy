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
		            //소켓의 i/o stream으로 부터 받아 
		//File file7 = new File("d:/aa7.png"); // 이파일에 jpg로 저장 
	    ImageIO.write(buffimage1, "jpg", fos1);
	        System.out.println("jpg로  저장됨"); 
	    
		 s1.close();
	     System.out.println("끄~~읕~~~~");
	
	}
}
// ImageIO.write(buffimage1, "jpg", fos1);
// ImageIcon imgicon1 = new ImageIcon(buffimage1);
//jlabel1.setIcon(imgicon1);
