package Day047_ImageIO_Socketing;

import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;
import java.io.*;

public class TcpClientIMG  { //extends JFrame { ////////////////
	public static void main(String args[]) 
			    throws UnknownHostException, IOException {
		Socket s1 = new Socket("127.0.0.1", 57795);
    	///////////////////////////////////////////////
		BufferedImage buffimage1 = ImageIO.read(s1.getInputStream());//////
		            //소켓의 i/o stream으로 부터 받아 
		File file7 = new File("e:/aa.png"); // 이파일에 png로 저장 
	   ImageIO.write(buffimage1, "png", file7); //물론 jpg로 맞추면 jpg로저장 
	        System.out.println("png로  저장됨"); 
	 	  // imgicon1 = new ImageIcon(buffimage1);
	  //  jlabel1.setIcon(imgicon1);
	 	 s1.close();
	     System.out.println("끄~~읕~~~~");
	}
}
