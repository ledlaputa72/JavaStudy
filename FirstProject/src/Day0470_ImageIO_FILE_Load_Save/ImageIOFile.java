package Day0470_ImageIO_FILE_Load_Save;


import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;

 public class ImageIOFile  {
		   
		    public static void main(String[] args) throws IOException{
		    	 File file1 = new File("e:/aa.jpg");//����
			      BufferedImage buffimage1= ImageIO.read(file1); 
			                   //���� ���� read�Ͽ�   �̹���ȭ �Ѵ��� 
		        // ������ �̹��� ����               //�纻
			        File file2 = new File("e:/aa2.jpg"); //.jpg�� �̹����� write
			        ImageIO.write(buffimage1, "jpg", file2);
			        System.out.println("jpg �����"); 
			        
			        File file3 = new File("e:/aa3.gif");
			        ImageIO.write(buffimage1,"gif", file3);
			        System.out.println("gif �����"); 
			         
			        File file5 = new File("e:/aa5.png");
			        ImageIO.write(buffimage1, "png", file5);
			        System.out.println("png �����"); 
		    }
		}


		

		