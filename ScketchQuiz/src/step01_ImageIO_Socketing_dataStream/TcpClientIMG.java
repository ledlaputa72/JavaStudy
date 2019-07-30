package step01_ImageIO_Socketing_dataStream;

import java.net.*;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import java.awt.image.BufferedImage;
import java.io.*;

class ImageSendThread extends Thread {
	
	Socket s1;
	
	//디폴트 생성자
	public ImageSendThread(Socket s1) throws IOException {
		this.s1 = s1;
	}

	public void run(){
		File file1 = new File("e:/aa.jpg"); //보내는 파일 
		try{
			BufferedImage buffimage1= ImageIO.read(file1); //파일을 읽어와서 버퍼에 저장하고 
			ImageIO.write(buffimage1, "jpg", s1.getOutputStream());//버퍼 이미지를 jpg 포맷으로 소켓아웃한다. 
			s1.close();
		} 
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

public class TcpClientIMG  { //extends JFrame { ////////////////
	public static void main(String args[]) 
			    throws UnknownHostException, IOException {
		Socket s1 = new Socket("127.0.0.1", 5999);
    	///////////////////////////////////////////////
		BufferedImage buffimage1 = ImageIO.read(s1.getInputStream());//////
		            //소켓의 i/o stream으로 부터 받아 
		File file7 = new File("e:/aa4.png"); // 이파일에 png로 저장 
	   ImageIO.write(buffimage1, "png", file7); //물론 jpg로 맞추면 jpg로저장 
	        System.out.println("png로  저장됨"); 
	 	  // imgicon1 = new ImageIcon(buffimage1);
	  //  jlabel1.setIcon(imgicon1);
	 	 s1.close();
	     System.out.println("끄~~읕~~~~");
	}
}
