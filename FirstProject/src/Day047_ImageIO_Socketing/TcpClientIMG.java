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
		            //������ i/o stream���� ���� �޾� 
		File file7 = new File("e:/aa.png"); // �����Ͽ� png�� ���� 
	   ImageIO.write(buffimage1, "png", file7); //���� jpg�� ���߸� jpg������ 
	        System.out.println("png��  �����"); 
	 	  // imgicon1 = new ImageIcon(buffimage1);
	  //  jlabel1.setIcon(imgicon1);
	 	 s1.close();
	     System.out.println("��~~��~~~~");
	}
}
